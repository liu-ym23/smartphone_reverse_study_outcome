package com.ss.android.vesdk.frame;

import android.graphics.SurfaceTexture;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TEFrameSizei;

/* JADX INFO: loaded from: classes40.dex */
public final class a extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SurfaceTexture f455831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f455832h;

    @Override // com.ss.android.vesdk.frame.b
    public final boolean b() {
        return super.b();
    }

    @Override // com.ss.android.vesdk.frame.b
    public final SurfaceTexture a() {
        return this.f455831g;
    }

    public a(TEFrameSizei r100, b.InterfaceC5458b r101, SurfaceTexture r102, int r110) {
        super(TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_BUFFER, r100, r101, true, r102);
        this.f455832h = 0;
        this.f455831g = r102;
        this.f455832h = r110;
    }
}
