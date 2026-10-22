package com.larus.slides.impl.select;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<GenerateImageViewHolder.b> f369657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f369658b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f369657a, r101.f369657a) == true) goto L12;
        return false;
    L12:
        if (this.f369658b == r101.f369658b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f369657a.hashCode() * 31;
        if (this.f369658b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "GenerateImageUIState(viewPagerViewData=" + this.f369657a + ", canConfirm=" + this.f369658b + ')';
    }

    public p(List<GenerateImageViewHolder.b> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "viewPagerViewData");
        this.f369657a = r100;
        this.f369658b = r101;
    }
}
