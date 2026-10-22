package t98;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f545114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f545115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f545116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f545117d;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f545114a == r101.f545114a) goto L12;
        return false;
    L12:
        if (this.f545115b == r101.f545115b) goto L15;
        return false;
    L15:
        if (this.f545116c == r101.f545116c) goto L18;
        return false;
    L18:
        if (this.f545117d == r101.f545117d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f545114a * 31) + this.f545115b) * 31) + this.f545116c) * 31) + this.f545117d;
    }

    public final String toString() {
        return "AlbumPowerPolicyConfig(normalVideoThreadCount=" + this.f545114a + ", balancedVideoThreadCount=" + this.f545115b + ", constrainedVideoThreadCount=" + this.f545116c + ", minimumVideoThreadCount=" + this.f545117d + ')';
    }

    public d(int r100) {
        this.f545114a = 8;
        this.f545115b = 6;
        this.f545116c = 4;
        this.f545117d = 2;
    }
}
