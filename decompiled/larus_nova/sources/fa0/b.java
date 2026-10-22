package fa0;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f475997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f475998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f475999c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (this.f475997a == r101.f475997a) goto L8;
        return false;
    L8:
        if (this.f475998b == r101.f475998b) goto L10;
        return false;
    L10:
        if (this.f475999c == r101.f475999c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        boolean r100 = this.f475997a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f475998b;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return ((r103 + r101) * 31) + this.f475999c;
    }

    public final String toString() {
        return "GroupContainerState(isVisible=" + this.f475997a + ", isInRegionB=" + this.f475998b + ", width=" + this.f475999c + ")";
    }

    public b(boolean r100, boolean r101, int r102) {
        this.f475997a = r100;
        this.f475998b = r101;
        this.f475999c = r102;
    }
}
