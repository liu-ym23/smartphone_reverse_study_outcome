package com.lynx.tasm.behavior.shadow.text;

/* JADX INFO: loaded from: classes32.dex */
public class AbsoluteSizeSpan extends android.text.style.AbsoluteSizeSpan {
    public final int hashCode() {
        return ((getDip() ? 1 : 0) * 31) + getSize();
    }

    public AbsoluteSizeSpan(int r100) {
        super(r100);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof AbsoluteSizeSpan) == false) goto L10;
        AbsoluteSizeSpan r101 = (AbsoluteSizeSpan) r100;
        if (r101.getDip() == getDip()) goto L7;
        return false;
    L7:
        if (r101.getSize() != getSize()) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
