package com.larus.bmhome.chat.layout.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f305233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f305234b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.f305233a, r101.f305233a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f305234b, r101.f305234b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f305233a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f305234b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageCoverEditViewData(isShowAiVideo=" + this.f305233a + ", isShowAiImageBeautify=" + this.f305234b + ')';
    }

    public n0() {
        Boolean r100 = Boolean.FALSE;
        this(r100, r100);
    }

    public n0(Boolean r100, Boolean r101) {
        this.f305233a = r100;
        this.f305234b = r101;
    }
}
