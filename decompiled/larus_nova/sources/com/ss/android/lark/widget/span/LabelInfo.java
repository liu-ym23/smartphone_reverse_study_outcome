package com.ss.android.lark.widget.span;

import com.ss.android.lark.widget.linked_emojicon.roundspan.RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum;

/* JADX INFO: loaded from: classes38.dex */
public class LabelInfo extends TextStyleInfo {
    public int index;
    public int mLeftMargin;
    public RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum mPADDING;
    public int mRadiusInDP;
    public int tagTextSize;

    public LabelInfo() {
        this.mLeftMargin = 0;
        this.tagTextSize = -1;
        this.index = -1;
        this.mPADDING = RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum.NORMAL;
    }
}
