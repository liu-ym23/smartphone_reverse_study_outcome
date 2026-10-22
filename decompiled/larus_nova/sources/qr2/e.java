package qr2;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f534575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f534576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f534577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f534578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f534579e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L16;
        e r101 = (e) r100;
        if (this.f534575a == r101.f534575a) goto L8;
        return false;
    L8:
        if (this.f534576b == r101.f534576b) goto L10;
        return false;
    L10:
        if (this.f534577c == r101.f534577c) goto L12;
        return false;
    L12:
        if (this.f534578d == r101.f534578d) goto L14;
        return false;
    L14:
        if (this.f534579e == r101.f534579e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        boolean r100 = this.f534575a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        long r103 = this.f534576b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f534577c;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        boolean r107 = this.f534578d;
        if (r107 == true) goto L9;
        r101 = r107;
    L9:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f534579e;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    }

    public final String toString() {
        return "RevPkAudienceLogData(hasAudienceJoin4Pk=" + this.f534575a + ", hasAudienceOnlineTime4Pk=" + this.f534576b + ", hasAudienceOnlineTime=" + this.f534577c + ", hasAudienceJoin4Penalty=" + this.f534578d + ", hasAudienceOnlineTime4Penalty=" + this.f534579e + ")";
    }

    public e(boolean r100, long r101, long r102, boolean r103, long r104) {
        this.f534575a = r100;
        this.f534576b = r101;
        this.f534577c = r102;
        this.f534578d = r103;
        this.f534579e = r104;
    }
}
