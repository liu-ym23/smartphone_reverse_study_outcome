package z82;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f570909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f570910b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (this.f570909a == r101.f570909a) goto L8;
        return false;
    L8:
        if (this.f570910b == r101.f570910b) goto L16;
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
        boolean r100 = this.f570909a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f570910b;
    }

    public final String toString() {
        return "needMovePlayer4StatusBar = " + this.f570909a + ", distance = " + this.f570910b;
    }

    public g(boolean r100, int r101) {
        this.f570909a = r100;
        this.f570910b = r101;
    }
}
