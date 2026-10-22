package com.ss.android.lark.movable.utils;

import android.content.res.Resources;
import android.graphics.Point;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.movable.island.ScrollIsland;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {
    public static final int a(int r100) {
        Resources r101 = Resources.getSystem();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public static final Point b(MovableView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ScrollIsland r101 = r100.getParentIsland$movable_release();
        if (r101 == null) goto L5;
        MovableView r102 = r100.getRootMovableView();
        int[] r103 = new int[2];
        int[] r104 = new int[2];
        r101.getLocationInWindow(r103);
        r102.getLocationInWindow(r104);
        return new Point(r103[0] - r104[0], r103[1] - r104[1]);
    L5:
        return new Point(0, 0);
    }

    public static final int c(MovableView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ScrollIsland r101 = r100.getParentIsland$movable_release();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getScrollX();
    }
}
