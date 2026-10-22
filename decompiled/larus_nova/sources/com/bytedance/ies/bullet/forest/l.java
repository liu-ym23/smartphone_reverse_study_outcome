package com.bytedance.ies.bullet.forest;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L11;
        return false;
    L11:
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "ForestPreloadOperation(callback=null, requestInfo=null)";
    }
}
