package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.t;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public abstract class OpenClientPushMessageReceiver extends BasePushMessageReceiver {
    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onDelAlias(Context r100, int r101, List<String> r102, List<String> r103, String r104) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onDelTags(Context r100, int r101, List<String> r102, List<String> r103, String r104) {
    }

    public void onNotificationMessageClicked(Context r100, UPSNotificationMessage r101) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onNotifyGuideDialogResult(int r100) {
    }

    public void onReceiveRegId(Context r100, String r101) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onSetAlias(Context r100, int r101, List<String> r102, List<String> r103, String r104) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onSetTags(Context r100, int r101, List<String> r102, List<String> r103, String r104) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(Context r100, UnvarnishedMessage r101) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessageExpired(UnvarnishedMessage r100) {
    }

    public OpenClientPushMessageReceiver() {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final boolean isAllowNet(Context r100) {
        return super.isAllowNet(r100);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onAppInstallCompleteShowMsg(String r100) {
        t.d(BasePushMessageReceiver.TAG, "thirdPackageName=".concat(String.valueOf(r100)));
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onForegroundMessageArrived(UPSNotificationMessage r100) {
        t.d(BasePushMessageReceiver.TAG, "");
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public final NotifyArriveCallbackByUser onNotificationMessageArrived(Context r100, UPSNotificationMessage r101) {
        return new NotifyArriveCallbackByUser(null, false);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onBind(Context r100, int r101, String r102) {
        super.onBind(r100, r101, r102);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onPublish(Context r100, int r101, String r102) {
        super.onPublish(r100, r101, r102);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onUnBind(Context r100, int r101, String r102) {
        super.onUnBind(r100, r101, r102);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onListTags(Context r100, int r101, List<String> r102, String r103) {
        super.onListTags(r100, r101, r102, r103);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onLog(Context r100, String r101, int r102, boolean r103) {
        super.onLog(r100, r101, r102, r103);
    }
}
