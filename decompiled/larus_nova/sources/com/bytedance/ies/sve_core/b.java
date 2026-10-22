package com.bytedance.ies.sve_core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f248683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<i, a> f248684b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f248683a, r101.f248683a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f248684b, r101.f248684b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        c r100 = this.f248683a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function1<i, a> r104 = this.f248684b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AndroidEffectBindInfo(effect=" + this.f248683a + ", map=" + this.f248684b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(c r100, Function1<? super i, ? extends a> r101) {
        this.f248683a = r100;
        this.f248684b = r101;
    }
}
