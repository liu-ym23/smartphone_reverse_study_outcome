package cy8;

/* JADX INFO: loaded from: classes26.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f465942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f465943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f465944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f465945d;

    public x() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (this.f465942a == r101.f465942a) goto L12;
        return false;
    L12:
        if (this.f465943b == r101.f465943b) goto L15;
        return false;
    L15:
        if (this.f465944c == r101.f465944c) goto L18;
        return false;
    L18:
        if (this.f465945d == r101.f465945d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f465942a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f465943b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f465944c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f465945d;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "CanvasSSETimeout(connectTimeout=" + this.f465942a + ", intervalTimeout=" + this.f465943b + ", writeTimeout=" + this.f465944c + ", protectTimeout=" + this.f465945d + ')';
    }

    public /* synthetic */ x(int r110) {
        this(60000, 60000, 60000, 180000);
    }

    public x(long r100, long r101, long r102, long r103) {
        this.f465942a = r100;
        this.f465943b = r101;
        this.f465944c = r102;
        this.f465945d = r103;
    }
}
