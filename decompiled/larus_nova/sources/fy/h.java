package fy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f479208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f479209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f479210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f479211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f479212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f479213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f479214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f479215h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L22;
        h r101 = (h) r100;
        if (this.f479208a == r101.f479208a) goto L8;
        return false;
    L8:
        if (this.f479209b == r101.f479209b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f479210c, r101.f479210c) == true) goto L12;
        return false;
    L12:
        if (this.f479211d == r101.f479211d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f479212e, r101.f479212e) == true) goto L16;
        return false;
    L16:
        if (this.f479213f == r101.f479213f) goto L18;
        return false;
    L18:
        if (this.f479214g == r101.f479214g) goto L20;
        return false;
    L20:
        if (this.f479215h == r101.f479215h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final int hashCode() {
        long r100 = this.f479208a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f479209b) * 31;
        String r102 = this.f479210c;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.f479211d;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L9;
        r108 = 1;
    L9:
        int r109 = (r105 + r108) * 31;
        String r110 = this.f479212e;
        if (r110 == null) goto L12;
        r103 = r110.hashCode();
    L12:
        int r111 = (((r109 + r103) * 31) + this.f479213f) * 31;
        long r112 = this.f479214g;
        int r113 = (r111 + ((int) ((r112 >>> 32) ^ r112))) * 31;
        boolean r114 = this.f479215h;
        if (r114 == true) goto L17;
        r107 = r114;
    L17:
        return r113 + r107;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "LeaveParams(channelId=" + this.f479208a + ", scene=" + this.f479209b + ", reqSrc=" + this.f479210c + ", clearAfterSuccess=" + this.f479211d + ", isManager=" + this.f479212e + ", leaveSource=" + this.f479213f + ", startTs=" + this.f479214g + ", requestFailed=" + this.f479215h + ")";
    }

    public h(long r100, int r101, String r102, boolean r103, String r110, int r111, int r112) {
        if ((r112 & 8) == 0) goto L6;
        r103 = false;
    L6:
        if ((r112 & 16) == 0) goto L9;
        r110 = "0";
    L9:
        if ((r112 & 32) == 0) goto L12;
        r111 = com.bytedance.android.live.revenuelink.connect.h.a(r102);
    L12:
        if ((r112 & 64) == 0) goto L14;
        i97.a r113 = i97.a.f488802a;
        long r104 = System.currentTimeMillis();
    L15:
        Intrinsics.checkNotNullParameter(r102, "reqSrc");
        Intrinsics.checkNotNullParameter(r110, "isManager");
        this.f479208a = r100;
        this.f479209b = r101;
        this.f479210c = r102;
        this.f479211d = r103;
        this.f479212e = r110;
        this.f479213f = r111;
        this.f479214g = r104;
        this.f479215h = false;
        return;
    L14:
        r104 = 0;
        goto L15
    }
}
