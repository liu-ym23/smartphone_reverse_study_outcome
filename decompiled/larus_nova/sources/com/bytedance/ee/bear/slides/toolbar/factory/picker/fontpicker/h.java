package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f238721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f238722b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Float.compare(this.f238721a, r101.f238721a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f238722b, r101.f238722b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f238721a) * 31) + Float.floatToIntBits(this.f238722b);
    }

    public final String toString() {
        return "SvgDimensions(width=" + this.f238721a + ", height=" + this.f238722b + ')';
    }

    public h(float r100, float r101) {
        this.f238721a = r100;
        this.f238722b = r101;
    }
}
