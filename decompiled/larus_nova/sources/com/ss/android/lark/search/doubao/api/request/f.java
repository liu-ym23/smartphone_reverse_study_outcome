package com.ss.android.lark.search.doubao.api.request;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f439963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f439964b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f439963a == r101.f439963a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f439964b, r101.f439964b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f439963a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f439964b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "CommonFilterModel(includeOuterTenant=" + this.f439963a + ", chatID=" + this.f439964b + ')';
    }

    public f(boolean r100, String r101) {
        this.f439963a = r100;
        this.f439964b = r101;
    }
}
