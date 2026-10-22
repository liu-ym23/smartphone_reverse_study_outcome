package com.larus.bmhome.chat.cell.slot;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f297770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xc8.b f297771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f297772c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f297770a, r101.f297770a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f297771b, r101.f297771b) == true) goto L15;
        return false;
    L15:
        if (this.f297772c == r101.f297772c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f297770a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f297771b.hashCode()) * 31) + this.f297772c;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "MessageBottomRetryBlockState(holder=" + this.f297770a + ", data=" + this.f297771b + ", boxType=" + this.f297772c + ')';
    }

    public c(xc8.b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f297770a = null;
        this.f297771b = r100;
        this.f297772c = r101;
    }
}
