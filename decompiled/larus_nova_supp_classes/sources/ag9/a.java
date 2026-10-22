package ag9;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final PThreadPoolExecutor a = null;

    /* JADX INFO: renamed from: ag9.a$a, reason: collision with other inner class name */
    public static final class ThreadFactoryC0001a implements ThreadFactory {
        public final AtomicInteger a;

        public ThreadFactoryC0001a() {
            this.a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            Intrinsics.checkNotNullParameter(r8, "r");
            return new PthreadThreadV2(new ThreadGroup("flow_a"), r8, "flow_a_launch" + this.a.getAndIncrement(), 0);
        }
    }

    static {
        ThreadFactoryC0001a r8 = new ThreadFactoryC0001a();
        int r0 = Runtime.getRuntime().availableProcessors();
        PThreadPoolExecutor r1 = new PThreadPoolExecutor(r0 + 1, (r0 * 2) + 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), r8);
        r1.allowCoreThreadTimeOut(true);
        a = r1;
    }
}
