package oq2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f524843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f524844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f524845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f524846d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f524843a, r101.f524843a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f524844b, r101.f524844b) == true) goto L10;
        return false;
    L10:
        if (this.f524845c == r101.f524845c) goto L12;
        return false;
    L12:
        if (this.f524846d == r101.f524846d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        String r100 = this.f524843a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f524844b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f524845c;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f524846d;
        if (r110 == true) goto L17;
        r107 = r110;
    L17:
        return r109 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RevCustomPkBg(topBgUrl=" + this.f524843a + ", bottomBgUrl=" + this.f524844b + ", isTopAnim=" + this.f524845c + ", isBottomAnim=" + this.f524846d + ")";
    }

    public b(String r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "topBgUrl");
        Intrinsics.checkNotNullParameter(r101, "bottomBgUrl");
        this.f524843a = r100;
        this.f524844b = r101;
        this.f524845c = r102;
        this.f524846d = r103;
    }
}
