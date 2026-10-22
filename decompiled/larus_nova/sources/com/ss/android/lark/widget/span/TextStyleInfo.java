package com.ss.android.lark.widget.span;

import android.graphics.Typeface;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class TextStyleInfo extends SpanInfo {
    public boolean isBold;
    public boolean isIndependent;
    public boolean isItalic;
    public boolean isStrikeThruText;
    public boolean isUnderlineText;
    public int maxLines;
    public int textBgColor;
    public int textColor;
    public int textSize;
    public transient Typeface textStyle;

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.textSize), Integer.valueOf(this.textColor), Integer.valueOf(this.textBgColor), this.textStyle, Boolean.valueOf(this.isUnderlineText), Boolean.valueOf(this.isStrikeThruText), Boolean.valueOf(this.isBold), Boolean.valueOf(this.isItalic), Boolean.valueOf(this.isIndependent)});
    }

    public TextStyleInfo() {
        this.textSize = -1;
        this.textColor = 0;
        this.textBgColor = 0;
        this.textStyle = null;
        this.isUnderlineText = false;
        this.isStrikeThruText = false;
        this.isBold = false;
        this.isItalic = false;
        this.isIndependent = true;
        this.maxLines = Integer.MAX_VALUE;
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextStyleInfo) == true) goto L8;
        return false;
    L8:
        TextStyleInfo r101 = (TextStyleInfo) r100;
        if (this.textSize == r101.textSize) goto L11;
    L27:
        return false;
    L11:
        if (this.textColor != r101.textColor) goto L27;
        if (this.textBgColor != r101.textBgColor) goto L27;
        if (this.isUnderlineText != r101.isUnderlineText) goto L27;
        if (this.isStrikeThruText != r101.isStrikeThruText) goto L27;
        if (this.isBold != r101.isBold) goto L27;
        if (this.isItalic != r101.isItalic) goto L27;
        if (this.isIndependent != r101.isIndependent) goto L27;
        if (Objects.equals(this.textStyle, r101.textStyle) == false) goto L27;
        return true;
    }
}
