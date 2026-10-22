package gxb;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f483283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f483284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f483285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f483286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f483287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f483288f;

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
        if (this.f483283a == r101.f483283a) goto L12;
        return false;
    L12:
        if (this.f483284b == r101.f483284b) goto L15;
        return false;
    L15:
        if (this.f483285c == r101.f483285c) goto L18;
        return false;
    L18:
        if (this.f483286d == r101.f483286d) goto L21;
        return false;
    L21:
        if (this.f483287e == r101.f483287e) goto L24;
        return false;
    L24:
        if (this.f483288f == r101.f483288f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f483283a * 31) + this.f483284b) * 31) + this.f483285c) * 31) + this.f483286d) * 31) + this.f483287e) * 31;
        if (this.f483288f == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OverlayNativeViewParams(width=" + this.f483283a + ", height=" + this.f483284b + ", left=" + this.f483285c + ", top=" + this.f483286d + ", zIndex=" + this.f483287e + ", fixed=" + this.f483288f + ')';
    }

    public c(int r100, int r101, int r102, int r103, int r104, boolean r105) {
        this.f483283a = r100;
        this.f483284b = r101;
        this.f483285c = r102;
        this.f483286d = r103;
        this.f483287e = r104;
        this.f483288f = r105;
    }
}
