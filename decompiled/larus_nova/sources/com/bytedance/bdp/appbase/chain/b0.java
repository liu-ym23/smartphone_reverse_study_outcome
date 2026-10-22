package com.bytedance.bdp.appbase.chain;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b0<T1, T2> extends d0 {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == false) goto L10;
        b0 r101 = (b0) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L14;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L16;
        return false;
    L16:
        return true;
    L14:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        return (0 * 31) + 0;
    }

    public final String toString() {
        return "Multi2(p1=null, p2=null)";
    }
}
