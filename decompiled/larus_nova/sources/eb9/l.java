package eb9;

/* JADX INFO: loaded from: classes29.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f471889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f471890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f471891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f471892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f471893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f471894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f471895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f471896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f471897i;

    /* JADX WARN: Multi-variable type inference failed */
    public l() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(false, r100, r101, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f471889a == r101.f471889a) goto L12;
        return false;
    L12:
        if (this.f471890b == r101.f471890b) goto L15;
        return false;
    L15:
        if (this.f471891c == r101.f471891c) goto L18;
        return false;
    L18:
        if (this.f471892d == r101.f471892d) goto L21;
        return false;
    L21:
        if (this.f471893e == r101.f471893e) goto L24;
        return false;
    L24:
        if (this.f471894f == r101.f471894f) goto L27;
        return false;
    L27:
        if (this.f471895g == r101.f471895g) goto L30;
        return false;
    L30:
        if (this.f471896h == r101.f471896h) goto L33;
        return false;
    L33:
        if (this.f471897i == r101.f471897i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f471889a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f471890b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.f471891c) * 31;
        if (this.f471892d == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f471893e == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f471894f == true) goto L23;
        r100 = 1237;
    L23:
        return ((((((r108 + r100) * 31) + this.f471895g) * 31) + this.f471896h) * 31) + this.f471897i;
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
        return "FlowFeedHostConfig(hasAvatar=" + this.f471889a + ", titleBold=" + this.f471890b + ", titleStartMarginPx=" + this.f471891c + ", isShowOnTopFlowCell=" + this.f471892d + ", isShowNotOnTopFlowCell=" + this.f471893e + ", isPagingDisplay=" + this.f471894f + ", initialDisplaySize=" + this.f471895g + ", secondPageSize=" + this.f471896h + ", loadMoreSize=" + this.f471897i + ')';
    }

    public /* synthetic */ l(boolean r110, boolean r111, int r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r113 & 2) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r113 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r113 & 8) == 0) goto L17;
        boolean r103 = true;
    L19:
        if ((r113 & 16) == 0) goto L21;
        boolean r104 = true;
    L23:
        if ((r113 & 64) == 0) goto L25;
        int r114 = 3;
    L27:
        if ((r113 & 128) == 0) goto L29;
        int r115 = 10;
    L31:
        if ((r113 & 256) == 0) goto L33;
        int r116 = 20;
    L34:
        this(r100, r101, r102, r103, r104, false, r114, r115, r116);
        return;
    L33:
        r116 = 0;
        goto L34
    L29:
        r115 = 0;
        goto L31
    L25:
        r114 = 0;
        goto L27
    L21:
        r104 = false;
        goto L23
    L17:
        r103 = false;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public l(boolean r100, boolean r101, int r102, boolean r103, boolean r104, boolean r105, int r106, int r107, int r108) {
        this.f471889a = r100;
        this.f471890b = r101;
        this.f471891c = r102;
        this.f471892d = r103;
        this.f471893e = r104;
        this.f471894f = r105;
        this.f471895g = r106;
        this.f471896h = r107;
        this.f471897i = r108;
    }
}
