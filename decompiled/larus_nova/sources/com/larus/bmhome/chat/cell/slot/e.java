package com.larus.bmhome.chat.cell.slot;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xc8.b f297783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f297784b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f297783a, r101.f297783a) == true) goto L12;
        return false;
    L12:
        if (this.f297784b == r101.f297784b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f297783a.hashCode() * 31) + this.f297784b;
    }

    public final String toString() {
        return "MessageCheckboxBlockState(data=" + this.f297783a + ", boxType=" + this.f297784b + ')';
    }

    public e(xc8.b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f297783a = r100;
        this.f297784b = r101;
    }
}
