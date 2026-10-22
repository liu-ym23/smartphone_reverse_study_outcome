package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f571912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571913b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p3) == false) goto L10;
        p3 r101 = (p3) r100;
        if (this.f571912a == r101.f571912a) goto L8;
        return false;
    L8:
        if (this.f571913b == r101.f571913b) goto L16;
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
        boolean r100 = this.f571912a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f571913b;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public final String toString() {
        return "WaterMarkClearScreenEvent(clear=" + this.f571912a + ", isAlpha=" + this.f571913b + ")";
    }

    public p3(boolean r100) {
        this.f571912a = false;
        this.f571913b = r100;
    }
}
