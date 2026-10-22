package ctc;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f465403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f465404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f465405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f465406d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L25:
        return true;
    L5:
        if ((r100 instanceof e) == false) goto L24;
        e r101 = (e) r100;
        if (this.f465403a != r101.f465403a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L24;
        if (this.f465404b != r101.f465404b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L24;
        if (Float.compare(this.f465405c, r101.f465405c) != 0) goto L24;
        if (this.f465406d != r101.f465406d) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L24;
    L21:
        r104 = false;
        goto L22
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L24:
        return false;
    }

    public final int hashCode() {
        return (((((this.f465403a * 31) + this.f465404b) * 31) + Float.floatToIntBits(this.f465405c)) * 31) + this.f465406d;
    }

    public final String toString() {
        return "ScrollBarTheme(scrollBarWidth=" + this.f465403a + ", scrollBarHeight=" + this.f465404b + ", scrollBarPadding=" + this.f465405c + ", scrollBarColor=" + this.f465406d + ")";
    }

    public e(int r100, int r101, int r102) {
        this.f465403a = r100;
        this.f465404b = r101;
        this.f465405c = 0.0f;
        this.f465406d = r102;
    }
}
