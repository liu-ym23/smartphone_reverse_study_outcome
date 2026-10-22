package iv7;

import java.util.Objects;

/* JADX INFO: loaded from: classes23.dex */
public final class n<T> extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f495965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f495966b;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f495965a, this.f495966b});
    }

    @Override // iv7.m
    public final long a() {
        return this.f495965a.a();
    }

    @Override // iv7.m
    public final long b() {
        return this.f495965a.b();
    }

    public final String toString() {
        return "range: " + this.f495965a + ", metadata: " + this.f495966b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f495965a.equals(r101.f495965a) == true) goto L11;
        return false;
    L11:
        T r102 = this.f495966b;
        if (r102 != null) goto L17;
        if (r101.f495966b == null) goto L19;
        return false;
    L19:
        return true;
    L17:
        if (r102.equals(r101.f495966b) == true) goto L19;
        return false;
    }

    public n(m r100, T r101) {
        this.f495965a = r100;
        this.f495966b = r101;
    }
}
