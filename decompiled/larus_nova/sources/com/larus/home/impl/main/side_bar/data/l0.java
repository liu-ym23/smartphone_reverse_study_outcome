package com.larus.home.impl.main.side_bar.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f344520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f344521b;

    public l0() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f344520a, r101.f344520a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f344521b, r101.f344521b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f344520a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f344521b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SideBarMobInfo(tabName=" + this.f344520a + ", cellName=" + this.f344521b + ')';
    }

    public l0(String r100, String r101) {
        this.f344520a = r100;
        this.f344521b = r101;
    }
}
