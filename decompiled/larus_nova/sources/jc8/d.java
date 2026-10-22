package jc8;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f498156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f498157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f498158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f498159d;

    public d() {
        this(0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f498156a == r101.f498156a) goto L12;
        return false;
    L12:
        if (this.f498157b == r101.f498157b) goto L15;
        return false;
    L15:
        if (this.f498158c == r101.f498158c) goto L18;
        return false;
    L18:
        if (this.f498159d == r101.f498159d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f498156a * 31) + this.f498157b) * 31) + this.f498158c) * 31) + this.f498159d;
    }

    public final String toString() {
        return "BlockMargin(start=" + this.f498156a + ", top=" + this.f498157b + ", end=" + this.f498158c + ", bottom=" + this.f498159d + ')';
    }

    public d(int r100, int r101, int r102, int r103) {
        this.f498156a = r100;
        this.f498157b = r101;
        this.f498158c = r102;
        this.f498159d = r103;
    }

    public static d a(d r100, int r101, int r102, int r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f498156a;
    L6:
        if ((r104 & 2) == 0) goto L8;
        int r105 = r100.f498157b;
    L10:
        if ((r104 & 4) == 0) goto L13;
        r102 = r100.f498158c;
    L13:
        if ((r104 & 8) == 0) goto L15;
        r103 = r100.f498159d;
    L15:
        r100.getClass();
        return new d(r101, r105, r102, r103);
    L8:
        r105 = 0;
        goto L10
    }
}
