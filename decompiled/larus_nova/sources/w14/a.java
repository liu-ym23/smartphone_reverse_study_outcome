package w14;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f557903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f557904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f557905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f557906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f557907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f557908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f557909g;

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
        if (this.f557903a == r101.f557903a) goto L12;
        return false;
    L12:
        if (this.f557904b == r101.f557904b) goto L15;
        return false;
    L15:
        if (this.f557905c == r101.f557905c) goto L18;
        return false;
    L18:
        if (this.f557906d == r101.f557906d) goto L21;
        return false;
    L21:
        if (this.f557907e == r101.f557907e) goto L24;
        return false;
    L24:
        if (this.f557908f == r101.f557908f) goto L27;
        return false;
    L27:
        if (this.f557909g == r101.f557909g) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public final int hashCode() {
        boolean r100 = this.f557903a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        long r103 = this.f557904b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f557905c;
        int r106 = (((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.f557906d) * 31;
        boolean r107 = this.f557907e;
        ?? r108 = r107;
        if (r107 == false) goto L8;
        r108 = 1;
    L8:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f557908f;
        ?? r111 = r110;
        if (r110 == false) goto L11;
        r111 = 1;
    L11:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f557909g;
        if (r113 == true) goto L16;
        r101 = r113;
    L16:
        return r112 + r101;
    }

    public final String toString() {
        return "AosFeedListPreloadConfig(isEnablePreload=" + this.f557903a + ", cacheAvailableTimeSpan=" + this.f557904b + ", cacheRefreshTimeSpan=" + this.f557905c + ", requestPreloadCount=" + this.f557906d + ", waitFeedPreloadResult=" + this.f557907e + ", recycleFeedData=" + this.f557908f + ", preloadFeedOnUserChanged=" + this.f557909g + ')';
    }

    public /* synthetic */ a(int r110) {
        this(true, 3000000, 1200000, 2, false, false, false);
    }

    public a(boolean r100, long r101, long r102, int r103, boolean r104, boolean r105, boolean r106) {
        this.f557903a = r100;
        this.f557904b = r101;
        this.f557905c = r102;
        this.f557906d = r103;
        this.f557907e = r104;
        this.f557908f = r105;
        this.f557909g = r106;
    }
}
