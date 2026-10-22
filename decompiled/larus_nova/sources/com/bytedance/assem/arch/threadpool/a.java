package com.bytedance.assem.arch.threadpool;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f193053d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadGroup f193054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f193055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f193056c;

    /* JADX INFO: renamed from: com.bytedance.assem.arch.threadpool.a$a, reason: collision with other inner class name */
    public static final class C2791a {
    }

    static {
        f193053d = new AtomicInteger(1);
    }

    public a() {
        this.f193055b = new AtomicInteger(1);
        SecurityManager r100 = System.getSecurityManager();
        if (r100 == null) goto L5;
        ThreadGroup r101 = r100.getThreadGroup();
    L6:
        this.f193054a = r101;
        this.f193056c = "pool-assem-core-" + f193053d.getAndIncrement() + "-thread-";
        return;
    L5:
        r101 = ThreadMethodProxy.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(this.f193054a, r100, this.f193056c + this.f193055b.getAndIncrement(), 0);
        if (r101.isDaemon() == false) goto L6;
        r101.setDaemon(false);
    L6:
        if (r101.getPriority() == 5) goto L8;
        ThreadMethodProxy.setPriority(r101, 5);
    L8:
        return r101;
    }
}
