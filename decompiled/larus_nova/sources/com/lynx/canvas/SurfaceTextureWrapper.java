package com.lynx.canvas;

import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import android.view.Surface;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes32.dex */
public class SurfaceTextureWrapper {
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;

    public Surface getSurface() {
        if (this.mSurface != null) goto L6;
        this.mSurface = new Surface(this.mSurfaceTexture);
    L6:
        return this.mSurface;
    }

    public double getTimestamp() {
        SurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 == null) goto L6;
        long r101 = r100.getTimestamp();
        long r102 = System.nanoTime();
        long r103 = Math.abs(r102 - r101);
        long r104 = Math.abs(SystemClock.elapsedRealtimeNanos() - r101);
        return r102 - Math.min(Math.min(r103, r104), Math.abs((SystemClock.uptimeMillis() * 1000000) - r101));
    L6:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public void release() {
        SurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        Surface r101 = this.mSurface;
        if (r101 == null) goto L9;
        r101.release();
        return;
    }

    public float[] updateTexture() {
        SurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 == null) goto L7;
        r100.updateTexImage();
        float[] r101 = new float[16];
        this.mSurfaceTexture.getTransformMatrix(r101);
        return r101;
    L7:
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public SurfaceTextureWrapper(int r100, int r101, int r102) {
        SurfaceTexture r103 = new SurfaceTexture(r100);
        this.mSurfaceTexture = r103;
        if (r101 <= 0) goto L7;
        if (r102 <= 0) goto L8;
        r103.setDefaultBufferSize(r101, r102);
        return;
    L8:
        return;
    }

    public static SurfaceTextureWrapper create(int r100, int r101, int r102) {
        return new SurfaceTextureWrapper(r100, r101, r102);
    }
}
