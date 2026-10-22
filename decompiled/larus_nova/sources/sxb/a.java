package sxb;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f543852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f543853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f543854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f543855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f543856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f543857f;

    /* JADX INFO: renamed from: sxb.a$a, reason: collision with other inner class name */
    public static final class C7669a {
    }

    static {
    }

    public a() {
        this(0, 0, 0, 0, 0, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f543852a == r101.f543852a) goto L12;
        return false;
    L12:
        if (this.f543853b == r101.f543853b) goto L15;
        return false;
    L15:
        if (this.f543854c == r101.f543854c) goto L18;
        return false;
    L18:
        if (this.f543855d == r101.f543855d) goto L21;
        return false;
    L21:
        if (this.f543856e == r101.f543856e) goto L24;
        return false;
    L24:
        if (this.f543857f == r101.f543857f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f543852a * 31) + this.f543853b) * 31) + this.f543854c) * 31) + this.f543855d) * 31) + this.f543856e) * 31;
        if (this.f543857f == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OverlayNativeViewParams(width=" + this.f543852a + ", height=" + this.f543853b + ", left=" + this.f543854c + ", top=" + this.f543855d + ", zIndex=" + this.f543856e + ", fixed=" + this.f543857f + ')';
    }

    public a(int r100, int r101, int r102, int r103, int r104, boolean r105) {
        this.f543852a = r100;
        this.f543853b = r101;
        this.f543854c = r102;
        this.f543855d = r103;
        this.f543856e = r104;
        this.f543857f = r105;
    }
}
