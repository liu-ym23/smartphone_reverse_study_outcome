package pc8;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f528592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f528593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f528594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f528595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f528596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f528597f;

    public static final class a {
    }

    static {
    }

    public h() {
        this(0, 0, 0, false, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f528592a == r101.f528592a) goto L12;
        return false;
    L12:
        if (this.f528593b == r101.f528593b) goto L15;
        return false;
    L15:
        if (this.f528594c == r101.f528594c) goto L18;
        return false;
    L18:
        if (this.f528595d == r101.f528595d) goto L21;
        return false;
    L21:
        if (this.f528596e == r101.f528596e) goto L24;
        return false;
    L24:
        if (this.f528597f == r101.f528597f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f528592a * 31) + this.f528593b) * 31;
        long r101 = this.f528594c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.f528595d == false) goto L5;
        int r103 = 1231;
    L7:
        return ((((r102 + r103) * 31) + this.f528596e) * 31) + this.f528597f;
    L5:
        r103 = 1237;
        goto L7
    }

    public final String toString() {
        return "BubbleBannerStrategy(showTiming=" + this.f528592a + ", dismissTiming=" + this.f528593b + ", autoDismissSeconds=" + this.f528594c + ", keepOnLeave=" + this.f528595d + ", clickDismissBehavior=" + this.f528596e + ", priority=" + this.f528597f + ')';
    }

    public h(int r100, int r101, long r102, boolean r103, int r104, int r105) {
        this.f528592a = r100;
        this.f528593b = r101;
        this.f528594c = r102;
        this.f528595d = r103;
        this.f528596e = r104;
        this.f528597f = r105;
    }
}
