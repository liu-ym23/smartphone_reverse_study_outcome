package lq9;

/* JADX INFO: loaded from: classes31.dex */
public final class p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p f510344f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f510345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f510346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f510347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f510348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f510349e;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f510345a == r101.f510345a) goto L12;
        return false;
    L12:
        if (this.f510346b == r101.f510346b) goto L15;
        return false;
    L15:
        if (this.f510347c == r101.f510347c) goto L18;
        return false;
    L18:
        if (this.f510348d == r101.f510348d) goto L21;
        return false;
    L21:
        if (this.f510349e == r101.f510349e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f510345a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f510346b;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f510347c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f510348d;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f510349e;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraSoothingConfig(enable=" + this.f510345a + ", normalInterval=" + this.f510346b + ", radioInterval=" + this.f510347c + ", minPlayingTime=" + this.f510348d + ", gFeedBackTime=" + this.f510349e + ')';
    }

    static {
        f510344f = new p(true, 2500, 2500, 750, 1000);
    }

    public p(boolean r100, long r101, long r102, long r103, long r104) {
        this.f510345a = r100;
        this.f510346b = r101;
        this.f510347c = r102;
        this.f510348d = r103;
        this.f510349e = r104;
    }
}
