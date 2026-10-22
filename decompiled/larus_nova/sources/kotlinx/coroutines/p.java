package kotlinx.coroutines;

/* JADX INFO: loaded from: classes.dex */
public final class p extends d1 implements o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f505000e;

    @Override // kotlinx.coroutines.o
    public final Job getParent() {
        return i();
    }

    public p(q r100) {
        this.f505000e = r100;
    }

    @Override // kotlinx.coroutines.z0
    public final void a(Throwable r100) {
        this.f505000e.a(i());
    }

    @Override // kotlinx.coroutines.o
    public final boolean b(Throwable r100) {
        return i().y(r100);
    }
}
