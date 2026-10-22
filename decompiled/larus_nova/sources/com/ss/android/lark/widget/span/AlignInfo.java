package com.ss.android.lark.widget.span;

import android.text.Layout;

/* JADX INFO: loaded from: classes38.dex */
public class AlignInfo extends SpanInfo {
    public Layout.Alignment mAlignment;

    public static String getPlaceHolder() {
        return "[align]";
    }

    public AlignInfo() {
        this.isGlobalSpanInfo = true;
    }
}
