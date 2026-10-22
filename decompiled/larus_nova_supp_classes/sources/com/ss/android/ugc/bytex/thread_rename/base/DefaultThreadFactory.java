package com.ss.android.ugc.bytex.thread_rename.base;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private final ThreadGroup group;
    public final String namePrefix;
    private final AtomicInteger threadNumber;

    public DefaultThreadFactory(String r3) {
        this.threadNumber = new AtomicInteger(1);
        SecurityManager r0 = System.getSecurityManager();
        if (r0 == null) goto L5;
        ThreadGroup r1 = r0.getThreadGroup();
    L6:
        this.group = r1;
        this.namePrefix = r3;
        return;
    L5:
        r1 = ThreadMethodProxy.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r8) {
        PthreadThread r6 = new PthreadThread(this.group, r8, this.namePrefix + this.threadNumber.getAndIncrement(), 0);
        if (r6.isDaemon() == false) goto L6;
        r6.setDaemon(false);
    L6:
        if (r6.getPriority() == 5) goto L8;
        ThreadMethodProxy.setPriority(r6, 5);
    L8:
        return r6;
    }
}
