package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n0> f345382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f345383b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (Intrinsics.areEqual(this.f345382a, r101.f345382a) == true) goto L12;
        return false;
    L12:
        if (this.f345383b == r101.f345383b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f345382a.hashCode() * 31;
        if (this.f345383b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SideBarDeviceListResult(devices=" + this.f345382a + ", refreshSucceeded=" + this.f345383b + ')';
    }

    public r0(List<n0> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "devices");
        this.f345382a = r100;
        this.f345383b = r101;
    }
}
