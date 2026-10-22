package com.bytedance.ug.sdk.luckydog.base.pagerelease;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f271804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f271805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f271806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f271807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f271808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f271809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f271810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f271811h;

    public f() {
        this(0, 0, 0, 0, 0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L48:
        return true;
    L5:
        if ((r100 instanceof f) == false) goto L47;
        f r101 = (f) r100;
        if (this.f271804a != r101.f271804a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L47;
        if (this.f271805b != r101.f271805b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L47;
        if (this.f271806c != r101.f271806c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L47;
        if (this.f271807d != r101.f271807d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L47;
        if (this.f271808e != r101.f271808e) goto L29;
        boolean r106 = true;
    L30:
        if (r106 == false) goto L47;
        if (this.f271809f != r101.f271809f) goto L34;
        boolean r107 = true;
    L35:
        if (r107 == false) goto L47;
        if (this.f271810g != r101.f271810g) goto L39;
        boolean r108 = true;
    L40:
        if (r108 == false) goto L47;
        if (this.f271811h != r101.f271811h) goto L44;
        boolean r109 = true;
    L45:
        if (r109 == false) goto L47;
    L44:
        r109 = false;
        goto L45
    L39:
        r108 = false;
        goto L40
    L34:
        r107 = false;
        goto L35
    L29:
        r106 = false;
        goto L30
    L24:
        r105 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L47:
        return false;
    }

    public final int hashCode() {
        return (((((((((((((this.f271804a * 31) + this.f271805b) * 31) + this.f271806c) * 31) + this.f271807d) * 31) + this.f271808e) * 31) + this.f271809f) * 31) + this.f271810g) * 31) + this.f271811h;
    }

    public final String toString() {
        return "PageHideStrategy(javaReleaseStrategy=" + this.f271804a + ", javaMemoryUsage=" + this.f271805b + ", physicsReleaseStrategy=" + this.f271806c + ", physicsMemoryUsage=" + this.f271807d + ", virtualReleaseStrategy=" + this.f271808e + ", virtualMemoryUsage=" + this.f271809f + ", delay=" + this.f271810g + ", otherPageAppearEnable=" + this.f271811h + ")";
    }

    public f(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
        this.f271804a = r100;
        this.f271805b = r101;
        this.f271806c = r102;
        this.f271807d = r103;
        this.f271808e = r104;
        this.f271809f = r105;
        this.f271810g = r106;
        this.f271811h = r107;
    }
}
