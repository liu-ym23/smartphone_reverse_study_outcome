package f32;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f475365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f475366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f475367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f475368d;

    public d() {
        this(false, false, 0, false, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (this.f475365a == r101.f475365a) goto L8;
        return false;
    L8:
        if (this.f475366b == r101.f475366b) goto L10;
        return false;
    L10:
        if (this.f475367c == r101.f475367c) goto L12;
        return false;
    L12:
        if (this.f475368d == r101.f475368d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        boolean r100 = this.f475365a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f475366b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f475367c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        boolean r109 = this.f475368d;
        if (r109 == true) goto L13;
        r101 = r109;
    L13:
        return r108 + r101;
    }

    public final String toString() {
        return "FlowLikeFeatureConfig(cancelFlow=" + this.f475365a + ", disableShowAvatar=" + this.f475366b + ", othersDiggFrq=" + this.f475367c + ", disableOthersDiggFlow=" + this.f475368d + ")";
    }

    public d(boolean r100, boolean r101, long r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 200;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this.f475365a = r100;
        this.f475366b = r101;
        this.f475367c = r102;
        this.f475368d = r103;
    }
}
