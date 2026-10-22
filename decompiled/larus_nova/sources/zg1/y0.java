package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f572015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f572016b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y0) == false) goto L10;
        y0 r101 = (y0) r100;
        if (this.f572015a == r101.f572015a) goto L8;
        return false;
    L8:
        if (this.f572016b == r101.f572016b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f572015a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f572016b;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public final String toString() {
        return "LandscapeSpiltAreaShowEvent(show=" + this.f572015a + ", withAnim=" + this.f572016b + ")";
    }

    public y0(boolean r100, boolean r101) {
        this.f572015a = r100;
        this.f572016b = r101;
    }
}
