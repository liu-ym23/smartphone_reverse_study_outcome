package jba;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f498046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f498047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f498048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f498049d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Float.compare(this.f498046a, r101.f498046a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f498047b, r101.f498047b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f498048c, r101.f498048c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f498049d, r101.f498049d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f498046a) * 31) + Float.floatToIntBits(this.f498047b)) * 31) + Float.floatToIntBits(this.f498048c)) * 31) + Float.floatToIntBits(this.f498049d);
    }

    public final String toString() {
        return "ObricLandscapeWindowCornerRadii(topLeft=" + this.f498046a + ", topRight=" + this.f498047b + ", bottomRight=" + this.f498048c + ", bottomLeft=" + this.f498049d + ')';
    }

    public final boolean a() {
        if (this.f498046a <= 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (this.f498047b > 0.0f) goto L12;
        if (this.f498048c > 0.0f) goto L12;
        if (this.f498049d > 0.0f) goto L12;
        return false;
    }

    public c(float r100, float r101, float r102, float r103) {
        this.f498046a = r100;
        this.f498047b = r101;
        this.f498048c = r102;
        this.f498049d = r103;
    }
}
