package y84;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f566891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f566892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f566893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f566894d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Float.compare(this.f566891a, r101.f566891a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f566892b, r101.f566892b) == 0) goto L15;
        return false;
    L15:
        if (this.f566893c == r101.f566893c) goto L18;
        return false;
    L18:
        if (Float.compare(this.f566894d, r101.f566894d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f566891a) * 31) + Float.floatToIntBits(this.f566892b)) * 31) + this.f566893c) * 31) + Float.floatToIntBits(this.f566894d);
    }

    public final String toString() {
        return "Seg(bearing=" + this.f566891a + ", distance=" + this.f566892b + ", idx=" + this.f566893c + ", dt=" + this.f566894d + ")";
    }

    public c(float r100, float r101, int r102, float r103) {
        this.f566891a = r100;
        this.f566892b = r101;
        this.f566893c = r102;
        this.f566894d = r103;
    }
}
