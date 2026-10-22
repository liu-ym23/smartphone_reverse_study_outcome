package com.ss.android.lark.watermark.v2;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f445556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f445557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f445558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f445559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f445560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f445561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f445562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f445563h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f445556a, r101.f445556a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f445557b, r101.f445557b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f445558c, r101.f445558c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f445559d, r101.f445559d) == 0) goto L21;
        return false;
    L21:
        if (this.f445560e == r101.f445560e) goto L24;
        return false;
    L24:
        if (this.f445561f == r101.f445561f) goto L27;
        return false;
    L27:
        if (Float.compare(this.f445562g, r101.f445562g) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.f445563h, r101.f445563h) == 0) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f445556a.hashCode() * 31;
        Bitmap r101 = this.f445557b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((((((((((r100 + r102) * 31) + Float.floatToIntBits(this.f445558c)) * 31) + Float.floatToIntBits(this.f445559d)) * 31) + this.f445560e) * 31) + this.f445561f) * 31) + Float.floatToIntBits(this.f445562g)) * 31) + Float.floatToIntBits(this.f445563h);
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "WatermarkState(text=" + this.f445556a + ", bitmap=" + this.f445557b + ", alpha=" + this.f445558c + ", alphaNightMode=" + this.f445559d + ", fontSize=" + this.f445560e + ", rotateAngleInDegree=" + this.f445561f + ", horizontalInterval=" + this.f445562g + ", verticalInterval=" + this.f445563h + ')';
    }

    public static v a(v r100, String r110, Bitmap r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r110 = r100.f445556a;
    L5:
        String r101 = r110;
        if ((r112 & 2) == 0) goto L8;
        r111 = r100.f445557b;
    L8:
        Bitmap r102 = r111;
        if ((r112 & 4) == 0) goto L11;
        float r103 = r100.f445558c;
    L13:
        if ((r112 & 8) == 0) goto L15;
        float r104 = r100.f445559d;
    L17:
        if ((r112 & 16) == 0) goto L19;
        int r105 = r100.f445560e;
    L21:
        if ((r112 & 32) == 0) goto L23;
        int r106 = r100.f445561f;
    L25:
        if ((r112 & 64) == 0) goto L27;
        float r107 = r100.f445562g;
    L29:
        if ((r112 & 128) == 0) goto L31;
        float r108 = r100.f445563h;
    L32:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "text");
        return new v(r101, r102, r103, r104, r105, r106, r107, r108);
    L31:
        r108 = 0.0f;
        goto L32
    L27:
        r107 = 0.0f;
        goto L29
    L23:
        r106 = 0;
        goto L25
    L19:
        r105 = 0;
        goto L21
    L15:
        r104 = 0.0f;
        goto L17
    L11:
        r103 = 0.0f;
        goto L13
    }

    public v(String r100, Bitmap r101, float r102, float r103, int r104, int r105, float r106, float r107) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f445556a = r100;
        this.f445557b = r101;
        this.f445558c = r102;
        this.f445559d = r103;
        this.f445560e = r104;
        this.f445561f = r105;
        this.f445562g = r106;
        this.f445563h = r107;
    }
}
