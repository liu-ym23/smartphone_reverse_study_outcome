package vkc;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes40.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PThreadPoolExecutor f555591a;

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f555592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f555593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f555594c;

        public a() {
            this.f555593b = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.f555592a = r101;
            this.f555594c = "live-sdk-";
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(this.f555592a, r100, this.f555594c + this.f555593b.getAndIncrement(), 0);
            if (r101.isDaemon() == false) goto L6;
            r101.setDaemon(false);
        L6:
            if (r101.getPriority() == 5) goto L8;
            ThreadMethodProxy.setPriority(r101, 5);
        L8:
            return r101;
        }
    }

    public g() {
        this.f555591a = new PThreadPoolExecutor(3, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a());
    }
}
