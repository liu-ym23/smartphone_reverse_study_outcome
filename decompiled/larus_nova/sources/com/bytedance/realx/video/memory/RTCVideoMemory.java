package com.bytedance.realx.video.memory;

import com.bytedance.realx.base.RefCounted;
import com.bytedance.realx.video.RXVideoMemoryType;
import com.bytedance.realx.video.RXVideoRotation;

/* JADX INFO: loaded from: classes21.dex */
public abstract class RTCVideoMemory implements RefCounted {
    RefObject refCounted;
    private Runnable releaseCallback;

    public static /* synthetic */ void a(RTCVideoMemory r100) {
        r100.lambda$new$0();
    }

    public abstract int getHeight();

    public abstract RXVideoMemoryType getMemoryType();

    public abstract RXVideoRotation getRotation();

    public abstract int getWidth();

    public synchronized boolean hasReleaseCallback() {
        monitor-enter(this);
        if (this.releaseCallback == null) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.realx.base.RefCounted
    public synchronized void release() {
        monitor-enter(this);
        this.refCounted.release();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.realx.base.RefCounted
    public synchronized void retain() {
        monitor-enter(this);
        this.refCounted.retain();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$0() {
        Runnable r100 = this.releaseCallback;
        if (r100 == null) goto L6;
        r100.run();
        return;
    }

    public RTCVideoMemory() {
        this.releaseCallback = null;
        this.refCounted = new RefObject(new c(this));
    }

    public synchronized void setReleaseCallback(Runnable r100) {
        monitor-enter(this);
        this.releaseCallback = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
