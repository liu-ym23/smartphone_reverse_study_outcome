package mg4;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f513722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f513723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f513724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f513725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f513726e;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Float.compare(this.f513722a, r101.f513722a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f513723b, r101.f513723b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f513724c, r101.f513724c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f513725d, r101.f513725d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f513726e, r101.f513726e) == 0) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return (((((((Float.floatToIntBits(this.f513722a) * 31) + Float.floatToIntBits(this.f513723b)) * 31) + Float.floatToIntBits(this.f513724c)) * 31) + Float.floatToIntBits(this.f513725d)) * 31) + Float.floatToIntBits(this.f513726e);
    }

    public final String toString() {
        return "CustomFontMetrics(top=" + this.f513722a + ", ascent=" + this.f513723b + ", descent=" + this.f513724c + ", bottom=" + this.f513725d + ", leading=" + this.f513726e + ")";
    }

    public /* synthetic */ b(int r100) {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public b(float r100, float r101, float r102, float r103, float r104) {
        this.f513722a = r100;
        this.f513723b = r101;
        this.f513724c = r102;
        this.f513725d = r103;
        this.f513726e = r104;
    }
}
