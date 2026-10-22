package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f572011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f572012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f572013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f572014d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L14;
        y r101 = (y) r100;
        if (this.f572011a == r101.f572011a) goto L8;
        return false;
    L8:
        if (this.f572012b == r101.f572012b) goto L10;
        return false;
    L10:
        if (this.f572013c == r101.f572013c) goto L12;
        return false;
    L12:
        if (this.f572014d == r101.f572014d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.f572011a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (((((r101 * 31) + this.f572012b) * 31) + this.f572013c) * 31) + this.f572014d;
    }

    public final String toString() {
        return "DrawActionReportEvent(isDispatch=" + this.f572011a + ", drawAction=" + this.f572012b + ", clickPosition=" + this.f572013c + ", curIndex=" + this.f572014d + ")";
    }

    public y(boolean r100, int r101, int r102, int r103) {
        this.f572011a = r100;
        this.f572012b = r101;
        this.f572013c = r102;
        this.f572014d = r103;
    }
}
