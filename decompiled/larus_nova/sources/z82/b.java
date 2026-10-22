package z82;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f570891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f570892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f570893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f570894d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (this.f570891a == r101.f570891a) goto L8;
        return false;
    L8:
        if (this.f570892b == r101.f570892b) goto L10;
        return false;
    L10:
        if (this.f570893c == r101.f570893c) goto L12;
        return false;
    L12:
        if (this.f570894d == r101.f570894d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f570891a * 31) + this.f570892b) * 31) + this.f570893c) * 31) + this.f570894d;
    }

    public final String toString() {
        return "width = " + this.f570891a + ", height = " + this.f570892b + ", topMargin = " + this.f570893c + ", leftMargin = " + this.f570894d;
    }

    public b(int r100, int r101, int r102, int r103) {
        this.f570891a = r100;
        this.f570892b = r101;
        this.f570893c = r102;
        this.f570894d = r103;
    }
}
