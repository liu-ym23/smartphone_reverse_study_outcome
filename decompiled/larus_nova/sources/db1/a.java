package db1;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f467793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f467794b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f467793a == r101.f467793a) goto L8;
        return false;
    L8:
        if (Float.compare(this.f467794b, r101.f467794b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f467793a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + Float.floatToIntBits(this.f467794b);
    }

    public final String toString() {
        return "MidiProgressInfo(startTime=" + this.f467793a + ", score=" + this.f467794b + ")";
    }

    public a(long r100, float r101) {
        this.f467793a = r100;
        this.f467794b = r101;
    }
}
