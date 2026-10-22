package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class o0 extends f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m0 f504998e;

    public o0(m0 r100) {
        this.f504998e = r100;
    }

    @Override // kotlinx.coroutines.z0
    public final void a(Throwable r100) {
        this.f504998e.dispose();
    }
}
