package com.ss.android.lark.search.doubao.api.request;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f440014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f440015b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.f440014a == r101.f440014a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f440015b, r101.f440015b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f440014a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f440015b;
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
        return "UserDslModel(excludeOuterContact=" + this.f440014a + ", chatID=" + this.f440015b + ')';
    }

    public u(boolean r100, String r101) {
        this.f440014a = r100;
        this.f440015b = r101;
    }
}
