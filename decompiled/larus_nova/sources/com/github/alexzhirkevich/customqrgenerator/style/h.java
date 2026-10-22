package com.github.alexzhirkevich.customqrgenerator.style;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f274266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f274267b;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f274266a) * 31) + Float.floatToIntBits(this.f274267b);
    }

    public final String toString() {
        return "QrOffset(x=" + this.f274266a + ", y=" + this.f274267b + ')';
    }

    public h() {
        this.f274266a = 0.0f;
        this.f274267b = 0.0f;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(Float.valueOf(this.f274266a), Float.valueOf(r101.f274266a)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.f274267b), Float.valueOf(r101.f274267b)) == true) goto L14;
        return false;
    L14:
        return true;
    }
}
