package com.bytedance.ee.bear.drive.biz.ai;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f222593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f222594b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f222593a == r101.f222593a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f222594b, r101.f222594b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f222593a * 31) + this.f222594b.hashCode();
    }

    public final String toString() {
        return "PdfSelectionValue(pageIndex=" + this.f222593a + ", selectedText=" + this.f222594b + ')';
    }

    public e(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "selectedText");
        this.f222593a = r100;
        this.f222594b = r101;
    }
}
