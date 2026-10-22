package androidx.camera.core.processing;

import androidx.camera.core.SurfaceRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f686a;

    public /* synthetic */ k(SurfaceRequest r1) {
        this.f686a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f686a.willNotProvideSurface();
    }
}
