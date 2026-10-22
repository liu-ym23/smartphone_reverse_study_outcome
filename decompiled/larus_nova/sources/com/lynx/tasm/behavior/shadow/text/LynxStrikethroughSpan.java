package com.lynx.tasm.behavior.shadow.text;

import android.text.style.StrikethroughSpan;

/* JADX INFO: loaded from: classes32.dex */
public class LynxStrikethroughSpan extends StrikethroughSpan {
    public final int hashCode() {
        return getSpanTypeId() * 31;
    }

    public LynxStrikethroughSpan() {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L14:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L14;
        if (getSpanTypeId() == ((LynxStrikethroughSpan) r100).getSpanTypeId()) goto L13;
        return false;
    L13:
        return true;
    }
}
