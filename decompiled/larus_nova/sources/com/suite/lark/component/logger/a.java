package com.suite.lark.component.logger;

import android.os.Looper;
import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.suite.component.logger.Log;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements com.suite.component.logger.api.c, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayBlockingQueue<com.suite.component.logger.c> f460148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PthreadThreadV2 f460149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f460150c;

    @Override // com.suite.component.logger.api.c
    public final void b() {
        this.f460150c = true;
        ThreadMethodProxy.start(this.f460149b);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);     // Catch: Throwable -> L10
    L5:
        if (this.f460150c == false) goto L22;
        com.suite.component.logger.c r100 = this.f460148a.take();     // Catch: Throwable -> L10
        if (r100 == null) goto L5;
        com.suite.component.logger.d.b(r100);     // Catch: Throwable -> L10
        goto L5
    L22:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }

    public a() {
        this.f460148a = new ArrayBlockingQueue(2000);
        this.f460149b = new PthreadThreadV2(this, "log-handler");
    }

    @Override // com.suite.component.logger.api.c
    public final boolean isRunning() {
        return this.f460150c;
    }

    @Override // com.suite.component.logger.api.c
    public final void a(com.suite.component.logger.c r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == true) goto L5;
        com.suite.component.logger.d.b(r100);
        return;
    L5:
        if (this.f460148a.offer(r100) == true) goto L11;
        com.suite.lark.component.logger.dynamic.a r101 = Log.f460091e;
        if (r101 == null) goto L12;
        r101.e(r100, 2000);
        return;
    L12:
        return;
    }
}
