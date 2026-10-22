package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.push.ds;

/* JADX INFO: loaded from: classes41.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {
    public void onCommandResult(Context r100, MiPushCommandMessage r101) {
    }

    public void onNotificationMessageArrived(Context r100, MiPushMessage r101) {
    }

    public void onNotificationMessageClicked(Context r100, MiPushMessage r101) {
    }

    public void onReceiveMessage(Context r100, MiPushMessage r101) {
    }

    public void onReceivePassThroughMessage(Context r100, MiPushMessage r101) {
    }

    public void onReceiveRegisterResult(Context r100, MiPushCommandMessage r101) {
    }

    public void onRequirePermissions(Context r100, String[] r101) {
    }

    public PushMessageReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L4;
        com.xiaomi.channel.commonutils.logger.b.e("[CRcv] receive a msg broadcast: " + r101.getAction());
    L4:
        MessageHandleService.addJob(r100.getApplicationContext(), new MessageHandleService.a(r101, this));
        int r102 = r101.getIntExtra("eventMessageType", -1);     // Catch: Exception -> L12
        if (r102 != 2000) goto L9;
        ds.a(r100.getApplicationContext()).a(r100.getPackageName(), r101, 2003, null);     // Catch: Exception -> L12
    L15:
        return;
    L9:
        if (r102 != 6000) goto L15;
        ds.a(r100.getApplicationContext()).a(r100.getPackageName(), r101, AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED, null);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("meet error in PushMessageReceiver. " + e);
    }
}
