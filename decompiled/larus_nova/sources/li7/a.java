package li7;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PThreadPoolExecutor f509407a = null;

    /* JADX INFO: renamed from: li7.a$a, reason: collision with other inner class name */
    public static class RejectedExecutionHandlerC6697a implements RejectedExecutionHandler {
        public RejectedExecutionHandlerC6697a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
            PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("TTExecutors$1")).execute(r100);
        }
    }

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f509408d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f509409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f509410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f509411c;

        static {
            f509408d = new AtomicInteger(1);
        }

        public b() {
            this.f509410b = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.f509409a = r101;
            this.f509411c = "TTDefaultExecutors-" + f509408d.getAndIncrement() + "-Thread-";
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(this.f509409a, r100, this.f509411c + this.f509410b.getAndIncrement(), 0);
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
        LinkedBlockingQueue r102 = new LinkedBlockingQueue();
        b r103 = new b();
        RejectedExecutionHandlerC6697a r110 = new RejectedExecutionHandlerC6697a();
        PThreadPoolExecutor r104 = new PThreadPoolExecutor(r101, (r101 * 2) + 1, 30, TimeUnit.SECONDS, r102, r103, r110);
        f509407a = r104;
        r104.allowCoreThreadTimeOut(true);
    }
}
