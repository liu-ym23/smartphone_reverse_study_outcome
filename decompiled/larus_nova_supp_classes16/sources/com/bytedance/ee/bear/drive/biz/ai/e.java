package com.bytedance.ee.bear.drive.biz.ai;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final int a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "PdfSelectionValue(pageIndex=" + this.a + ", selectedText=" + this.b + ')';
    }

    public e(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "selectedText");
        this.a = r2;
        this.b = r3;
    }
}
