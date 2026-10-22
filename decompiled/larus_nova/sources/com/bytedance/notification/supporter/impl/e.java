package com.bytedance.notification.supporter.impl;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.push.utils.j;

/* JADX INFO: loaded from: classes21.dex */
public final class e {
    public e() {
    }

    public final int a(Context r100, NotificationBody r101) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        if (j.g() == false) goto L44;
        NotificationManager r102 = (NotificationManager) r100.getSystemService("notification");
        if (r102 != null) goto L11;
        return 0;
    L11:
        if (TextUtils.isEmpty(r101.notificationCategory) == false) goto L13;
    L36:
        return 1;
    L13:
        if (TextUtils.isEmpty(r101.channelId) == true) goto L36;
        NotificationChannel r103 = r102.getNotificationChannel(r101.channelId);
        if (r103 != null) goto L19;
        return 2;
    L19:
        if (r101.channelImportance != 1) goto L24;
        if (r103.getImportance() <= 2) goto L24;
        return 3;
    L24:
        if (r103.getImportance() <= 2) goto L26;
        return 0;
    L26:
        if (r103.shouldVibrate() == false) goto L28;
    L35:
        return 4;
    L28:
        if (r103.getSound() == null) goto L34;
        if (r103.getSound() == Settings.System.DEFAULT_NOTIFICATION_URI) goto L34;
        if (TextUtils.isEmpty(r103.getSound().toString()) == false) goto L35;
    L34:
        if (r103.getLockscreenVisibility() != (-1)) goto L35;
        return 0;
    L44:
        return 0;
    }
}
