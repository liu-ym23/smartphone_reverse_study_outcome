package com.bytedance.locallife.dito.data;

/* JADX INFO: loaded from: classes21.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f258255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f258256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f258257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f258258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f258259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f258260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f258261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f258262h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.f258255a == r101.f258255a) goto L12;
        return false;
    L12:
        if (this.f258256b == r101.f258256b) goto L15;
        return false;
    L15:
        if (this.f258257c == r101.f258257c) goto L18;
        return false;
    L18:
        if (this.f258258d == r101.f258258d) goto L21;
        return false;
    L21:
        if (this.f258259e == r101.f258259e) goto L24;
        return false;
    L24:
        if (this.f258260f == r101.f258260f) goto L27;
        return false;
    L27:
        if (this.f258261g == r101.f258261g) goto L30;
        return false;
    L30:
        if (this.f258262h == r101.f258262h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f258255a * 31) + this.f258256b) * 31) + this.f258257c) * 31) + this.f258258d) * 31) + this.f258259e) * 31) + this.f258260f) * 31) + this.f258261g) * 31) + this.f258262h;
    }

    public final String toString() {
        return "ListScrollMessage(dx=" + this.f258255a + ", dy=" + this.f258256b + ", totalScrollX=" + this.f258257c + ", totalScrollY=" + this.f258258d + ", fixedTotalScrollY=" + this.f258259e + ", firstItemPosition=" + this.f258260f + ", lastItemPosition=" + this.f258261g + ", totalNestedScrollY=" + this.f258262h + ')';
    }

    public u(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
        this.f258255a = r100;
        this.f258256b = r101;
        this.f258257c = r102;
        this.f258258d = r103;
        this.f258259e = r104;
        this.f258260f = r105;
        this.f258261g = r106;
        this.f258262h = r107;
    }
}
