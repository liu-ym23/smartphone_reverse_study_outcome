package nh0;

/* JADX INFO: loaded from: classes46.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f519138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f519139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f519140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f519141d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L14;
        n r101 = (n) r100;
        if (this.f519138a == r101.f519138a) goto L8;
        return false;
    L8:
        if (this.f519139b == r101.f519139b) goto L10;
        return false;
    L10:
        if (this.f519140c == r101.f519140c) goto L12;
        return false;
    L12:
        if (this.f519141d == r101.f519141d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f519138a * 31) + this.f519139b) * 31) + this.f519140c) * 31) + this.f519141d;
    }

    public final String toString() {
        return "StageExtraFrame(x=" + this.f519138a + ", y=" + this.f519139b + ", w=" + this.f519140c + ", h=" + this.f519141d + ")";
    }

    public n(int r100, int r101, int r102, int r103) {
        this.f519138a = r100;
        this.f519139b = r101;
        this.f519140c = r102;
        this.f519141d = r103;
    }
}
