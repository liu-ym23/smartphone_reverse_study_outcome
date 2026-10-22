package hg6;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f485014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f485015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f485016c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (this.f485014a == r101.f485014a) goto L8;
        return false;
    L8:
        if (this.f485015b == r101.f485015b) goto L10;
        return false;
    L10:
        if (this.f485016c == r101.f485016c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = this.f485014a * 31;
        boolean r101 = this.f485015b;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f485016c;
        if (r105 == true) goto L10;
        r102 = r105;
    L10:
        return r104 + r102;
    }

    public final String toString() {
        return "AudioSelectParams(currentScene=" + this.f485014a + ", isMultiChorusOpen=" + this.f485015b + ", isInRealTimeChorus=" + this.f485016c + ")";
    }

    public b(int r100, boolean r101, boolean r102) {
        this.f485014a = r100;
        this.f485015b = r101;
        this.f485016c = r102;
    }
}
