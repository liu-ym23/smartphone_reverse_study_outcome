package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final int a;
    public final String b;
    public final List<d> c;
    public final float d;
    public final float e;
    public final float f;

    public e() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f, r6.f) == 0) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f);
    }

    public final String toString() {
        return "GradientDetail(angle=" + this.a + ", gradientType=" + this.b + ", colorStops=" + this.c + ", centerX=" + this.d + ", centerY=" + this.e + ", radius=" + this.f + ')';
    }

    public e(int r2, String r3, List r4) {
        Intrinsics.checkNotNullParameter(r3, "gradientType");
        Intrinsics.checkNotNullParameter(r4, "colorStops");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = 0.5f;
        this.e = 0.5f;
        this.f = 1.0f;
    }
}
