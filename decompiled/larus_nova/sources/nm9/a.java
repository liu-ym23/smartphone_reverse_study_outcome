package nm9;

import com.larus.jato.api.IJato;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PThreadPoolExecutor f519606a = null;

    /* JADX INFO: renamed from: nm9.a$a, reason: collision with other inner class name */
    public static final class ThreadFactoryC6939a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f519607a;

        public ThreadFactoryC6939a() {
            this.f519607a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "r");
            com.larus.init.task.firstframe.jato.a.C4382a r101 = com.larus.init.task.firstframe.jato.a.f351302e;
            r101.a();
            com.larus.init.task.firstframe.jato.a.e("bindBigCore");
            IJato.Companion r102 = IJato.f351658a;
            r102.bindBigCore();
            r101.a();
            r102.t(-20);
            PthreadThreadV2 r103 = new PthreadThreadV2(new ThreadGroup("flow_a"), r100, "flow_a_launch" + this.f519607a.getAndIncrement(), 0);
            ThreadMethodProxy.setPriority(r103, 10);
            return r103;
        }
    }

    static {
        ThreadFactoryC6939a r100 = new ThreadFactoryC6939a();
        int r101 = Math.min(Runtime.getRuntime().availableProcessors(), 3);
        PThreadPoolExecutor r102 = new PThreadPoolExecutor(r101 + 1, (r101 * 2) + 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), r100);
        r102.allowCoreThreadTimeOut(true);
        f519606a = r102;
    }
}
