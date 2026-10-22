package jba;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f498051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f498052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f498053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f498054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f498055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f498056f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f498051a == r101.f498051a) goto L12;
        return false;
    L12:
        if (this.f498052b == r101.f498052b) goto L15;
        return false;
    L15:
        if (this.f498053c == r101.f498053c) goto L18;
        return false;
    L18:
        if (this.f498054d == r101.f498054d) goto L21;
        return false;
    L21:
        if (this.f498055e == r101.f498055e) goto L24;
        return false;
    L24:
        if (this.f498056f == r101.f498056f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f498051a * 31) + this.f498052b) * 31) + this.f498053c) * 31) + this.f498054d) * 31) + this.f498055e) * 31;
        if (this.f498056f == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ObricLandscapeWindowLayoutSpec(width=" + this.f498051a + ", height=" + this.f498052b + ", gravity=" + this.f498053c + ", x=" + this.f498054d + ", y=" + this.f498055e + ", isLandscapeWindow=" + this.f498056f + ')';
    }

    public e(int r100, int r101, int r102, int r103, int r104, boolean r105) {
        this.f498051a = r100;
        this.f498052b = r101;
        this.f498053c = r102;
        this.f498054d = r103;
        this.f498055e = r104;
        this.f498056f = r105;
    }
}
