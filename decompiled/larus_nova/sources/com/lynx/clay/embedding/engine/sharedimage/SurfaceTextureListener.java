package com.lynx.clay.embedding.engine.sharedimage;

import android.graphics.SurfaceTexture;

/* JADX INFO: loaded from: classes32.dex */
class SurfaceTextureListener implements SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f380939a;

    private native void nativeDestroy(long r100, SurfaceTextureListener r101);

    private native void nativeFrameAvailable(long r100, SurfaceTextureListener r101);

    public final void finalize() throws Throwable {
        nativeDestroy(this.f380939a, this);     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    static {
    }

    public SurfaceTextureListener(long r100) {
        this.f380939a = r100;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r100) {
        nativeFrameAvailable(this.f380939a, this);
    }
}
