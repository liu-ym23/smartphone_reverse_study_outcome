package com.larus.cache;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements ThreadFactory {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f321248c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f321249d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f321250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f321251b;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f321252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f321253b;

        @Override // java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(this.f321253b);     // Catch: Throwable -> L4
            this.f321252a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "r");
            this.f321252a = r100;
            this.f321253b = 10;
        }
    }

    static {
        f321248c = new AtomicInteger(1);
        f321249d = new AtomicInteger(1);
    }

    public e() {
        Intrinsics.checkNotNullParameter("disk-lru-cache-pool", "poolName");
        this.f321250a = LazyKt.lazy(new d());
        this.f321251b = "disk-lru-cache-pool-" + f321248c.getAndIncrement() + '-';
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        if (r100 != null) goto L5;
        r100 = new c();
    L5:
        b r101 = new b(r100);
        PthreadThreadV2 r102 = new PthreadThreadV2((ThreadGroup) this.f321250a.getValue(), r101, this.f321251b + f321249d.getAndIncrement(), 0);
        if (r102.isDaemon() == false) goto L9;
        r102.setDaemon(false);
    L9:
        if (r102.getPriority() == 5) goto L11;
        ThreadMethodProxy.setPriority(r102, 5);
    L11:
        return r102;
    }
}
