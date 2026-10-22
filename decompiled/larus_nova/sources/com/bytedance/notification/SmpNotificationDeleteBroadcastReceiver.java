package com.bytedance.notification;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes21.dex */
public class SmpNotificationDeleteBroadcastReceiver extends NotificationDeleteBroadcastReceiver {
    public SmpNotificationDeleteBroadcastReceiver() {
    }

    @Override // com.bytedance.notification.NotificationDeleteBroadcastReceiver
    public final boolean b(String r100, Context r101) {
        return TextUtils.equals(r100, r101.getPackageName() + ".pushsdk.notification.delete.action.smp");
    }
}
