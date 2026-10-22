package hq2;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f486497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486498b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f486497a == r101.f486497a) goto L8;
        return false;
    L8:
        if (this.f486498b == r101.f486498b) goto L16;
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
        int r100 = this.f486497a * 31;
        boolean r101 = this.f486498b;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "RevMatchMessageTrayUpdateData(trayHeight=" + this.f486497a + ", visible=" + this.f486498b + ")";
    }

    public c(int r100, boolean r101) {
        this.f486497a = r100;
        this.f486498b = r101;
    }
}
