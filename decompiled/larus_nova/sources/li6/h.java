package li6;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f509402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f509403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f509404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f509405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f509406e;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L16;
        h r101 = (h) r100;
        if (this.f509402a == r101.f509402a) goto L8;
        return false;
    L8:
        if (this.f509403b == r101.f509403b) goto L10;
        return false;
    L10:
        if (this.f509404c == r101.f509404c) goto L12;
        return false;
    L12:
        if (this.f509405d == r101.f509405d) goto L14;
        return false;
    L14:
        if (this.f509406e == r101.f509406e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return (((((((this.f509402a * 31) + this.f509403b) * 31) + this.f509404c) * 31) + this.f509405d) * 31) + this.f509406e;
    }

    public final String toString() {
        return "VideoParams(maxBitrateKbps=" + this.f509402a + ", minBitrateKbps=" + this.f509403b + ", fps=" + this.f509404c + ", height=" + this.f509405d + ", width=" + this.f509406e + ")";
    }

    public /* synthetic */ h(int r100) {
        this(0, 0, 0, 0, 0);
    }

    public h(int r100, int r101, int r102, int r103, int r104) {
        this.f509402a = r100;
        this.f509403b = r101;
        this.f509404c = r102;
        this.f509405d = r103;
        this.f509406e = r104;
    }
}
