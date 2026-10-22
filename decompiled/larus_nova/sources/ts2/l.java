package ts2;

/* JADX INFO: loaded from: classes11.dex */
public final class l extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f547353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f547354b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L10;
        l r101 = (l) r100;
        if (this.f547353a == r101.f547353a) goto L8;
        return false;
    L8:
        if (this.f547354b == r101.f547354b) goto L16;
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
        boolean r100 = this.f547353a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f547354b;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public final String toString() {
        return "OnPictureInPictureModeChangedData(isInPictureInPictureMode=" + this.f547353a + ", mUserVisibleHint=" + this.f547354b + ")";
    }

    public l(boolean r100, boolean r101) {
        this.f547353a = r100;
        this.f547354b = r101;
    }
}
