package com.larus.voicecall.impl.video;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f379581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f379582b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Float.compare(this.f379581a, r101.f379581a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f379582b, r101.f379582b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f379581a) * 31) + Float.floatToIntBits(this.f379582b);
    }

    public final String toString() {
        return "BrushDot(x=" + this.f379581a + ", y=" + this.f379582b + ')';
    }

    public a(float r100, float r101) {
        this.f379581a = r100;
        this.f379582b = r101;
    }
}
