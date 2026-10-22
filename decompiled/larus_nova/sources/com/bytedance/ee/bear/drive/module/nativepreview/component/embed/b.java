package com.bytedance.ee.bear.drive.module.nativepreview.component.embed;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends a implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SurfaceTexture f224506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Surface f224507b;

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
    }

    public b() {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
        Log.i("AndroidSurfaceViewHolder", "onSurfaceTextureAvailable");
        if (this.f224507b != null) goto L6;
        this.f224506a = r100;
        this.f224507b = new Surface(r100);
        return;
    }
}
