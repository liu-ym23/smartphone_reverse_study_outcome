package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f571812c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (this.f571810a == r101.f571810a) goto L8;
        return false;
    L8:
        if (this.f571811b == r101.f571811b) goto L10;
        return false;
    L10:
        if (this.f571812c == r101.f571812c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = this.f571810a * 31;
        boolean r101 = this.f571811b;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f571812c;
        if (r105 == true) goto L10;
        r102 = r105;
    L10:
        return r104 + r102;
    }

    public final String toString() {
        return "AnchorLinkMicFinishEvent(scene=" + this.f571810a + ", isPkSwitchToLink=" + this.f571811b + ", isLinkSwitchToPk=" + this.f571812c + ")";
    }

    public d(int r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = false;
    L8:
        this.f571810a = r100;
        this.f571811b = r101;
        this.f571812c = r102;
    }
}
