package com.larus.bmhome.chat.cell.slot;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f297805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xc8.b f297806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f297807c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f297805a, r101.f297805a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f297806b, r101.f297806b) == true) goto L15;
        return false;
    L15:
        if (this.f297807c == r101.f297807c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f297805a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f297806b.hashCode()) * 31) + this.f297807c;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "MessageInBoxBottomExtWidgetState(holder=" + this.f297805a + ", data=" + this.f297806b + ", boxType=" + this.f297807c + ')';
    }

    public k(xc8.b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f297805a = null;
        this.f297806b = r100;
        this.f297807c = r101;
    }
}
