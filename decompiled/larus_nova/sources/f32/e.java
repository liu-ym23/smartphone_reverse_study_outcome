package f32;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f475369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f475370b;

    public e() {
        this(false, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (this.f475369a == r101.f475369a) goto L8;
        return false;
    L8:
        if (this.f475370b == r101.f475370b) goto L16;
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
        boolean r100 = this.f475369a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f475370b;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public final String toString() {
        return "HotCommentFeatureConfig(enable=" + this.f475369a + ", numberNotScale=" + this.f475370b + ")";
    }

    public e(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r101 & 2) == 0) goto L9;
        r100 = false;
    L9:
        this.f475369a = r102;
        this.f475370b = r100;
        return;
    L5:
        r102 = false;
        goto L7
    }
}
