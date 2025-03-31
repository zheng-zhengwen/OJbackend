//package com.wen.oj.service.AI;
//
//
//import com.wen.oj.common.ErrorCode;
//import com.wen.oj.exception.BusinessException;
//import com.wen.oj.model.entity.User;
//import com.wen.oj.model.enums.UserRoleEnum;
//import com.wen.oj.model.vo.UserVO;
//import org.springframework.beans.BeanUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Collection;
//import java.util.List;
//
///**
// * 用户服务
// */
//
//public interface UserFeignClient {
//
//
//    /**
//     * 根据id获取用户
//     *
//     * @param userId
//     * @return
//     */
//    @GetMapping("/get/id")
//    User getById(@RequestParam("userId") long userId);
//
//    /**
//     * 根据id获取用户列表
//     *
//     * @param idList
//     * @return
//     */
//    @GetMapping("/get/ids")
//    List<User> listByIds(@RequestParam("idList") Collection<Long> idList);
//
//    /**
//     * 获取当前登录用户
//     *
//     * @param request
//     * @return
//     */
//    default User getLoginUser(HttpServletRequest request) {
//        String userIdStr = request.getHeader("X-User-Id");
//        if (userIdStr==null && userIdStr.isEmpty()) {
//            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
//        }
//        long userId = Long.parseLong(userIdStr);
//       User currentUser = this.getById(userId);
//        if (currentUser == null) {
//            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
//        }
//        return currentUser;
//    }
//
//    /**
//     * 是否为管理员
//     *
//     * @param user
//     * @return
//     */
//    default boolean isAdmin(User user) {
//        return user != null && UserRoleEnum.ADMIN.getValue().equals(user.getUserRole());
//    }
//
//    /**
//     * 获取脱敏的用户信息
//     *
//     * @param user
//     * @return
//     */
//    default UserVO getUserVO(User user) {
//        if (user == null) {
//            return null;
//        }
//        UserVO userVO = new UserVO();
//        BeanUtils.copyProperties(user, userVO);
//        return userVO;
//    }
//}
