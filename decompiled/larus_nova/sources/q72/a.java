package q72;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f531916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f531917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f531918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f531919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f531920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f531921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f531922g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (this.f531917b == r101.f531917b) goto L8;
        return false;
    L8:
        if (this.f531918c == r101.f531918c) goto L10;
        return false;
    L10:
        if (this.f531919d == r101.f531919d) goto L12;
        return false;
    L12:
        if (this.f531920e == r101.f531920e) goto L14;
        return false;
    L14:
        if (this.f531921f == r101.f531921f) goto L16;
        return false;
    L16:
        if (this.f531922g == r101.f531922g) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        int r100 = ((((((((this.f531917b * 31) + this.f531918c) * 31) + this.f531919d) * 31) + this.f531920e) * 31) + this.f531921f) * 31;
        boolean r101 = this.f531922g;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "CarnivalDanmakuConfig(displayWidth=" + this.f531917b + ", displayHeight=" + this.f531918c + ", lineHeight=" + this.f531919d + ", lineSpacing=" + this.f531920e + ", duration=" + this.f531921f + ", left2right=" + this.f531922g + ")";
    }

    public a(int r100, int r101, int r102, int r103, int r104, boolean r105) {
        this.f531917b = r100;
        this.f531918c = r101;
        this.f531919d = r102;
        this.f531920e = r103;
        this.f531921f = r104;
        this.f531922g = r105;
        this.f531916a = r101 / (r102 + r103);
    }
}
