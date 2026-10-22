package ok1;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f523618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f523619b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.f523618a == r101.f523618a) goto L8;
        return false;
    L8:
        if (this.f523619b == r101.f523619b) goto L16;
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
        int r100 = this.f523618a * 31;
        boolean r101 = this.f523619b;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "MatchMessageTrayUpdateData(trayHeight=" + this.f523618a + ", visible=" + this.f523619b + ")";
    }

    public b(int r100, boolean r101) {
        this.f523618a = r100;
        this.f523619b = r101;
    }
}
