package com.ttnetuploader.uploader.utils;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private final boolean mIgnoreStatusCheck;
    private final String mThreadName;
    private final AtomicInteger mThreadSeq;

    public DefaultThreadFactory(String r100) {
        this(r100, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, this.mThreadName + "-" + this.mThreadSeq.incrementAndGet());
        if (this.mIgnoreStatusCheck == false) goto L5;
    L10:
        return r101;
    L5:
        if (r101.isDaemon() == false) goto L8;
        r101.setDaemon(false);
    L8:
        if (r101.getPriority() == 5) goto L10;
        ThreadMethodProxy.setPriority(r101, 5);
        goto L10
    }

    public DefaultThreadFactory(String r100, boolean r101) {
        this.mThreadSeq = new AtomicInteger();
        this.mThreadName = r100;
        this.mIgnoreStatusCheck = r101;
    }
}
