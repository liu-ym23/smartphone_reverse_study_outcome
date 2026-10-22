package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571825b;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (this.f571824a == r101.f571824a) goto L8;
        return false;
    L8:
        if (this.f571825b == r101.f571825b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        int r100 = this.f571824a * 31;
        boolean r101 = this.f571825b;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "AnchorWidgetTranslationEvent(leftSpace=" + this.f571824a + ", isExtend=" + this.f571825b + ")";
    }

    public f(int r100) {
        this.f571824a = 0;
        this.f571825b = false;
    }
}
