package hq9;

/* JADX INFO: loaded from: classes4.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f486627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f486628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f486629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f486630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f486631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f486632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f486633j;

    public h0() {
        this(false, false, false, false, false, false, 0, false, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (this.f486624a == r101.f486624a) goto L12;
        return false;
    L12:
        if (this.f486625b == r101.f486625b) goto L15;
        return false;
    L15:
        if (this.f486626c == r101.f486626c) goto L18;
        return false;
    L18:
        if (this.f486627d == r101.f486627d) goto L21;
        return false;
    L21:
        if (this.f486628e == r101.f486628e) goto L24;
        return false;
    L24:
        if (this.f486629f == r101.f486629f) goto L27;
        return false;
    L27:
        if (this.f486630g == r101.f486630g) goto L30;
        return false;
    L30:
        if (this.f486631h == r101.f486631h) goto L33;
        return false;
    L33:
        if (this.f486632i == r101.f486632i) goto L36;
        return false;
    L36:
        if (this.f486633j == r101.f486633j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486624a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f486625b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f486626c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f486627d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f486628e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f486629f == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (((r110 + r111) * 31) + this.f486630g) * 31;
        if (this.f486631h == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.f486632i == false) goto L33;
        int r115 = 1231;
    L34:
        int r116 = (r114 + r115) * 31;
        if (this.f486633j == true) goto L39;
        r100 = 1237;
    L39:
        return r116 + r100;
    L33:
        r115 = 1237;
        goto L34
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
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
        return "ChatNavigatorConfig(hasUnreadCount=" + this.f486624a + ", navigatorSimplify=" + this.f486625b + ", mainBotUseDrawerBack=" + this.f486626c + ", showSearchEntrance=" + this.f486627d + ", showRealtimeCallEntrance=" + this.f486628e + ", showMoreEntrance=" + this.f486629f + ", badgeStyle=" + this.f486630g + ", enableSideBarRedDot=" + this.f486631h + ", halfChatFragmentHideTtsEntrance=" + this.f486632i + ", halfChatFragmentHideCloseIconEntrance=" + this.f486633j + ')';
    }

    public h0(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, int r110, boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r103 = false;
    L15:
        if ((r112 & 16) == 0) goto L18;
        r104 = true;
    L18:
        if ((r112 & 32) == 0) goto L21;
        r105 = false;
    L21:
        if ((r112 & 64) == 0) goto L24;
        r110 = 0;
    L24:
        if ((r112 & 128) == 0) goto L26;
        r111 = false;
    L26:
        this.f486624a = r100;
        this.f486625b = r101;
        this.f486626c = r102;
        this.f486627d = r103;
        this.f486628e = r104;
        this.f486629f = r105;
        this.f486630g = r110;
        this.f486631h = r111;
        this.f486632i = false;
        this.f486633j = false;
    }
}
