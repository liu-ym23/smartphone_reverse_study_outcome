package com.bytedance.livesdk.ktvcommon.midi.view.miditone;

/* JADX INFO: loaded from: classes20.dex */
public final class b {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        r101.getClass();
        if (Float.compare(0.0f, 0.0f) != 0) goto L18;
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
        return (((((Float.floatToIntBits(0.0f) * 31) + Float.floatToIntBits(0.0f)) * 31) + Float.floatToIntBits(0.0f)) * 31) + Float.floatToIntBits(0.0f);
    }

    public final String toString() {
        return "LineSegment(startX=0.0, startY=0.0, endX=0.0, endY=0.0)";
    }
}
