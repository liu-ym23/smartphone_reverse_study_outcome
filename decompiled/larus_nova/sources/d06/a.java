package d06;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f466197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f466198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f466199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f466200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f466201e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (this.f466197a == r101.f466197a) goto L8;
        return false;
    L8:
        if (this.f466198b == r101.f466198b) goto L10;
        return false;
    L10:
        if (this.f466199c == r101.f466199c) goto L12;
        return false;
    L12:
        if (this.f466200d == r101.f466200d) goto L14;
        return false;
    L14:
        if (Double.compare(this.f466201e, r101.f466201e) == 0) goto L25;
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
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f466197a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f466198b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f466199c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f466200d;
        if (r110 == true) goto L15;
        r101 = r110;
    L15:
        int r111 = (r109 + r101) * 31;
        long r112 = Double.doubleToLongBits(this.f466201e);
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    }

    public final String toString() {
        return "DefaultSampleRateModel(monitorNormal=" + this.f466197a + ", monitorError=" + this.f466198b + ", interceptError=" + this.f466199c + ", normalEnable=" + this.f466200d + ", localSampleRate=" + this.f466201e + ")";
    }

    public a(boolean r100, boolean r101, boolean r102, boolean r103, double r104) {
        this.f466197a = r100;
        this.f466198b = r101;
        this.f466199c = r102;
        this.f466200d = r103;
        this.f466201e = r104;
    }
}
