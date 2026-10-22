package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f571976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f571977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f571978d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x0) == false) goto L14;
        x0 r101 = (x0) r100;
        if (this.f571975a == r101.f571975a) goto L8;
        return false;
    L8:
        if (this.f571976b == r101.f571976b) goto L10;
        return false;
    L10:
        if (this.f571977c == r101.f571977c) goto L12;
        return false;
    L12:
        if (this.f571978d == r101.f571978d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f571975a * 31) + this.f571976b) * 31) + this.f571977c) * 31) + this.f571978d;
    }

    public final String toString() {
        return "LandscapeRootViewChangeEvent(startX=" + this.f571975a + ", endX=" + this.f571976b + ", marginStart=" + this.f571977c + ", marginEnd=" + this.f571978d + ")";
    }

    public x0(int r100, int r101, int r102, int r103) {
        this.f571975a = r100;
        this.f571976b = r101;
        this.f571977c = r102;
        this.f571978d = r103;
    }
}
