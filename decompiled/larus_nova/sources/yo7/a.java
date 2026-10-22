package yo7;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yo7.b f568671a = null;

    /* JADX INFO: renamed from: yo7.a$a, reason: collision with other inner class name */
    public static class RejectedExecutionHandlerC8367a implements RejectedExecutionHandler {
        public RejectedExecutionHandlerC8367a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
            PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("TTExecutors$1")).execute(r100);
        }
    }

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f568672d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f568673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f568674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f568675c;

        static {
            f568672d = new AtomicInteger(1);
        }

        public b() {
            this.f568674b = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.f568673a = r101;
            this.f568675c = "TTDefaultExecutors-" + f568672d.getAndIncrement() + "-Thread-";
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(this.f568673a, r100, this.f568675c + this.f568674b.getAndIncrement(), 0);
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
        b r102 = new b();
        LinkedBlockingQueue r103 = new LinkedBlockingQueue();
        RejectedExecutionHandlerC8367a r104 = new RejectedExecutionHandlerC8367a();
        yo7.b r105 = new yo7.b(r101, (r101 * 2) + 1, TimeUnit.SECONDS, r103, r102, r104);
        f568671a = r105;
        r105.allowCoreThreadTimeOut(true);
    }
}
