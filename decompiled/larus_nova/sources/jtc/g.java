package jtc;

/* JADX INFO: loaded from: classes41.dex */
public final class g implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f500397b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f500398a;

    @Override // jtc.i
    public final i a(io.opentelemetry.api.internal.i r100, Object r101) {
        return this;
    }

    @Override // jtc.i
    public final i c(String r100) {
        return this;
    }

    @Override // jtc.i
    public final void end() {
    }

    static {
        f500397b = new g(io.opentelemetry.api.internal.h.f492674a);
    }

    public final String toString() {
        return "PropagatedSpan{" + this.f500398a + '}';
    }

    @Override // jtc.i
    public final k b() {
        return this.f500398a;
    }

    public g(k r100) {
        this.f500398a = r100;
    }
}
