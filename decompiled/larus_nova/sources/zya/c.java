package zya;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f574000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f574001b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Float.compare(this.f574000a, r101.f574000a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f574001b, r101.f574001b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f574000a) * 31) + Float.floatToIntBits(this.f574001b);
    }

    public final String toString() {
        return "GridItemDisplayParam(textSize=" + this.f574000a + ", lineHeight=" + this.f574001b + ')';
    }

    public c(float r100, float r101) {
        this.f574000a = r100;
        this.f574001b = r101;
    }
}
