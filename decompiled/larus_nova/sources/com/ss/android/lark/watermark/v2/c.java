package com.ss.android.lark.watermark.v2;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f445536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ApplicationBroadcastReceiverTimeTickerImpl$request$1 f445537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f445538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Function0<Unit>> f445539d;

    @Override // com.ss.android.lark.watermark.v2.n
    public final void clear() {
        if (this.f445538c.compareAndSet(false, true) == false) goto L20;
        ApplicationBroadcastReceiverTimeTickerImpl$request$1 r100 = this.f445537b;
        if (r100 == null) goto L16;
        Application r101 = this.f445536a;
        ReceiverRegisterLancet.loge(r100, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L18;
        r101.unregisterReceiver(r100);
    L15:
        this.f445537b = null;
        goto L16
    L18:
    L12:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r100.toString());
        e.printStackTrace();
        goto L15
    L9:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r100, r101) == false) goto L15;
        r101.unregisterReceiver(r100);     // Catch: Exception -> L12
    L16:
        this.f445539d.clear();
        return;
    }

    public c(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f445536a = r100;
        this.f445538c = new AtomicBoolean(true);
        this.f445539d = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.BroadcastReceiver, com.ss.android.lark.watermark.v2.ApplicationBroadcastReceiverTimeTickerImpl$request$1] */
    @Override // com.ss.android.lark.watermark.v2.n
    public final void a(Function0 r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        if (this.f445538c.compareAndSet(true, false) == false) goto L35;
        IntentFilter r100 = new IntentFilter("android.intent.action.TIME_TICK");
        ?? r101 = new ApplicationBroadcastReceiverTimeTickerImpl$request$1(this);
        this.f445537b = r101;
        Application r111 = this.f445536a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L38:
    L30:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r100);
        goto L35
    L34:
        throw e;
    L8:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L21;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L21;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r100, 0, null, null, 2, r111).result;     // Catch: Exception -> L30
        if (r102 != 1) goto L14;
        r111.registerReceiver(r101, r100);     // Catch: Exception -> L30
    L37:
        goto L35
    L14:
        if (r102 != 2) goto L16;
        new Intent();     // Catch: Exception -> L30
        goto L37
    L16:
        if (r102 == 3) goto L37;
        r111.registerReceiver(r101, r100);     // Catch: Exception -> L30
    L21:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L24;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L30
        r111.registerReceiver(r101, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L30
        goto L37
    L24:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L26;
    L28:
        r111.registerReceiver(r101, r100);     // Catch: Exception -> L30
        goto L37
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L28;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L30
        ContextCompat.registerReceiver(r111, r101, r100, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L30
    L35:
        this.f445539d.add(r110);
    }
}
