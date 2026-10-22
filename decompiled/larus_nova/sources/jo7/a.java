package jo7;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jo7.b f499905a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final jo7.b f499906b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final jo7.b f499907c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ScheduledExecutorService f499908d = null;

    /* JADX INFO: renamed from: jo7.a$a, reason: collision with other inner class name */
    public static class RejectedExecutionHandlerC6471a implements RejectedExecutionHandler {
        public RejectedExecutionHandlerC6471a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
            PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("TTExecutors$1")).execute(r100);
        }
    }

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f499909d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f499910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f499911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f499912c;

        static {
            f499909d = new AtomicInteger(1);
        }

        public b(String r100) {
            this.f499911b = new AtomicInteger(1);
            SecurityManager r101 = System.getSecurityManager();
            if (r101 == null) goto L5;
            ThreadGroup r102 = r101.getThreadGroup();
        L6:
            this.f499910a = r102;
            this.f499912c = r100 + "-" + f499909d.getAndIncrement() + "-Thread-";
            return;
        L5:
            r102 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(this.f499910a, r100, this.f499912c + this.f499911b.getAndIncrement(), 0);
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
        int r101 = r100 - 1;
        int r102 = Math.max(2, Math.min(r101, 6)) * 2;
        new b("TTDefaultExecutors");
        new b("TTCpuExecutors");
        b r103 = new b("TTScheduledExecutors");
        new b("TTDownLoadExecutors");
        LinkedBlockingQueue r104 = new LinkedBlockingQueue();
        LinkedBlockingQueue r110 = new LinkedBlockingQueue();
        LinkedBlockingQueue r111 = new LinkedBlockingQueue();
        RejectedExecutionHandlerC6471a r112 = new RejectedExecutionHandlerC6471a();
        TimeUnit r113 = TimeUnit.SECONDS;
        jo7.b r114 = new jo7.b(r102, (r102 * 2) + 1, r113, r104, r112);
        f499905a = r114;
        r114.allowCoreThreadTimeOut(true);
        jo7.b r105 = new jo7.b(Math.max(2, Math.min(r101, 3)), (r100 * 2) + 1, r113, r110, r112);
        f499906b = r105;
        r105.allowCoreThreadTimeOut(true);
        f499908d = PThreadExecutorsUtils.newScheduledThreadPool(3, r103);
        jo7.b r106 = new jo7.b(2, 2, r113, r111, r112);
        f499907c = r106;
        r106.allowCoreThreadTimeOut(true);
    }
}
