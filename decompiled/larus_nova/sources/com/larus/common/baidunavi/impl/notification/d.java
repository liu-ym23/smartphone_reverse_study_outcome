package com.larus.common.baidunavi.impl.notification;

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
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f326286a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Bitmap f326287b;

    static {
        f326286a = new d();
    }

    public d() {
    }

    public static void a() {
        NotificationManagerCompat r100 = NotificationManagerCompat.from(AppHost.f326268a.getApplication());
        if (Build.VERSION.SDK_INT < 26) goto L6;
        NotificationChannel r101 = new NotificationChannel("navigation_channel", NotificationCompat.CATEGORY_NAVIGATION, 3);
        r101.enableVibration(false);
        r101.setLockscreenVisibility(1);
        r101.setSound(null, null);
        r100.createNotificationChannel(r101);
        return;
    }

    public static Notification b(String r100, String r101, Integer r102, Bitmap r110) {
        AppHost.Companion r103 = AppHost.f326268a;
        Intent r104 = new Intent(r103.getApplication(), BaiduNaviNotificationActivity.class);
        Application r105 = r103.getApplication();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r106 = 201326592;
    L6:
        PendingIntent r107 = PendingIntent.getActivity(r105, 0, r104, r106);
        f326287b = null;
        if (r110 == null) goto L9;
        f326287b = r110;
    L11:
        Bitmap r108 = f326287b;
        if (r108 != null) goto L14;
    L16:
        r108 = null;
    L22:
        return new NotificationCompat.Builder(r103.getApplication(), "navigation_channel").setContentIntent(r107).setShowWhen(false).setSound(null).setContentTitle(r100).setContentText(r101).setSmallIcon(r103.b()).setLargeIcon(r108).setAutoCancel(false).setOngoing(false).setPriority(0).setCategory(NotificationCompat.CATEGORY_NAVIGATION).setVisibility(1).build();
    L19:
        e = move-exception;
        FLogger.f375446a.e("BaiduNaviNotificationManager", "Notification build fails", e);
        g.f365738a.ensureNotReachHere(e, "BaiduNaviNotificationManager");
        return null;
    L14:
        if (r108.isRecycled() == false) goto L22;
        FLogger.f375446a.e("BaiduNaviNotificationManager", "mLatestLargeIcon is recycled");
        goto L16
    L9:
        if (r102 == null) goto L11;
        f326287b = BitmapFactory.decodeResource(r103.getApplication().getResources(), r102.intValue());
        goto L11
    L5:
        r106 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L6
    }

    public static void c(String r100, String r101, Integer r102, Bitmap r103, int r104) {
        d r105 = f326286a;
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        monitor-enter(r105);
        Intrinsics.checkNotNullParameter(r100, "title");     // Catch: Throwable -> L25
        Notification r106 = b(r100, r101, r102, r103);     // Catch: Throwable -> L25
        BaiduNaviForegroundService r107 = BaiduNaviForegroundService.f326282b;     // Catch: Throwable -> L25
        if (r107 != null) goto L12;
    L23:
        monitor-exit(r105);
        return;
    L12:
        if (r106 != null) goto L29;
        FLogger.f375446a.i("BaiduNaviForegroundService", "ignore starting foreground service due to null");     // Catch: Throwable -> L25
        goto L23
    L29:
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
