package com.bytedance.ee.bear.assemble;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mwc.a f206276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Class<?>> f206277b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f206276a, r101.f206276a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f206277b, r101.f206277b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        mwc.a r100 = this.f206276a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f206277b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "KoinFallbackSpec(qualifier=" + this.f206276a + ", classProvider=" + this.f206277b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(mwc.a r100, Function0<? extends Class<?>> r101) {
        Intrinsics.checkNotNullParameter(r101, "classProvider");
        this.f206276a = r100;
        this.f206277b = r101;
    }
}
