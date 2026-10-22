package vg3;

/* JADX INFO: loaded from: classes13.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f554684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f554685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f554686c;

    public k0() {
        boolean r100 = false;
        this(r100, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k0) == false) goto L12;
        k0 r101 = (k0) r100;
        if (this.f554684a == r101.f554684a) goto L8;
        return false;
    L8:
        if (this.f554685b == r101.f554685b) goto L10;
        return false;
    L10:
        if (this.f554686c == r101.f554686c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r100 = this.f554684a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f554685b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f554686c;
        if (r107 == true) goto L13;
        r101 = r107;
    L13:
        return r106 + r101;
    }

    public final String toString() {
        return "Options(fromUserClick=" + this.f554684a + ", fromSplit=" + this.f554685b + ", isClickBack=" + this.f554686c + ")";
    }

    public /* synthetic */ k0(boolean r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, false, r101);
    }

    public k0(boolean r100, boolean r101, boolean r102) {
        this.f554684a = r100;
        this.f554685b = r101;
        this.f554686c = r102;
    }
}
