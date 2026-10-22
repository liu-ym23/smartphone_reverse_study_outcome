package com.bytedance.sysoptimizer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Arrays;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
@Skip({"com.bytedance.thanos+", "com.tencent.tinker.loader+", "com.tencent.tinker.lib+"})
public class ReceiverRegisterLancet {
    public static String TAG = "ReceiverRegisterLancet";
    public static Handler sMainHandler;
    public static Handler sProxyHandler;
    public static volatile Handler sReceiverHandler;
    public static HandlerThread sReceiverHandlerThread;

    public ReceiverRegisterLancet() {
    }

    public static void initHandler() {
        if (sReceiverHandler == null) goto L5;
        return;
    L5:
        monitor-enter(ReceiverRegisterLancet.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sReceiverHandler != null) goto L9;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("ReceiverHandler");     // Catch: Throwable -> L11
        sReceiverHandlerThread = r100;     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L11
        sMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
        final Looper r101 = sReceiverHandlerThread.getLooper();     // Catch: Throwable -> L11
        sReceiverHandler = new AnonymousClass1(r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ReceiverRegisterLancet.class);     // Catch: Throwable -> L11
    }

    public static void initProxyHandler() {
        if (sProxyHandler == null) goto L5;
        return;
    L5:
        monitor-enter(ReceiverRegisterLancet.class);
        final Looper r100 = Looper.getMainLooper();     // Catch: Throwable -> L9
        sProxyHandler = new AnonymousClass2(r100);     // Catch: Throwable -> L9
        monitor-exit(ReceiverRegisterLancet.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public void unregisterReceiver(BroadcastReceiver r100) {
        loge(r100, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        Origin.callVoid();
        return;
    L14:
    L8:
        e = move-exception;
        if (r100 == null) goto L11;
        Npth.addTag("unregisterReceiver", r100.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r100, (Context) This.get()) == false) goto L16;
        Origin.callVoid();     // Catch: Exception -> L8
        return;
    }

    public static int logCat(String r100, String r101) {
        return Log.e(r100, r101);
    }

    public static void loge(BroadcastReceiver r100, boolean r101) {
        ReceiverLogInterface r102 = ReceiverRegisterCrashOptimizer.sReceiverLogInterface;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.enable() == false) goto L17;
        if (r100 == null) goto L8;
        String r103 = r100.toString();
    L10:
        if (TextUtils.isEmpty(r103) == false) goto L12;
        logCat("dy_receiver_monitor", Arrays.toString(ThreadMethodProxy.currentThread().getStackTrace()));
    L12:
        if (r101 == false) goto L14;
        ReceiverRegisterCrashOptimizer.sReceiverLogInterface.onRegister(r103);
        return;
    L14:
        ReceiverRegisterCrashOptimizer.sReceiverLogInterface.onUnRegister(r103);
        return;
    L8:
        r103 = "";
        goto L10
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public Intent registerReceiver(BroadcastReceiver r100, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r100, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r100, r110, 0, null, null, 2, (Context) This.get());     // Catch: Exception -> L36
        int r102 = r101.result;     // Catch: Exception -> L36
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L19;
        return (Intent) Origin.call();
    L19:
        return r101.intent;
    L21:
        return new Intent();
    L23:
        return (Intent) Origin.call();
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        initHandler();     // Catch: Exception -> L36
        return INVOKEVIRTUAL_com_bytedance_sysoptimizer_ReceiverRegisterLancet_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver((Context) This.get(), r100, r110, null, sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver((Context) This.get(), r100, r110, null, sProxyHandler, 2);
    L35:
        return (Intent) Origin.call();
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public Intent registerReceiver(BroadcastReceiver r100, IntentFilter r110, int r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r100, r110, r111);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r100, r110, r111, null, null, 3, (Context) This.get());     // Catch: Exception -> L36
        int r102 = r101.result;     // Catch: Exception -> L36
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L19;
        return (Intent) Origin.call();
    L19:
        return r101.intent;
    L21:
        return new Intent();
    L23:
        return (Intent) Origin.call();
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        initHandler();     // Catch: Exception -> L36
        return INVOKEVIRTUAL_com_bytedance_sysoptimizer_ReceiverRegisterLancet_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver((Context) This.get(), r100, r110, null, sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver((Context) This.get(), r100, r110, null, sProxyHandler, r111);
    L35:
        return (Intent) Origin.call();
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public Intent registerReceiver(BroadcastReceiver r100, IntentFilter r110, String r111, Handler r112) {
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
        return ReceiverRegisterCrashOptimizer.registerReceiver(r100, r110, r111, r112);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r100, r110, 0, r111, r112, 4, (Context) This.get());     // Catch: Exception -> L26
        int r102 = r101.result;     // Catch: Exception -> L26
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L19;
        return (Intent) Origin.call();
    L19:
        return r101.intent;
    L21:
        return new Intent();
    L23:
        return (Intent) Origin.call();
    L25:
        return (Intent) Origin.call();
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_sysoptimizer_ReceiverRegisterLancet_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, String r111, Handler r112) {
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

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public Intent registerReceiver(BroadcastReceiver r100, IntentFilter r110, String r111, Handler r112, int r113) {
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
        return ReceiverRegisterCrashOptimizer.registerReceiver(r100, r110, r111, r112, r113);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r100, r110, r113, r111, r112, 5, (Context) This.get());     // Catch: Exception -> L26
        int r102 = r101.result;     // Catch: Exception -> L26
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L19;
        return (Intent) Origin.call();
    L19:
        return r101.intent;
    L21:
        return new Intent();
    L23:
        return (Intent) Origin.call();
    L25:
        return (Intent) Origin.call();
    }
}
