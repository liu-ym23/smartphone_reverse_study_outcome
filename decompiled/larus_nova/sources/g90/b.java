package g90;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f480471a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Float.compare(this.f480471a, ((b) r100).f480471a) == 0) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f480471a);
    }

    public final String toString() {
        return "PkBusinessData(gameRatio=" + this.f480471a + ")";
    }

    public b(float r100) {
        this.f480471a = r100;
    }
}
