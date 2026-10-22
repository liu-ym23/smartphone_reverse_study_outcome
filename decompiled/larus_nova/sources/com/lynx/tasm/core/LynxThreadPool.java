package com.lynx.tasm.core;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.g0;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxThreadPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Executor f383247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Executor f383248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Executor f383249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Executor f383250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Executor f383251e;

    public static final enum ConcurrentTaskType extends Enum<ConcurrentTaskType> {
        public static final ConcurrentTaskType HIGH_PRIORITY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ConcurrentTaskType[] f383252a = null;

        static {
            ConcurrentTaskType r100 = new ConcurrentTaskType();
            HIGH_PRIORITY = r100;
            f383252a = new ConcurrentTaskType[]{r100};
        }

        public ConcurrentTaskType() {
            super("HIGH_PRIORITY", 0);
        }

        public static ConcurrentTaskType[] values() {
            return (ConcurrentTaskType[]) f383252a.clone();
        }

        public static ConcurrentTaskType valueOf(String r100) {
            return (ConcurrentTaskType) r27.a.a(ConcurrentTaskType.class, r100);
        }
    }

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f383253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f383254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f383255c;

        /* JADX INFO: renamed from: com.lynx.tasm.core.LynxThreadPool$a$a, reason: collision with other inner class name */
        public class C4571a implements Thread.UncaughtExceptionHandler {
            public C4571a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread r100, Throwable r101) {
                r101.toString();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, this.f383254b + "-" + this.f383253a.getAndIncrement());
            if (r101.isDaemon() == false) goto L5;
            r101.setDaemon(false);
        L5:
            ThreadMethodProxy.setPriority(r101, this.f383255c);
            r101.setUncaughtExceptionHandler(new C4571a());
            return r101;
        }

        public a(String r100, int r101) {
            this.f383254b = r100;
            this.f383255c = r101;
            this.f383253a = new AtomicInteger(1);
        }
    }

    public static class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
        }
    }

    public LynxThreadPool() {
    }

    public static Executor a() {
        if (f383248b != null) goto L15;
        monitor-enter(LynxThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f383248b != null) goto L9;
        f383248b = c("lynx-card-service-thread", 10, 2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return f383248b;
    }

    public static Executor b() {
        if (f383247a != null) goto L15;
        monitor-enter(LynxThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f383247a != null) goto L9;
        f383247a = c("lynx-brief-io-thread", 3, 2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return f383247a;
    }

    public static Executor d() {
        if (f383249c != null) goto L15;
        monitor-enter(LynxThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f383249c != null) goto L9;
        f383249c = c("lynx-image-request-thread", 10, 1);     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return f383249c;
    }

    public static Executor e() {
        if (f383250d != null) goto L15;
        monitor-enter(LynxThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f383250d != null) goto L9;
        f383250d = c("lynx-svg-thread", 3, 1);     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return f383250d;
    }

    public static Future f(g0 r100) {
        FutureTask r101 = new FutureTask(r100);
        LynxEnv.runJavaTaskOnConcurrentLoop(new m(r101), ConcurrentTaskType.HIGH_PRIORITY.ordinal());
        return r101;
    }

    public static void g(Runnable r100) {
        LynxEnv.runJavaTaskOnConcurrentLoop(r100, ConcurrentTaskType.HIGH_PRIORITY.ordinal());
    }

    public static Executor c(String r100, int r101, int r102) {
        return PThreadExecutorsUtils.newFixedThreadPool(r102, new a(r100, r101));
    L4:
        th = move-exception;
        th.toString();
        return new b();
    }
}
