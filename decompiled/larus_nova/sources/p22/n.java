package p22;

/* JADX INFO: loaded from: classes9.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f527437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f527438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f527439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f527440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f527441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f527442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f527443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f527444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f527445i;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L24;
        n r101 = (n) r100;
        if (this.f527437a == r101.f527437a) goto L8;
        return false;
    L8:
        if (this.f527438b == r101.f527438b) goto L10;
        return false;
    L10:
        if (this.f527439c == r101.f527439c) goto L12;
        return false;
    L12:
        if (Float.compare(this.f527440d, r101.f527440d) == 0) goto L14;
        return false;
    L14:
        if (this.f527441e == r101.f527441e) goto L16;
        return false;
    L16:
        if (this.f527442f == r101.f527442f) goto L18;
        return false;
    L18:
        if (Float.compare(this.f527443g, r101.f527443g) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(this.f527444h, r101.f527444h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.f527445i, r101.f527445i) == 0) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    public final int hashCode() {
        boolean r100 = this.f527437a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (((((((((((((((r101 * 31) + this.f527438b) * 31) + this.f527439c) * 31) + Float.floatToIntBits(this.f527440d)) * 31) + this.f527441e) * 31) + this.f527442f) * 31) + Float.floatToIntBits(this.f527443g)) * 31) + Float.floatToIntBits(this.f527444h)) * 31) + Float.floatToIntBits(this.f527445i);
    }

    public final String toString() {
        return "SimpleDanmakuConfig(isDanmakuOpen=" + this.f527437a + ", displayWidth=" + this.f527438b + ", lineCount=" + this.f527439c + ", lineHeight=" + this.f527440d + ", lineSpacing=" + this.f527441e + ", barrageMinSpacing=" + this.f527442f + ", speed=" + this.f527443g + ", alpha=" + this.f527444h + ", fontSize=" + this.f527445i + ")";
    }

    public n(boolean r100, int r101, int r102, float r103, int r104, int r105, float r106, float r107, float r108) {
        this.f527437a = r100;
        this.f527438b = r101;
        this.f527439c = r102;
        this.f527440d = r103;
        this.f527441e = r104;
        this.f527442f = r105;
        this.f527443g = r106;
        this.f527444h = r107;
        this.f527445i = r108;
    }
}
