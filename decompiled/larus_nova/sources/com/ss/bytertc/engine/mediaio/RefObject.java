package com.ss.bytertc.engine.mediaio;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes40.dex */
public class RefObject {
    private final AtomicInteger refCount;
    private final Runnable releaseCallback;

    public boolean hasReleaseCallback() {
        if (this.releaseCallback == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void release() {
        if (this.refCount.decrementAndGet() != 0) goto L8;
        Runnable r100 = this.releaseCallback;
        if (r100 == null) goto L9;
        r100.run();
        return;
    L9:
        return;
    }

    public void retain() {
        this.refCount.incrementAndGet();
    }

    public RefObject(Runnable r100) {
        this.refCount = new AtomicInteger(1);
        this.releaseCallback = r100;
    }
}
