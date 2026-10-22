package jsb;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f500270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f500271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f500272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f500273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f500274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f500275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f500276g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f500270a == r101.f500270a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f500271b, r101.f500271b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f500272c, r101.f500272c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f500273d, r101.f500273d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f500274e, r101.f500274e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f500275f, r101.f500275f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.f500276g, r101.f500276g) == 0) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f500270a * 31) + Float.floatToIntBits(this.f500271b)) * 31) + Float.floatToIntBits(this.f500272c)) * 31) + Float.floatToIntBits(this.f500273d)) * 31) + Float.floatToIntBits(this.f500274e)) * 31) + Float.floatToIntBits(this.f500275f)) * 31) + Float.floatToIntBits(this.f500276g);
    }

    public final String toString() {
        return "IslandInfo(islandID=" + this.f500270a + ", x=" + this.f500271b + ", y=" + this.f500272c + ", width=" + this.f500273d + ", height=" + this.f500274e + ", contentWidth=" + this.f500275f + ", contentHeight=" + this.f500276g + ')';
    }

    public a(int r100, float r101, float r102, float r103, float r104, float r105, float r106) {
        this.f500270a = r100;
        this.f500271b = r101;
        this.f500272c = r102;
        this.f500273d = r103;
        this.f500274e = r104;
        this.f500275f = r105;
        this.f500276g = r106;
    }
}
