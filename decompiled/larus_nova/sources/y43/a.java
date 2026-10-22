package y43;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f565988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f565989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f565990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f565991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f565992e;

    public a() {
        this(false, false, false, false, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (this.f565988a == r101.f565988a) goto L8;
        return false;
    L8:
        if (this.f565989b == r101.f565989b) goto L10;
        return false;
    L10:
        if (this.f565990c == r101.f565990c) goto L12;
        return false;
    L12:
        if (this.f565991d == r101.f565991d) goto L14;
        return false;
    L14:
        if (this.f565992e == r101.f565992e) goto L25;
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
        boolean r100 = this.f565988a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f565989b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f565990c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f565991d;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f565992e;
        if (r113 == true) goto L19;
        r101 = r113;
    L19:
        return r112 + r101;
    }

    public final String toString() {
        return "LoadingViewModel(loading=" + this.f565988a + ", skeleton=" + this.f565989b + ", doubleBall=" + this.f565990c + ", touchDisable=" + this.f565991d + ", floatCover=" + this.f565992e + ")";
    }

    public a(boolean r100, boolean r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this.f565988a = r100;
        this.f565989b = r101;
        this.f565990c = r102;
        this.f565991d = r103;
        this.f565992e = false;
    }
}
