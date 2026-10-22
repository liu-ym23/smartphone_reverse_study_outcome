package i40;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f488135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f488136b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (this.f488135a == r101.f488135a) goto L8;
        return false;
    L8:
        if (this.f488136b == r101.f488136b) goto L16;
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
        boolean r100 = this.f488135a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f488136b;
    }

    public final String toString() {
        return "KeyBoardResult(keyboardVisible=" + this.f488135a + ", keyboardHeight=" + this.f488136b + ")";
    }

    public d(boolean r100, int r101) {
        this.f488135a = r100;
        this.f488136b = r101;
    }
}
