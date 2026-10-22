package k31;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f501655g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f501656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f501657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f501658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f501659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f501660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f501661f;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L18;
        i r101 = (i) r100;
        if (this.f501656a == r101.f501656a) goto L8;
        return false;
    L8:
        if (this.f501657b == r101.f501657b) goto L10;
        return false;
    L10:
        if (this.f501658c == r101.f501658c) goto L12;
        return false;
    L12:
        if (this.f501659d == r101.f501659d) goto L14;
        return false;
    L14:
        if (this.f501660e == r101.f501660e) goto L16;
        return false;
    L16:
        if (this.f501661f == r101.f501661f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        return (((((((((this.f501656a * 31) + this.f501657b) * 31) + this.f501658c) * 31) + this.f501659d) * 31) + this.f501660e) * 31) + this.f501661f;
    }

    public final String toString() {
        return "PlayerLayoutDescriptor(playerWidth=" + this.f501656a + ", playerHeight=" + this.f501657b + ", coreLeftMargin=" + this.f501658c + ", coreTopMargin=" + this.f501659d + ", coreWidth=" + this.f501660e + ", coreHeight=" + this.f501661f + ")";
    }

    static {
        f501655g = new a();
    }

    public i(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.f501656a = r100;
        this.f501657b = r101;
        this.f501658c = r102;
        this.f501659d = r103;
        this.f501660e = r104;
        this.f501661f = r105;
    }
}
