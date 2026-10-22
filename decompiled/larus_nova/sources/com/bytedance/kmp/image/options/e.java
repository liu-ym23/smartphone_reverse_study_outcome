package com.bytedance.kmp.image.options;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes19.dex */
public final class e {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        ((e) r100).getClass();
        if (Dp.m7549equalsimpl0(0.0f, 0.0f) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(0.0f, 0.0f) == true) goto L15;
        return false;
    L15:
        if (Color.m4828equalsimpl0(0, 0) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((((Dp.m7550hashCodeimpl(0.0f) * 31) + Dp.m7550hashCodeimpl(0.0f)) * 31) + Color.m4834hashCodeimpl(0)) * 31) + 1237;
    }

    public final String toString() {
        return "ImageBorderOption(borderWidth=" + Dp.m7555toStringimpl(0.0f) + ", radius=" + Dp.m7555toStringimpl(0.0f) + ", borderColor=" + Color.m4835toStringimpl(0) + ", asCircle=false)";
    }
}
