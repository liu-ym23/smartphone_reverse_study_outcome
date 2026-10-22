package com.bytedance.sdk.account.network.dispatcher;

import android.os.Process;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.account.k;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends PthreadThreadV2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final BlockingQueue<IRequest> f269209v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final BlockingQueue<IRequest> f269210w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f269211x;

    public final void l() {
        Process.setThreadPriority(10);
    L36:
        IRequest r100 = this.f269209v.take();     // Catch: InterruptedException -> L31
        if ((r100 instanceof b) == false) goto L7;
        b r101 = (b) r100;
    L8:
        if (r101 == null) goto L36;
        String r102 = ThreadMethodProxy.currentThread().getName();
        String r103 = r101.f269217e;
        if (r101.f269214b.get() == true) goto L36;
        if (StringUtils.isEmpty(r103) == false) goto L17;
    L19:
        k.d().isLocalTest();     // Catch: Throwable -> L24
        if (r101.f269218f != IRequest.Priority.IMMEDIATE) goto L22;
        ThreadPlus.submitRunnable(r101);     // Catch: Throwable -> L24
    L27:
        if (StringUtils.isEmpty(r103) == true) goto L36;
        if (StringUtils.isEmpty(r102) == true) goto L36;
        ThreadMethodProxy.setName(ThreadMethodProxy.currentThread(), r102);
        goto L36
    L22:
        r101.f269215c.removeMessages(0);     // Catch: Throwable -> L24
        r101.f269215c.sendEmptyMessageDelayed(0, 1000);     // Catch: Throwable -> L24
        this.f269210w.add(r101);     // Catch: Throwable -> L24
        goto L27
    L17:
        if (StringUtils.isEmpty(r102) == true) goto L19;
        ThreadMethodProxy.setName(ThreadMethodProxy.currentThread(), "ApiLocalDispatcher-" + r103);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        tb7.a.c("ApiLocalDispatcher", "run: ", th);
        goto L27
    L7:
        r101 = null;
    L32:
        if (this.f269211x == false) goto L36;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        l();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(BlockingQueue<IRequest> r100, BlockingQueue<IRequest> r101) {
        super("ApiLocalDispatcher-Thread");
        this.f269211x = false;
        this.f269209v = r100;
        this.f269210w = r101;
    }
}
