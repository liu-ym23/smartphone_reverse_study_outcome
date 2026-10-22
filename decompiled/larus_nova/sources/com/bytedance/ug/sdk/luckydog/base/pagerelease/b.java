package com.bytedance.ug.sdk.luckydog.base.pagerelease;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f271795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f271796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f271797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f271798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f271799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f271800f;

    public static final class a {
    }

    static {
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L38:
        return true;
    L5:
        if ((r100 instanceof b) == false) goto L37;
        b r101 = (b) r100;
        if (this.f271795a != r101.f271795a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L37;
        if (this.f271796b != r101.f271796b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L37;
        if (this.f271797c != r101.f271797c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L37;
        if (this.f271798d != r101.f271798d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L37;
        if (this.f271799e != r101.f271799e) goto L29;
        boolean r106 = true;
    L30:
        if (r106 == false) goto L37;
        if (this.f271800f != r101.f271800f) goto L34;
        boolean r107 = true;
    L35:
        if (r107 == false) goto L37;
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
    L37:
        return false;
    }

    public final int hashCode() {
        return (((((((((this.f271795a * 31) + this.f271796b) * 31) + this.f271797c) * 31) + this.f271798d) * 31) + this.f271799e) * 31) + this.f271800f;
    }

    public final String toString() {
        return "CommonPageReleaseStrategy(javaReleaseStrategy=" + this.f271795a + ", javaMemoryUsage=" + this.f271796b + ", physicsReleaseStrategy=" + this.f271797c + ", physicsMemoryUsage=" + this.f271798d + ", virtualReleaseStrategy=" + this.f271799e + ", virtualMemoryUsage=" + this.f271800f + ")";
    }

    public /* synthetic */ b(int r100) {
        this(0, 0, 0, 0, 0, 0);
    }

    public b(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.f271795a = r100;
        this.f271796b = r101;
        this.f271797c = r102;
        this.f271798d = r103;
        this.f271799e = r104;
        this.f271800f = r105;
    }
}
