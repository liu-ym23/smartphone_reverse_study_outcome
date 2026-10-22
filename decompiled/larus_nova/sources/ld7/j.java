package ld7;

/* JADX INFO: loaded from: classes22.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f508748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f508749b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f508748a == r101.f508748a) goto L12;
        return false;
    L12:
        if (this.f508749b == r101.f508749b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f508748a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f508749b;
    }

    public final String toString() {
        return "LimitRecord(spendTimestamp=" + this.f508748a + ", count=" + this.f508749b + ')';
    }

    public j(long r100, int r101) {
        this.f508748a = r100;
        this.f508749b = r101;
    }
}
