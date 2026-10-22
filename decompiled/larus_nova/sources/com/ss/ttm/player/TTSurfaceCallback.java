package com.ss.ttm.player;

import android.view.SurfaceHolder;

/* JADX INFO: loaded from: classes40.dex */
public class TTSurfaceCallback implements SurfaceHolder.Callback {
    private static final String TAG = null;
    private ISurfaceListener mListener;

    static {
        TAG = "TTSurfaceCallback";
    }

    public TTSurfaceCallback(ISurfaceListener r100) {
        this.mListener = r100;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r100) {
        ISurfaceListener r101 = this.mListener;
        if (r101 == null) goto L6;
        r101.onSurfaceCreated(r100);
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r100) {
        ISurfaceListener r101 = this.mListener;
        if (r101 == null) goto L6;
        r101.onSurfaceDestroyed(r100);
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        ISurfaceListener r104 = this.mListener;
        if (r104 == null) goto L6;
        r104.onSurfaceChanged(r100);
        return;
    }
}
