package cu7;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f465438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f465439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f465440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f465441d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f465438a == r101.f465438a) goto L12;
        return false;
    L12:
        if (this.f465439b == r101.f465439b) goto L15;
        return false;
    L15:
        if (this.f465440c == r101.f465440c) goto L18;
        return false;
    L18:
        if (this.f465441d == r101.f465441d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f465438a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f465439b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f465440c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f465441d;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "MemoryData(timestamp=" + this.f465438a + ", javaHeap=" + this.f465439b + ", nativeHeap=" + this.f465440c + ", totalPss=" + this.f465441d + ')';
    }

    public d(long r100, long r101, long r102, long r103) {
        this.f465438a = r100;
        this.f465439b = r101;
        this.f465440c = r102;
        this.f465441d = r103;
    }
}
