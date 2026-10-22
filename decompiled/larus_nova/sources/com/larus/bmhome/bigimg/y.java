package com.larus.bmhome.bigimg;

/* JADX INFO: loaded from: classes25.dex */
public final class y implements l19.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BigImageLocalPhotoViewerDialog f296152a;

    @Override // l19.f
    public final void onTransitionChanged(int r100, float r101) {
    }

    public y(BigImageLocalPhotoViewerDialog r100) {
        this.f296152a = r100;
    }

    @Override // l19.f
    public final void onTransitionBegin(int r100) {
        this.f296152a.G = true;
    }

    @Override // l19.f
    public final void onTransitionEnd(int r100) {
        this.f296152a.G = false;
    }
}
