package com.larus.ui.arch.vm.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class o<A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f375270a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f375270a, ((o) r100).f375270a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f375270a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "Tuple1(a=" + this.f375270a + ')';
    }

    public o(A r100) {
        this.f375270a = r100;
    }
}
