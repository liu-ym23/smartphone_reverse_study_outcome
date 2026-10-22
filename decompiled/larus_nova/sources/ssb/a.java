package ssb;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f543495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f543496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f543497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f543498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f543499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f543500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f543501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f543502h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f543495a == r101.f543495a) goto L12;
        return false;
    L12:
        if (this.f543496b == r101.f543496b) goto L15;
        return false;
    L15:
        if (this.f543497c == r101.f543497c) goto L18;
        return false;
    L18:
        if (this.f543498d == r101.f543498d) goto L21;
        return false;
    L21:
        if (this.f543499e == r101.f543499e) goto L24;
        return false;
    L24:
        if (this.f543500f == r101.f543500f) goto L27;
        return false;
    L27:
        if (this.f543501g == r101.f543501g) goto L30;
        return false;
    L30:
        if (this.f543502h == r101.f543502h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f543495a * 31) + this.f543496b) * 31) + this.f543497c) * 31) + this.f543498d) * 31) + this.f543499e) * 31) + this.f543500f) * 31) + this.f543501g) * 31) + this.f543502h;
    }

    public final String toString() {
        return "CreateItemParams(cw=" + this.f543495a + ", ch=" + this.f543496b + ", cm=" + this.f543497c + ", eh=" + this.f543498d + ", rw=" + this.f543499e + ", rvStartPadding=" + this.f543500f + ", rvEndPadding=" + this.f543501g + ", mc=" + this.f543502h + ')';
    }

    public a(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
        this.f543495a = r100;
        this.f543496b = r101;
        this.f543497c = r102;
        this.f543498d = r103;
        this.f543499e = r104;
        this.f543500f = r105;
        this.f543501g = r106;
        this.f543502h = r107;
    }
}
