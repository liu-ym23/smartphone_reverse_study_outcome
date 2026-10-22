package f32;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f475359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f475360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f475361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f475362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f475363e;

    public b() {
        this(false, false, false, false, false, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (this.f475359a == r101.f475359a) goto L8;
        return false;
    L8:
        if (this.f475360b == r101.f475360b) goto L10;
        return false;
    L10:
        if (this.f475361c == r101.f475361c) goto L12;
        return false;
    L12:
        if (this.f475362d == r101.f475362d) goto L14;
        return false;
    L14:
        if (this.f475363e == r101.f475363e) goto L25;
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
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f475359a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f475360b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f475361c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f475362d;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f475363e;
        if (r113 == true) goto L19;
        r101 = r113;
    L19:
        return r112 + r101;
    }

    public final String toString() {
        return "EnterAnimFeatureConfig(disableEcomAnim=" + this.f475359a + ", disableHighLevelEnterAnim=" + this.f475360b + ", disableEffectMsgAnim=" + this.f475361c + ", canSelfSee=" + this.f475362d + ", disableGameAnim=" + this.f475363e + ")";
    }

    public b(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = false;
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = false;
    L17:
        this.f475359a = r100;
        this.f475360b = r101;
        this.f475361c = r102;
        this.f475362d = r103;
        this.f475363e = r104;
    }
}
