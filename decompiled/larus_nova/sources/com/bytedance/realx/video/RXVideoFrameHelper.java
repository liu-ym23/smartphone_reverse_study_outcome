package com.bytedance.realx.video;

import android.opengl.EGLContext;
import com.bytedance.realx.video.memory.RefObject;

/* JADX INFO: loaded from: classes21.dex */
public class RXVideoFrameHelper implements RXVideoFrameHelperInterface {
    protected long nativeHandle;
    RefObject refCounted;

    public static /* synthetic */ void a(RXVideoFrameHelper r100) {
        r100.lambda$new$0();
    }

    private static native long nativeCreateRXVideoFrameHelperOpenGL(long r100);

    private static native void nativeReleaseVideoFrameHelper(long r100);

    @Override // com.bytedance.realx.video.RXVideoFrameHelperInterface, com.bytedance.realx.base.RefCounted
    public synchronized void release() {
        monitor-enter(this);
        this.refCounted.release();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.realx.video.RXVideoFrameHelperInterface, com.bytedance.realx.base.RefCounted
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
        nativeReleaseVideoFrameHelper(r100);
        this.nativeHandle = 0;
        return;
    }

    @Override // com.bytedance.realx.video.RXVideoFrameHelperInterface
    public long getNativeHandle() {
        return this.nativeHandle;
    }

    private RXVideoFrameHelper(long r100) {
        this.nativeHandle = r100;
        this.refCounted = new RefObject(new p(this));
    }

    public static RXVideoFrameHelperInterface createRXVideoFrameHelperOpenGL(EGLContext r100) {
        return new RXVideoFrameHelper(nativeCreateRXVideoFrameHelperOpenGL(EglBaseUtils.getNativeEGLContext(r100)));
    }
}
