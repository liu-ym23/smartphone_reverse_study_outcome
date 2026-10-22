package com.heytap.mcssdk;

import android.app.Activity;
import android.content.Context;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.INotificationPermissionCallback;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
interface b {
    void cancelNotification(JSONObject r100);

    void clearNotificationAdvanceCallback();

    void clearNotificationType();

    void clearNotificationType(JSONObject r100);

    void clearNotifications();

    void clearNotifications(JSONObject r100);

    void disableAppNotificationSwitch(ISetAppNotificationCallBackService r100);

    void enableAppNotificationSwitch(ISetAppNotificationCallBackService r100);

    void getAppNotificationSwitch(IGetAppNotificationCallBackService r100);

    void getNotificationStatus();

    void getNotificationStatus(JSONObject r100);

    void getRegister();

    void getRegister(JSONObject r100);

    String getRegisterID();

    void openNotificationSettings();

    void openNotificationSettings(JSONObject r100);

    void pausePush();

    void pausePush(JSONObject r100);

    void register(Context r100, String r101, String r102, ICallBackResultService r103);

    void register(Context r100, String r101, String r102, JSONObject r103, ICallBackResultService r104);

    void requestNotificationAdvance(Activity r100, INotificationPermissionCallback r101, int r102);

    void requestNotificationPermission();

    void resumePush();

    void resumePush(JSONObject r100);

    void setNotificationType(int r100);

    void setNotificationType(int r100, JSONObject r101);

    void setPushTime(List<Integer> r100, int r101, int r102, int r103, int r104);

    void setPushTime(List<Integer> r100, int r101, int r102, int r103, int r104, JSONObject r105);

    void setRegisterID(String r100);

    void unRegister();

    void unRegister(JSONObject r100);
}
