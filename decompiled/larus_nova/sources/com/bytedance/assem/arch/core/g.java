package com.bytedance.assem.arch.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f192894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f192895b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f192894a, r101.f192894a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f192895b, r101.f192895b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Class<?> r100 = this.f192894a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f192895b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HierarchyDataIdentifier(clazz=" + this.f192894a + ", key=" + this.f192895b + ")";
    }

    public g(Class<?> r100, String r101) {
        this.f192894a = r100;
        this.f192895b = r101;
    }
}
