package zy5;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PThreadPoolExecutor f573941a;

    /* JADX INFO: renamed from: zy5.a$a, reason: collision with other inner class name */
    public class ThreadFactoryC8506a implements ThreadFactory {
        public ThreadFactoryC8506a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "DefaultUpdateExecutor$1");
            ThreadMethodProxy.setName(r101, "gecko-update-thread");
            ThreadMethodProxy.setPriority(r101, 3);
            return r101;
        }
    }

    public a() {
        PriorityBlockingQueue r100 = new PriorityBlockingQueue();
        this.f573941a = new PThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, r100, new ThreadFactoryC8506a());
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        this.f573941a.execute(r100);
    }
}
