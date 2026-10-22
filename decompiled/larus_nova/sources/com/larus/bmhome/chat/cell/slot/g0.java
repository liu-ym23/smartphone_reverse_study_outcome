package com.larus.bmhome.chat.cell.slot;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g0 implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f297795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xc8.b f297796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f297797c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.f297795a, r101.f297795a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f297796b, r101.f297796b) == true) goto L15;
        return false;
    L15:
        if (this.f297797c == r101.f297797c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f297795a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f297796b.hashCode()) * 31) + this.f297797c;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "MessageRetryBlockState(holder=" + this.f297795a + ", data=" + this.f297796b + ", boxType=" + this.f297797c + ')';
    }

    public g0(xc8.b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f297795a = null;
        this.f297796b = r100;
        this.f297797c = r101;
    }
}
