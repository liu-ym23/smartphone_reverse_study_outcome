package wf4;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f559474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f559475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f559476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f559477d;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (this.f559474a == r101.f559474a) goto L8;
        return false;
    L8:
        if (this.f559475b == r101.f559475b) goto L10;
        return false;
    L10:
        if (Float.compare(this.f559476c, r101.f559476c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f559477d, r101.f559477d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f559474a * 31) + this.f559475b) * 31) + Float.floatToIntBits(this.f559476c)) * 31) + Float.floatToIntBits(this.f559477d);
    }

    public final String toString() {
        return "Stroke(width=" + this.f559474a + ", color=" + this.f559475b + ", dashWidth=" + this.f559476c + ", dashGap=" + this.f559477d + ")";
    }

    public d(int r100) {
        this.f559474a = -1;
        this.f559475b = -1;
        this.f559476c = 0.0f;
        this.f559477d = 0.0f;
    }
}
