package com.huawei.hms.push;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.TransActivity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* JADX INFO: loaded from: classes23.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f277622a;

    private static boolean a() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean a(o r100) {
        if (r100 != null) goto L4;
    L9:
        return true;
    L4:
        if (TextUtils.isEmpty(r100.t()) == true) goto L6;
    L8:
        return false;
    L6:
        if (TextUtils.isEmpty(r100.i()) == false) goto L8;
        goto L8
    }

    private static void a(Notification.Builder r100) {
        r100.setShowWhen(true);
        r100.setWhen(System.currentTimeMillis());
    }

    public static synchronized void a(Context r100, o r101) {
        monitor-enter(n.class);
        if (r100 != null) goto L43;
    L41:
        monitor-exit(n.class);
        return;
    L43:
    L38:
        th = move-exception;
        throw th;
    L6:
        if (a(r101) == true) goto L41;
        HMSLog.d("PushSelfShowLog", "showNotification, the msg id = " + r101.o());     // Catch: Throwable -> L38
        if (f277622a != 0) goto L12;
        f277622a = (r100.getPackageName() + System.currentTimeMillis()).hashCode();     // Catch: Throwable -> L38
    L12:
        if (TextUtils.isEmpty(r101.k()) == false) goto L20;
        String r102 = r101.p();     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r102) == true) goto L17;
        int r103 = r102.hashCode();     // Catch: Throwable -> L38
        r101.a(r103);     // Catch: Throwable -> L38
        HMSLog.d("PushSelfShowLog", "notification msgTag = " + r103);     // Catch: Throwable -> L38
    L17:
        if (r101.r() == (-1)) goto L19;
        int r104 = r101.r();     // Catch: Throwable -> L38
        int r105 = (r101.j() + System.currentTimeMillis()).hashCode();     // Catch: Throwable -> L38
        int r106 = r105 + 1;     // Catch: Throwable -> L38
        int r107 = (r101.r() + r101.j() + r100.getPackageName()).hashCode();     // Catch: Throwable -> L38
    L21:
        HMSLog.d("PushSelfShowLog", "notifyId:" + r104 + ",openNotifyId:" + r105 + ",delNotifyId:" + r106 + ",alarmNotifyId:" + r107);     // Catch: Throwable -> L38
        int[] r108 = new int[4];     // Catch: Throwable -> L38
        r108[0] = r104;     // Catch: Throwable -> L38
        r108[1] = r105;     // Catch: Throwable -> L38
        r108[2] = r106;     // Catch: Throwable -> L38
        if (r101.e() > 0) goto L25;
        r107 = 0;
    L25:
        r108[3] = r107;     // Catch: Throwable -> L38
        if (e.d() == false) goto L28;
        Notification r109 = a(r100, r101, r108);     // Catch: Throwable -> L38
    L29:
        NotificationManager r110 = (NotificationManager) r100.getSystemService("notification");     // Catch: Throwable -> L38
        if (r110 == null) goto L36;
        if (r109 == null) goto L36;
        if (Build.VERSION.SDK_INT < 26) goto L35;
        r110.createNotificationChannel(new NotificationChannel("HwPushChannelID", r100.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));     // Catch: Throwable -> L38
    L35:
        r110.notify(r104, r109);     // Catch: Throwable -> L38
        l.a(r100, r101.o(), r101.b(), "100");     // Catch: Throwable -> L38
    L36:
        monitor-exit(n.class);
        return;
    L28:
        r109 = null;
        goto L29
    L19:
        r104 = f277622a + 1;     // Catch: Throwable -> L38
        r105 = r104 + 1;     // Catch: Throwable -> L38
        r106 = r105 + 1;     // Catch: Throwable -> L38
        r107 = r106 + 1;     // Catch: Throwable -> L38
        f277622a = r107;     // Catch: Throwable -> L38
        goto L21
    L20:
        r104 = (r101.k() + r101.j()).hashCode();     // Catch: Throwable -> L38
        r105 = f277622a + 1;     // Catch: Throwable -> L38
        r106 = r105 + 1;     // Catch: Throwable -> L38
        f277622a = r106;     // Catch: Throwable -> L38
        r107 = (r101.k() + r101.j() + r100.getPackageName()).hashCode();     // Catch: Throwable -> L38
        goto L21
    }

    private static void b(o r100, Notification.Builder r101) {
        String r102 = r100.s();
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r101.setSubText(r102);
        return;
    }

    private static void c(o r100, Notification.Builder r101) {
        r101.setTicker(r100.w());
    }

    private static void d(o r100, Notification.Builder r101) {
        String r102 = r100.t();
        String r103 = r100.i();
        if (TextUtils.isEmpty(r103) == false) goto L6;
        r101.setContentText(r102);
        return;
    L6:
        r101.setContentText(r103);
        if (TextUtils.isEmpty(r102) == true) goto L10;
        r101.setContentTitle(r102);
        return;
    }

    private static void a(o r100, Notification.Builder r101) {
        boolean r102 = true;
        if (r100.d() == 1) goto L6;
        r102 = false;
    L6:
        r101.setAutoCancel(r102);
        r101.setOngoing(false);
    }

    private static void a(Context r100, Notification.Builder r101, o r102) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) goto L5;
        return;
    L5:
        if (e.a(r100) == false) goto L14;
        Bundle r103 = new Bundle();
        String r104 = r102.j();
        HMSLog.i("PushSelfShowLog", "the package name of notification is:" + r104);
        if (TextUtils.isEmpty(r104) == true) goto L11;
        String r105 = e.a(r100, r104);
        HMSLog.i("PushSelfShowLog", "the app name is:" + r105);
        if (r105 == null) goto L11;
        r103.putCharSequence("android.extraAppName", r105);
    L11:
        r101.setExtras(r103);
        return;
    }

    private static void b(Context r100, Notification.Builder r101, o r102) {
        if ("com.huawei.android.pushagent".equals(r100.getPackageName()) == false) goto L8;
        Bundle r103 = new Bundle();
        String r104 = r102.j();
        if (TextUtils.isEmpty(r104) == true) goto L9;
        r103.putString("hw_origin_sender_package_name", r104);
        r101.setExtras(r103);
        return;
    L9:
        return;
    }

    private static PendingIntent c(Context r100, o r101, int[] r102) {
        Intent r103 = a(r100, r101, r102, "1", 268435456);
        if (a() == false) goto L7;
        r103.setClass(r100, TransActivity.class);
        r103.setFlags(268468224);
        return PendingIntent.getActivity(r100, r102[1], r103, e.a());
    L7:
        return PendingIntent.getBroadcast(r100, r102[1], r103, e.a());
    }

    private static Notification a(Context r100, o r101, int[] r102) {
        Notification.Builder r103 = new Notification.Builder(r100);
        if (j.a(r101) != k.f277616b) goto L5;
        j.a(r103, r101.f(), r101);
    L5:
        h.a(r100, r103, r101);
        b(r101, r103);
        d(r101, r103);
        a(r100, r101, r103);
        a(r103);
        a(r101, r103);
        c(r101, r103);
        r103.setContentIntent(c(r100, r101, r102));
        r103.setDeleteIntent(b(r100, r101, r102));
        if (Build.VERSION.SDK_INT < 26) goto L8;
        r103.setChannelId("HwPushChannelID");
    L8:
        b(r100, r103, r101);
        a(r100, r103, r101);
        return r103.build();
    }

    private static PendingIntent b(Context r100, o r101, int[] r102) {
        Intent r103 = a(r100, r101, r102, "2", 268435456);
        return PendingIntent.getBroadcast(r100, r102[2], r103, e.a());
    }

    private static void a(Context r100, o r101, Notification.Builder r102) {
        Bitmap r103 = h.a(r100, r101);
        if (r103 == null) goto L6;
        r102.setLargeIcon(r103);
        return;
    }

    private static Intent a(Context r100, o r101, int[] r102, String r103, int r104) {
        Intent r105 = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        r105.putExtra("selfshow_info", r101.n()).putExtra("selfshow_token", r101.x()).putExtra("selfshow_event_id", r103).putExtra("selfshow_notify_id", r102[0]).putExtra("selfshow_auto_clear_id", r102[3]).setPackage(r100.getPackageName()).setFlags(r104);
        return r105;
    }
}
