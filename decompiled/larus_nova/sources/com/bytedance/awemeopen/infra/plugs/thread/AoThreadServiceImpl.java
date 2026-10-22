package com.bytedance.awemeopen.infra.plugs.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.bytedance.awemeopen.servicesapi.thread.AoThreadService;
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

/* JADX INFO: loaded from: classes3.dex */
public class AoThreadServiceImpl implements AoThreadService {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f198903d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f198904e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f198905f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PThreadPoolExecutor f198906g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PThreadPoolExecutor f198907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PThreadPoolExecutor f198908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f198909c;

    public static class a implements RejectedExecutionHandler {
        public a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
            AoThreadServiceImpl.f198906g.execute(r100);
        }
    }

    public class b extends PThreadPoolExecutor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AoThreadServiceImpl f198910a;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            super.execute(r100);     // Catch: OutOfMemoryError -> L4
            return;
        L4:
            this.f198910a.f198907a.execute(r100);
        }

        public b(AoThreadServiceImpl r110, TimeUnit r111, BlockingQueue r112, c r113, a r114) {
            this.f198910a = r110;
            super(0, 64, 60, r111, r112, r113, r114);
        }
    }

    public static class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f198911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f198912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f198913c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f198914d;

        /* JADX INFO: loaded from: classes46.dex */
        public class a extends PthreadThreadV2 {

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ c f198915v;

            @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
            public final void run() {
                Process.setThreadPriority(this.f198915v.f198914d);     // Catch: Throwable -> L4
                super.run();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(c r100, ThreadGroup r101, Runnable r102, String r110) {
                this.f198915v = r100;
                super(r101, r102, r110, 0);
            }
        }

        public c(String r100) {
            this.f198912b = new AtomicInteger(1);
            ThreadGroup r101 = new ThreadGroup("BdpPool");
            this.f198911a = r101;
            r101.setDaemon(false);
            r101.setMaxPriority(10);
            this.f198913c = "BdpPool-" + r100 + "-";
            this.f198914d = 0;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            a r101 = new a(this, this.f198911a, r100, this.f198913c + this.f198912b.getAndIncrement());
            if (r101.isDaemon() == false) goto L6;
            r101.setDaemon(false);
        L6:
            if (r101.getPriority() == 5) goto L8;
            ThreadMethodProxy.setPriority(r101, 5);
        L8:
            return r101;
        }
    }

    static {
        f198903d = new Handler(Looper.getMainLooper());
        int r100 = Runtime.getRuntime().availableProcessors();
        f198904e = r100;
        f198905f = new a();
        PThreadPoolExecutor r101 = new PThreadPoolExecutor(Math.max(2, r100 - 2), Math.max(2, r100 - 2), 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c("FIX"));
        f198906g = r101;
        r101.allowCoreThreadTimeOut(true);
    }

    public AoThreadServiceImpl() {
        int r100 = f198904e;
        int r101 = Math.max(4, r100 - 1);
        int r102 = Math.max(8, r100 * 2);
        TimeUnit r103 = TimeUnit.SECONDS;
        LinkedBlockingQueue r110 = new LinkedBlockingQueue(64);
        c r111 = new c("CPU");
        a r104 = f198905f;
        this.f198907a = new PThreadPoolExecutor(r101, r102, 30, r103, r110, r111, r104);
        this.f198908b = new PThreadPoolExecutor(1, 1, 30, r103, new LinkedBlockingQueue(64), new c("Logic"), r104);
        this.f198909c = new b(this, r103, new SynchronousQueue(), new c("IO"), r104);
    }

    @Override // com.bytedance.awemeopen.servicesapi.thread.AoThreadService
    public final void c(Runnable r100) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r100.run();
        return;
    L5:
        f198903d.post(r100);
    }

    @Override // com.bytedance.awemeopen.servicesapi.thread.AoThreadService
    public final void executeIO(Runnable r100) {
        this.f198909c.execute(r100);
    }

    @Override // com.bytedance.awemeopen.servicesapi.thread.AoThreadService
    public final void executeLogic(Runnable r100) {
        this.f198908b.execute(r100);
    }

    @Override // com.bytedance.awemeopen.servicesapi.thread.AoThreadService
    public final void p1(Runnable r100) {
        f198903d.removeCallbacks(r100);
    }

    @Override // com.bytedance.awemeopen.servicesapi.thread.AoThreadService
    public final void F(Runnable r100, long r101) {
        if (r101 > 0) goto L6;
        c(r100);
        return;
    L6:
        f198903d.postDelayed(r100, r101);
    }
}
