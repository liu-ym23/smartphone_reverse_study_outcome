package kotlinx.coroutines;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class p extends d1 implements o {
    public final q e;

    @Override // kotlinx.coroutines.o
    public final Job getParent() {
        return i();
    }

    public p(q r1) {
        this.e = r1;
    }

    @Override // kotlinx.coroutines.z0
    public final void a(Throwable r2) {
        this.e.a(i());
    }

    @Override // kotlinx.coroutines.o
    public final boolean b(Throwable r2) {
        return i().y(r2);
    }
}
