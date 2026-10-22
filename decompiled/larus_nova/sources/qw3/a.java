package qw3;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f534981a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f534982b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BlockingQueue<Runnable> f534983c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f534984d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final RejectedExecutionHandlerC7401a f534985e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f534986f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f534987g = null;

    /* JADX INFO: renamed from: qw3.a$a, reason: collision with other inner class name */
    public static class RejectedExecutionHandlerC7401a implements RejectedExecutionHandler {
        public RejectedExecutionHandlerC7401a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
            PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("AppLogExecutors$1")).execute(r100);
        }
    }

    public static class b extends com.bytedance.applog.log.b<qw3.b> {
        public b() {
        }

        @Override // com.bytedance.applog.log.b
        public final qw3.b a(Object[] r110) {
            qw3.b r111 = new qw3.b(a.f534981a, a.f534982b, 30, TimeUnit.SECONDS, a.f534983c, a.f534984d, a.f534985e);
            r111.allowCoreThreadTimeOut(true);
            return r111;
        }
    }

    public static class c extends com.bytedance.applog.log.b<qw3.b> {
        public c() {
        }

        @Override // com.bytedance.applog.log.b
        public final qw3.b a(Object[] r110) {
            qw3.b r111 = new qw3.b(1, a.f534982b, 1, TimeUnit.SECONDS, a.f534983c, a.f534984d, a.f534985e);
            r111.allowCoreThreadTimeOut(true);
            return r111;
        }
    }

    public static class d implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f534988d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f534989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f534990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f534991c;

        static {
            f534988d = new AtomicInteger(1);
        }

        public d() {
            this.f534990b = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.f534989a = r101;
            this.f534991c = "AppLogDefaultExecutors-" + f534988d.getAndIncrement() + "-Thread-";
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(this.f534989a, r100, this.f534991c + this.f534990b.getAndIncrement(), 0);
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
        int r100 = Runtime.getRuntime().availableProcessors();
        if (r100 > 0) goto L6;
        r100 = 1;
    L6:
        int r101 = Math.max(2, Math.min(r100 - 1, 6)) * 2;
        f534981a = r101;
        f534982b = (r101 * 2) + 1;
        f534983c = new LinkedBlockingQueue();
        f534984d = new d();
        f534985e = new RejectedExecutionHandlerC7401a();
        f534986f = new b();
        f534987g = new c();
    }
}
