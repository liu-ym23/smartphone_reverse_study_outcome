package com.larus.uaigc.chat.notification;

import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.common.utility.DeviceUtils;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.uaigc.helper.d0;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CreationService f371333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f371334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f371335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Integer> f371336d = null;

    static {
        f371336d = new LinkedHashSet();
    }

    public static void d() {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        CreationService r100 = f371333a;
        if (r100 == null) goto L10;
        r100.stopForeground(1);
    L10:
        f371335c = false;
        f371336d.clear();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        AppHost.Companion r102 = AppHost.f326268a;     // Catch: Throwable -> L13
        Intent r103 = new Intent(r102.getApplication(), CreationService.class);     // Catch: Throwable -> L13
        r102.getApplication().stopService(r103);     // Catch: Throwable -> L13
        f371333a = null;     // Catch: Throwable -> L13
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L16:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L21;
        FLogger.f375446a.e("CreationNotificationManager", "unbindForegroundService failed");
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L7:
        CreationService r106 = f371333a;
        if (r106 == null) goto L10;
        r106.stopForeground(true);
        goto L10
    }

    public static void b(int r100) {
        f371336d.remove(Integer.valueOf(r100));
        NotificationManagerCompat r101 = NotificationManagerCompat.from(AppHost.f326268a.getApplication());
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        r101.cancel(r100);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L13;
        FLogger.f375446a.e("CreationNotificationManager", "notificationManager cancel failed");
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static void c(k r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        f371336d.add(Integer.valueOf(r100.f371337a));
        if (f371333a != null) goto L6;
        f371334b = new d(r100);
        return;
    L6:
        if (f371335c == false) goto L29;
        e(r100);
        return;
    L29:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L19
        if (Build.VERSION.SDK_INT < 34) goto L13;
        CreationService r102 = f371333a;     // Catch: Throwable -> L19
        if (r102 == null) goto L16;
        r102.startForeground(107, a(AppHost.f326268a.getApplication(), r100), 128);     // Catch: Throwable -> L19
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L19
    L21:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L25;
        FLogger.f375446a.e("CreationNotificationManager", "showForegroundNotification failed, " + r105.getMessage());
    L25:
        if (Result.m9456isSuccessimpl(r104) == false) goto L27;
        Unit r106 = (Unit) r104;
        f371335c = true;
    L27:
        Result.m9448boximpl(r104);
        return;
    L16:
        r103 = null;
        goto L17
    L13:
        CreationService r107 = f371333a;     // Catch: Throwable -> L19
        if (r107 == null) goto L16;
        r107.startForeground(107, a(AppHost.f326268a.getApplication(), r100));     // Catch: Throwable -> L19
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public static void e(k r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        AppHost.Companion r101 = AppHost.f326268a;
        NotificationManagerCompat r102 = NotificationManagerCompat.from(r101.getApplication());
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        r102.notify(r100.f371337a, a(r101.getApplication(), r100));     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(r105, "notificationManager notify failed");
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static Notification a(Context r210, k r211) {
        int r100 = d0.f373007a;
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r210.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r101 = true;
    L6:
        String r102 = r210.getPackageName();
        if (d0.a() == true) goto L23;
        String r103 = Build.MANUFACTURER;
        if (r103 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == true) goto L20;
        if (DeviceUtils.isVivo() == true) goto L20;
        if (DeviceUtils.isOppo() == true) goto L20;
    L22:
        boolean r105 = false;
    L25:
        if (r105 == false) goto L29;
        if (r101 == false) goto L28;
        int r106 = R.layout.larus_layout_creation_progress_notification_with_margin_dark;
    L32:
        RemoteViews r107 = new RemoteViews(r102, r106);
        int r110 = Build.VERSION.SDK_INT;
        if (r110 >= 31) goto L35;
    L37:
        r107.setChronometer(R.id.chronometer, r211.f371340d, "%s", true);
        r107.setTextViewText(R.id.title, r211.f371338b);
        r107.setTextViewText(R.id.content, r211.f371339c);
        r107.setProgressBar(R.id.progressBar, 100, r211.f371341e, false);
        r107.setImageViewResource(R.id.photo, R.drawable.larus_ic_creation_notification);
        if (r110 < 31) goto L42;
        if (DeviceUtils.isVivo() == false) goto L42;
    L44:
        r107.setViewVisibility(R.id.progressBarContainer, 8);
    L45:
        String r111 = r210.getPackageName();
        String r108 = Build.MANUFACTURER;
        if (r108 != null) goto L48;
    L50:
        boolean r212 = false;
    L51:
        if (r212 == false) goto L53;
    L56:
        if (r110 >= 31) goto L58;
        boolean r112 = true;
    L59:
        if (r112 == false) goto L63;
        if (r101 == false) goto L62;
        int r113 = R.layout.larus_layout_creation_progress_notification_with_margin_dark;
    L66:
        RemoteViews r114 = new RemoteViews(r111, r113);
        r114.setTextViewText(R.id.title, r211.f371338b);
        r114.setTextViewText(R.id.content, r211.f371339c);
        r114.setChronometer(R.id.chronometer, r211.f371340d, null, true);
        r114.setProgressBar(R.id.progressBar, 100, r211.f371341e, false);
        if (r211.f371343g == false) goto L69;
        r114.setViewVisibility(R.id.progressBarContainer, 0);
    L70:
        r114.setImageViewResource(R.id.photo, R.drawable.larus_ic_creation_notification);
        IFlowSdkDepend r109 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r109 == null) goto L73;
        r109.P();
        PendingIntent r115 = ChatServiceImpl.f346124a.d(r211.f371342f);
    L74:
        NotificationCompat.Builder r116 = new NotificationCompat.Builder(r210, "ugc_creation_channel");
        AppHost.Companion r117 = AppHost.f326268a;
        NotificationCompat.Builder r118 = r116.setSmallIcon(r117.b()).setShowWhen(false).setSound(null).setVibrate(null).setContentTitle(r211.f371338b).setContentText(r211.f371339c).setAutoCancel(false).setOngoing(false).setPriority(1).setContentIntent(r115);
        Bundle r119 = r211.f371344h;
        Intent r120 = new Intent(r117.getApplication(), CreationService.class);
        r120.setAction("delete");
        if (r119 == null) goto L77;
        r120.putExtras(r119);
    L77:
        Application r121 = r117.getApplication();
        if (r110 < 23) goto L80;
        int r122 = 201326592;
    L81:
        NotificationCompat.Builder r123 = r118.setDeleteIntent(PendingIntent.getService(r121, 99, r120, r122)).setVisibility(1);
        if (d0.a() == true) goto L99;
        if (r108 != null) goto L85;
    L87:
        boolean r124 = false;
    L88:
        if (r124 == true) goto L99;
        if (DeviceUtils.isHuawei() == true) goto L99;
        if (DeviceUtils.isOppo() == true) goto L99;
        if (DeviceUtils.isVivo() == true) goto L99;
        if (DeviceUtils.isFlyme() == true) goto L99;
        boolean r125 = false;
    L100:
        if (r125 == false) goto L109;
        r123.setCustomContentView(r107);
        r123.setCustomBigContentView(r114);
        int r126 = j0.f375426a;
        if (r101 == false) goto L104;
        int r127 = R.color.larus_creation_notification_bg_dark;
    L105:
        r123.setColor(j0.a(r127));
        if (r110 < 26) goto L112;
        r123.setColorized(true);
    L112:
        return r123.build();
    L104:
        r127 = R.color.larus_creation_notification_bg_light;
        goto L105
    L109:
        if (r211.f371343g == false) goto L112;
        r123.setProgress(100, r211.f371341e, false);
        goto L112
    L85:
        if (StringsKt.equals(r108, "OnePlus", true) == false) goto L87;
        r124 = true;
    L99:
        r125 = true;
        goto L100
    L80:
        r122 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L81
    L73:
        r115 = null;
        goto L74
    L69:
        r114.setViewVisibility(R.id.progressBarContainer, 8);
        goto L70
    L62:
        r113 = R.layout.larus_layout_creation_progress_notification_with_margin_light;
        goto L66
    L63:
        if (r101 == false) goto L65;
        r113 = R.layout.larus_layout_creation_progress_notification_dark;
        goto L66
    L65:
        r113 = R.layout.larus_layout_creation_progress_notification_light;
    L58:
        r112 = false;
        goto L59
    L53:
        if (DeviceUtils.isOppo() == true) goto L56;
        if (DeviceUtils.isVivo() == false) goto L58;
    L48:
        if (StringsKt.equals(r108, "OnePlus", true) == false) goto L50;
        r212 = true;
    L42:
        if (r211.f371343g == false) goto L44;
        r107.setViewVisibility(R.id.progressBarContainer, 0);
        goto L45
    L35:
        if (d0.a() == false) goto L37;
        r107.setViewLayoutMargin(R.id.photo, 4, 0.0f, 1);
        goto L37
    L28:
        r106 = R.layout.larus_layout_creation_progress_notification_with_margin_light;
        goto L32
    L29:
        if (r101 == false) goto L31;
        r106 = R.layout.larus_layout_creation_progress_notification_dark;
        goto L32
    L31:
        r106 = R.layout.larus_layout_creation_progress_notification_light;
    L20:
        if (Build.VERSION.SDK_INT >= 31) goto L22;
    L11:
        if (StringsKt.equals(r103, "OnePlus", true) == false) goto L13;
        r104 = true;
    L23:
        r105 = true;
        goto L25
    L5:
        r101 = false;
        goto L6
    }
}
