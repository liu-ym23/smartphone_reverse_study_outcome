package com.github.alexzhirkevich.customqrgenerator.style;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f274257i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f274258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f274259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f274260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f274261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f274262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f274263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f274264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f274265h;

    public static final class a {
    }

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f274258a == r101.f274258a) goto L12;
        return false;
    L12:
        if (this.f274259b == r101.f274259b) goto L15;
        return false;
    L15:
        if (this.f274260c == r101.f274260c) goto L18;
        return false;
    L18:
        if (this.f274261d == r101.f274261d) goto L21;
        return false;
    L21:
        if (this.f274262e == r101.f274262e) goto L24;
        return false;
    L24:
        if (this.f274263f == r101.f274263f) goto L27;
        return false;
    L27:
        if (this.f274264g == r101.f274264g) goto L30;
        return false;
    L30:
        if (this.f274265h == r101.f274265h) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public final int hashCode() {
        boolean r100 = this.f274258a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f274259b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f274260c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f274261d;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f274262e;
        ?? r114 = r113;
        if (r113 == false) goto L17;
        r114 = 1;
    L17:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f274263f;
        ?? r117 = r116;
        if (r116 == false) goto L20;
        r117 = 1;
    L20:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f274264g;
        ?? r120 = r119;
        if (r119 == false) goto L23;
        r120 = 1;
    L23:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.f274265h;
        if (r122 == true) goto L28;
        r101 = r122;
    L28:
        return r121 + r101;
    }

    public final String toString() {
        return "Neighbors(topLeft=" + this.f274258a + ", topRight=" + this.f274259b + ", left=" + this.f274260c + ", top=" + this.f274261d + ", right=" + this.f274262e + ", bottomLeft=" + this.f274263f + ", bottom=" + this.f274264g + ", bottomRight=" + this.f274265h + ')';
    }

    static {
        f274257i = new c(0);
    }

    public /* synthetic */ c(int r110) {
        this(false, false, false, false, false, false, false, false);
    }

    public c(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        this.f274258a = r100;
        this.f274259b = r101;
        this.f274260c = r102;
        this.f274261d = r103;
        this.f274262e = r104;
        this.f274263f = r105;
        this.f274264g = r106;
        this.f274265h = r107;
    }
}
