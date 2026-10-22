package qr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f534545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f534546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f534547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f534548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f534549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f534550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f534551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f534552h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L22;
        a r101 = (a) r100;
        if (this.f534545a == r101.f534545a) goto L8;
        return false;
    L8:
        if (this.f534546b == r101.f534546b) goto L10;
        return false;
    L10:
        if (this.f534547c == r101.f534547c) goto L12;
        return false;
    L12:
        if (this.f534548d == r101.f534548d) goto L14;
        return false;
    L14:
        if (this.f534549e == r101.f534549e) goto L16;
        return false;
    L16:
        if (this.f534550f == r101.f534550f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f534551g, r101.f534551g) == true) goto L20;
        return false;
    L20:
        if (this.f534552h == r101.f534552h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        boolean r100 = this.f534545a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f534546b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (((r103 + r105) * 31) + this.f534547c) * 31;
        boolean r107 = this.f534548d;
        if (r107 == true) goto L12;
        r101 = r107;
    L12:
        int r108 = (((((r106 + r101) * 31) + this.f534549e) * 31) + this.f534550f) * 31;
        String r109 = this.f534551g;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 31;
        long r112 = this.f534552h;
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    L15:
        r110 = 0;
        goto L16
    }

    public final String toString() {
        return "AudiencePlayInfo(isSelfGuest=" + this.f534545a + ", isNotSelfGuest=" + this.f534546b + ", pos=" + this.f534547c + ", isBackground=" + this.f534548d + ", linkType=" + this.f534549e + ", silenceStatus=" + this.f534550f + ", interactId=" + this.f534551g + ", linkRoomID=" + this.f534552h + ")";
    }

    public a(boolean r100, boolean r101, int r102, boolean r103, int r104, int r105, String r106, long r107) {
        Intrinsics.checkNotNullParameter(r106, "interactId");
        this.f534545a = r100;
        this.f534546b = r101;
        this.f534547c = r102;
        this.f534548d = r103;
        this.f534549e = r104;
        this.f534550f = r105;
        this.f534551g = r106;
        this.f534552h = r107;
    }
}
