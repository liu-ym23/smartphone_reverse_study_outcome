package com.ss.bytertc.base.media;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.realx.base.RXLogging;

/* JADX INFO: loaded from: classes40.dex */
public class RTCSurfaceTextureListener implements TextureView.SurfaceTextureListener {
    private final String key;
    private long nativeSurfaceHelperHandle;
    private boolean needFristFrameRenderedCallback;
    private TextureView textureView;

    public static /* synthetic */ void a(RTCSurfaceTextureListener r100, SurfaceTexture r101, long r102, String r103, boolean r104) {
        r100.lambda$new$0(r101, r102, r103, r104);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r100) {
    }

    public void resetCallback() {
        this.nativeSurfaceHelperHandle = 0;
        TextureView r100 = this.textureView;
        if (r100 == null) goto L6;
        r100.setSurfaceTextureListener(null);
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        this.needFristFrameRenderedCallback = false;
        if (this.nativeSurfaceHelperHandle == 0) goto L7;
        RXLogging.i("RTCSurfaceTextureListener", "onSurfaceTextureDestroyed key:" + this.key);
        RTCSurfaceHelper.nativeSetRenderTarget(this.nativeSurfaceHelperHandle, null, this.key, false);
        return true;
    L7:
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        if (this.nativeSurfaceHelperHandle == 0) goto L6;
        RXLogging.i("RTCSurfaceTextureListener", "onSurfaceTextureAvailable key:" + this.key);
        RTCSurfaceHelper.nativeSetRenderTarget(this.nativeSurfaceHelperHandle, new Surface(r100), this.key, this.needFristFrameRenderedCallback);
        return;
    }

    public RTCSurfaceTextureListener(TextureView r110, final long r111, final String r112, final boolean r113) {
        this.nativeSurfaceHelperHandle = 0;
        this.needFristFrameRenderedCallback = false;
        this.textureView = r110;
        this.key = r112;
        if (r110 == null) goto L5;
        SurfaceTexture r114 = r110.getSurfaceTexture();
    L6:
        final SurfaceTexture r100 = r114;
        this.nativeSurfaceHelperHandle = r111;
        this.needFristFrameRenderedCallback = r113;
        if (r100 != null) goto L9;
        return;
    L9:
        if (r111 == 0) goto L13;
        new Handler(Looper.getMainLooper()).post(new i(this, r100, r111, r112, r113));
        return;
    L13:
        return;
    L5:
        r114 = null;
        goto L6
    }

    private /* synthetic */ void lambda$new$0(SurfaceTexture r100, long r101, String r102, boolean r103) {
        SurfaceTexture r104 = this.textureView.getSurfaceTexture();
        if (r104 == null) goto L7;
        if (r104 != r100) goto L8;
        RTCSurfaceHelper.nativeSetRenderTarget(r101, new Surface(r104), r102, r103);
        return;
    L8:
        return;
    }
}
