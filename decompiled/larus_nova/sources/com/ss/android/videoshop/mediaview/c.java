package com.ss.android.videoshop.mediaview;

import android.view.SurfaceHolder;

/* JADX INFO: loaded from: classes40.dex */
public final class c implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SurfaceVideoView f456071a;

    public c(SurfaceVideoView r100) {
        this.f456071a = r100;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        a.InterfaceC5459a r101 = this.f456071a.f456022a;
        if (r101 == null) goto L6;
        ((VideoPatchLayout) r101).f0();
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        a.InterfaceC5459a r101 = this.f456071a.f456022a;
        if (r101 == null) goto L6;
        ((VideoPatchLayout) r101).g0();
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        SurfaceVideoView r104 = this.f456071a;
        if (r104.f456022a != null) goto L5;
        return;
    L5:
        if (r104.getHolder() == null) goto L9;
        if (r102 <= 0) goto L9;
        if (r103 <= 0) goto L9;
        this.f456071a.getHolder().setFixedSize(r102, r103);
        this.f456071a.requestLayout();
    L9:
        ((VideoPatchLayout) this.f456071a.f456022a).d0();
    }
}
