package fy;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f479196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f479197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f479198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f479199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f479200e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L16;
        f r101 = (f) r100;
        if (this.f479196a == r101.f479196a) goto L8;
        return false;
    L8:
        if (this.f479197b == r101.f479197b) goto L10;
        return false;
    L10:
        if (this.f479198c == r101.f479198c) goto L12;
        return false;
    L12:
        if (this.f479199d == r101.f479199d) goto L14;
        return false;
    L14:
        if (this.f479200e == r101.f479200e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f479196a;
        int r101 = ((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f479197b) * 31) + this.f479198c) * 31) + this.f479199d) * 31;
        long r102 = this.f479200e;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "JoinChannelParams(channelId=" + this.f479196a + ", scene=" + this.f479197b + ", fromAudience=" + this.f479198c + ", matchType=" + this.f479199d + ", startTs=" + this.f479200e + ")";
    }

    public f(long r100, int r101, int r102, int r103) {
        if ((r103 & 8) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r103 & 16) == 0) goto L8;
        i97.a r104 = i97.a.f488802a;
        long r105 = System.currentTimeMillis();
    L9:
        this.f479196a = r100;
        this.f479197b = r101;
        this.f479198c = 0;
        this.f479199d = r102;
        this.f479200e = r105;
        return;
    L8:
        r105 = 0;
        goto L9
    }
}
