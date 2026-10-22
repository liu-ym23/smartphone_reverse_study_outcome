package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f571907a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p0) == true) goto L6;
        return false;
    L6:
        if (Float.compare(this.f571907a, ((p0) r100).f571907a) == 0) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f571907a);
    }

    public final String toString() {
        return "InterAlphaEvent(factor=" + this.f571907a + ")";
    }

    public p0(float r100) {
        this.f571907a = r100;
    }
}
