package com.larus.home.impl.main.side_bar.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f345072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f345073b;

    public d() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f345072a, r101.f345072a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f345073b, r101.f345073b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Function0<Unit> r100 = this.f345072a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function0<Unit> r104 = this.f345073b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ItemShowResult(checkItemShow=" + this.f345072a + ", cleanReportTag=" + this.f345073b + ')';
    }

    public d(Function0<Unit> r100, Function0<Unit> r101) {
        this.f345072a = r100;
        this.f345073b = r101;
    }
}
