package q72;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f531954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f531955b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (this.f531954a == r101.f531954a) goto L8;
        return false;
    L8:
        if (this.f531955b == r101.f531955b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f531954a * 31) + this.f531955b;
    }

    public final String toString() {
        return "WebpSize(width=" + this.f531954a + ", height=" + this.f531955b + ")";
    }

    public g(int r100, int r101) {
        this.f531954a = r100;
        this.f531955b = r101;
    }
}
