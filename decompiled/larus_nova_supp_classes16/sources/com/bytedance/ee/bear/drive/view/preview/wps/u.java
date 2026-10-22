package com.bytedance.ee.bear.drive.view.preview.wps;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u {
    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof u) == true) goto L8;
        return false;
    L8:
        ((u) r4).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "WpsStageInfo(name=null, duration=0, time=0, stageTime=0, ts=0)";
    }
}
