package com.ss.android.lark.widget.select;

/* JADX INFO: loaded from: classes38.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f448514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f448515b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Float.compare(this.f448514a, r101.f448514a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f448515b, r101.f448515b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f448514a) * 31) + Float.floatToIntBits(this.f448515b);
    }

    public final String toString() {
        return "TextSelectionScrollBounds(top=" + this.f448514a + ", bottom=" + this.f448515b + ')';
    }

    public s(float r100, float r101) {
        this.f448514a = r100;
        this.f448515b = r101;
    }
}
