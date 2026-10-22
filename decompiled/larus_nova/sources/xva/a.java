package xva;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f565189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f565190b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L18:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L17;
        a r101 = (a) r100;
        if (this.f565189a != r101.f565189a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L17;
        if (this.f565190b != r101.f565190b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L17:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        long r100 = this.f565189a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f565190b;
        ?? r103 = r102;
        if (r102 == false) goto L6;
        r103 = 1;
    L6:
        return r101 + r103;
    }

    public final String toString() {
        return "Configuration(startupTimestamp=" + this.f565189a + ", needReportToTea=" + this.f565190b + ")";
    }

    public a() {
        this.f565189a = 0;
        this.f565190b = true;
    }
}
