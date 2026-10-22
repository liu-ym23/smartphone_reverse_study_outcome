package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SurfaceTextureHelper f202167a;

    public /* synthetic */ o(SurfaceTextureHelper r100) {
        this.f202167a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceTextureHelper.g(this.f202167a);
    }
}
