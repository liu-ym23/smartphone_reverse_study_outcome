package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f3 f339204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y2 f339205b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d3) == true) goto L8;
        return false;
    L8:
        d3 r101 = (d3) r100;
        if (Intrinsics.areEqual(this.f339204a, r101.f339204a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f339205b, r101.f339205b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f339204a.hashCode() * 31;
        y2 r101 = this.f339205b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraObricGlassesModeSheetResult(state=" + this.f339204a + ", effect=" + this.f339205b + ')';
    }

    public d3(f3 r100, y2 r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f339204a = r100;
        this.f339205b = r101;
    }
}
