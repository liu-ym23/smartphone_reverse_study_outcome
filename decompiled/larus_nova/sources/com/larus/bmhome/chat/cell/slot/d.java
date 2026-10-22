package com.larus.bmhome.chat.cell.slot;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xc8.b f297778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f297779b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f297778a, r101.f297778a) == true) goto L12;
        return false;
    L12:
        if (this.f297779b == r101.f297779b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f297778a.hashCode() * 31) + this.f297779b;
    }

    public final String toString() {
        return "MessageBottomSourceSlotCellData(data=" + this.f297778a + ", boxType=" + this.f297779b + ')';
    }

    public d(xc8.b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f297778a = r100;
        this.f297779b = r101;
    }
}
