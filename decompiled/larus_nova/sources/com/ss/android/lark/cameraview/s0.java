package com.ss.android.lark.cameraview;

/* JADX INFO: loaded from: classes34.dex */
public final class s0 implements d0b.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JCameraView f411015a;

    @Override // d0b.f
    public final void cancel() {
        JCameraView r100 = this.f411015a;
        r100.f410829a.i(r100.f410834f.getHolder(), this.f411015a.f410842n);
    }

    @Override // d0b.f
    public final void confirm() {
        this.f411015a.f410829a.confirm();
    }

    public s0(JCameraView r100) {
        this.f411015a = r100;
    }
}
