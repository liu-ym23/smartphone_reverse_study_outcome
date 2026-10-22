package com.ss.android.ugc.bytex.thread_rename.base;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private final ThreadGroup group;
    public final String namePrefix;
    private final AtomicInteger threadNumber;

    public DefaultThreadFactory(String r100) {
        this.threadNumber = new AtomicInteger(1);
        SecurityManager r101 = System.getSecurityManager();
        if (r101 == null) goto L5;
        ThreadGroup r102 = r101.getThreadGroup();
    L6:
        this.group = r102;
        this.namePrefix = r100;
        return;
    L5:
        r102 = ThreadMethodProxy.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        PthreadThread r101 = new PthreadThread(this.group, r100, this.namePrefix + this.threadNumber.getAndIncrement(), 0);
        if (r101.isDaemon() == false) goto L6;
        r101.setDaemon(false);
    L6:
        if (r101.getPriority() == 5) goto L8;
        ThreadMethodProxy.setPriority(r101, 5);
    L8:
        return r101;
    }
}
