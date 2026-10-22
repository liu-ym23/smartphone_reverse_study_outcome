package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f486730d;

    public o1() {
        this(false, false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o1) == true) goto L8;
        return false;
    L8:
        o1 r101 = (o1) r100;
        if (this.f486727a == r101.f486727a) goto L12;
        return false;
    L12:
        if (this.f486728b == r101.f486728b) goto L15;
        return false;
    L15:
        if (this.f486729c == r101.f486729c) goto L18;
        return false;
    L18:
        if (this.f486730d == r101.f486730d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486727a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f486728b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f486729c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f486730d == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
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
        return "GenImgCardStyleSettings(adaptiveImage4Box=" + this.f486727a + ", isHorizontalScroll=" + this.f486728b + ", horizontalScrollShowShare=" + this.f486729c + ", horizontalScrollShowDownload=" + this.f486730d + ')';
    }

    public o1(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f486727a = r100;
        this.f486728b = r101;
        this.f486729c = r102;
        this.f486730d = r103;
    }
}
