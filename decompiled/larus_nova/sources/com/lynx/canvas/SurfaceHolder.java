package com.lynx.canvas;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;

/* JADX INFO: loaded from: classes32.dex */
public class SurfaceHolder implements FirstFrameAwareSurfaceTexture.FirstFrameAvailableListener, INativeSurfaceProvider {
    private static final String TAG = "KryptonSurfaceHolder";
    private FirstFrameListener mFirstFrameListener;
    private int mHeight;
    private long mNativeSurfacePtr;
    private final Surface mSurface;
    private final FirstFrameAwareSurfaceTexture mSurfaceTexture;
    private int mWidth;

    public interface FirstFrameListener {
        void onFirstFrame();
    }

    private static native long nativeCreateSurface(Surface r100, SurfaceTexture r101);

    private static native void nativeDestroySurface(long r100);

    @Override // com.lynx.canvas.INativeSurfaceProvider
    public synchronized long acquireNativeSurfacePtr() {
        monitor-enter(this);
        long r100 = this.mNativeSurfacePtr;     // Catch: Throwable -> L6
        this.mNativeSurfacePtr = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public void dispose() {
        KryptonLLog.i(TAG, "dispose surface texture with " + this.mSurfaceTexture);
        this.mSurface.release();
        this.mFirstFrameListener = null;
        monitor-enter(this);
        long r100 = this.mNativeSurfacePtr;     // Catch: Throwable -> L9
        if (r100 == 0) goto L7;
        nativeDestroySurface(r100);     // Catch: Throwable -> L9
        this.mNativeSurfacePtr = 0;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.FirstFrameAwareSurfaceTexture.FirstFrameAvailableListener
    public void onFirstFrameAvailable() {
        KryptonLLog.i(TAG, "onFirstFrameAvailable mFirstFrameListener " + this.mFirstFrameListener);
        FirstFrameListener r100 = this.mFirstFrameListener;
        if (r100 == null) goto L6;
        r100.onFirstFrame();
        return;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public SurfaceHolder(FirstFrameListener r100) {
        FirstFrameAwareSurfaceTexture r101 = new FirstFrameAwareSurfaceTexture(0);
        this.mSurfaceTexture = r101;
        r101.detachFromGLContext();
        r101.setFirstFrameListener(this);
        Surface r102 = new Surface(r101);
        this.mSurface = r102;
        this.mFirstFrameListener = r100;
        this.mWidth = 1;
        this.mHeight = 1;
        this.mNativeSurfacePtr = nativeCreateSurface(r102, r101);
        KryptonLLog.i(TAG, "Created with surface texture " + r101);
    }

    public static void destroyOrphanSurface(long r100) {
        if (r100 == 0) goto L6;
        nativeDestroySurface(r100);
        return;
    }

    public void initTextureView(TextureView r100) {
        KryptonLLog.i(TAG, "initTextureView with " + r100);
        SurfaceTexture r101 = r100.getSurfaceTexture();
        if (this.mSurfaceTexture.equals(r101) == false) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        KryptonLLog.i(TAG, "Init TextureView but it has already another st.");
    L7:
        r100.setSurfaceTexture(this.mSurfaceTexture);
    }

    public void onSurfaceTextureSizeChanged(int r100, int r101) {
        if (this.mWidth == r100) goto L5;
    L7:
        if (r100 == 0) goto L12;
        if (r101 == 0) goto L12;
        this.mWidth = r100;
        this.mHeight = r101;
        return;
    L12:
        KryptonLLog.w(TAG, "onSurfaceTextureSizeChanged with invalid size " + r100 + " / " + r101);
        return;
    L5:
        if (this.mHeight != r101) goto L7;
    }
}
