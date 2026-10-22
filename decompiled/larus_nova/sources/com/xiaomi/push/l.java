package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Handler f464122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f962a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Handler f464123b;

    public l() {
    }

    static {
        f962a = new Object();
    }

    public static Handler a() {
        if (f464123b != null) goto L15;
        Object r100 = f962a;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f464123b != null) goto L9;
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("receiver_task");     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r101);     // Catch: Throwable -> L11
        f464123b = new Handler(r101.getLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return f464123b;
    }

    private static Handler b() {
        if (f464122a != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f464122a != null) goto L9;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("handle_receiver");     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L11
        f464122a = new Handler(r100.getLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f464122a;
    }

    public static Intent a(Context r100, BroadcastReceiver r101, IntentFilter r102, int r103) {
        return a(r100, r101, r102, null, r103);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_xiaomi_push_l_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, String r111, Handler r112) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111, r112);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, r111, r112, 4, r100);     // Catch: Exception -> L26
        int r103 = r102.result;     // Catch: Exception -> L26
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111, r112);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111, r112);
    L25:
        return r100.registerReceiver(r101, r110, r111, r112);
    }

    public static Intent a(Context r100, BroadcastReceiver r101, IntentFilter r102, String r103, int r110) {
        return a(r100, r101, r102, r103, b(), r110);
    }

    public static Intent a(Context r100, BroadcastReceiver r101, IntentFilter r102, String r103, Handler r110) {
        return a(r100, r101, r102, r103, r110, 2);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_xiaomi_push_l_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, String r111, Handler r112, int r113) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111, r112, r113);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, r113, r111, r112, 5, r100);     // Catch: Exception -> L26
        int r103 = r102.result;     // Catch: Exception -> L26
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111, r112, r113);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111, r112, r113);
    L25:
        return r100.registerReceiver(r101, r110, r111, r112, r113);
    }

    public static Intent a(Context r100, BroadcastReceiver r101, IntentFilter r102, String r103, Handler r104, int r105) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L14;
        if (r102 != null) goto L7;
        return null;
    L7:
        if (Build.VERSION.SDK_INT < 33) goto L11;
        return INVOKEVIRTUAL_com_xiaomi_push_l_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102, r103, r104, r105);
    L11:
        return INVOKEVIRTUAL_com_xiaomi_push_l_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102, r103, r104);
    L14:
        return null;
    L12:
        return null;
    }
}
