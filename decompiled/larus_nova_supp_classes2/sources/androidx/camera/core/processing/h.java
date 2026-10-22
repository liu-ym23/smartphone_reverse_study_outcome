package androidx.camera.core.processing;

import androidx.camera.core.SurfaceOutput;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SurfaceOutput f676a;

    public /* synthetic */ h(SurfaceOutput r1) {
        this.f676a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f676a.close();
    }
}
