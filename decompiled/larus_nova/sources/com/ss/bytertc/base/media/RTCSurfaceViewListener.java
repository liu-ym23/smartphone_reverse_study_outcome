package com.ss.bytertc.base.media;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.realx.base.RXLogging;

/* JADX INFO: loaded from: classes40.dex */
public class RTCSurfaceViewListener implements SurfaceHolder.Callback {
    private final String key;
    private long nativeSurfaceHelperHandle;
    private boolean needFristFrameRenderedCallback;
    private SurfaceView surfaceView;

    public static /* synthetic */ void a(RTCSurfaceViewListener r100, Surface r101, long r102, String r103, boolean r104) {
        r100.lambda$new$0(r101, r102, r103, r104);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
    }

    public void resetCallback() {
        this.nativeSurfaceHelperHandle = 0;
        SurfaceView r100 = this.surfaceView;
        if (r100 == null) goto L6;
        r100.getHolder().removeCallback(this);
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r100) {
        if (this.nativeSurfaceHelperHandle == 0) goto L11;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getSurface() != null) goto L8;
        return;
    L8:
        if (r100.getSurface().isValid() == false) goto L14;
        RXLogging.i("RTCSurfaceViewListener", "surfaceCreated key:" + this.key);
        RTCSurfaceHelper.nativeSetRenderTarget(this.nativeSurfaceHelperHandle, r100.getSurface(), this.key, this.needFristFrameRenderedCallback);
        return;
    L14:
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r100) {
        this.needFristFrameRenderedCallback = false;
        if (this.nativeSurfaceHelperHandle == 0) goto L6;
        RXLogging.i("RTCSurfaceViewListener", "surfaceDestroyed key:" + this.key);
        RTCSurfaceHelper.nativeSetRenderTarget(this.nativeSurfaceHelperHandle, null, this.key, false);
        return;
    }

    public RTCSurfaceViewListener(SurfaceView r100, final long r110, final String r111, final boolean r112) {
        this.nativeSurfaceHelperHandle = r110;
        this.surfaceView = r100;
        this.key = r111;
        this.needFristFrameRenderedCallback = r112;
        if (r100 != null) goto L5;
    L15:
        Surface r101 = null;
    L16:
        final Surface r102 = r101;
        if (r102 != null) goto L19;
        return;
    L19:
        if (this.nativeSurfaceHelperHandle == 0) goto L23;
        new Handler(Looper.getMainLooper()).post(new j(this, r102, r110, r111, r112));
        return;
    L23:
        return;
    L5:
        if (r100.getHolder() == null) goto L15;
        SurfaceHolder r103 = this.surfaceView.getHolder();
        if (r103 == null) goto L15;
        if (r103.getSurface() == null) goto L15;
        Surface r104 = r103.getSurface();
        if (r104 == null) goto L15;
        if (r104.isValid() == false) goto L15;
        r101 = r103.getSurface();
        goto L16
    }

    private /* synthetic */ void lambda$new$0(Surface r100, long r101, String r102, boolean r103) {
        Surface r104 = this.surfaceView.getHolder().getSurface();
        if (r104 != null) goto L5;
        return;
    L5:
        if (r104.isValid() == false) goto L10;
        if (r104 != r100) goto L11;
        RTCSurfaceHelper.nativeSetRenderTarget(r101, r104, r102, r103);
        return;
    L11:
        return;
    }
}
