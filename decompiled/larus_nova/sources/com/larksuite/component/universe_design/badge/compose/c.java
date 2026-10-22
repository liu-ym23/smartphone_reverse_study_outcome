package com.larksuite.component.universe_design.badge.compose;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        ((c) r100).getClass();
        if (Dp.m7549equalsimpl0(0.0f, 0.0f) == true) goto L12;
        return false;
    L12:
        if (Color.m4828equalsimpl0(0, 0) == true) goto L15;
        return false;
    L15:
        if (Dp.m7549equalsimpl0(0.0f, 0.0f) == true) goto L18;
        return false;
    L18:
        if (Color.m4828equalsimpl0(0, 0) == true) goto L21;
        return false;
    L21:
        if (Dp.m7549equalsimpl0(0.0f, 0.0f) == true) goto L24;
        return false;
    L24:
        if (Color.m4828equalsimpl0(0, 0) == true) goto L27;
        return false;
    L27:
        if (Color.m4828equalsimpl0(0, 0) == true) goto L30;
        return false;
    L30:
        if (Dp.m7549equalsimpl0(0.0f, 0.0f) == true) goto L33;
        return false;
    L33:
        if (Dp.m7549equalsimpl0(0.0f, 0.0f) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(null, null) == true) goto L39;
        return false;
    L39:
        if (Color.m4828equalsimpl0(0, 0) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final UDBadgeType getType() {
        return null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "UDBadgeStyle(type=null, badgeSize=" + Dp.m7555toStringimpl(0.0f) + ", badgeColor=" + Color.m4835toStringimpl(0) + ", outerBorderWidth=" + Dp.m7555toStringimpl(0.0f) + ", outerBorderColor=" + Color.m4835toStringimpl(0) + ", innerBorderWidth=" + Dp.m7555toStringimpl(0.0f) + ", innerBorderColor=" + Color.m4835toStringimpl(0) + ", textColor=" + Color.m4835toStringimpl(0) + ", textSize=" + Dp.m7555toStringimpl(0.0f) + ", textWidthPadding=" + Dp.m7555toStringimpl(0.0f) + ", textMaxLength=0, iconPadding=null, iconTint=" + Color.m4835toStringimpl(0) + ')';
    }
}
