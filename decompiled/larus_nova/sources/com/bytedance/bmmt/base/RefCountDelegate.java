package com.bytedance.bmmt.base;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes8.dex */
public class RefCountDelegate implements RefCounted {
    private final AtomicInteger refCount;
    private final Runnable releaseCallback;

    @Override // com.bytedance.bmmt.base.RefCounted
    public void release() {
        if (this.refCount.decrementAndGet() != 0) goto L8;
        Runnable r100 = this.releaseCallback;
        if (r100 == null) goto L9;
        r100.run();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.bmmt.base.RefCounted
    public void retain() {
        this.refCount.incrementAndGet();
    }

    public RefCountDelegate(Runnable r100) {
        this.refCount = new AtomicInteger(1);
        this.releaseCallback = r100;
    }
}
