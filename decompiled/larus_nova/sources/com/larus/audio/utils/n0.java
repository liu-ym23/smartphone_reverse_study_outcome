package com.larus.audio.utils;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class n0 implements ThreadFactory {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f290088c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f290089d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f290090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f290091b;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f290092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f290093b;

        @Override // java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(this.f290093b);     // Catch: Throwable -> L4
            this.f290092a.run();     // Catch: Throwable -> L4
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
            this.f290092a = r100;
            this.f290093b = 10;
        }
    }

    static {
        f290088c = new AtomicInteger(1);
        f290089d = new AtomicInteger(1);
    }

    public n0() {
        Intrinsics.checkNotNullParameter("audio-disk-lru-cache-pool", "poolName");
        this.f290090a = LazyKt.lazy(new l0());
        this.f290091b = "audio-disk-lru-cache-pool-" + f290088c.getAndIncrement() + '-';
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        if (r100 != null) goto L5;
        r100 = new m0();
    L5:
        b r101 = new b(r100);
        PthreadThreadV2 r102 = new PthreadThreadV2((ThreadGroup) this.f290090a.getValue(), r101, this.f290091b + f290089d.getAndIncrement(), 0);
        if (r102.isDaemon() == false) goto L9;
        r102.setDaemon(false);
    L9:
        if (r102.getPriority() == 5) goto L11;
        ThreadMethodProxy.setPriority(r102, 5);
    L11:
        return r102;
    }
}
