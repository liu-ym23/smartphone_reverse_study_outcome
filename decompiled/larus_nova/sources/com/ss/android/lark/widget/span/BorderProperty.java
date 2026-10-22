package com.ss.android.lark.widget.span;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class BorderProperty implements Serializable {
    private int mBorderColor;
    private int mBorderRadiusPx;
    private int mBorderWidthPx;

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mBorderColor), Integer.valueOf(this.mBorderWidthPx), Integer.valueOf(this.mBorderRadiusPx)});
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderRadiusPx() {
        return this.mBorderRadiusPx;
    }

    public int getBorderWidthPx() {
        return this.mBorderWidthPx;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof BorderProperty) == true) goto L8;
        return false;
    L8:
        BorderProperty r101 = (BorderProperty) r100;
        if (this.mBorderWidthPx == r101.mBorderWidthPx) goto L11;
    L15:
        return false;
    L11:
        if (this.mBorderRadiusPx != r101.mBorderRadiusPx) goto L15;
        if (this.mBorderColor != r101.mBorderColor) goto L15;
        return true;
    }

    public BorderProperty(int r100, int r101, int r102) {
        this.mBorderColor = r100;
        this.mBorderWidthPx = r101;
        this.mBorderRadiusPx = r102;
    }
}
