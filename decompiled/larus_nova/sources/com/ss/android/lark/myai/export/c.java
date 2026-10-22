package com.ss.android.lark.myai.export;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        ((c) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "MyAIInfo(shadowId=null, avatar=null, name=null)";
    }
}
