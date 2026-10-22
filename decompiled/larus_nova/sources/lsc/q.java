package lsc;

/* JADX INFO: loaded from: classes5.dex */
public final class q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510619a;

    public final int hashCode() {
        return this.f510619a.hashCode();
    }

    public final String toString() {
        return "Prop{name='" + this.f510619a + "'}";
    }

    public q(String r100) {
        this.f510619a = r100;
    }

    public final T a(t r100) {
        return (T) ((u) r100).a(this);
    }

    public final T b(t r100) {
        T r101 = a(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new NullPointerException(this.f510619a);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (q.class == r100.getClass()) goto L10;
        return false;
    L10:
        return this.f510619a.equals(((q) r100).f510619a);
    }

    public final void c(t r100, T r101) {
        ((u) r100).c(this, r101);
    }
}
