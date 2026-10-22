package com.bytedance.ee.bear.drive.module.nativepreview.component.embed;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends a implements TextureView.SurfaceTextureListener {
    public SurfaceTexture a;
    public Surface b;

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceTexture");
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "surfaceTexture");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceTexture");
    }

    public b() {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "surfaceTexture");
        Log.i("AndroidSurfaceViewHolder", "onSurfaceTextureAvailable");
        if (this.b != null) goto L6;
        this.a = r1;
        this.b = new Surface(r1);
        return;
    }
}
