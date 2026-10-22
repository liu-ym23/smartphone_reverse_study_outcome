package z82;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f570897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f570898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f570899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f570900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f570901e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (this.f570897a == r101.f570897a) goto L8;
        return false;
    L8:
        if (this.f570898b == r101.f570898b) goto L10;
        return false;
    L10:
        if (this.f570899c == r101.f570899c) goto L12;
        return false;
    L12:
        if (this.f570900d == r101.f570900d) goto L14;
        return false;
    L14:
        if (this.f570901e == r101.f570901e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return (((((((this.f570897a * 31) + this.f570898b) * 31) + this.f570899c) * 31) + this.f570900d) * 31) + this.f570901e;
    }

    public final String toString() {
        return "PlayerLayoutData(width=" + this.f570897a + ", height=" + this.f570898b + ", topMargin=" + this.f570899c + ", leftMargin=" + this.f570900d + ", gravity=" + this.f570901e + ")";
    }

    public d(int r100, int r101, int r102, int r103) {
        this.f570897a = r100;
        this.f570898b = r101;
        this.f570899c = r102;
        this.f570900d = r103;
        this.f570901e = 51;
    }
}
