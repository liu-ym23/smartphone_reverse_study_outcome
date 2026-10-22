package tw;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f547716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f547717b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Float.compare(this.f547716a, r101.f547716a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f547717b, r101.f547717b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f547716a) * 31) + Float.floatToIntBits(this.f547717b);
    }

    public final String toString() {
        return "GoldBoxPosition(rightMargin=" + this.f547716a + ", bottomMargin=" + this.f547717b + ")";
    }

    public a(float r100, float r101) {
        this.f547716a = r100;
        this.f547717b = r101;
    }
}
