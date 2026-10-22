package r54;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f536300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f536301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f536302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f536303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f536304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f536305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f536306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f536307h;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f536300a == r101.f536300a) goto L12;
        return false;
    L12:
        if (this.f536301b == r101.f536301b) goto L15;
        return false;
    L15:
        if (this.f536302c == r101.f536302c) goto L18;
        return false;
    L18:
        if (this.f536303d == r101.f536303d) goto L21;
        return false;
    L21:
        if (this.f536304e == r101.f536304e) goto L24;
        return false;
    L24:
        if (this.f536305f == r101.f536305f) goto L27;
        return false;
    L27:
        if (this.f536306g == r101.f536306g) goto L30;
        return false;
    L30:
        if (this.f536307h == r101.f536307h) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public final int hashCode() {
        boolean r100 = this.f536300a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        long r103 = this.f536301b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f536302c;
        int r106 = (((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.f536303d) * 31;
        boolean r107 = this.f536304e;
        ?? r108 = r107;
        if (r107 == false) goto L8;
        r108 = 1;
    L8:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f536305f;
        ?? r111 = r110;
        if (r110 == false) goto L11;
        r111 = 1;
    L11:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f536306g;
        if (r113 == true) goto L16;
        r101 = r113;
    L16:
        return ((r112 + r101) * 31) + this.f536307h;
    }

    public final String toString() {
        return "AosExportFeedListPreloadConfig(isEnablePreload=" + this.f536300a + ", cacheAvailableTimeSpan=" + this.f536301b + ", cacheRefreshTimeSpan=" + this.f536302c + ", requestPreloadCount=" + this.f536303d + ", waitFeedPreloadResult=" + this.f536304e + ", recycleFeedData=" + this.f536305f + ", preloadFeedOnUserChanged=" + this.f536306g + ", autoLoadMoreLessThenBottomCount=" + this.f536307h + ')';
    }

    public a(int r100) {
        this.f536300a = true;
        this.f536301b = 3000000;
        this.f536302c = 1200000;
        this.f536303d = 2;
        this.f536304e = false;
        this.f536305f = false;
        this.f536306g = false;
        this.f536307h = 6;
    }
}
