package ub9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f549409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f549410b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f549409a == r101.f549409a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f549410b, r101.f549410b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f549409a * 31;
        String r101 = this.f549410b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SideBarNavigationTarget(page=" + this.f549409a + ", tab=" + this.f549410b + ')';
    }

    public l(int r100, String r101) {
        this.f549409a = r100;
        this.f549410b = r101;
    }
}
