package com.heytap.mcssdk.d;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import com.heytap.msp.push.notification.PushNotification;

/* JADX INFO: loaded from: classes23.dex */
public class a {
    public a() {
    }

    public static Notification a(Context r100, String r101, PushNotification.Builder r102) {
        Notification.Builder r103 = new Notification.Builder(r100);
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r103.setChannelId(com.heytap.mcssdk.b.a.f276297a);
    L5:
        r103.setGroup(r101);
        r103.setGroupSummary(true);
        if (a(r103, r102) == true) goto L8;
        return null;
    L8:
        return r103.build();
    }

    public static NotificationManager a(Context r100) {
        if (r100 == null) goto L10;
        return (NotificationManager) r100.getSystemService("notification");
    L11:
        return null;
    L10:
        return null;
    }

    private static boolean a(Notification.Builder r100, PushNotification.Builder r101) {
        int r102 = r101.getIconRes();
        int r103 = r101.getIconLevel();
        Icon r104 = r101.getIcon();
        if (r104 != null) goto L5;
    L8:
        if (r102 == 0) goto L12;
        if (r103 == 0) goto L12;
        r100.setSmallIcon(r102, r103);
        return true;
    L12:
        if (r102 == 0) goto L15;
        r100.setSmallIcon(r102);
        return true;
    L15:
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        r100.setSmallIcon(r104);
        return true;
    }

    public static boolean a(NotificationManager r100, String r101, int r102) {
        StatusBarNotification[] r103 = a(r100, r101);
        if (r103 != null) goto L5;
    L14:
        return false;
    L5:
        if (r103.length == 0) goto L14;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L14;
        if (r103[r105].getId() == r102) goto L11;
        r105 = r105 + 1;
        goto L8
    L11:
        return true;
    }

    public static StatusBarNotification[] a(NotificationManager r100, String r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return null;
    L7:
        return r100.getActiveNotifications();
    }
}
