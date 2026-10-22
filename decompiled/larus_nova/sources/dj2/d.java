package dj2;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f468885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f468886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f468887c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (this.f468885a == r101.f468885a) goto L8;
        return false;
    L8:
        if (this.f468886b == r101.f468886b) goto L10;
        return false;
    L10:
        if (this.f468887c == r101.f468887c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f468885a * 31) + this.f468886b) * 31) + this.f468887c;
    }

    public final String toString() {
        return "ExplainBigProductCardState(bigCardViewWidth=" + this.f468885a + ", bigCardViewHeight=" + this.f468886b + ", productImageSize=" + this.f468887c + ")";
    }

    public d(int r100, int r101, int r102) {
        this.f468885a = r100;
        this.f468886b = r101;
        this.f468887c = r102;
    }
}
