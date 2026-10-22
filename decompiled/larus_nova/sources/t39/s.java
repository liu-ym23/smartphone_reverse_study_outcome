package t39;

/* JADX INFO: loaded from: classes27.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f544480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f544481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f544482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f544483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f544484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f544485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f544486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f544487h;

    public s() {
        this(0, 0, 0, 0, 0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.f544480a == r101.f544480a) goto L12;
        return false;
    L12:
        if (this.f544481b == r101.f544481b) goto L15;
        return false;
    L15:
        if (this.f544482c == r101.f544482c) goto L18;
        return false;
    L18:
        if (this.f544483d == r101.f544483d) goto L21;
        return false;
    L21:
        if (this.f544484e == r101.f544484e) goto L24;
        return false;
    L24:
        if (this.f544485f == r101.f544485f) goto L27;
        return false;
    L27:
        if (this.f544486g == r101.f544486g) goto L30;
        return false;
    L30:
        if (this.f544487h == r101.f544487h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f544480a * 31) + this.f544481b) * 31) + this.f544482c) * 31) + this.f544483d) * 31) + this.f544484e) * 31) + this.f544485f) * 31) + this.f544486g) * 31) + this.f544487h;
    }

    public final String toString() {
        return "MirrorData(bwdlConnectTime=" + this.f544480a + ", castConnectTime=" + this.f544481b + ", castInitTime=" + this.f544482c + ", castStartMirrorTime=" + this.f544483d + ", height=" + this.f544484e + ", mirrorFps=" + this.f544485f + ", width=" + this.f544486g + ", transType=" + this.f544487h + ')';
    }

    public s(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
        this.f544480a = r100;
        this.f544481b = r101;
        this.f544482c = r102;
        this.f544483d = r103;
        this.f544484e = r104;
        this.f544485f = r105;
        this.f544486g = r106;
        this.f544487h = r107;
    }
}
