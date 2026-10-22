package com.larus.dora.impl.device.battery;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mira.event.PluginEventManager;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import h49.m;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f333599m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f333600n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile e f333601o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f333602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f333603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f333604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f333605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f333606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f333607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f333608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f333609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f333610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f333611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f333612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f333613l;

    public static final class a {
        @JvmStatic
        public final e a() {
            e r100 = e.f333601o;
            if (r100 != null) goto L13;
            monitor-enter(this);
            r100 = e.f333601o;     // Catch: Throwable -> L10
            if (r100 != null) goto L8;
            r100 = new e();     // Catch: Throwable -> L10
            e.f333601o = r100;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r100;
        }

        public a() {
        }
    }

    static {
        f333599m = new a();
        f333600n = "";
    }

    public static void b() {
        g49.d.d("DoraChargingCaseNotificationManager", "clearAllNotifications called");
        NotificationManagerCompat r100 = NotificationManagerCompat.from(AppHost.f326268a.getApplication());
        r100.cancel(22001);
        r100.cancel(PluginEventManager.InstallStatusCode.INSTALL_PERMISSION_NOT_MATCH);
        r100.cancel(PluginEventManager.InstallStatusCode.INSTALL_COPY_APK_FAILED);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.dora.impl.device.battery.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.device.battery.c] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.impl.device.battery.d] */
    public e() {
        this.f333610i = new Handler(Looper.getMainLooper());
        this.f333611j = new b(this);
        this.f333612k = new c(this);
        this.f333613l = new d(this);
    }

    public final void c(int r100) {
        g49.d.d("DoraChargingCaseNotificationManager", "clearNotification called for id: " + r100);
        NotificationManagerCompat.from(AppHost.f326268a.getApplication()).cancel(r100);
        switch(r100) {
            case 22001: goto L7;
            case 22002: goto L6;
            case 22003: goto L5;
            default: goto L11;
        };
    L5:
        this.f333610i.removeCallbacks(this.f333613l);
        return;
    L6:
        this.f333610i.removeCallbacks(this.f333612k);
        return;
    L7:
        this.f333610i.removeCallbacks(this.f333611j);
        return;
    }

    public final void d(String r110, String r111, int r112) {
        Application r100 = AppHost.f326268a.getApplication();
        if (Build.VERSION.SDK_INT >= 23) goto L36;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == false) goto L16;
        g49.d.d("DoraChargingCaseNotificationManager", "Notification " + r112 + " is already active, skip showing.");
        return;
    L16:
        AppHost.Companion r102 = AppHost.f326268a;
        Application r103 = r102.getApplication();
        NotificationManagerCompat r104 = NotificationManagerCompat.from(r103);
        int r105 = Build.VERSION.SDK_INT;
        if (r105 < 26) goto L19;
        r104.createNotificationChannel(new NotificationChannel("dora_battery_notification", f333600n, 4));
    L19:
        com.bytedance.router.i r106 = SmartRouter.buildRoute(r103, "//flow/device_management");
        r106.f267554c.addFlags(603979776);
        Intent r107 = r106.b();
        r107.addFlags(603979776);
        if (r105 < 23) goto L22;
        int r108 = 201326592;
    L23:
        NotificationCompat.Builder r113 = new NotificationCompat.Builder(r103, "dora_battery_notification").setSmallIcon(r102.b()).setContentTitle(r110).setContentText(r111).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(r103, r112, r107, r108)).setPriority(1).setDefaults(-1);
        if (ContextCompat.checkSelfPermission(r103, "android.permission.POST_NOTIFICATIONS") != 0) goto L43;
        r104.notify(r112, r113.build());     // Catch: Exception -> L33
        switch(r112) {
            case 22001: goto L30;
            case 22002: goto L29;
            case 22003: goto L28;
            default: goto L44;
        };     // Catch: Exception -> L33
    L28:
        Runnable r114 = this.f333613l;     // Catch: Exception -> L33
    L31:
        this.f333610i.removeCallbacks(r114);     // Catch: Exception -> L33
        this.f333610i.postDelayed(r114, 86400000);     // Catch: Exception -> L33
        return;
    L29:
        r114 = this.f333612k;     // Catch: Exception -> L33
        goto L31
    L30:
        r114 = this.f333611j;     // Catch: Exception -> L33
        goto L31
    L44:
        return;
    L33:
        e = move-exception;
        g49.d.c("DoraChargingCaseNotificationManager", "showNotification failed", e);
        return;
    L43:
        return;
    L22:
        r108 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L23
    L36:
        Object r109 = r100.getSystemService("notification");     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.app.NotificationManager");     // Catch: Exception -> L10
        Iterator r115 = ArrayIteratorKt.iterator(((NotificationManager) r109).getActiveNotifications());     // Catch: Exception -> L10
    L6:
        if (r115.hasNext() == false) goto L12;
        if (((StatusBarNotification) r115.next()).getId() != r112) goto L6;
        r101 = true;
    L10:
        e = move-exception;
        g49.d.c("DoraChargingCaseNotificationManager", "isNotificationActive check failed", e);
        goto L12
    }

    public static final void a(e r110, DoraDevice r111, int[] r112, int[] r113) {
        r110.getClass();
        if (o59.a.l(r111) == true) goto L5;
        g49.d.d("DoraChargingCaseNotificationManager", "handleBatteryChange return: device is null or not Dora G");
        return;
    L5:
        if (r112 == null) goto L116;
        if (r113 == null) goto L116;
        Integer r100 = ArraysKt.getOrNull(r112, 2);
        int r101 = -1;
        if (r100 == null) goto L11;
        int r102 = r100.intValue();
    L12:
        Integer r103 = ArraysKt.getOrNull(r113, 2);
        if (r103 != null) goto L16;
    L18:
        boolean r104 = false;
    L19:
        Integer r105 = ArraysKt.getOrNull(r112, 0);
        if (r105 == null) goto L22;
        r101 = r105.intValue();
    L22:
        Integer r106 = ArraysKt.getOrNull(r113, 0);
        if (r106 != null) goto L26;
    L28:
        boolean r107 = false;
    L29:
        g49.d.d("DoraChargingCaseNotificationManager", "handleBatteryChange - Switches and Thresholds: CASE_COOLING_TIME_MS: 1800000, GLASSES_COOLING_TIME_MS: 1800000, CASE_FULL_CHARGE_THRESHOLD: 100, CASE_LOW_BATTERY_THRESHOLD: 20, CASE_LOW_BATTERY_RESET_THRESHOLD: 25, GLASSES_FULL_CHARGE_THRESHOLD: 100,  *** State: caseLowBatteryTriggered: " + r110.f333602a + ", caseWasFullCharged: " + r110.f333604c + ", glassesWasFullCharged: " + r110.f333607f + ", hasReceivedCaseBattery: " + r110.f333605d + ", hasReceivedGlassesBattery: " + r110.f333608g + " \n\n");
        if (r102 >= 0) goto L33;
        g49.d.d("DoraChargingCaseNotificationManager", "handleCaseLowBattery return: caseBattery < 0 (" + r102 + ')');
    L46:
        if (r102 >= 0) goto L48;
        boolean r114 = true;
    L50:
        if (r102 <= 100) goto L52;
        boolean r115 = true;
    L54:
        if ((r114 | r115) == false) goto L56;
        g49.d.d("DoraChargingCaseNotificationManager", "handleCaseFullCharge return: caseBattery < 0 or > 100 (" + r102 + ')');
    L70:
        Boolean r108 = r110.f333609h;
        r110.f333609h = Boolean.valueOf(r107);
        if (Intrinsics.areEqual(r108, Boolean.TRUE) == false) goto L74;
        if (r107 == true) goto L74;
        boolean r109 = true;
    L75:
        if (r107 == true) goto L79;
        if (r109 == true) goto L79;
        r110.f333607f = false;
        r110.f333608g = true;
        g49.d.d("DoraChargingCaseNotificationManager", "handleGlassesFullCharge return: not charging");
        return;
    L79:
        if (kj4.a.g().b() == 1) goto L81;
        boolean r116 = true;
    L82:
        if (r116 == false) goto L84;
        g49.d.d("DoraChargingCaseNotificationManager", "handleGlassesFullCharge return: wearingSwitchOff");
        return;
    L84:
        CopyOnWriteArraySet<m> r117 = t69.g.f544683a;
        if (t69.g.b() == false) goto L87;
        g49.d.d("DoraChargingCaseNotificationManager", "handleGlassesFullCharge return: is wearing");
        return;
    L87:
        if (r101 >= 0) goto L89;
    L91:
        boolean r118 = false;
    L92:
        if (r118 == false) goto L94;
        r110.f333607f = false;
        r110.f333608g = true;
        g49.d.d("DoraChargingCaseNotificationManager", "handleGlassesFullCharge return: battery is " + r101 + " (not full)");
        return;
    L94:
        if (r101 >= 0) goto L96;
        boolean r119 = true;
    L98:
        if (r101 <= 100) goto L100;
        boolean r120 = true;
    L102:
        if ((r119 | r120) == false) goto L105;
        r110.f333607f = false;
        r110.f333608g = true;
        g49.d.d("DoraChargingCaseNotificationManager", "handleGlassesFullCharge return: leftBattery < 0 or leftBattery > 100 (" + r101 + ')');
        return;
    L105:
        if (r110.f333607f == false) goto L107;
        g49.d.d("DoraChargingCaseNotificationManager", "handleGlassesFullCharge return: already triggered full charge");
    L115:
        r110.f333608g = true;
        return;
    L107:
        if (r110.f333608g == true) goto L109;
        g49.d.d("DoraChargingCaseNotificationManager", "Glasses are already full on first connect, skip notification.");
    L113:
        r110.f333607f = true;
        goto L115
    L109:
        long r121 = System.currentTimeMillis();
        if ((r121 - r110.f333606e) <= 1800000) goto L112;
        g49.d.d("DoraChargingCaseNotificationManager", "Trigger glasses full charge notification.");
        AppHost.Companion r122 = AppHost.f326268a;
        r110.d(r122.getAppStringName(), o59.a.d(r111) + r122.getApplication().getString(R.string.larus_dora_g_device_fully_charged_cn), PluginEventManager.InstallStatusCode.INSTALL_COPY_APK_FAILED);
        r110.f333606e = r121;
        goto L113
    L112:
        g49.d.d("DoraChargingCaseNotificationManager", "handleGlassesFullCharge return: in cooling time");
        goto L113
    L100:
        r120 = false;
        goto L102
    L96:
        r119 = false;
        goto L98
    L89:
        if (r101 >= 100) goto L91;
        r118 = true;
        goto L92
    L81:
        r116 = false;
    L74:
        r109 = false;
        goto L75
    L56:
        if (r102 >= 100) goto L58;
        g49.d.d("DoraChargingCaseNotificationManager", "handleCaseFullCharge return: not matching condition (charging: " + r104 + ", battery: " + r102 + ')');
        r110.f333604c = false;
    L69:
        r110.f333605d = true;
        goto L70
    L58:
        if (r110.f333604c == false) goto L60;
        g49.d.d("DoraChargingCaseNotificationManager", "handleCaseFullCharge return: already triggered full charge");
        goto L69
    L60:
        if (r110.f333605d == true) goto L62;
        g49.d.d("DoraChargingCaseNotificationManager", "Case is already full on first connect, skip notification.");
    L66:
        r110.f333604c = true;
        goto L69
    L62:
        long r123 = System.currentTimeMillis();
        if ((r123 - r110.f333603b) <= 1800000) goto L65;
        g49.d.d("DoraChargingCaseNotificationManager", "Trigger case full charge notification.");
        r110.c(22001);
        AppHost.Companion r124 = AppHost.f326268a;
        r110.d(r124.getAppStringName(), r124.getApplication().getString(R.string.larus_dora_g_case_full_charge_cn), PluginEventManager.InstallStatusCode.INSTALL_PERMISSION_NOT_MATCH);
        r110.f333603b = r123;
        goto L66
    L65:
        g49.d.d("DoraChargingCaseNotificationManager", "handleCaseFullCharge return: in cooling time");
        goto L66
    L52:
        r115 = false;
        goto L54
    L48:
        r114 = false;
        goto L50
    L33:
        if (r102 < 25) goto L36;
        r110.f333602a = false;
    L36:
        if (r104 == false) goto L39;
        if (r102 < 20) goto L39;
        g49.d.d("DoraChargingCaseNotificationManager", "Clear case low battery notification because charging and battery >= 20");
        r110.c(22001);
    L39:
        if (r104 == true) goto L45;
        if (r102 > 20) goto L45;
        if (r110.f333602a == true) goto L44;
        g49.d.d("DoraChargingCaseNotificationManager", "Trigger case low battery notification. Battery: " + r102);
        r110.f333602a = true;
        AppHost.Companion r125 = AppHost.f326268a;
        r110.d(r125.getAppStringName(), r125.getApplication().getString(R.string.larus_dora_g_case_low_below20_cn), 22001);
        goto L46
    L44:
        g49.d.d("DoraChargingCaseNotificationManager", "handleCaseLowBattery return: already triggered");
    L45:
        g49.d.d("DoraChargingCaseNotificationManager", "handleCaseLowBattery return: not matching condition (charging: " + r104 + ", battery: " + r102 + ')');
        goto L46
    L26:
        if (r106.intValue() != 1) goto L28;
        r107 = true;
        goto L29
    L16:
        if (r103.intValue() != 1) goto L18;
        r104 = true;
        goto L19
    L11:
        r102 = -1;
    L116:
        g49.d.d("DoraChargingCaseNotificationManager", "handleBatteryChange return: battery or charge is null");
    }
}
