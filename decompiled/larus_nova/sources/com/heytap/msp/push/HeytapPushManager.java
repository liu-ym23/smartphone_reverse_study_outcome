package com.heytap.msp.push;

import android.app.Activity;
import android.content.Context;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.INotificationPermissionCallback;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import com.heytap.msp.push.notification.PushNotificationManager;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class HeytapPushManager {
    public HeytapPushManager() {
    }

    public static void cancelNotification(JSONObject r100) {
        PushService.getInstance().cancelNotification(r100);
    }

    public static void clearNotificationAdvanceCallback() {
        PushService.getInstance().clearNotificationAdvanceCallback();
    }

    public static void clearNotificationType() {
        clearNotificationType(null);
    }

    public static void clearNotificationType(JSONObject r100) {
        PushService.getInstance().clearNotificationType(r100);
    }

    public static void clearNotifications() {
        clearNotifications(null);
    }

    public static void clearNotifications(JSONObject r100) {
        PushService.getInstance().clearNotifications(r100);
    }

    public static void disableAppNotificationSwitch(ISetAppNotificationCallBackService r100) {
        PushService.getInstance().disableAppNotificationSwitch(r100);
    }

    public static void enableAppNotificationSwitch(ISetAppNotificationCallBackService r100) {
        PushService.getInstance().enableAppNotificationSwitch(r100);
    }

    public static void getAppNotificationSwitch(IGetAppNotificationCallBackService r100) {
        PushService.getInstance().getAppNotificationSwitch(r100);
    }

    public static String getMcsPackageName(Context r100) {
        return PushService.getInstance().getMcsPackageName(r100);
    }

    public static void getNotificationStatus() {
        getNotificationStatus(null);
    }

    public static void getNotificationStatus(JSONObject r100) {
        PushService.getInstance().getNotificationStatus(r100);
    }

    public static ICallBackResultService getPushCallback() {
        return PushService.getInstance().getPushCallback();
    }

    public static PushNotificationManager getPushNotificationManager() {
        return PushNotificationManager.getInstance();
    }

    public static void getPushStatus() {
        PushService.getInstance().getPushStatus();
    }

    public static int getPushVersionCode() {
        return PushService.getInstance().getPushVersionCode();
    }

    public static String getPushVersionName() {
        return PushService.getInstance().getPushVersionName();
    }

    public static String getReceiveSdkAction(Context r100) {
        return PushService.getInstance().getReceiveSdkAction(r100);
    }

    public static void getRegister() {
        getRegister(null);
    }

    public static void getRegister(JSONObject r100) {
        PushService.getInstance().getRegister(r100);
    }

    public static String getRegisterID() {
        return PushService.getInstance().getRegisterID();
    }

    public static int getSDKVersionCode() {
        return PushService.getSDKVersionCode();
    }

    public static String getSDKVersionName() {
        return PushService.getSDKVersionName();
    }

    public static void init(Context r100, boolean r101) {
        PushService.getInstance().init(r100, r101);
    }

    public static boolean isSupportPush(Context r100) {
        return PushService.getInstance().isSupportPushByClient(r100);
    }

    public static void openNotificationSettings() {
        openNotificationSettings(null);
    }

    public static void openNotificationSettings(JSONObject r100) {
        PushService.getInstance().openNotificationSettings(r100);
    }

    public static void pausePush() {
        pausePush(null);
    }

    public static void pausePush(JSONObject r100) {
        PushService.getInstance().pausePush(r100);
    }

    public static void register(Context r100, String r101, String r102, ICallBackResultService r103) {
        register(r100, r101, r102, null, r103);
    }

    public static void register(Context r100, String r101, String r102, JSONObject r103, ICallBackResultService r110) {
        PushService.getInstance().register(r100, r101, r102, r103, r110);
    }

    public static void requestNotificationAdvance(Activity r100, INotificationPermissionCallback r101, int r102) {
        PushService.getInstance().requestNotificationAdvance(r100, r101, r102);
    }

    public static void requestNotificationPermission() {
        PushService.getInstance().requestNotificationPermission();
    }

    public static void resumePush() {
        resumePush(null);
    }

    public static void resumePush(JSONObject r100) {
        PushService.getInstance().resumePush(r100);
    }

    public static void setAppKeySecret(String r100, String r101) {
        PushService.getInstance().setAppKeySecret(r100, r101);
    }

    public static void setNotificationType(int r100) {
        setNotificationType(r100, null);
    }

    public static void setNotificationType(int r100, JSONObject r101) {
        PushService.getInstance().setNotificationType(r100, r101);
    }

    public static void setPushCallback(ICallBackResultService r100) {
        PushService.getInstance().setPushCallback(r100);
    }

    public static void setPushTime(List<Integer> r100, int r101, int r102, int r103, int r110) {
        setPushTime(r100, r101, r102, r103, r110, null);
    }

    public static void setPushTime(List<Integer> r100, int r101, int r102, int r110, int r111, JSONObject r112) {
        PushService.getInstance().setPushTime(r100, r101, r102, r110, r111, r112);
    }

    public static void setRegisterID(String r100) {
        PushService.getInstance().setRegisterID(r100);
    }

    public static void statisticEvent(Context r100, String r101, DataMessage r102) {
        StatisticUtils.statisticEvent(r100, r101, r102);
    }

    public static void statisticMessage(Context r100, MessageStat r101) {
        StatUtil.statisticMessage(r100, r101);
    }

    public static void statisticMessage(Context r100, List<MessageStat> r101) {
        StatUtil.statisticMessage(r100, r101);
    }

    public static void unRegister() {
        unRegister(null);
    }

    public static void unRegister(Context r100, String r101, String r102, JSONObject r103, ICallBackResultService r110) {
        PushService.getInstance().unRegister(r100, r101, r102, r103, r110);
    }

    public static void unRegister(JSONObject r100) {
        PushService.getInstance().unRegister(r100);
    }
}
