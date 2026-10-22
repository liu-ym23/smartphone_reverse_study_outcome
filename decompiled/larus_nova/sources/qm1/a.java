package qm1;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f533837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f533838b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f533837a == r101.f533837a) goto L8;
        return false;
    L8:
        if (this.f533838b == r101.f533838b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        long r100 = this.f533837a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f533838b;
        ?? r103 = r102;
        if (r102 == false) goto L6;
        r103 = 1;
    L6:
        return r101 + r103;
    }

    public final String toString() {
        return "ReserveEvent(appointmentId=" + this.f533837a + ", isReserved=" + this.f533838b + ")";
    }

    public a(long r100, boolean r101) {
        this.f533837a = r100;
        this.f533838b = r101;
    }
}
