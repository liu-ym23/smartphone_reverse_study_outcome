package com.ss.android.videoshop.mediaview;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextureVideoView f456072a;

    public d(TextureVideoView r100) {
        this.f456072a = r100;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        TextureVideoView r101 = this.f456072a;
        if (r101.f456031c == true) goto L5;
    L9:
        TextureView.SurfaceTextureListener r102 = this.f456072a.f456029a;
        if (r102 == null) goto L12;
        r102.onSurfaceTextureDestroyed(r100);
    L12:
        a.InterfaceC5459a r103 = this.f456072a.f456030b;
        if (r103 == null) goto L15;
        ((VideoPatchLayout) r103).g0();
    L15:
        TextureVideoView r104 = this.f456072a;
        boolean r105 = r104.f456031c;
        if (r105 == true) goto L23;
        if (r105 == true) goto L21;
        Surface r106 = r104.f456033e;
        if (r106 == null) goto L21;
        r106.release();
        r104.f456033e = null;
    L21:
        r104.f456032d = false;
        r104.f456033e = null;
        r104.f456034f = null;
    L23:
        return !this.f456072a.f456031c;
    L5:
        if (r101.f456032d == true) goto L9;
        Surface r107 = r101.f456033e;
        if (r107 == null) goto L9;
        r107.release();
        TextureVideoView r108 = this.f456072a;
        r108.f456033e = null;
        r108.f456034f = null;
        goto L9
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        TextureView.SurfaceTextureListener r101 = this.f456072a.f456029a;
        if (r101 == null) goto L6;
        r101.onSurfaceTextureUpdated(r100);
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        TextureVideoView r103 = this.f456072a;
        if (r103.f456031c == false) goto L28;
        Surface r104 = r103.f456033e;
        if (r104 != null) goto L7;
    L11:
        TextureVideoView r105 = this.f456072a;
        if (r105.f456033e != null) goto L37;
        r105.f456033e = new Surface(r100);
        this.f456072a.f456034f = r100;
    L27:
        this.f456072a.f456032d = true;
    L29:
        a.InterfaceC5459a r106 = this.f456072a.f456030b;
        if (r106 == null) goto L32;
        ((VideoPatchLayout) r106).f0();
    L32:
        TextureVideoView r107 = this.f456072a;
        TextureView.SurfaceTextureListener r108 = r107.f456029a;
        if (r108 == null) goto L39;
        r108.onSurfaceTextureAvailable(r107.f456034f, r101, r102);
        return;
    L39:
        return;
    L37:
        SurfaceTexture r109 = r105.f456034f;     // Catch: Exception -> L25
        if (r109 != null) goto L17;
    L23:
        TextureVideoView r110 = this.f456072a;     // Catch: Exception -> L25
        r110.f456034f = r100;     // Catch: Exception -> L25
        r110.f456033e = new Surface(r100);     // Catch: Exception -> L25
    L36:
        goto L27
    L17:
        if (TextureVideoView.a(r109) == true) goto L23;
        TextureVideoView r111 = this.f456072a;     // Catch: Exception -> L25
        if (r111.f456034f != r111.getSurfaceTexture()) goto L22;
        ajc.b.a("TextureVideoView", "surface_texture_available surface equal");     // Catch: Exception -> L25
        goto L36
    L22:
        TextureVideoView r112 = this.f456072a;     // Catch: Exception -> L25
        r112.setSurfaceTexture(r112.f456034f);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        ajc.b.a("TextureVideoView", "surface_texture_available:" + e.getMessage());
        TextureVideoView r113 = this.f456072a;
        r113.f456034f = r100;
        r113.f456033e = new Surface(r100);
        goto L27
    L7:
        if (r103.f456032d == true) goto L9;
    L10:
        this.f456072a.f456033e.release();
        TextureVideoView r114 = this.f456072a;
        r114.f456033e = null;
        r114.f456034f = null;
        goto L11
    L9:
        if (r104.isValid() == true) goto L11;
    L28:
        r103.f456033e = new Surface(r100);
        this.f456072a.f456034f = r100;
        goto L29
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        ajc.b.a("TextureVideoView", "onSurfaceTextureSizeChanged width:" + r101 + " height:" + r102);
        a.InterfaceC5459a r103 = this.f456072a.f456030b;
        if (r103 == null) goto L5;
        ((VideoPatchLayout) r103).d0();
    L5:
        TextureView.SurfaceTextureListener r104 = this.f456072a.f456029a;
        if (r104 == null) goto L9;
        r104.onSurfaceTextureSizeChanged(r100, r101, r102);
        return;
    }
}
