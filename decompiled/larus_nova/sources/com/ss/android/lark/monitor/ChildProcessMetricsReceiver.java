package com.ss.android.lark.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes36.dex */
public class ChildProcessMetricsReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f432306a = 0;

    public ChildProcessMetricsReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        String r102 = r101.getAction();
        LarkMetrics r103 = LarkMetrics.a.f432318a;
        if ("com.ss.android.lark.metrics.doMetrics".equals(r102) == false) goto L10;
        String r104 = r101.getStringExtra("activity_name");
        if (r103.f432314h == true) goto L7;
        return;
    L7:
        if (r103.f432310d.f432400d == true) goto L12;
        r103.b(r104);
        return;
    L12:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, ChildProcessMetricsReceiver r101, IntentFilter r110, String r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L29;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L29:
    L23:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L28;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111, null, 4);
        return;
    L28:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L8;
    L21:
        r100.registerReceiver(r101, r110, r111, null, 4);     // Catch: Exception -> L23
        return;
    L8:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L21;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 4, r111, null, 5, r100).result;     // Catch: Exception -> L23
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110, r111, null, 4);     // Catch: Exception -> L23
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L23
        return;
    L14:
        if (r102 == 3) goto L30;
        r100.registerReceiver(r101, r110, r111, null, 4);     // Catch: Exception -> L23
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r100, ChildProcessMetricsReceiver r110, IntentFilter r111, String r112) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L30;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L30:
    L24:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L29;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, r112, null);
        return;
    L29:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L9;
    L22:
        r100.registerReceiver(r110, r111, r112, null);     // Catch: Exception -> L24
        return;
    L9:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L22;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 0, r112, null, 4, r100).result;     // Catch: Exception -> L24
        if (r101 != 1) goto L13;
        r100.registerReceiver(r110, r111, r112, null);     // Catch: Exception -> L24
        return;
    L13:
        if (r101 != 2) goto L15;
        new Intent();     // Catch: Exception -> L24
        return;
    L15:
        if (r101 == 3) goto L31;
        r100.registerReceiver(r110, r111, r112, null);     // Catch: Exception -> L24
        return;
    }
}
