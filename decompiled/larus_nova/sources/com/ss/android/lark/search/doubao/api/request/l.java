package com.ss.android.lark.search.doubao.api.request;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f439979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f439980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f439981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f439982d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f439979a, r101.f439979a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f439980b, r101.f439980b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f439981c, r101.f439981c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f439982d, r101.f439982d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f439979a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f439980b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f439981c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f439982d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LayoutModel(titleLine=" + this.f439979a + ", subTitleLine=" + this.f439980b + ", titleNumOfChars=" + this.f439981c + ", subTitleNumOfChars=" + this.f439982d + ')';
    }

    public l(Integer r100, Integer r101) {
        this.f439979a = null;
        this.f439980b = r100;
        this.f439981c = null;
        this.f439982d = r101;
    }
}
