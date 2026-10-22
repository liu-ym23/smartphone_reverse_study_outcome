package w98;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f558759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f558760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f558761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f558762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f558763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f558764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f558765g;

    public b() {
        this(0, 0, 0, 0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f558759a == r101.f558759a) goto L12;
        return false;
    L12:
        if (this.f558760b == r101.f558760b) goto L15;
        return false;
    L15:
        if (this.f558761c == r101.f558761c) goto L18;
        return false;
    L18:
        if (this.f558762d == r101.f558762d) goto L21;
        return false;
    L21:
        if (this.f558763e == r101.f558763e) goto L24;
        return false;
    L24:
        if (this.f558764f == r101.f558764f) goto L27;
        return false;
    L27:
        if (this.f558765g == r101.f558765g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f558759a * 31) + this.f558760b) * 31) + this.f558761c) * 31) + this.f558762d) * 31) + this.f558763e) * 31) + this.f558764f) * 31) + this.f558765g;
    }

    public final String toString() {
        return "LiveAiMirrorData(bwdlConnectTime=" + this.f558759a + ", castConnectTime=" + this.f558760b + ", castInitTime=" + this.f558761c + ", castStartMirrorTime=" + this.f558762d + ", height=" + this.f558763e + ", mirrorFps=" + this.f558764f + ", width=" + this.f558765g + ')';
    }

    public b(int r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        this.f558759a = r100;
        this.f558760b = r101;
        this.f558761c = r102;
        this.f558762d = r103;
        this.f558763e = r104;
        this.f558764f = r105;
        this.f558765g = r106;
    }
}
