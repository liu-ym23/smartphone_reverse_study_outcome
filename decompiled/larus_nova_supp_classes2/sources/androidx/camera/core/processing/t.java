package androidx.camera.core.processing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge.SettableSurface f700a;

    public /* synthetic */ t(SurfaceEdge.SettableSurface r1) {
        this.f700a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f700a.close();
    }
}
