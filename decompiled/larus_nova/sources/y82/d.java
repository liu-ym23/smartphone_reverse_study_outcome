package y82;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f566849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f566850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f566851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f566852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f566853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f566854f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (this.f566849a == r101.f566849a) goto L8;
        return false;
    L8:
        if (this.f566850b == r101.f566850b) goto L10;
        return false;
    L10:
        if (this.f566851c == r101.f566851c) goto L12;
        return false;
    L12:
        if (this.f566852d == r101.f566852d) goto L14;
        return false;
    L14:
        if (this.f566853e == r101.f566853e) goto L16;
        return false;
    L16:
        if (this.f566854f == r101.f566854f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        return (((((((((this.f566849a * 31) + this.f566850b) * 31) + this.f566851c) * 31) + this.f566852d) * 31) + this.f566853e) * 31) + this.f566854f;
    }

    public final String toString() {
        return "MediaComponentLayoutData(width=" + this.f566849a + ", height=" + this.f566850b + ", topMargin=" + this.f566851c + ", leftMargin=" + this.f566852d + ", rightMargin=" + this.f566853e + ", gravity=" + this.f566854f + ")";
    }

    public d(int r100, int r101, int r102, int r103, int r104) {
        this.f566849a = r100;
        this.f566850b = r101;
        this.f566851c = r102;
        this.f566852d = r103;
        this.f566853e = 0;
        this.f566854f = r104;
    }
}
