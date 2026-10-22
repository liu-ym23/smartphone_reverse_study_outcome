package com.bytedance.livesdk.preview.msg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L8;
        ((b) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "MessageInt(key=0, listener=null)";
    }
}
