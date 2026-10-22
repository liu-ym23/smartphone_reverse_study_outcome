package com.bytedance.ee.bear.widgets.menuconfig;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f240254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f240255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f240256c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f240254a, r101.f240254a) == true) goto L12;
        return false;
    L12:
        if (this.f240255b == r101.f240255b) goto L15;
        return false;
    L15:
        if (this.f240256c == r101.f240256c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f240254a.hashCode() * 31;
        if (this.f240255b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f240256c;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeSpaceMenuGroup(groupId=" + this.f240254a + ", visible=" + this.f240255b + ", order=" + this.f240256c + ')';
    }

    public f(String r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "groupId");
        this.f240254a = r100;
        this.f240255b = r101;
        this.f240256c = r102;
    }
}
