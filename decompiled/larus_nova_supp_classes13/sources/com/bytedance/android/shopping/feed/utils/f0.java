package com.bytedance.android.shopping.feed.utils;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f0 {
    public static final View a(RecyclerView r8, OrientationHelper r9, Integer r10) {
        Intrinsics.checkNotNullParameter(r8, "$this$findCenterView");
        Intrinsics.checkNotNullParameter(r9, "helper");
        RecyclerView.LayoutManager r11 = r8.getLayoutManager();
        View r0 = null;
        if (r11 == null) goto L25;
        int r1 = r11.getChildCount();
        if (r1 == 0) goto L25;
        if (r11.getClipToPadding() == false) goto L10;
        int r2 = r9.getStartAfterPadding() + (r9.getTotalSpace() / 2);
    L11:
        int r3 = Integer.MAX_VALUE;
        int r4 = 0;
    L12:
        if (r4 >= r1) goto L25;
        View r5 = r11.getChildAt(r4);
        if (r5 == null) goto L16;
        int r6 = r11.getPosition(r5);
    L17:
        if (r10 != null) goto L20;
    L21:
        int r7 = Math.abs((r9.getDecoratedStart(r5) + (r9.getDecoratedMeasurement(r5) / 2)) - r2);
        if (r7 >= r3) goto L24;
        r0 = r5;
        r3 = r7;
    L24:
        r4 = r4 + 1;
        goto L12
    L20:
        if (r6 == r10.intValue()) goto L24;
    L16:
        r6 = -1;
        goto L17
    L10:
        r2 = r9.getEnd() / 2;
    L25:
        return r0;
    }
}
