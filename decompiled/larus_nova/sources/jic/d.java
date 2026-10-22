package jic;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;

/* JADX INFO: loaded from: classes40.dex */
public final class d extends e implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextureView f499268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextureView.SurfaceTextureListener f499269f;

    public d(TextureView r100) {
        super(0);
        this.f499268e = r100;
        this.f499269f = r100.getSurfaceTextureListener();
        r100.setSurfaceTextureListener(this);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        TextureView.SurfaceTextureListener r101 = this.f499269f;
        if (r101 == null) goto L5;
        boolean r102 = r101.onSurfaceTextureDestroyed(r100);
    L6:
        Surface r103 = this.f499272c;
        if (r103 == null) goto L9;
        r103.release();
        this.f499272c = null;
    L9:
        return r102;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        TextureView.SurfaceTextureListener r101 = this.f499269f;
        if (r101 == null) goto L6;
        r101.onSurfaceTextureUpdated(r100);
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        TextureView.SurfaceTextureListener r103 = this.f499269f;
        if (r103 == null) goto L5;
        r103.onSurfaceTextureAvailable(r100, r101, r102);
    L5:
        this.f499270a = r101;
        this.f499271b = r102;
        a(new Surface(r100));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        TextureView.SurfaceTextureListener r103 = this.f499269f;
        if (r103 == null) goto L5;
        r103.onSurfaceTextureSizeChanged(r100, r101, r102);
    L5:
        b(this.f499272c, 0, r101, r102);
    }
}
