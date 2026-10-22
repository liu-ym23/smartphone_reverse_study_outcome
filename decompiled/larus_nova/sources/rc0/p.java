package rc0;

/* JADX INFO: loaded from: classes45.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f537064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f537065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f537066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f537067d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L14;
        p r101 = (p) r100;
        if (this.f537064a == r101.f537064a) goto L8;
        return false;
    L8:
        if (this.f537065b == r101.f537065b) goto L10;
        return false;
    L10:
        if (this.f537066c == r101.f537066c) goto L12;
        return false;
    L12:
        if (this.f537067d == r101.f537067d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f537064a * 31) + this.f537065b) * 31) + this.f537066c) * 31) + this.f537067d;
    }

    public final String toString() {
        return "RevenuePlayerLayoutDescriptorExternal(width=" + this.f537064a + ", height=" + this.f537065b + ", leftMargin=" + this.f537066c + ", topMargin=" + this.f537067d + ")";
    }

    public p(int r100, int r101, int r102, int r103) {
        this.f537064a = r100;
        this.f537065b = r101;
        this.f537066c = r102;
        this.f537067d = r103;
    }
}
