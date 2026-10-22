package com.bytedance.timonbase.scene;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.report.TMMetric;
import com.bytedance.timonbase.scene.lifecycle.ForegroundState;
import com.bytedance.timonbase.utils.TMThreadUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import sh7.e;
import sh7.f;

/* JADX INFO: loaded from: classes3.dex */
public final class ScenesDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f270865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function0<Boolean> f270866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function0<Boolean> f270867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function0<Boolean> f270868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f270869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AppSilenceReferee f270870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static SensesUpdateBroadcastReceiver f270871g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f270872h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f270873i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ScenesDetector f270874j = null;

    public ScenesDetector() {
    }

    static {
        f270874j = new ScenesDetector();
    }

    public static boolean h() {
        if (TMEnv.f270768b == false) goto L11;
        ph7.c r100 = ph7.d.f529300a;
        if (r100 == null) goto L7;
        boolean r101 = r100.e();
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    L11:
        return false;
    }

    public static void l() {
        TMThreadUtils r100 = TMThreadUtils.f270906d;
        ScenesDetector$updateThreshold$1 r101 = ScenesDetector$updateThreshold$1.INSTANCE;
        r100.getClass();
        TMThreadUtils.a(r101);
    }

    public static long b() {
        if (h() == false) goto L18;
        AtomicBoolean r100 = b.f270882a;
        HashMap<Integer, String> r101 = qh7.b.f532975a;
        ph7.c r102 = ph7.d.f529300a;
        if (r102 == null) goto L7;
        long r103 = r102.b();
    L8:
        ForegroundState r104 = qh7.b.a();
        if (r104.f270887b == false) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == true) goto L17;
        return 0;
    L17:
        return System.currentTimeMillis() - qh7.b.a().f270888c;
    L12:
        if ((System.currentTimeMillis() - r104.f270888c) < r103) goto L14;
        r105 = true;
        goto L15
    L7:
        r103 = 0;
        goto L8
    L18:
        a r106 = f270869e;
        if (r106 != null) goto L21;
        return 0;
    L21:
        if (r106.f270879b != 0) goto L24;
        return 0;
    L24:
        return SystemClock.elapsedRealtime() - r106.f270879b;
    }

    public static boolean e() {
        if (h() == true) goto L12;
        Function0<Boolean> r100 = f270866b;
        if (r100 == null) goto L10;
        Boolean r101 = r100.invoke();
        if (r101 == null) goto L10;
        return r101.booleanValue();
    L10:
        com.bytedance.timonbase.b.c("ScenesDetector", "未注册隐私协议");
        return true;
    L12:
        return Boolean.valueOf(e.f541978a).booleanValue();
    }

    public static boolean f() {
        if (h() == false) goto L14;
        AtomicBoolean r100 = b.f270882a;
        HashMap<Integer, String> r101 = qh7.b.f532975a;
        ph7.c r102 = ph7.d.f529300a;
        if (r102 == null) goto L7;
        long r103 = r102.b();
    L8:
        ForegroundState r104 = qh7.b.a();
        if (r104.f270887b == false) goto L12;
        return false;
    L12:
        if ((System.currentTimeMillis() - r104.f270888c) < r103) goto L18;
        return true;
    L18:
        return false;
    L7:
        r103 = 0;
        goto L8
    L14:
        a r105 = f270869e;
        if (r105 != null) goto L17;
        return false;
    L17:
        return r105.f270878a;
    }

    public static boolean g() {
        if (h() == true) goto L12;
        Function0<Boolean> r100 = f270867c;
        if (r100 == null) goto L10;
        Boolean r101 = r100.invoke();
        if (r101 == null) goto L10;
        return r101.booleanValue();
    L10:
        com.bytedance.timonbase.b.c("ScenesDetector", "未注册基础模式");
        return false;
    L12:
        return Boolean.valueOf(sh7.b.f541975a).booleanValue();
    }

    public static boolean i() {
        if (h() == true) goto L12;
        Function0<Boolean> r100 = f270868d;
        if (r100 == null) goto L10;
        Boolean r101 = r100.invoke();
        if (r101 == null) goto L10;
        return r101.booleanValue();
    L10:
        com.bytedance.timonbase.b.c("ScenesDetector", "未注册青少年模式");
        return false;
    L12:
        return Boolean.valueOf(f.f541980a).booleanValue();
    }

    public static final void a(Application r110) {
        if (h() == false) goto L134;
        ph7.c r100 = ph7.d.f529300a;
        if (r100 == null) goto L7;
        boolean r101 = r100.c();
    L9:
        if (b.f270882a.get() == true) goto L59;
        b r102 = b.f270883b;
        monitor-enter(r102);
        Object r103 = r110.getSystemService("activity");     // Catch: Throwable -> L131
        if ((r103 instanceof ActivityManager) == true) goto L16;
        r103 = null;
    L16:
        ActivityManager r104 = (ActivityManager) r103;     // Catch: Throwable -> L131
        if (r101 == false) goto L38;
        if (r104 == null) goto L34;
        List<ActivityManager.RunningAppProcessInfo> r105 = r104.getRunningAppProcesses();     // Catch: Throwable -> L131
        if (r105 == null) goto L34;
        Iterator<T> r106 = r105.iterator();     // Catch: Throwable -> L131
    L23:
        if (r106.hasNext() == false) goto L32;
        Object r107 = r106.next();     // Catch: Throwable -> L131
        ActivityManager.RunningAppProcessInfo r108 = (ActivityManager.RunningAppProcessInfo) r107;     // Catch: Throwable -> L131
        if (ArraysKt.contains(r108.pkgList, r110.getPackageName()) == true) goto L27;
    L29:
        boolean r109 = false;
    L30:
        if (r109 == false) goto L23;
    L33:
        ActivityManager.RunningAppProcessInfo r111 = (ActivityManager.RunningAppProcessInfo) r107;     // Catch: Throwable -> L131
    L35:
        if (r111 != null) goto L55;
    L56:
        boolean r112 = false;
    L57:
        r110.registerActivityLifecycleCallbacks(qh7.b.f532979e);     // Catch: Throwable -> L131
        qh7.a.b(r110, r112);     // Catch: Throwable -> L131
        b.f270882a.set(true);     // Catch: Throwable -> L131
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L131
        monitor-exit(r102);
    L55:
        r112 = true;
        goto L57
    L27:
        if (r108.importance > 100) goto L29;
        r109 = true;
        goto L30
    L32:
        r107 = null;
    L34:
        r111 = null;
        goto L35
    L38:
        if (Build.VERSION.SDK_INT < 23) goto L56;
        if (r104 == null) goto L53;
        List<ActivityManager.AppTask> r114 = r104.getAppTasks();     // Catch: Throwable -> L131
        if (r114 == null) goto L53;
        Iterator<T> r115 = r114.iterator();     // Catch: Throwable -> L131
    L44:
        if (r115.hasNext() == false) goto L51;
        Object r116 = r115.next();     // Catch: Throwable -> L131
        if (((ActivityManager.AppTask) r116).getTaskInfo().baseActivity == null) goto L48;
        boolean r117 = true;
    L49:
        if (r117 == false) goto L44;
    L52:
        ActivityManager.AppTask r118 = (ActivityManager.AppTask) r116;     // Catch: Throwable -> L131
    L54:
        if (r118 == null) goto L56;
    L48:
        r117 = false;
        goto L49
    L51:
        r116 = null;
    L53:
        r118 = null;
    L131:
        th = move-exception;
        throw th;
    L59:
        f270871g = new SensesUpdateBroadcastReceiver(r110);
        if (r110.getApplicationInfo().targetSdkVersion >= 34) goto L62;
    L93:
        SensesUpdateBroadcastReceiver r119 = f270871g;
        IntentFilter r120 = new IntentFilter("com.bytedance.timon.base.APP_SENSE_UPDATE_ACTION");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L138;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L138:
    L117:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L130;
        ReceiverRegisterCrashOptimizer.registerReceiver(r119, r120);
    L121:
        Function0<Boolean> r121 = f270866b;
        if (r121 == null) goto L124;
        boolean r122 = r121.invoke().booleanValue();
        SensesUpdateBroadcastReceiver.a r123 = SensesUpdateBroadcastReceiver.f270877c;
        Boolean r124 = Boolean.valueOf(r122);
        r123.getClass();
        SensesUpdateBroadcastReceiver.a.a(0, r124);
    L124:
        Function0<Boolean> r125 = f270868d;
        if (r125 == null) goto L127;
        boolean r126 = r125.invoke().booleanValue();
        SensesUpdateBroadcastReceiver.a r127 = SensesUpdateBroadcastReceiver.f270877c;
        Boolean r128 = Boolean.valueOf(r126);
        r127.getClass();
        SensesUpdateBroadcastReceiver.a.a(1, r128);
    L127:
        Function0<Boolean> r129 = f270867c;
        if (r129 == null) goto L153;
        boolean r130 = r129.invoke().booleanValue();
        SensesUpdateBroadcastReceiver.a r131 = SensesUpdateBroadcastReceiver.f270877c;
        Boolean r132 = Boolean.valueOf(r130);
        r131.getClass();
        SensesUpdateBroadcastReceiver.a.a(2, r132);
        return;
    L153:
        return;
    L130:
        throw e;
    L97:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L108;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r120) == false) goto L108;
        int r133 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r119, r120, 0, null, null, 2, r110).result;     // Catch: Exception -> L117
        if (r133 == 1) goto L106;
        if (r133 == 2) goto L105;
        if (r133 == 3) goto L137;
        r110.registerReceiver(r119, r120);     // Catch: Exception -> L117
    L137:
        goto L121
    L105:
        new Intent();     // Catch: Exception -> L117
        goto L137
    L106:
        r110.registerReceiver(r119, r120);     // Catch: Exception -> L117
    L108:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L111;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L117
        r110.registerReceiver(r119, r120, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L117
        goto L137
    L111:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L113;
    L115:
        r110.registerReceiver(r119, r120);     // Catch: Exception -> L117
        goto L137
    L113:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r120) == false) goto L115;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L117
        ContextCompat.registerReceiver(r110, r119, r120, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L117
        goto L137
    L62:
        if (Build.VERSION.SDK_INT < 34) goto L93;
        SensesUpdateBroadcastReceiver r134 = f270871g;
        IntentFilter r135 = new IntentFilter("com.bytedance.timon.base.APP_SENSE_UPDATE_ACTION");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L141;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L141:
    L88:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L92;
        ReceiverRegisterCrashOptimizer.registerReceiver(r134, r135, 4);
        goto L121
    L92:
        throw e;
    L68:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L79;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r135) == false) goto L79;
        int r136 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r134, r135, 4, null, null, 3, r110).result;     // Catch: Exception -> L88
        if (r136 == 1) goto L77;
        if (r136 == 2) goto L76;
        if (r136 == 3) goto L140;
        r110.registerReceiver(r134, r135, 4);     // Catch: Exception -> L88
    L140:
        goto L121
    L76:
        new Intent();     // Catch: Exception -> L88
        goto L140
    L77:
        r110.registerReceiver(r134, r135, 4);     // Catch: Exception -> L88
    L79:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L82;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L88
        r110.registerReceiver(r134, r135, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L88
        goto L140
    L82:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L84;
    L86:
        r110.registerReceiver(r134, r135, 4);     // Catch: Exception -> L88
        goto L140
    L84:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r135) == false) goto L86;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L88
        ContextCompat.registerReceiver(r110, r134, r135, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L88
        goto L140
    L7:
        r101 = false;
        goto L9
    }

    public final void j(Application r100) {
        if (f270865a == false) goto L5;
        return;
    L5:
        f270865a = true;
        f270872h = SystemClock.elapsedRealtime();
        c(this, false, true, 31);
        TMThreadUtils r101 = TMThreadUtils.f270906d;
        ScenesDetector$pureInit$1 r102 = ScenesDetector$pureInit$1.INSTANCE;
        r101.getClass();
        ((Handler) TMThreadUtils.f270905c.getValue()).postDelayed(new com.bytedance.timonbase.utils.b(r102), 30000);
        if (f270869e != null) goto L8;
        boolean r103 = TMEnv.f270767a;
        f270869e = new a(r100);
    L8:
        a r104 = f270869e;
        if (r104 == null) goto L12;
        r104.a(ScenesDetector$pureInit$2.INSTANCE);
        return;
    }

    public final void k(final Application r100) {
        j(r100);
        boolean r101 = TMEnv.f270767a;
        ph7.c r102 = ph7.d.a();
        if (r102 == null) goto L5;
        ph7.d.f529300a = r102;
    L5:
        ph7.c r103 = ph7.d.f529300a;
        if (r103 == null) goto L8;
        boolean r104 = r103.f();
    L9:
        if (r104 == false) goto L15;
        ph7.c r105 = ph7.d.f529300a;
        if (r105 == null) goto L13;
        long r106 = r105.g();
    L14:
        f270870f = new AppSilenceReferee(r106);
        goto L15
    L13:
        r106 = 600000;
    L15:
        TMThreadUtils r107 = TMThreadUtils.f270906d;
        Function0<Unit> r108 = new ScenesDetector$start$2(r100);
        r107.getClass();
        TMThreadUtils.a(r108);
        return;
    L8:
        r104 = false;
        goto L9
    }

    public static void d(String r100, int r101) {
        boolean r102 = TMEnv.f270767a;
        ph7.c r103 = ph7.d.f529300a;
        if (r103 == null) goto L5;
        ph7.c r104 = ph7.c.a(r103, false);
    L6:
        ph7.d.f529300a = r104;
        TMMetric.e(r101, r100);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static int c(ScenesDetector r110, boolean r111, boolean r112, int r113) {
        int r100 = 0;
        if ((r113 & 1) == 0) goto L9;
        r110.getClass();
        if (f() == false) goto L9;
        if (b() < 30000) goto L9;
        boolean r101 = true;
    L11:
        if ((r113 & 2) == 0) goto L13;
        r110.getClass();
        boolean r102 = e();
    L15:
        if ((r113 & 4) == 0) goto L17;
        r110.getClass();
        boolean r103 = g();
    L19:
        if ((r113 & 8) == 0) goto L21;
        r110.getClass();
        boolean r104 = TMEnv.f270767a;
        boolean r105 = i();
    L23:
        if ((r113 & 16) == 0) goto L33;
        r110.getClass();
        if (f270873i > 0) goto L27;
        long r106 = Long.MAX_VALUE;
    L29:
        if (r106 >= 30000) goto L31;
        r111 = true;
        goto L33
    L31:
        r111 = false;
        goto L33
    L27:
        r106 = SystemClock.elapsedRealtime() - f270873i;
    L33:
        if ((r113 & 32) == 0) goto L38;
        r110.getClass();
        if ((SystemClock.elapsedRealtime() - f270872h) >= 30000) goto L37;
        r112 = true;
        goto L38
    L37:
        r112 = false;
    L38:
        r110.getClass();
        if (r101 == false) goto L41;
        int r114 = 16;
    L42:
        int r115 = r114 | 1;
        if (r102 == false) goto L45;
        int r116 = 0;
    L46:
        int r117 = r115 | r116;
        if (r103 == false) goto L49;
        int r118 = 4;
    L50:
        int r119 = r117 | r118;
        if (r105 == false) goto L53;
        int r120 = 8;
    L54:
        int r121 = r119 | r120;
        if (r111 == false) goto L57;
        int r122 = 64;
    L58:
        int r123 = r121 | r122;
        if (r112 == false) goto L62;
        r100 = 32;
    L62:
        return r123 | r100;
    L57:
        r122 = 0;
        goto L58
    L53:
        r120 = 0;
        goto L54
    L49:
        r118 = 0;
        goto L50
    L45:
        r116 = 2;
        goto L46
    L41:
        r114 = 0;
        goto L42
    L21:
        r105 = false;
        goto L23
    L17:
        r103 = false;
        goto L19
    L13:
        r102 = false;
    L9:
        r101 = false;
        goto L11
    }
}
