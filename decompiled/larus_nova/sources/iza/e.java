package iza;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f496728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f496729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f496730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f496731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f496732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f496733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f496734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f496735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f496736i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f496728a == r101.f496728a) goto L12;
        return false;
    L12:
        if (this.f496729b == r101.f496729b) goto L15;
        return false;
    L15:
        if (this.f496730c == r101.f496730c) goto L18;
        return false;
    L18:
        if (this.f496731d == r101.f496731d) goto L21;
        return false;
    L21:
        if (this.f496732e == r101.f496732e) goto L24;
        return false;
    L24:
        if (this.f496733f == r101.f496733f) goto L27;
        return false;
    L27:
        if (this.f496734g == r101.f496734g) goto L30;
        return false;
    L30:
        if (this.f496735h == r101.f496735h) goto L33;
        return false;
    L33:
        if (this.f496736i == r101.f496736i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f496728a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f496729b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.f496730c) * 31;
        if (this.f496731d == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((r104 + r105) * 31) + this.f496732e) * 31;
        if (this.f496733f == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f496734g == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (((r108 + r109) * 31) + this.f496735h) * 31;
        if (this.f496736i == true) goto L27;
        r100 = 1237;
    L27:
        return r110 + r100;
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SidebarItemConfig(hasAvatar=" + this.f496728a + ", titleIsBoldDisplay=" + this.f496729b + ", titleLeftMargin=" + this.f496730c + ", isPagingDisplay=" + this.f496731d + ", firstPageLoadMoreSize=" + this.f496732e + ", isShowOnTopFlowCell=" + this.f496733f + ", isShowNotOnTopFlowCell=" + this.f496734g + ", nextPageLoadMoreSize=" + this.f496735h + ", showPinTag=" + this.f496736i + ')';
    }

    public e(boolean r100, boolean r101, int r102, boolean r103, int r104, boolean r110, boolean r111, int r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r113 & 8) == 0) goto L12;
        r103 = false;
    L12:
        if ((r113 & 16) == 0) goto L15;
        r104 = 10;
    L15:
        if ((r113 & 32) == 0) goto L18;
        r110 = true;
    L18:
        if ((r113 & 64) == 0) goto L21;
        r111 = true;
    L21:
        if ((r113 & 128) == 0) goto L23;
        r112 = 10;
    L23:
        this.f496728a = r100;
        this.f496729b = r101;
        this.f496730c = r102;
        this.f496731d = r103;
        this.f496732e = r104;
        this.f496733f = r110;
        this.f496734g = r111;
        this.f496735h = r112;
        this.f496736i = false;
    }
}
