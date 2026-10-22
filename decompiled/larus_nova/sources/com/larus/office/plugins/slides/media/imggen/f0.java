package com.larus.office.plugins.slides.media.imggen;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<GenerateImageViewHolder.b> f363365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f363366b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f363365a, r101.f363365a) == true) goto L12;
        return false;
    L12:
        if (this.f363366b == r101.f363366b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f363365a.hashCode() * 31;
        if (this.f363366b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "GenerateImageUIState(viewPagerViewData=" + this.f363365a + ", canConfirm=" + this.f363366b + ')';
    }

    public f0(List<GenerateImageViewHolder.b> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "viewPagerViewData");
        this.f363365a = r100;
        this.f363366b = r101;
    }
}
