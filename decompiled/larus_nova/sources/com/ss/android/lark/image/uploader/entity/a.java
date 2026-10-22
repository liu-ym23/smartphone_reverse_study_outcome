package com.ss.android.lark.image.uploader.entity;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f426384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f426385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f426386c;

    public a() {
        this(1.0f, "native", 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Float.compare(this.f426384a, r101.f426384a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f426385b, r101.f426385b) == true) goto L15;
        return false;
    L15:
        if (this.f426386c == r101.f426386c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.f426384a) * 31) + this.f426385b.hashCode()) * 31) + this.f426386c;
    }

    public final String toString() {
        return "compressRatio:" + this.f426384a + ", compress_algorithm:" + this.f426385b + ", compressCost:" + this.f426386c;
    }

    public a(float r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "compressAlgorithm");
        this.f426384a = r100;
        this.f426385b = r101;
        this.f426386c = r102;
    }
}
