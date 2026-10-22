package iv7;

/* JADX INFO: loaded from: classes23.dex */
public final class a extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f495946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f495947b;

    public final int hashCode() {
        long r100 = this.f495946a;
        int r101 = (((int) (r100 ^ (r100 >>> 32))) ^ 1000003) * 1000003;
        long r102 = this.f495947b;
        return ((int) ((r102 >>> 32) ^ r102)) ^ r101;
    }

    public final String toString() {
        return "Range{offset=" + this.f495946a + ", length=" + this.f495947b + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // iv7.m
    public final long a() {
        return this.f495947b;
    }

    @Override // iv7.m
    public final long b() {
        return this.f495946a;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == false) goto L14;
        m r101 = (m) r100;
        if (this.f495946a == r101.b()) goto L10;
    L12:
        return false;
    L10:
        if (this.f495947b != r101.a()) goto L12;
        return true;
    L14:
        return false;
    }

    public a(long r100, long r101) {
        this.f495946a = r100;
        this.f495947b = r101;
    }
}
