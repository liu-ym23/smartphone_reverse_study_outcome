package com.bytedance.realx.video.memory;

/* JADX INFO: loaded from: classes21.dex */
public abstract class RXVideoMemory implements RXVideoMemoryInterface {
    protected long nativeHandle;
    RefObject refCounted;

    public static /* synthetic */ void a(RXVideoMemory r100) {
        r100.lambda$new$0();
    }

    private static native void nativeReleaseVideoMemory(long r100);

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface, com.bytedance.realx.base.RefCounted
    public synchronized void release() {
        monitor-enter(this);
        this.refCounted.release();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface, com.bytedance.realx.base.RefCounted
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
        long r100 = this.nativeHandle;
        if (r100 == 0) goto L6;
        nativeReleaseVideoMemory(r100);
        this.nativeHandle = 0;
        return;
    }

    public boolean isNullPointer() {
        if (this.nativeHandle != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public long getNativeHandle() {
        return this.nativeHandle;
    }

    public RXVideoMemory(long r100) {
        this.nativeHandle = r100;
        this.refCounted = new RefObject(new d(this));
    }
}
