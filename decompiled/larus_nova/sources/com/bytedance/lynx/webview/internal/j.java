package com.bytedance.lynx.webview.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.lynx.webview.util.MSReceiver;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f265330a;

    public final void a() {
        IntentFilter r100 = new IntentFilter();
        r100.addAction("com.bytedance.lynx.webview.util.MSACTION");
        l17.k.d(new String[]{"on call initReceiver"});
        if (Build.VERSION.SDK_INT < 26) goto L34;
        Context r110 = this.f265330a;
        MSReceiver r111 = new MSReceiver();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L68;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L68:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L33;
        ReceiverRegisterCrashOptimizer.registerReceiver(r111, r100, 4);
        return;
    L33:
        throw e;
    L9:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L20;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r111, r100, 4, null, null, 3, r110).result;     // Catch: Exception -> L29
        if (r101 == 1) goto L18;
        if (r101 == 2) goto L17;
        if (r101 == 3) goto L67;
        r110.registerReceiver(r111, r100, 4);     // Catch: Exception -> L29
    L67:
        return;
    L17:
        new Intent();     // Catch: Exception -> L29
        goto L67
    L18:
        r110.registerReceiver(r111, r100, 4);     // Catch: Exception -> L29
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r110.registerReceiver(r111, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        goto L67
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r110.registerReceiver(r111, r100, 4);     // Catch: Exception -> L29
        goto L67
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        ContextCompat.registerReceiver(r110, r111, r100, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L29
        goto L67
    L34:
        Context r112 = this.f265330a;
        MSReceiver r113 = new MSReceiver();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L65;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L65:
    L58:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L63;
        ReceiverRegisterCrashOptimizer.registerReceiver(r113, r100);
        return;
    L63:
        throw e;
    L38:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L49;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L49;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r113, r100, 0, null, null, 2, r112).result;     // Catch: Exception -> L58
        if (r102 == 1) goto L47;
        if (r102 == 2) goto L46;
        if (r102 == 3) goto L64;
        r112.registerReceiver(r113, r100);     // Catch: Exception -> L58
    L64:
        return;
    L46:
        new Intent();     // Catch: Exception -> L58
        goto L64
    L47:
        r112.registerReceiver(r113, r100);     // Catch: Exception -> L58
    L49:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L52;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L58
        r112.registerReceiver(r113, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L58
        goto L64
    L52:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L54;
    L56:
        r112.registerReceiver(r113, r100);     // Catch: Exception -> L58
        goto L64
    L54:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L56;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L58
        ContextCompat.registerReceiver(r112, r113, r100, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L58
        goto L64
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(Context r100) {
        this.f265330a = r100;
    }
}
