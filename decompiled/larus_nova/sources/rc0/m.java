package rc0;

/* JADX INFO: loaded from: classes45.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f537046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f537047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f537048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f537049d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L14;
        m r101 = (m) r100;
        if (this.f537046a == r101.f537046a) goto L8;
        return false;
    L8:
        if (this.f537047b == r101.f537047b) goto L10;
        return false;
    L10:
        if (this.f537048c == r101.f537048c) goto L12;
        return false;
    L12:
        if (this.f537049d == r101.f537049d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f537046a * 31) + this.f537047b) * 31) + this.f537048c) * 31) + this.f537049d;
    }

    public final String toString() {
        return "RevCoreLayout(width=" + this.f537046a + ", height=" + this.f537047b + ", topMargin=" + this.f537048c + ", leftMargin=" + this.f537049d + ")";
    }

    public m(int r100, int r101, int r102, int r103) {
        this.f537046a = r100;
        this.f537047b = r101;
        this.f537048c = r102;
        this.f537049d = r103;
    }
}
