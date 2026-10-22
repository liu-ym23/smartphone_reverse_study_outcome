package com.larus.bmhome.chat.cell.slot;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f0 implements ei9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f297792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xc8.b f297793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f297794c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f297792a, r101.f297792a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f297793b, r101.f297793b) == true) goto L15;
        return false;
    L15:
        if (this.f297794c == r101.f297794c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f297792a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f297793b.hashCode()) * 31) + this.f297794c;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "MessageRegenBlockState(holder=" + this.f297792a + ", data=" + this.f297793b + ", boxType=" + this.f297794c + ')';
    }

    public f0(xc8.b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f297792a = null;
        this.f297793b = r100;
        this.f297794c = r101;
    }
}
