package h24;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f483587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f483588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f483589c;

    public a() {
        this(true, 86400000, com.heytap.mcssdk.constant.a.f276320g);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f483587a == r101.f483587a) goto L12;
        return false;
    L12:
        if (this.f483588b == r101.f483588b) goto L15;
        return false;
    L15:
        if (this.f483589c == r101.f483589c) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.f483587a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.f483588b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f483589c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "AosPreloadDataConfig(isEnablePreload=" + this.f483587a + ", cacheAvailableTimeSpan=" + this.f483588b + ", cacheRefreshTimeSpan=" + this.f483589c + ')';
    }

    public a(boolean r100, long r101, long r102) {
        this.f483587a = r100;
        this.f483588b = r101;
        this.f483589c = r102;
    }
}
