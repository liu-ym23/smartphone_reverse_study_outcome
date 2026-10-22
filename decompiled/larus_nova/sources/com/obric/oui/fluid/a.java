package com.obric.oui.fluid;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f400848a;

    public a() {
        this(null);
    }

    public final String toString() {
        return "FluidConfig(glassParams=" + Arrays.toString(this.f400848a) + ')';
    }

    public final int hashCode() {
        float[] r100 = this.f400848a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r100);
    }

    public a(float[] r100) {
        this.f400848a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        Class<?> r101 = null;
    L10:
        if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if (Arrays.equals(this.f400848a, ((a) r100).f400848a) == true) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.fluid.FluidConfig");
    L8:
        r101 = r100.getClass();
        goto L10
    }
}
