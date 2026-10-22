package qk6;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements nf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f533557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f533558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f533559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f533560d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (this.f533557a == r101.f533557a) goto L8;
        return false;
    L8:
        if (Float.compare(this.f533558b, r101.f533558b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f533559c, r101.f533559c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f533560d, r101.f533560d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f533557a * 31) + Float.floatToIntBits(this.f533558b)) * 31) + Float.floatToIntBits(this.f533559c)) * 31) + Float.floatToIntBits(this.f533560d);
    }

    public final String toString() {
        return "Transform3D(offset=" + this.f533557a + ", x=" + this.f533558b + ", y=" + this.f533559c + ", z=" + this.f533560d + ")";
    }

    public c() {
        this.f533557a = 0;
        this.f533558b = 0.0f;
        this.f533559c = 0.0f;
        this.f533560d = 0.0f;
    }
}
