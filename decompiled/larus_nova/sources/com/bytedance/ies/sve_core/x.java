package com.bytedance.ies.sve_core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f248706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<i, a> f248707b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L10;
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f248706a, r101.f248706a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f248707b, r101.f248707b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        w r100 = this.f248706a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function1<i, a> r104 = this.f248707b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "WidgetEffectBindInfo(effect=" + this.f248706a + ", map=" + this.f248707b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(w r100, Function1<? super i, ? extends a> r101) {
        this.f248706a = r100;
        this.f248707b = r101;
    }
}
