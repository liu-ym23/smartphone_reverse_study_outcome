package vf6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f554592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f554593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f554594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f554595d;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.f554592a == r101.f554592a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f554593b, r101.f554593b) == true) goto L10;
        return false;
    L10:
        if (this.f554594c == r101.f554594c) goto L12;
        return false;
    L12:
        if (this.f554595d == r101.f554595d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f554592a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f554593b;
        if (r104 == null) goto L8;
        int r105 = r104.hashCode();
    L9:
        int r106 = (((r103 + r105) * 31) + this.f554594c) * 31;
        boolean r107 = this.f554595d;
        if (r107 == true) goto L14;
        r101 = r107;
    L14:
        return r106 + r101;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "GuestBizLinkLogParams(isAutoJoin=" + this.f554592a + ", fromUserId=" + this.f554593b + ", disconnectSource=" + this.f554594c + ", disconnectBySelf=" + this.f554595d + ")";
    }

    public a(int r100) {
        Intrinsics.checkNotNullParameter("", "fromUserId");
        this.f554592a = false;
        this.f554593b = "";
        this.f554594c = 200;
        this.f554595d = false;
    }
}
