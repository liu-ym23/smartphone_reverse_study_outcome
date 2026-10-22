package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f238663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f238664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f238665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f238666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f238667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f238668f;

    public e() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f238663a == r101.f238663a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f238664b, r101.f238664b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f238665c, r101.f238665c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f238666d, r101.f238666d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f238667e, r101.f238667e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f238668f, r101.f238668f) == 0) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f238663a * 31) + this.f238664b.hashCode()) * 31) + this.f238665c.hashCode()) * 31) + Float.floatToIntBits(this.f238666d)) * 31) + Float.floatToIntBits(this.f238667e)) * 31) + Float.floatToIntBits(this.f238668f);
    }

    public final String toString() {
        return "GradientDetail(angle=" + this.f238663a + ", gradientType=" + this.f238664b + ", colorStops=" + this.f238665c + ", centerX=" + this.f238666d + ", centerY=" + this.f238667e + ", radius=" + this.f238668f + ')';
    }

    public e(int r100, String r101, List r102) {
        Intrinsics.checkNotNullParameter(r101, "gradientType");
        Intrinsics.checkNotNullParameter(r102, "colorStops");
        this.f238663a = r100;
        this.f238664b = r101;
        this.f238665c = r102;
        this.f238666d = 0.5f;
        this.f238667e = 0.5f;
        this.f238668f = 1.0f;
    }
}
