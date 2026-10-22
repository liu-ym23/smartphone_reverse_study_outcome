package e73;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f471167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f471168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f471169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f471170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f471171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f471172f;

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L18;
        i r101 = (i) r100;
        if (this.f471167a == r101.f471167a) goto L8;
        return false;
    L8:
        if (this.f471168b == r101.f471168b) goto L10;
        return false;
    L10:
        if (this.f471169c == r101.f471169c) goto L12;
        return false;
    L12:
        if (this.f471170d == r101.f471170d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f471171e, r101.f471171e) == true) goto L16;
        return false;
    L16:
        if (this.f471172f == r101.f471172f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        long r100 = this.f471167a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f471168b;
        ?? r103 = 1;
        ?? r104 = r102;
        if (r102 == false) goto L5;
        r104 = 1;
    L5:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.f471169c;
        ?? r107 = r106;
        if (r106 == false) goto L8;
        r107 = 1;
    L8:
        int r108 = (r105 + r107) * 31;
        boolean r109 = this.f471170d;
        ?? r110 = r109;
        if (r109 == false) goto L11;
        r110 = 1;
    L11:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f471171e;
        if (r112 == null) goto L14;
        int r113 = r112.hashCode();
    L15:
        int r114 = (r111 + r113) * 31;
        boolean r115 = this.f471172f;
        if (r115 == true) goto L20;
        r103 = r115;
    L20:
        return r114 + r103;
    L14:
        r113 = 0;
        goto L15
    }

    public final String toString() {
        return "ResponseStatus(timestamp=" + this.f471167a + ", hitCache=" + this.f471168b + ", refresh=" + this.f471169c + ", chunk=" + this.f471170d + ", chunkRequestId=" + this.f471171e + ", traxex=" + this.f471172f + ")";
    }

    public i(int r100) {
        this.f471167a = 0;
        this.f471168b = false;
        this.f471169c = false;
        this.f471170d = false;
        this.f471171e = null;
        this.f471172f = false;
    }
}
