package qr2;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f534553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f534554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f534555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f534556d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (this.f534553a == r101.f534553a) goto L8;
        return false;
    L8:
        if (this.f534554b == r101.f534554b) goto L10;
        return false;
    L10:
        if (this.f534555c == r101.f534555c) goto L12;
        return false;
    L12:
        if (this.f534556d == r101.f534556d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f534553a * 31) + this.f534554b) * 31) + this.f534555c) * 31) + this.f534556d;
    }

    public final String toString() {
        return "FrameLayoutParamsDef(width=" + this.f534553a + ", height=" + this.f534554b + ", leftMargin=" + this.f534555c + ", topMargin=" + this.f534556d + ")";
    }

    public b(int r100, int r101, int r102, int r103) {
        this.f534553a = r100;
        this.f534554b = r101;
        this.f534555c = r102;
        this.f534556d = r103;
    }
}
