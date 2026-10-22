package nf6;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f518953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f518954b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Float.compare(this.f518953a, r101.f518953a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f518954b, r101.f518954b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f518953a) * 31) + Float.floatToIntBits(this.f518954b);
    }

    public final String toString() {
        return "Position2D(posX=" + this.f518953a + ", posY=" + this.f518954b + ")";
    }

    public b() {
        this.f518953a = 0.0f;
        this.f518954b = 0.0f;
    }
}
