package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final float a;
    public final String b;
    public final float c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.a) * 31) + this.b.hashCode()) * 31) + Float.floatToIntBits(this.c);
    }

    public final String toString() {
        return "ColorStop(alpha=" + this.a + ", color=" + this.b + ", offset=" + this.c + ')';
    }

    public d(float r2, String r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "color");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
