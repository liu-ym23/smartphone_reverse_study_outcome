package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.aa;
import com.vivo.push.util.t;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public abstract class BasePushMessageReceiver extends BroadcastReceiver implements PushMessageCallback {
    public static final String TAG = "PushMessageReceiver";

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onBind(Context r100, int r101, String r102) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onDelAlias(Context r100, int r101, List<String> r102, List<String> r103, String r104) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onDelTags(Context r100, int r101, List<String> r102, List<String> r103, String r104) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onForegroundMessageArrived(UPSNotificationMessage r100) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onListTags(Context r100, int r101, List<String> r102, String r103) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onLog(Context r100, String r101, int r102, boolean r103) {
    }

    public void onNotifyGuideDialogResult(int r100) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onPublish(Context r100, int r101, String r102) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onSetAlias(Context r100, int r101, List<String> r102, List<String> r103, String r104) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onSetTags(Context r100, int r101, List<String> r102, List<String> r103, String r104) {
    }

    public void onTransmissionMessage(Context r100, UnvarnishedMessage r101) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessageExpired(UnvarnishedMessage r100) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onUnBind(Context r100, int r101, String r102) {
    }

    public BasePushMessageReceiver() {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public boolean isAllowNet(Context r100) {
        if (r100 != null) goto L6;
        t.a(TAG, "isAllowNet sContext is null");
        return false;
    L6:
        String r101 = r100.getPackageName();
        if (TextUtils.isEmpty(r101) == false) goto L10;
        t.a(TAG, "isAllowNet pkgName is null");
        return false;
    L10:
        Intent r102 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        r102.setPackage(r101);
        List<ResolveInfo> r103 = r100.getPackageManager().queryIntentServices(r102, 576);
        if (r103 != null) goto L13;
    L17:
        t.a(TAG, "this is client sdk");
        return true;
    L13:
        if (r103.size() <= 0) goto L17;
        return aa.a(r100, r101);
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onAppInstallCompleteShowMsg(String r100) {
        t.d(TAG, "thirdPackageName=".concat(String.valueOf(r100)));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        t.c(TAG, "not need do something");
    }
}
