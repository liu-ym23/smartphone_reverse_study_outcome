package lq9;

/* JADX INFO: loaded from: classes31.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f510352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f510353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f510354c;

    public r() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Float.compare(this.f510352a, r101.f510352a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f510353b, r101.f510353b) == 0) goto L15;
        return false;
    L15:
        if (this.f510354c == r101.f510354c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.f510352a) * 31) + Float.floatToIntBits(this.f510353b)) * 31) + this.f510354c;
    }

    public final String toString() {
        return "LoudnessConfig(targetLufs=" + this.f510352a + ", doraLufs=" + this.f510353b + ", loudNormAlgoType=" + this.f510354c + ')';
    }

    public /* synthetic */ r(int r100) {
        this(0.0f, 0.0f, 0);
    }

    public r(float r100, float r101, int r102) {
        this.f510352a = r100;
        this.f510353b = r101;
        this.f510354c = r102;
    }
}
