package h5;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f483830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f483831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f483832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f483833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f483834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f483835f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f483830a == r101.f483830a) goto L12;
        return false;
    L12:
        if (this.f483831b == r101.f483831b) goto L15;
        return false;
    L15:
        if (this.f483832c == r101.f483832c) goto L18;
        return false;
    L18:
        if (Float.compare(this.f483833d, r101.f483833d) == 0) goto L21;
        return false;
    L21:
        if (this.f483834e == r101.f483834e) goto L24;
        return false;
    L24:
        if (this.f483835f == r101.f483835f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f483830a * 31) + this.f483831b) * 31) + this.f483832c) * 31) + Float.floatToIntBits(this.f483833d)) * 31) + this.f483834e) * 31) + this.f483835f;
    }

    public final String toString() {
        return "WidgetConfig(borderMargin=" + this.f483830a + ", fgStrokeWidth=" + this.f483831b + ", fgStrokeColor=" + this.f483832c + ", cornerRadius=" + this.f483833d + ", noOutlineBoxType=" + this.f483834e + ", defaultHeight=" + this.f483835f + ')';
    }

    public j(int r100, int r101, int r102, float r103, int r104) {
        this.f483830a = r100;
        this.f483831b = r101;
        this.f483832c = r102;
        this.f483833d = r103;
        this.f483834e = 3;
        this.f483835f = r104;
    }
}
