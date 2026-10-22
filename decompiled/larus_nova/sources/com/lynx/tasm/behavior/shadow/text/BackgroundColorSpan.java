package com.lynx.tasm.behavior.shadow.text;

/* JADX INFO: loaded from: classes32.dex */
public class BackgroundColorSpan extends android.text.style.BackgroundColorSpan {
    public final int hashCode() {
        return getBackgroundColor() + 31;
    }

    public BackgroundColorSpan(int r100) {
        super(r100);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof BackgroundColorSpan) == true) goto L5;
        return false;
    L5:
        if (getBackgroundColor() != ((BackgroundColorSpan) r100).getBackgroundColor()) goto L9;
        return true;
    L9:
        return false;
    }
}
