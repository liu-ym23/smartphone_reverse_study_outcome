package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class n0 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f504997a;

    public final String toString() {
        return "DisposeOnCancel[" + this.f504997a + ']';
    }

    public n0(m0 r100) {
        this.f504997a = r100;
    }

    @Override // kotlinx.coroutines.h
    public final void a(Throwable r100) {
        this.f504997a.dispose();
    }
}
