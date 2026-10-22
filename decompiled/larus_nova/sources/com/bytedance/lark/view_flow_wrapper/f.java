package com.bytedance.lark.view_flow_wrapper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f<T> {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        ((f) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return 38347;
    }

    public final String toString() {
        return "Event(data=null, autoConsume=false, onConsume=null)";
    }
}
