package com.flow.performance.perflog.scenario;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f274159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<f09.a.b> f274160b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f274161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Boolean f274162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f274163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile String f274164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile long f274165g;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a implements com.flow.performance.perflog.scenario.a.InterfaceC3840a {
        public a() {
        }

        @Override // com.flow.performance.perflog.scenario.a.InterfaceC3840a
        public final void a(boolean r100) {
            b r101 = b.f274159a;
            Boolean r102 = Boolean.valueOf(r100);
            r101.getClass();
            b.f274162d = r102;
        }
    }

    /* JADX INFO: renamed from: com.flow.performance.perflog.scenario.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class C3841b implements ScreenStateMonitor.b {
        public C3841b() {
        }

        @Override // com.flow.performance.perflog.scenario.ScreenStateMonitor.b
        public final void onScreenOff() {
            b r100 = b.f274159a;
            String r101 = ScreenStateMonitor.ScreenState.SCREEN_OFF.getValue();
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            b.f274161c = r101;
        }

        @Override // com.flow.performance.perflog.scenario.ScreenStateMonitor.b
        public final void onScreenOn() {
            b r100 = b.f274159a;
            String r101 = ScreenStateMonitor.ScreenState.SCREEN_ON.getValue();
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            b.f274161c = r101;
        }

        @Override // com.flow.performance.perflog.scenario.ScreenStateMonitor.b
        public final void onUserPresent() {
            b r100 = b.f274159a;
            String r101 = ScreenStateMonitor.ScreenState.USER_PRESENT.getValue();
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            b.f274161c = r101;
        }
    }

    public b() {
    }

    static {
        f274159a = new b();
        f274160b = new CopyOnWriteArrayList();
        f274161c = ScreenStateMonitor.ScreenState.SCREEN_ON.getValue();
        f274164f = "foreground";
        f274165g = -1;
    }

    public static void a() {
        com.flow.performance.perflog.scenario.a r100 = com.flow.performance.perflog.scenario.a.f274156a;
        a r101 = new a();
        Intrinsics.checkNotNullParameter(r101, "listener");
        monitor-enter(r100);
        com.flow.performance.perflog.scenario.a.f274158c.add(r101);     // Catch: Throwable -> L48
        monitor-exit(r100);
        Application r102 = AppHost.f326268a.getApplication();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        IntentFilter r103 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        com.flow.performance.perflog.scenario.a.b r104 = new com.flow.performance.perflog.scenario.a.b();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L9;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L9:
        boolean r110 = true;
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L47;
        Intent r105 = ReceiverRegisterCrashOptimizer.registerReceiver(r104, r103);
    L37:
        if (r105 == null) goto L45;
        com.flow.performance.perflog.scenario.a r106 = com.flow.performance.perflog.scenario.a.f274156a;
        int r107 = r105.getIntExtra("status", -1);
        if (r107 != 2) goto L41;
    L44:
        com.flow.performance.perflog.scenario.a.f274157b = r110;
        goto L45
    L41:
        if (r107 == 5) goto L44;
        r110 = false;
    L45:
        com.flow.performance.perflog.scenario.a r108 = com.flow.performance.perflog.scenario.a.f274156a;
        f274162d = Boolean.valueOf(com.flow.performance.perflog.scenario.a.f274157b);
        return;
    L47:
        throw e;
    L11:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r103) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r109 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r104, r103, 0, null, null, 2, r102);     // Catch: Exception -> L33
        int r111 = r109.result;     // Catch: Exception -> L33
        if (r111 == 1) goto L22;
        if (r111 != 2) goto L18;
        r105 = new Intent();     // Catch: Exception -> L33
    L53:
        goto L37
    L18:
        if (r111 == 3) goto L20;
        r105 = r102.registerReceiver(r104, r103);     // Catch: Exception -> L33
        goto L53
    L20:
        r105 = r109.intent;     // Catch: Exception -> L33
        goto L53
    L22:
        r105 = r102.registerReceiver(r104, r103);     // Catch: Exception -> L33
    L24:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r105 = r102.registerReceiver(r104, r103, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        goto L53
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L31:
        r105 = r102.registerReceiver(r104, r103);     // Catch: Exception -> L33
        goto L53
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r103) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        r105 = ContextCompat.registerReceiver(r102, r104, r103, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    L48:
        th = move-exception;
        throw th;
    }

    public static void b() {
        CopyOnWriteArraySet<ScreenStateMonitor.b> r100 = ScreenStateMonitor.f274152a;
        C3841b r101 = new C3841b();
        Intrinsics.checkNotNullParameter(r101, "screenStateListener");
        if (ScreenStateMonitor.f274152a.isEmpty() == true) goto L5;
    L37:
        ScreenStateMonitor.f274152a.add(r101);
        return;
    L5:
        if (ScreenStateMonitor.f274153b != null) goto L37;
        ScreenStateMonitor.f274153b = new ScreenStateMonitor.a();
        IntentFilter r102 = new IntentFilter();
        r102.addAction("android.intent.action.SCREEN_OFF");
        r102.addAction("android.intent.action.SCREEN_ON");
        r102.addAction("android.intent.action.USER_PRESENT");
        Application r103 = AppHost.f326268a.getApplication();
        ScreenStateMonitor.a r110 = ScreenStateMonitor.f274153b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L32:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L36;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r102);
        goto L37
    L36:
        throw e;
    L10:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r102) == false) goto L23;
        int r104 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r102, 0, null, null, 2, r103).result;     // Catch: Exception -> L32
        if (r104 != 1) goto L16;
        r103.registerReceiver(r110, r102);     // Catch: Exception -> L32
    L39:
        goto L37
    L16:
        if (r104 != 2) goto L18;
        new Intent();     // Catch: Exception -> L32
        goto L39
    L18:
        if (r104 == 3) goto L39;
        r103.registerReceiver(r110, r102);     // Catch: Exception -> L32
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L32
        r103.registerReceiver(r110, r102, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L32
        goto L39
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L30:
        r103.registerReceiver(r110, r102);     // Catch: Exception -> L32
        goto L39
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r102) == false) goto L30;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L32
        ContextCompat.registerReceiver(r103, r110, r102, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L32
        goto L39
    }
}
