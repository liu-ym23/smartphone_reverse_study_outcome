package com.larus.avlink.env.diary.style;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e0> f292147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f292148b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f292147a, r101.f292147a) == true) goto L12;
        return false;
    L12:
        if (this.f292148b == r101.f292148b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f292147a.hashCode() * 31) + this.f292148b;
    }

    public final String toString() {
        return "DiaryStyleListUiData(styles=" + this.f292147a + ", maxCount=" + this.f292148b + ')';
    }

    public f0(List<e0> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "styles");
        this.f292147a = r100;
        this.f292148b = r101;
    }
}
