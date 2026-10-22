package com.ss.android.lark.chat.cot.detail.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f415052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f415053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f415054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f415055d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f415052a == r101.f415052a) goto L12;
        return false;
    L12:
        if (this.f415053b == r101.f415053b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f415054c, r101.f415054c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f415055d, r101.f415055d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f415052a * 31) + this.f415053b) * 31;
        Integer r101 = this.f415054c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f415055d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FoldIconConfig(iconRes=" + this.f415052a + ", padding=" + this.f415053b + ", tint=" + this.f415054c + ", backgroundColor=" + this.f415055d + ')';
    }

    public c(int r100, Integer r101, Integer r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 8) == 0) goto L8;
        r102 = null;
    L8:
        this.f415052a = r100;
        this.f415053b = 0;
        this.f415054c = r101;
        this.f415055d = r102;
    }
}
