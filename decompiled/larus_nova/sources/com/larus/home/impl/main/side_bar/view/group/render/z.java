package com.larus.home.impl.main.side_bar.view.group.render;

/* JADX INFO: loaded from: classes29.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f345736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f345737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f345738c;

    public static final class a {
    }

    static {
    }

    public z() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (this.f345736a == r101.f345736a) goto L12;
        return false;
    L12:
        if (this.f345737b == r101.f345737b) goto L15;
        return false;
    L15:
        if (this.f345738c == r101.f345738c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f345736a * 31) + this.f345737b) * 31) + this.f345738c;
    }

    public final String toString() {
        return "GroupPagingConfig(firstPageSize=" + this.f345736a + ", secondPageSize=" + this.f345737b + ", pageSize=" + this.f345738c + ')';
    }

    public /* synthetic */ z(int r100) {
        this(5, 10, 20);
    }

    public z(int r100, int r101, int r102) {
        this.f345736a = r100;
        this.f345737b = r101;
        this.f345738c = r102;
    }
}
