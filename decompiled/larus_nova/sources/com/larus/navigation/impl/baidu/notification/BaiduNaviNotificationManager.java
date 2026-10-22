package com.larus.navigation.impl.baidu.notification;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class BaiduNaviNotificationManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BaiduNaviNotificationManager f359788a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f359789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Bitmap f359790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j<tl9.c> f359791d = null;

    public BaiduNaviNotificationManager() {
    }

    static {
        f359788a = new BaiduNaviNotificationManager();
        f359791d = new j();
    }

    public static void b() {
        NotificationManagerCompat r100 = NotificationManagerCompat.from(AppHost.f326268a.getApplication());
        if (Build.VERSION.SDK_INT < 26) goto L6;
        NotificationChannel r101 = new NotificationChannel("navigation_channel", NotificationCompat.CATEGORY_NAVIGATION, 3);
        r101.enableVibration(false);
        r101.setLockscreenVisibility(1);
        r101.setSound(null, null);
        r100.createNotificationChannel(r101);
        return;
    }

    public static tl9.c c() {
        j<tl9.c> r100 = f359791d;
        monitor-enter(r100);
        tl9.c r101 = r100.f359814a;     // Catch: Throwable -> L8
        monitor-exit(r100);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.navigation.impl.baidu.notification.i] */
    public final i a() {
        final j<tl9.c> r100 = f359791d;
        final BaiduNaviNotificationManager$captureNaviNotificationRemoval$1 r101 = new BaiduNaviNotificationManager$captureNaviNotificationRemoval$1(this);
        monitor-enter(r100);
        Intrinsics.checkNotNullParameter(r101, "action");     // Catch: Throwable -> L7
        final long r102 = r100.f359815b;     // Catch: Throwable -> L7
        ?? r103 = new i(r100, r102, r101);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f() {
        f359791d.a(new BaiduNaviNotificationManager$removeNaviNotification$1(this));
    }

    public static void e() {
        tl9.c r100 = c();
        int r101 = com.larus.navigation.api.c.f359656a;
        StringBuilder r102 = new StringBuilder("onNotificationClicked: callbackPresent=");
        if (r100 == null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r102.append(" cls=");
        if (r100 == null) goto L9;
        String r104 = r100.getClass().getSimpleName();
    L10:
        r102.append(r104);
        com.larus.navigation.api.c.d("nav_notif_mgr", r102.toString());
        if (r100 == null) goto L14;
        r100.onClick();
        return;
    L14:
        return;
    L9:
        r104 = "null";
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(tl9.c r100) {
        tl9.c r101 = c();
        j<tl9.c> r102 = f359791d;
        monitor-enter(r102);
        r102.f359815b++;     // Catch: Throwable -> L17
        r102.f359814a = r100;     // Catch: Throwable -> L17
        monitor-exit(r102);
        int r103 = com.larus.navigation.api.c.f359656a;
        StringBuilder r104 = new StringBuilder("setCallback: ");
        if (r101 == null) goto L10;
        String r105 = "replace ".concat(r101.getClass().getSimpleName());
        if (r105 == null) goto L10;
    L11:
        r104.append(r105);
        r104.append(" -> ");
        if (r100 == 0) goto L14;
        String r106 = r100.getClass().getSimpleName();
    L15:
        r104.append(r106);
        com.larus.navigation.api.c.d("nav_notif_mgr", r104.toString());
        return;
    L14:
        r106 = "null";
    L10:
        r105 = SoloKtvContext.SOLO_PAGE_FIRST;
    L17:
        th = move-exception;
        throw th;
    }

    public static Notification d(String r100, String r101, Integer r110, Bitmap r111) {
        AppHost.Companion r102 = AppHost.f326268a;
        Intent r103 = new Intent(r102.getApplication(), BaiduNaviNotificationActivity.class);
        Application r104 = r102.getApplication();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r105 = 201326592;
    L6:
        PendingIntent r106 = PendingIntent.getActivity(r104, 0, r103, r105);
        f359790c = null;
        if (r111 == null) goto L9;
        f359790c = r111;
    L11:
        Bitmap r112 = f359790c;
        if (r112 != null) goto L14;
    L16:
        r112 = null;
    L26:
        return new NotificationCompat.Builder(r102.getApplication(), "navigation_channel").setContentIntent(r106).setShowWhen(false).setSound(null).setContentTitle(r100).setContentText(r101).setSmallIcon(r102.b()).setLargeIcon(r112).setAutoCancel(false).setOngoing(false).setPriority(0).setCategory(NotificationCompat.CATEGORY_NAVIGATION).setVisibility(1).build();
    L20:
        e = move-exception;
        tl9.c r107 = c();
        if (r107 == null) goto L24;
        r107.c(1, null);
    L24:
        FLogger.f375446a.e("BaiduNaviNotificationManager", "Notification build fails", e);
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "BaiduNaviNotificationManager");
        return null;
    L14:
        if (r112.isRecycled() == false) goto L26;
        FLogger.f375446a.e("BaiduNaviNotificationManager", "mLatestLargeIcon is recycled");
        goto L16
    L9:
        if (r110 == null) goto L11;
        f359790c = BitmapFactory.decodeResource(r102.getApplication().getResources(), r110.intValue());
        goto L11
    L5:
        r105 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L6
    }

    public static void h(final int r100, final int r110, final String r111, final String r112, final Integer r113, final Bitmap r114) {
        Intrinsics.checkNotNullParameter(r111, "title");
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("updateNaviNotification triggered, routePlanType[");
        r102.append(r100);
        r102.append("], turnKind[");
        r102.append(r110);
        r102.append("], customIconIdIsNull[");
        boolean r103 = false;
        if (r113 != null) goto L5;
        boolean r104 = true;
    L6:
        r102.append(r104);
        r102.append("], customIconBitmapIsNull[");
        if (r114 != null) goto L9;
        r103 = true;
    L9:
        r102.append(r103);
        r102.append(']');
        r101.i("BaiduNaviNotificationManager", r102.toString());
        f359789b = true;
        tl9.c r105 = c();
        if (r105 == null) goto L12;
        r105.b(r111, r112, r113, d.a(r100, r110));
    L12:
        Function1<? super Boolean, Unit> r106 = new e(r100, r110, r111, r112, r113, r114);
        BaiduNaviForegroundService.f359784a.startService(r106);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public static void i(BaiduNaviNotificationManager r100, String r101, String r102, Integer r103, Bitmap r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = null;
    L8:
        monitor-enter(r100);
        Intrinsics.checkNotNullParameter(r101, "title");     // Catch: Throwable -> L25
        Notification r106 = d(r101, r102, r103, r104);     // Catch: Throwable -> L25
        BaiduNaviForegroundService r107 = BaiduNaviForegroundService.f359786c;     // Catch: Throwable -> L25
        if (r107 != null) goto L12;
    L23:
        monitor-exit(r100);
        return;
    L12:
        if (r106 != null) goto L28;
        FLogger.f375446a.i("BaiduNaviForegroundService", "ignore starting foreground service due to null");     // Catch: Throwable -> L25
        goto L23
    L28:
    L21:
        e = move-exception;
        FLogger.f375446a.e("BaiduNaviForegroundService", "fail starting foreground service", e);     // Catch: Throwable -> L25
        goto L23
    L16:
        if (Build.VERSION.SDK_INT < 34) goto L18;
        r107.startForeground(106, r106, 8);     // Catch: Exception -> L21 Throwable -> L25
    L19:
        FLogger.f375446a.i("BaiduNaviForegroundService", "succeed starting foreground service");     // Catch: Exception -> L21 Throwable -> L25
    L18:
        r107.startForeground(106, r106);     // Catch: Exception -> L21 Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
