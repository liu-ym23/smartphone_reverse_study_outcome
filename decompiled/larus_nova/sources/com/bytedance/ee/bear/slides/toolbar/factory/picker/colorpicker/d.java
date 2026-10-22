package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f238660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f238661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f238662c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Float.compare(this.f238660a, r101.f238660a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f238661b, r101.f238661b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f238662c, r101.f238662c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.f238660a) * 31) + this.f238661b.hashCode()) * 31) + Float.floatToIntBits(this.f238662c);
    }

    public final String toString() {
        return "ColorStop(alpha=" + this.f238660a + ", color=" + this.f238661b + ", offset=" + this.f238662c + ')';
    }

    public d(float r100, String r101, float r102) {
        Intrinsics.checkNotNullParameter(r101, "color");
        this.f238660a = r100;
        this.f238661b = r101;
        this.f238662c = r102;
    }
}
