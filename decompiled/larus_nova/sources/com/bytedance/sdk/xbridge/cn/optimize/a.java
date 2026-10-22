package com.bytedance.sdk.xbridge.cn.optimize;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f269935d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadGroup f269936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f269937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f269938c;

    /* JADX INFO: renamed from: com.bytedance.sdk.xbridge.cn.optimize.a$a, reason: collision with other inner class name */
    public static final class C3773a {
    }

    static {
        f269935d = new AtomicInteger(1);
    }

    public a() {
        Intrinsics.checkNotNullParameter("bdx_bridge_serial_executors", "factoryTag");
        this.f269937b = new AtomicInteger(1);
        SecurityManager r100 = System.getSecurityManager();
        if (r100 == null) goto L5;
        ThreadGroup r101 = r100.getThreadGroup();
    L6:
        this.f269936a = r101;
        this.f269938c = "bdx_bridge_serial_executors-" + f269935d.getAndIncrement() + "-Thread-";
        return;
    L5:
        r101 = ThreadMethodProxy.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        PthreadThreadV2 r101 = new PthreadThreadV2(this.f269936a, r100, this.f269938c + this.f269937b.getAndIncrement(), 0);
        if (r101.isDaemon() == false) goto L6;
        r101.setDaemon(false);
    L6:
        if (r101.getPriority() == 5) goto L8;
        ThreadMethodProxy.setPriority(r101, 5);
    L8:
        return r101;
    }
}
