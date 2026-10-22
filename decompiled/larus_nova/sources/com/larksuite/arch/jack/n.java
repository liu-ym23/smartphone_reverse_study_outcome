package com.larksuite.arch.jack;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class n<A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f282809a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f282809a, ((n) r100).f282809a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f282809a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "Tuple1(a=" + this.f282809a + ')';
    }

    public n(A r100) {
        this.f282809a = r100;
    }
}
