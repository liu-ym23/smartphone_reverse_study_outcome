package com.ss.android.videoshop.mediaview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/* JADX INFO: loaded from: classes40.dex */
public class SurfaceVideoView extends SurfaceView implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a.InterfaceC5459a f456022a;

    @Override // com.ss.android.videoshop.mediaview.a
    public Bitmap getBitmap() {
        return null;
    }

    @Override // com.ss.android.videoshop.mediaview.a
    public View getView() {
        return this;
    }

    @Override // com.ss.android.videoshop.mediaview.a
    public void setPlayEntity(tic.a r100) {
    }

    @Override // com.ss.android.videoshop.mediaview.a
    public Surface getSurface() {
        return getHolder().getSurface();
    }

    @Override // com.ss.android.videoshop.mediaview.a
    public SurfaceHolder getSurfaceHolder() {
        return getHolder();
    }

    public SurfaceVideoView(Context r100) {
        super(r100);
        getHolder().addCallback(new c(this));
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
    }

    @Override // android.view.View
    public void setKeepScreenOn(boolean r100) {
        super.setKeepScreenOn(r100);
        ajc.b.a("SurfaceVideoView", "surface view keep_screen_on:" + Boolean.valueOf(r100).toString());
    }

    @Override // com.ss.android.videoshop.mediaview.a
    public void setSurfaceCallback(a.InterfaceC5459a r100) {
        this.f456022a = r100;
    }

    public SurfaceVideoView(Context r100, AttributeSet r101) {
        super(r100, r101);
        getHolder().addCallback(new c(this));
    }

    public SurfaceVideoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        getHolder().addCallback(new c(this));
    }
}
