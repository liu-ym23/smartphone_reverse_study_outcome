package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public interface PushMessageCallback {
    boolean isAllowNet(Context r100);

    void onAppInstallCompleteShowMsg(String r100);

    void onBind(Context r100, int r101, String r102);

    void onDelAlias(Context r100, int r101, List<String> r102, List<String> r103, String r104);

    void onDelTags(Context r100, int r101, List<String> r102, List<String> r103, String r104);

    void onForegroundMessageArrived(UPSNotificationMessage r100);

    void onListTags(Context r100, int r101, List<String> r102, String r103);

    void onLog(Context r100, String r101, int r102, boolean r103);

    NotifyArriveCallbackByUser onNotificationMessageArrived(Context r100, UPSNotificationMessage r101);

    void onNotificationMessageClicked(Context r100, UPSNotificationMessage r101);

    void onNotifyGuideDialogResult(int r100);

    void onPublish(Context r100, int r101, String r102);

    void onReceiveRegId(Context r100, String r101);

    void onSetAlias(Context r100, int r101, List<String> r102, List<String> r103, String r104);

    void onSetTags(Context r100, int r101, List<String> r102, List<String> r103, String r104);

    void onTransmissionMessage(Context r100, UnvarnishedMessage r101);

    void onTransmissionMessageExpired(UnvarnishedMessage r100);

    void onUnBind(Context r100, int r101, String r102);
}
