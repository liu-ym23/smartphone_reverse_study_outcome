package vr1;

/* JADX INFO: loaded from: classes8.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f556808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f556809b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e0) == false) goto L10;
        e0 r101 = (e0) r100;
        if (this.f556808a == r101.f556808a) goto L8;
        return false;
    L8:
        if (this.f556809b == r101.f556809b) goto L16;
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
        boolean r100 = this.f556808a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f556809b;
    }

    public final String toString() {
        return "ReplayKeyBoardResult(keyboardVisible=" + this.f556808a + ", keyboardHeight=" + this.f556809b + ")";
    }

    public e0(boolean r100, int r101) {
        this.f556808a = r100;
        this.f556809b = r101;
    }
}
