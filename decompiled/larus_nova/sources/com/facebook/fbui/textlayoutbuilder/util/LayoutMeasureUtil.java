package com.facebook.fbui.textlayoutbuilder.util;

import android.text.Layout;

/* JADX INFO: loaded from: classes23.dex */
public class LayoutMeasureUtil {
    public LayoutMeasureUtil() {
    }

    public static int getHeight(Layout r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getHeight() - 0;
    }

    public static int getWidth(Layout r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r102 = r100.getLineCount();
        int r103 = 0;
    L6:
        if (r101 >= r102) goto L8;
        r103 = Math.max(r103, (int) r100.getLineRight(r101));
        r101 = r101 + 1;
        goto L6
    L8:
        return r103;
    }
}
