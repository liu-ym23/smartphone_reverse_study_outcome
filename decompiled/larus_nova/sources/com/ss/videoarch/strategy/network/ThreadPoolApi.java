package com.ss.videoarch.strategy.network;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes38.dex */
public class ThreadPoolApi {
    private final ThreadPoolExecutor threadPool;

    /* JADX INFO: renamed from: com.ss.videoarch.strategy.network.ThreadPoolApi$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class NetWorkThreadFactory implements ThreadFactory {
        private final String mPrefix;
        private final ThreadGroup mThreadGroup;
        private final AtomicInteger mThreadNumber;

        private NetWorkThreadFactory() {
            this.mThreadNumber = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.mThreadGroup = r101;
            this.mPrefix = "live-strategy-network-";
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        public /* synthetic */ NetWorkThreadFactory(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(this.mThreadGroup, r100, this.mPrefix + this.mThreadNumber.getAndIncrement(), 0);
            if (r101.isDaemon() == false) goto L6;
            r101.setDaemon(false);
        L6:
            if (r101.getPriority() == 5) goto L8;
            ThreadMethodProxy.setPriority(r101, 5);
        L8:
            return r101;
        }
    }

    public ThreadPoolApi() {
        this.threadPool = new PThreadPoolExecutor(3, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NetWorkThreadFactory(null));
    }

    public void execute(Runnable r100) {
        this.threadPool.execute(r100);
    }
}
