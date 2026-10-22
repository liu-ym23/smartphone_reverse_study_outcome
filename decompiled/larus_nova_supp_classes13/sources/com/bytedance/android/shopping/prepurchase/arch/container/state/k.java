package com.bytedance.android.shopping.prepurchase.arch.container.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k<A> {
    public final A a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof k) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((k) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        A r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "Tuple1(a=" + this.a + ")";
    }

    public k(A r1) {
        this.a = r1;
    }
}
