package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f486619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f486621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f486622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f486623f;

    public h() {
        this(false, 0, false, 0, 0, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f486618a == r101.f486618a) goto L12;
        return false;
    L12:
        if (this.f486619b == r101.f486619b) goto L15;
        return false;
    L15:
        if (this.f486620c == r101.f486620c) goto L18;
        return false;
    L18:
        if (this.f486621d == r101.f486621d) goto L21;
        return false;
    L21:
        if (this.f486622e == r101.f486622e) goto L24;
        return false;
    L24:
        if (this.f486623f == r101.f486623f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486618a == false) goto L5;
        int r101 = 1231;
    L6:
        long r102 = this.f486619b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        if (this.f486620c == true) goto L10;
        r100 = 1237;
    L10:
        int r104 = (r103 + r100) * 31;
        long r105 = this.f486621d;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f486622e;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f486623f;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppLaunchFeedOptConfig(enable=" + this.f486618a + ", viewWaitTimeOutDuration=" + this.f486619b + ", optimizeLandingChatActivity=" + this.f486620c + ", boostDuration=" + this.f486621d + ", boostDurationList=" + this.f486622e + ", boostDurationPager=" + this.f486623f + ')';
    }

    public h(boolean r100, long r101, boolean r102, long r103, long r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = 5000;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r111 & 16) == 0) goto L15;
        r103 = 0;
    L15:
        if ((r111 & 32) == 0) goto L17;
        r110 = 0;
    L17:
        this.f486618a = r100;
        this.f486619b = r101;
        this.f486620c = r102;
        this.f486621d = 0;
        this.f486622e = r103;
        this.f486623f = r110;
    }
}
