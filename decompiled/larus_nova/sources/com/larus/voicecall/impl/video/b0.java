package com.larus.voicecall.impl.video;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f379585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f379586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPortContainerView f379587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f379588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f379589e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Float.compare(this.f379585a, r101.f379585a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f379586b, r101.f379586b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f379587c, r101.f379587c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f379588d, r101.f379588d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f379589e, r101.f379589e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((Float.floatToIntBits(this.f379585a) * 31) + Arrays.hashCode(this.f379586b)) * 31) + this.f379587c.hashCode()) * 31) + Float.floatToIntBits(this.f379588d)) * 31) + Float.floatToIntBits(this.f379589e);
    }

    public final String toString() {
        return "ZoomInOutAnimParam(scale=" + this.f379585a + ", targetLocation=" + Arrays.toString(this.f379586b) + ", viewPortContainer=" + this.f379587c + ", fromAlpha=" + this.f379588d + ", toAlpha=" + this.f379589e + ')';
    }

    public b0(float r100, int[] r101, ViewPortContainerView r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r101, "targetLocation");
        Intrinsics.checkNotNullParameter(r102, "viewPortContainer");
        this.f379585a = r100;
        this.f379586b = r101;
        this.f379587c = r102;
        this.f379588d = r103;
        this.f379589e = r104;
    }
}
