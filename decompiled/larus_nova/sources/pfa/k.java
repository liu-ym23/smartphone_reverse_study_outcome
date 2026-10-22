package pfa;

/* JADX INFO: loaded from: classes33.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f529015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f529016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f529017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f529018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f529019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f529020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f529021g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f529015a == r101.f529015a) goto L12;
        return false;
    L12:
        if (this.f529016b == r101.f529016b) goto L15;
        return false;
    L15:
        if (this.f529017c == r101.f529017c) goto L18;
        return false;
    L18:
        if (this.f529018d == r101.f529018d) goto L21;
        return false;
    L21:
        if (this.f529019e == r101.f529019e) goto L24;
        return false;
    L24:
        if (this.f529020f == r101.f529020f) goto L27;
        return false;
    L27:
        if (this.f529021g == r101.f529021g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f529015a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f529016b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        if (this.f529017c == false) goto L5;
        int r104 = 1231;
    L6:
        long r105 = this.f529018d;
        int r106 = (((r103 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f529019e;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f529020f;
        return ((r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31) + this.f529021g;
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "NovaProcessControlerInitParams(stopDelayMs=" + this.f529015a + ", startDelayMs=" + this.f529016b + ", enableBootAutoStartExit=" + this.f529017c + ", bootAutoStartWindowMs=" + this.f529018d + ", bootAutoStartFirstCheckDelayMs=" + this.f529019e + ", bootAutoStartRetryDelayMs=" + this.f529020f + ", bootAutoStartMaxRetryCount=" + this.f529021g + ')';
    }

    public k(long r100, long r101, boolean r102, long r103, long r104, long r110, int r111) {
        this.f529015a = r100;
        this.f529016b = r101;
        this.f529017c = r102;
        this.f529018d = r103;
        this.f529019e = r104;
        this.f529020f = r110;
        this.f529021g = r111;
    }
}
