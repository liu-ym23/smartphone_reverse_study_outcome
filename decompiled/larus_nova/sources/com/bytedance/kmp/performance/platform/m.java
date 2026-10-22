package com.bytedance.kmp.performance.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class m {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        ((m) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "FfiFrameTraceEvent(traceName=null, durationUs=0, mainThreadDurationUs=0, paramConvertDurationUs=0, syncOverheadDurationUs=0)";
    }
}
