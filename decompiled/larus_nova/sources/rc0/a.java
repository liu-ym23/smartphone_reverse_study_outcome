package rc0;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f537023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f537024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f537025c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f537023a == r101.f537023a) goto L8;
        return false;
    L8:
        if (this.f537024b == r101.f537024b) goto L10;
        return false;
    L10:
        if (this.f537025c == r101.f537025c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f537023a * 31) + this.f537024b) * 31) + this.f537025c;
    }

    public final String toString() {
        return "BottomSizeInfo(mode=" + this.f537023a + ", width=" + this.f537024b + ", height=" + this.f537025c + ")";
    }

    public a(int r100, int r101, int r102) {
        this.f537023a = r100;
        this.f537024b = r101;
        this.f537025c = r102;
    }
}
