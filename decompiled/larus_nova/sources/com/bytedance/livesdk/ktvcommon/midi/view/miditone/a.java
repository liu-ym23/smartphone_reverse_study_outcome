package com.bytedance.livesdk.ktvcommon.midi.view.miditone;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L18;
        r101.getClass();
        if (Float.compare(0.0f, 0.0f) != 0) goto L19;
        r101.getClass();
        if (Float.compare(0.0f, 0.0f) != 0) goto L20;
        r101.getClass();
        if (Float.compare(0.0f, 0.0f) == 0) goto L22;
        return false;
    L22:
        return true;
    L20:
        return false;
    L19:
        return false;
    L18:
        return false;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((0 * 31) + Float.floatToIntBits(0.0f)) * 31) + Float.floatToIntBits(0.0f)) * 31) + Float.floatToIntBits(0.0f);
    }

    public final String toString() {
        return "HitSegment(segments=null, startX=0.0, endX=0.0, y=0.0)";
    }
}
