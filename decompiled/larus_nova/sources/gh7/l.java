package gh7;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements dh7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f481299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f481300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f481301c;

    public l() {
        this(false, false, 0, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L12;
        l r101 = (l) r100;
        if (this.f481299a == r101.f481299a) goto L8;
        return false;
    L8:
        if (this.f481300b == r101.f481300b) goto L10;
        return false;
    L10:
        if (this.f481301c == r101.f481301c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        boolean r100 = this.f481299a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f481300b;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return ((r103 + r101) * 31) + this.f481301c;
    }

    public final String toString() {
        return "ShieldInfo(filtered=" + this.f481299a + ", interceptStrategy=" + this.f481300b + ", shieldCount=" + this.f481301c + ")";
    }

    public l(boolean r100, boolean r101, int r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this.f481299a = r100;
        this.f481300b = r101;
        this.f481301c = r102;
    }
}
