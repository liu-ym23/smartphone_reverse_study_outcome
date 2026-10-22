package jt5;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f500307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f500308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f500309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f500310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f500311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f500312f;

    public static final class a {
    }

    static {
    }

    public c() {
        this(0, 0, 0, 0, 0, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f500307a == r101.f500307a) goto L12;
        return false;
    L12:
        if (this.f500308b == r101.f500308b) goto L15;
        return false;
    L15:
        if (this.f500309c == r101.f500309c) goto L18;
        return false;
    L18:
        if (this.f500310d == r101.f500310d) goto L21;
        return false;
    L21:
        if (this.f500311e == r101.f500311e) goto L24;
        return false;
    L24:
        if (this.f500312f == r101.f500312f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f500307a * 31) + this.f500308b) * 31) + this.f500309c) * 31) + this.f500310d) * 31) + this.f500311e) * 31;
        if (this.f500312f == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OverlayNativeViewParams(width=" + this.f500307a + ", height=" + this.f500308b + ", left=" + this.f500309c + ", top=" + this.f500310d + ", zIndex=" + this.f500311e + ", fixed=" + this.f500312f + ')';
    }

    public c(int r100, int r101, int r102, int r103, int r104, boolean r105) {
        this.f500307a = r100;
        this.f500308b = r101;
        this.f500309c = r102;
        this.f500310d = r103;
        this.f500311e = r104;
        this.f500312f = r105;
    }
}
