package com.bytedance.ies.sdk.widgets.inflater;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes19.dex */
public class HighPriorityThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolNumber = null;
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger threadNumber;

    static {
        poolNumber = new AtomicInteger(1);
    }

    public HighPriorityThreadFactory() {
        this.threadNumber = new AtomicInteger(1);
        SecurityManager r100 = System.getSecurityManager();
        if (r100 == null) goto L5;
        ThreadGroup r101 = r100.getThreadGroup();
    L6:
        this.group = r101;
        this.namePrefix = "p-pool-" + poolNumber.getAndIncrement() + "-thread-";
        return;
    L5:
        r101 = ThreadMethodProxy.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(this.group, r100, this.namePrefix + this.threadNumber.getAndIncrement(), 0);
        if (r101.isDaemon() == false) goto L6;
        r101.setDaemon(false);
    L6:
        if (r101.getPriority() == 10) goto L8;
        ThreadMethodProxy.setPriority(r101, 10);
    L8:
        return r101;
    }
}
