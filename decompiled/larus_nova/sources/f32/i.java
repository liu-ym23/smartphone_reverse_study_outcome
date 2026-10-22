package f32;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f475375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f475376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f475377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f475378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f475379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f475380f;

    public i() {
        this(0, false, false, false, false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L18;
        i r101 = (i) r100;
        if (this.f475375a == r101.f475375a) goto L8;
        return false;
    L8:
        if (this.f475376b == r101.f475376b) goto L10;
        return false;
    L10:
        if (this.f475377c == r101.f475377c) goto L12;
        return false;
    L12:
        if (this.f475378d == r101.f475378d) goto L14;
        return false;
    L14:
        if (this.f475379e == r101.f475379e) goto L16;
        return false;
    L16:
        if (this.f475380f == r101.f475380f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        long r100 = this.f475375a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f475376b;
        ?? r103 = 1;
        ?? r104 = r102;
        if (r102 == false) goto L5;
        r104 = 1;
    L5:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.f475377c;
        ?? r107 = r106;
        if (r106 == false) goto L8;
        r107 = 1;
    L8:
        int r108 = (r105 + r107) * 31;
        boolean r109 = this.f475378d;
        ?? r110 = r109;
        if (r109 == false) goto L11;
        r110 = 1;
    L11:
        int r111 = (r108 + r110) * 31;
        boolean r112 = this.f475379e;
        ?? r113 = r112;
        if (r112 == false) goto L14;
        r113 = 1;
    L14:
        int r114 = (r111 + r113) * 31;
        boolean r115 = this.f475380f;
        if (r115 == true) goto L19;
        r103 = r115;
    L19:
        return r114 + r103;
    }

    public final String toString() {
        return "TapLikeFeatureConfig(tapAnimInterval=" + this.f475375a + ", cancelDiggCountAnim=" + this.f475376b + ", disableVibrationEffect=" + this.f475377c + ", disableIconScale=" + this.f475378d + ", disableIconRotate=" + this.f475379e + ", disableIconAlpha=" + this.f475380f + ")";
    }

    public /* synthetic */ i(long r100, boolean r110, boolean r111, boolean r112, boolean r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        long r101 = r100;
        if ((r114 & 2) == 0) goto L8;
        boolean r102 = false;
    L10:
        if ((r114 & 4) == 0) goto L12;
        boolean r103 = false;
    L14:
        if ((r114 & 16) == 0) goto L16;
        boolean r104 = false;
    L18:
        if ((r114 & 32) == 0) goto L20;
        boolean r105 = false;
    L21:
        this(r101, r102, r103, false, r104, r105);
        return;
    L20:
        r105 = r113;
        goto L21
    L16:
        r104 = r112;
        goto L18
    L12:
        r103 = r111;
        goto L14
    L8:
        r102 = r110;
        goto L10
    }

    public i(long r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        this.f475375a = r100;
        this.f475376b = r101;
        this.f475377c = r102;
        this.f475378d = r103;
        this.f475379e = r104;
        this.f475380f = r105;
    }
}
