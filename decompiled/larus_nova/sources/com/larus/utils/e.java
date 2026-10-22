package com.larus.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f375382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f375383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f375384c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f375382a, r101.f375382a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f375383b, r101.f375383b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f375384c, r101.f375384c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f375382a.hashCode() * 31) + Float.floatToIntBits(this.f375383b)) * 31;
        Float r101 = this.f375384c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AdaptiveTextSegment(text=" + this.f375382a + ", textSize=" + this.f375383b + ", minTextSize=" + this.f375384c + ')';
    }

    public e(String r100, float r101, Float r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f375382a = r100;
        this.f375383b = r101;
        this.f375384c = r102;
    }
}
