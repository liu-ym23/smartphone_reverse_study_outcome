package com.flow.performance.perflog.scenario;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import f09.a;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static final b a = null;
    public static final CopyOnWriteArrayList<a.b> b = null;
    public static volatile String c;
    public static volatile Boolean d;
    public static volatile boolean e;
    public static volatile String f;
    public static volatile long g;

    public b() {
    }

    static {
        a = new b();
        b = new CopyOnWriteArrayList();
        c = ScreenStateMonitor$ScreenState.SCREEN_ON.getValue();
        f = "foreground";
        g = -1;
    }

    public static void a() {
        a r0 = a.a;
        a r1 = new a();
        Intrinsics.checkNotNullParameter(r1, "listener");
        monitor-enter(r0);
        a.c.add(r1);     // Catch: Throwable -> L48
        monitor-exit(r0);
        Application r2 = AppHost.a.getApplication();
        Intrinsics.checkNotNullParameter(r2, "context");
        IntentFilter r8 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        a.b r9 = new a.b();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L9;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L9:
        boolean r10 = true;
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L47;
        Intent r3 = ReceiverRegisterCrashOptimizer.registerReceiver(r9, r8);
    L37:
        if (r3 == null) goto L45;
        a r4 = a.a;
        int r5 = r3.getIntExtra("status", -1);
        if (r5 != 2) goto L41;
    L44:
        a.b = r10;
        goto L45
    L41:
        if (r5 == 5) goto L44;
        r10 = false;
    L45:
        a r6 = a.a;
        d = Boolean.valueOf(a.b);
        return;
    L47:
        throw e;
    L11:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r8) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r7 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r8, 0, null, null, 2, r2);     // Catch: Exception -> L33
        int r11 = r7.result;     // Catch: Exception -> L33
        if (r11 == 1) goto L22;
        if (r11 != 2) goto L18;
        r3 = new Intent();     // Catch: Exception -> L33
    L53:
        goto L37
    L18:
        if (r11 == 3) goto L20;
        r3 = r2.registerReceiver(r9, r8);     // Catch: Exception -> L33
        goto L53
    L20:
        r3 = r7.intent;     // Catch: Exception -> L33
        goto L53
    L22:
        r3 = r2.registerReceiver(r9, r8);     // Catch: Exception -> L33
    L24:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r3 = r2.registerReceiver(r9, r8, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        goto L53
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L31:
        r3 = r2.registerReceiver(r9, r8);     // Catch: Exception -> L33
        goto L53
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r8) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        r3 = ContextCompat.registerReceiver(r2, r9, r8, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    L48:
        th = move-exception;
        throw th;
    }

    public static void b() {
        CopyOnWriteArraySet r0 = ScreenStateMonitor.a;
        b r1 = new b();
        Intrinsics.checkNotNullParameter(r1, "screenStateListener");
        if (ScreenStateMonitor.a.isEmpty() == true) goto L5;
    L37:
        ScreenStateMonitor.a.add(r1);
        return;
    L5:
        if (ScreenStateMonitor.b != null) goto L37;
        ScreenStateMonitor.b = new ScreenStateMonitor.a();
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.intent.action.SCREEN_OFF");
        r2.addAction("android.intent.action.SCREEN_ON");
        r2.addAction("android.intent.action.USER_PRESENT");
        Application r9 = AppHost.a.getApplication();
        ScreenStateMonitor.a r10 = ScreenStateMonitor.b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L32:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L36;
        ReceiverRegisterCrashOptimizer.registerReceiver(r10, r2);
        goto L37
    L36:
        throw e;
    L10:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r2) == false) goto L23;
        int r3 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r10, r2, 0, null, null, 2, r9).result;     // Catch: Exception -> L32
        if (r3 != 1) goto L16;
        r9.registerReceiver(r10, r2);     // Catch: Exception -> L32
    L39:
        goto L37
    L16:
        if (r3 != 2) goto L18;
        new Intent();     // Catch: Exception -> L32
        goto L39
    L18:
        if (r3 == 3) goto L39;
        r9.registerReceiver(r10, r2);     // Catch: Exception -> L32
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L32
        r9.registerReceiver(r10, r2, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L32
        goto L39
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L30:
        r9.registerReceiver(r10, r2);     // Catch: Exception -> L32
        goto L39
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r2) == false) goto L30;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L32
        ContextCompat.registerReceiver(r9, r10, r2, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L32
        goto L39
    }
}
