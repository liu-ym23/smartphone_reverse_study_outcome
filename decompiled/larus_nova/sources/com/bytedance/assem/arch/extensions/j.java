package com.bytedance.assem.arch.extensions;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j<A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f192930a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f192930a, ((j) r100).f192930a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f192930a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "Tuple1(a=" + this.f192930a + ")";
    }

    public j(A r100) {
        this.f192930a = r100;
    }
}
