package z08;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f569638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f569639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f569640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f569641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f569642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f569643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f569644g;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f569638a == r101.f569638a) goto L12;
        return false;
    L12:
        if (this.f569639b == r101.f569639b) goto L15;
        return false;
    L15:
        if (this.f569640c == r101.f569640c) goto L18;
        return false;
    L18:
        if (this.f569641d == r101.f569641d) goto L21;
        return false;
    L21:
        if (Float.compare(this.f569642e, r101.f569642e) == 0) goto L24;
        return false;
    L24:
        if (this.f569643f == r101.f569643f) goto L27;
        return false;
    L27:
        if (this.f569644g == r101.f569644g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f569638a * 31) + this.f569639b) * 31) + this.f569640c) * 31) + this.f569641d) * 31) + Float.floatToIntBits(this.f569642e)) * 31) + this.f569643f) * 31) + this.f569644g;
    }

    public final String toString() {
        return "UDProgressSpec(type=" + this.f569638a + ", thickness=" + this.f569639b + ", trackColor=" + this.f569640c + ", indicatorColor=" + this.f569641d + ", indicatorCornerRadius=" + this.f569642e + ", progress=" + this.f569643f + ", circularSize=" + this.f569644g + ')';
    }

    public final int getType() {
        return this.f569638a;
    }

    public /* synthetic */ b(int r100) {
        this(0, 0, 0, 0, 0.0f, 0, 0);
    }

    public b(int r100, int r101, int r102, int r103, float r104, int r105, int r106) {
        this.f569638a = r100;
        this.f569639b = r101;
        this.f569640c = r102;
        this.f569641d = r103;
        this.f569642e = r104;
        this.f569643f = r105;
        this.f569644g = r106;
    }
}
