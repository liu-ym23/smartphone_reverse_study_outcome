package com.bytedance.ies.sdk.widgets.info;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes19.dex */
public class WidgetInfoHelper {
    public WidgetInfoHelper() {
    }

    public static WidgetInfo constructInfo(View r100) {
        Rect r101 = new Rect();
        r100.getGlobalVisibleRect(r101);
        int[] r102 = new int[2];
        r100.getLocationOnScreen(r102);
        int[] r103 = new int[2];
        r100.getLocationInWindow(r103);
        return new WidgetInfo(r100.getWidth(), r100.getHeight(), r101, r102, r103);
    }
}
