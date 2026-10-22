package k31;

/* JADX INFO: loaded from: classes47.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f501667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f501668b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L10;
        k r101 = (k) r100;
        if (this.f501667a == r101.f501667a) goto L8;
        return false;
    L8:
        if (this.f501668b == r101.f501668b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f501667a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f501668b;
    }

    public final String toString() {
        return "StatusBarOption(needMovePlayer4StatusBar=" + this.f501667a + ", distance=" + this.f501668b + ")";
    }

    public k(boolean r100, int r101) {
        this.f501667a = r100;
        this.f501668b = r101;
    }
}
