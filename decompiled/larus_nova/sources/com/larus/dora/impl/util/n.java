package com.larus.dora.impl.util;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import kotlin.Lazy;
import kotlin.LazyKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes27.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f338147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f338148b = null;

    static {
        f338147a = LazyKt.lazy(new l());
        f338148b = LazyKt.lazy(new m());
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Application r100, IntentFilter r110) {
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
        return ReceiverRegisterCrashOptimizer.registerReceiver(null, r110);
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r102 = r101.result;     // Catch: Exception -> L36
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L19;
        return r100.registerReceiver(null, r110);
    L19:
        return r101.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(null, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(null, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, null, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(null, r110);
    }
}
