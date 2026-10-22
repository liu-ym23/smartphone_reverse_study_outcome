package ki4;

/* JADX INFO: loaded from: classes15.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f503621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f503622b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (this.f503621a == r101.f503621a) goto L12;
        return false;
    L12:
        if (this.f503622b == r101.f503622b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f503621a * 31) + this.f503622b;
    }

    public final String toString() {
        return "MaterialRange(startPosition=" + this.f503621a + ", totalCount=" + this.f503622b + ')';
    }

    public d0(int r100, int r101) {
        this.f503621a = r100;
        this.f503622b = r101;
    }
}
