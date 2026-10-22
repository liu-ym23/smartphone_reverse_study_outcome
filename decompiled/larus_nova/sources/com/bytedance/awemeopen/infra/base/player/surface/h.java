package com.bytedance.awemeopen.infra.base.player.surface;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f198791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f198792b;

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
    }

    public h(i r100) {
        this.f198792b = r100;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
        AoLogger.g("TextureViewHolder", new Object[]{"onSurfaceTextureDestroyed:" + r100 + ", reuse surface: " + this.f198792b.f198794b});
        a.InterfaceC2875a r101 = this.f198792b.f198798f;
        if (r101 == null) goto L6;
        r101.onSurfaceDestroyed();
    L6:
        if (this.f198792b.f198794b == true) goto L8;
        AoLogger.g("TextureViewHolder", new Object[]{"onSurfaceTextureDestroyed: Surface:" + this.f198792b.f198799g + ", SurfaceTexture:" + r100});
        this.f198792b.f198799g = null;
    L8:
        final i r102 = this.f198792b;
        r102.f198793a.post(new g(r102));
        return !this.f198792b.f198794b;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        if (this.f198791a == true) goto L8;
        this.f198791a = true;
        Function0<Unit> r101 = this.f198792b.f198796d;
        if (r101 == null) goto L9;
        r101.invoke();
        return;
    L9:
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
        AoLogger.g("TextureViewHolder", new Object[]{"onSurfaceTextureAvailable: " + this.f198792b.f198799g + ", reuse surface: " + this.f198792b.f198794b});
        if (this.f198792b.f198799g != null) goto L5;
        this.f198792b.f198799g = new Surface(r100);
        AoLogger.g("TextureViewHolder", new Object[]{"onSurfaceTextureAvailable: Surface:" + this.f198792b.f198799g + ", SurfaceTexture:" + r100});
    L5:
        i r103 = this.f198792b;
        if (r103.f198794b == false) goto L8;
        r103.f198797e = r100;
    L8:
        a.InterfaceC2875a r104 = r103.f198798f;
        if (r104 == null) goto L12;
        r104.onSurfaceAvailable();
        return;
    }
}
