package com.larus.home.impl.main.side_bar.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f344501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f344502b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f344501a, r101.f344501a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f344502b, r101.f344502b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f344501a.hashCode() * 31;
        k0 r101 = this.f344502b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SideBarDataState(userId=" + this.f344501a + ", layout=" + this.f344502b + ')';
    }

    public h0(String r100, k0 r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f344501a = r100;
        this.f344502b = r101;
    }
}
