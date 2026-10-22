package com.bytedance.bdp.bdpbase.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpThreadUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f201314a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PThreadPoolExecutor f201315b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f201316c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PThreadPoolExecutor f201317d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f201318e = null;

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f201319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f201320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f201321c;

        /* JADX INFO: renamed from: com.bytedance.bdp.bdpbase.util.BdpThreadUtil$a$a, reason: collision with other inner class name */
        public static final class C2901a extends PthreadThreadV2 {

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ Runnable f201322v;

            @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
            public final void run() {
                Process.setThreadPriority(getPriority());     // Catch: Throwable -> L4
                super.run();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public C2901a(Runnable r100, ThreadGroup r101, Runnable r102, String r110) {
                this.f201322v = r100;
                super(r101, r102, r110, 0);
            }
        }

        public a(String r100) {
            this.f201320b = new AtomicInteger(1);
            ThreadGroup r101 = new ThreadGroup("BdpPool");
            this.f201319a = r101;
            r101.setDaemon(false);
            r101.setMaxPriority(10);
            this.f201321c = "BdpPool-" + r100 + '-';
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            C2901a r101 = new C2901a(r100, this.f201319a, r100, this.f201321c + this.f201320b.getAndIncrement());
            if (r101.isDaemon() == false) goto L6;
            r101.setDaemon(false);
        L6:
            if (r101.getPriority() == 5) goto L8;
            ThreadMethodProxy.setPriority(r101, 5);
        L8:
            return r101;
        }
    }

    public static final class b extends PThreadPoolExecutor {
        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            super.execute(r100);     // Catch: OutOfMemoryError -> L4
            return;
        L4:
            BdpThreadUtil.f201317d.execute(r100);
        }

        public b(int r110, TimeUnit r111, BlockingQueue r112, a r113) {
            super(0, r110, 60, r111, r112, r113, c.f201323a);
        }
    }

    public static final class c implements RejectedExecutionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f201323a = null;

        static {
            f201323a = new c();
        }

        public c() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
            BdpThreadUtil.f201315b.execute(r100);
        }
    }

    static {
        f201314a = new Handler(Looper.getMainLooper());
        int r100 = Runtime.getRuntime().availableProcessors();
        int r110 = r100 - 2;
        int r101 = Math.max(2, r110);
        int r102 = Math.max(2, r110);
        TimeUnit r111 = TimeUnit.SECONDS;
        PThreadPoolExecutor r103 = new PThreadPoolExecutor(r101, r102, 30, r111, new LinkedBlockingQueue(), new a("FIX"));
        r103.allowCoreThreadTimeOut(true);
        f201315b = r103;
        c r112 = c.f201323a;
        f201316c = LazyKt.lazy(BdpThreadUtil$sSingle$2.INSTANCE);
        f201317d = new PThreadPoolExecutor(Math.max(4, r110), Math.max(8, r100 * 2), 30, r111, new LinkedBlockingQueue(64), new a("CPU"), r112);
        f201318e = new b(Math.max(16, r100 * 8), r111, new SynchronousQueue(), new a("IO"));
    }
}
