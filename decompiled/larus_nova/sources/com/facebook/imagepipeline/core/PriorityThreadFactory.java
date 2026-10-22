package com.facebook.imagepipeline.core;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class PriorityThreadFactory implements ThreadFactory {
    private final boolean mAddThreadNumber;
    private final String mPrefix;
    private final AtomicInteger mThreadNumber;
    private final int mThreadPriority;

    public PriorityThreadFactory(int r100) {
        this(r100, "PriorityThreadFactory", true);
    }

    public static /* synthetic */ int access$000(PriorityThreadFactory r100) {
        return r100.mThreadPriority;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable r100) {
        Runnable r101 = new AnonymousClass1(this, r100);
        if (this.mAddThreadNumber == false) goto L5;
        String r102 = this.mPrefix + "-" + this.mThreadNumber.getAndIncrement();
    L7:
        return new PthreadThreadV2(r101, r102);
    L5:
        r102 = this.mPrefix;
        goto L7
    }

    public PriorityThreadFactory(int r100, String r101, boolean r102) {
        this.mThreadNumber = new AtomicInteger(1);
        this.mThreadPriority = r100;
        this.mPrefix = r101;
        this.mAddThreadNumber = r102;
    }
}
