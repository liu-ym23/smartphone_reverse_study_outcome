package v72;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f553447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f553448b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (this.f553447a == r101.f553447a) goto L8;
        return false;
    L8:
        if (this.f553448b == r101.f553448b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f553447a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f553448b;
    }

    public final String toString() {
        return "FrequencyBarrier(leftBarrierTs=" + this.f553447a + ", sliceCounter=" + this.f553448b + ")";
    }

    public d(long r100, int r101) {
        this.f553447a = r100;
        this.f553448b = r101;
    }
}
