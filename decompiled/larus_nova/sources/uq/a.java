package uq;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f551167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f551168b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Float.compare(this.f551167a, r101.f551167a) == 0) goto L8;
        return false;
    L8:
        if (this.f551168b == r101.f551168b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f551167a) * 31) + this.f551168b;
    }

    public final String toString() {
        return "SlcCSSValue(value=" + this.f551167a + ", unit=" + this.f551168b + ")";
    }

    public a(float r100, int r101) {
        this.f551167a = r100;
        this.f551168b = r101;
    }
}
