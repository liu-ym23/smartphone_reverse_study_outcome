package com.bytedance.badger.network;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.badger.e;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes47.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f199110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f199111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f199112c;

    public j0(Context r100) {
        this.f199110a = Collections.synchronizedSet(new HashSet());
        this.f199111b = new AtomicBoolean(false);
        this.f199112c = r100;
    }

    public final synchronized void c(i0 r100) {
        monitor-enter(this);
        Iterator r101 = this.f199110a.iterator();     // Catch: Throwable -> L13 Exception -> L15
        e.f("NetObserver#", "unObserve");     // Catch: Throwable -> L13 Exception -> L15
    L5:
        if (r101.hasNext() == false) goto L17;
        WeakReference r102 = (WeakReference) r101.next();     // Catch: Throwable -> L13 Exception -> L15
        if (r102 == null) goto L8;
        if (((i0) r102.get()) != r100) goto L5;
        r101.remove();     // Catch: Throwable -> L13 Exception -> L15
    L8:
        r101.remove();     // Catch: Throwable -> L13 Exception -> L15
    L17:
        monitor-exit(this);
        return;
    L15:
        e = move-exception;
        e.c("NetObserver#", "unObserve error", e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(t0 r100) {
        monitor-enter(this);
        this.f199110a.add(new WeakReference(r100));     // Catch: Throwable -> L12
        if (this.f199111b.compareAndSet(false, true) == false) goto L10;
        h0 r101 = new h0(this);     // Catch: Throwable -> L12
        IntentFilter r102 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L12
        a(this.f199112c, r101, r102);     // Catch: Exception -> L8 Throwable -> L12
    L8:
        e = move-exception;
        e.c("NetObserver#", "net observer error", e);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, h0 r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
