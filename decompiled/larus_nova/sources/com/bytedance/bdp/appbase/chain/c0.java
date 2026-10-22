package com.bytedance.bdp.appbase.chain;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c0<T1, T2, T3> extends d0 {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L12;
        c0 r101 = (c0) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L16;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L17;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L19;
        return false;
    L19:
        return true;
    L17:
        return false;
    L16:
        return false;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((0 * 31) + 0) * 31) + 0;
    }

    public final String toString() {
        return "Multi3(p1=null, p2=null, p3=null)";
    }
}
