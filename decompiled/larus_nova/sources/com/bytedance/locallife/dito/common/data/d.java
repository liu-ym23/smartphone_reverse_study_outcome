package com.bytedance.locallife.dito.common.data;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f257338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f257339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f257340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f257341d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f257338a == r101.f257338a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f257339b, r101.f257339b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f257340c, r101.f257340c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f257341d, r101.f257341d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f257338a * 31) + Float.floatToIntBits(this.f257339b)) * 31) + Float.floatToIntBits(this.f257340c)) * 31) + Float.floatToIntBits(this.f257341d);
    }

    public final String toString() {
        return "TopShadowData(shadowColor=" + this.f257338a + ", shadowRadius=" + this.f257339b + ", shadowOffsetX=" + this.f257340c + ", shadowOffsetY=" + this.f257341d + ')';
    }

    public d(int r100, float r101, float r102, float r103) {
        this.f257338a = r100;
        this.f257339b = r101;
        this.f257340c = r102;
        this.f257341d = r103;
    }
}
