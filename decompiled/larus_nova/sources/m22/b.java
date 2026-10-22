package m22;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f511652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f511653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f511654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f511655d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (this.f511652a == r101.f511652a) goto L8;
        return false;
    L8:
        if (this.f511653b == r101.f511653b) goto L10;
        return false;
    L10:
        if (this.f511654c == r101.f511654c) goto L12;
        return false;
    L12:
        if (this.f511655d == r101.f511655d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        boolean r100 = this.f511652a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f511653b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f511654c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f511655d;
        if (r110 == true) goto L16;
        r101 = r110;
    L16:
        return r109 + r101;
    }

    public final String toString() {
        return "AnchorAsrSwitch(enable=" + this.f511652a + ", enableWelcome=" + this.f511653b + ", enableThanks=" + this.f511654c + ", enableCongrats=" + this.f511655d + ")";
    }

    public b(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f511652a = r100;
        this.f511653b = r101;
        this.f511654c = r102;
        this.f511655d = r103;
    }
}
