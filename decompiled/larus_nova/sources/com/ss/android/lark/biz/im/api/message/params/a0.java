package com.ss.android.lark.biz.im.api.message.params;

/* JADX INFO: loaded from: classes34.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f410333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f410334c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (this.f410332a == r101.f410332a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f410333b, r101.f410333b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f410334c, r101.f410334c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f410332a * 31) + Float.floatToIntBits(this.f410333b)) * 31) + Float.floatToIntBits(this.f410334c);
    }

    public final String toString() {
        return "UnderlineParam(lineColor=" + this.f410332a + ", lineWidth=" + this.f410333b + ", lineOffsetY=" + this.f410334c + ')';
    }

    public a0(int r100, float r101, float r102) {
        this.f410332a = r100;
        this.f410333b = r101;
        this.f410334c = r102;
    }
}
