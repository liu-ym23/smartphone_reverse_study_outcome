package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

/* JADX INFO: loaded from: classes40.dex */
class TTTextureView extends TextureView implements ITTRenderView, TextureView.SurfaceTextureListener {
    private boolean mEnableSurfaceTextureReuse;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private ITTRenderView.RenderCallback renderCallback;

    @Override // com.ss.ttm.player.ITTRenderView
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r100) {
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void reuse() {
        this.mEnableSurfaceTextureReuse = true;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void setFixedSizeIfNeeded(int r100, int r101) {
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void reCreateSurface() {
        ITTRenderView.RenderCallback r100 = this.renderCallback;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mSurfaceTexture == null) goto L13;
        r100.onSurfaceDestroyed();
        Surface r101 = this.mSurface;
        if (r101 == null) goto L10;
        r101.release();
        this.mSurface = null;
    L10:
        Surface r102 = new Surface(this.mSurfaceTexture);
        this.mSurface = r102;
        this.renderCallback.onSurfaceCreated(r102);
        return;
    }

    private void reusedSurfaceTexture() {
        SurfaceTexture r100 = getSurfaceTexture();
        SurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        if (r100 == r101) goto L6;
        setSurfaceTexture(r101);
    L6:
        this.mEnableSurfaceTextureReuse = false;
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        reusedSurfaceTexture();
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public Surface getSurface() {
        return this.mSurface;
    }

    public TTTextureView(Context r100) {
        super(r100);
        this.mSurface = null;
        this.mSurfaceTexture = null;
        this.mEnableSurfaceTextureReuse = false;
        init();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        ITTRenderView.RenderCallback r101 = this.renderCallback;
        if (r101 == null) goto L8;
        if (this.mEnableSurfaceTextureReuse == true) goto L8;
        r101.onSurfaceDestroyed();
    L8:
        if (this.mEnableSurfaceTextureReuse == true) goto L14;
        Surface r102 = this.mSurface;
        if (r102 == null) goto L12;
        r102.release();
        this.mSurface = null;
    L12:
        this.mSurfaceTexture = null;
    L14:
        return !this.mEnableSurfaceTextureReuse;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void setRenderCallback(ITTRenderView.RenderCallback r100) {
        this.renderCallback = r100;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void snapshotBitmap(boolean r100, ITTRenderView.SnapshotCallback r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Bitmap r102 = getBitmap();
        if (r102 == null) goto L7;
        int r103 = 0;
    L8:
        r101.onResult(r103, r102);
        return;
    L7:
        r103 = -1;
        goto L8
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        if (this.mEnableSurfaceTextureReuse == true) goto L5;
    L6:
        this.mSurfaceTexture = r100;
        this.mSurface = new Surface(r100);
    L7:
        ITTRenderView.RenderCallback r103 = this.renderCallback;
        if (r103 == null) goto L11;
        r103.onSurfaceCreated(this.mSurface);
        return;
    L11:
        return;
    L5:
        if (this.mSurfaceTexture != null) goto L7;
        goto L6
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        ITTRenderView.RenderCallback r103 = this.renderCallback;
        if (r103 == null) goto L6;
        r103.onSurfaceChanged(r101, r102);
        return;
    }
}
