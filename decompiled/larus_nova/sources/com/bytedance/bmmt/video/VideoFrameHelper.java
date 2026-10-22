package com.bytedance.bmmt.video;

import android.opengl.EGLContext;
import com.bytedance.bmmt.video.memory.RefObject;

/* JADX INFO: loaded from: classes8.dex */
public class VideoFrameHelper implements VideoFrameHelperInterface {
    protected long nativeHandle;
    RefObject refCounted;

    public static /* synthetic */ void a(VideoFrameHelper r100) {
        r100.lambda$new$0();
    }

    private static native long nativeCreateVideoFrameHelperOpenGL(long r100);

    private static native void nativeReleaseVideoFrameHelper(long r100);

    @Override // com.bytedance.bmmt.video.VideoFrameHelperInterface, com.bytedance.bmmt.base.RefCounted
    public synchronized void release() {
        monitor-enter(this);
        this.refCounted.release();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bmmt.video.VideoFrameHelperInterface, com.bytedance.bmmt.base.RefCounted
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

    @Override // com.bytedance.bmmt.video.VideoFrameHelperInterface
    public long getNativeHandle() {
        return this.nativeHandle;
    }

    private VideoFrameHelper(long r100) {
        this.nativeHandle = r100;
        this.refCounted = new RefObject(new v(this));
    }

    public static VideoFrameHelperInterface createVideoFrameHelperOpenGL(EGLContext r100) {
        return new VideoFrameHelper(nativeCreateVideoFrameHelperOpenGL(EglBaseUtils.getNativeEGLContext(r100)));
    }
}
