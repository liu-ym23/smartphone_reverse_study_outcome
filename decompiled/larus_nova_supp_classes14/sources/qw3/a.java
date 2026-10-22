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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final int a = 0;
    public static final int b = 0;
    public static final BlockingQueue<Runnable> c = null;
    public static final d d = null;
    public static final RejectedExecutionHandlerC0160a e = null;
    public static final b f = null;
    public static final c g = null;

    /* JADX INFO: renamed from: qw3.a$a, reason: collision with other inner class name */
    public static class RejectedExecutionHandlerC0160a implements RejectedExecutionHandler {
        public RejectedExecutionHandlerC0160a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r2, ThreadPoolExecutor r3) {
            PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("AppLogExecutors$1")).execute(r2);
        }
    }

    public static class b extends com.bytedance.applog.log.b<qw3.b> {
        public b() {
        }

        public final Object a(Object[] r10) {
            qw3.b r11 = new qw3.b(a.a, a.b, 30, TimeUnit.SECONDS, a.c, a.d, a.e);
            r11.allowCoreThreadTimeOut(true);
            return r11;
        }
    }

    public static class c extends com.bytedance.applog.log.b<qw3.b> {
        public c() {
        }

        public final Object a(Object[] r10) {
            qw3.b r11 = new qw3.b(1, a.b, 1, TimeUnit.SECONDS, a.c, a.d, a.e);
            r11.allowCoreThreadTimeOut(true);
            return r11;
        }
    }

    public static class d implements ThreadFactory {
        public static final AtomicInteger d = null;
        public final ThreadGroup a;
        public final AtomicInteger b;
        public final String c;

        static {
            d = new AtomicInteger(1);
        }

        public d() {
            this.b = new AtomicInteger(1);
            SecurityManager r0 = System.getSecurityManager();
            if (r0 == null) goto L5;
            ThreadGroup r1 = r0.getThreadGroup();
        L6:
            this.a = r1;
            this.c = "AppLogDefaultExecutors-" + d.getAndIncrement() + "-Thread-";
            return;
        L5:
            r1 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            PthreadThreadV2 r6 = new PthreadThreadV2(this.a, r8, this.c + this.b.getAndIncrement(), 0);
            if (r6.isDaemon() == false) goto L6;
            r6.setDaemon(false);
        L6:
            if (r6.getPriority() == 5) goto L8;
            ThreadMethodProxy.setPriority(r6, 5);
        L8:
            return r6;
        }
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        if (r0 > 0) goto L6;
        r0 = 1;
    L6:
        int r1 = Math.max(2, Math.min(r0 - 1, 6)) * 2;
        a = r1;
        b = (r1 * 2) + 1;
        c = new LinkedBlockingQueue();
        d = new d();
        e = new RejectedExecutionHandlerC0160a();
        f = new b();
        g = new c();
    }
}
