package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.cpscard;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m extends LinearLayout {
    public m(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        int r101 = View.MeasureSpec.getSize(r100);
        int r102 = getChildCount();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L8;
        final View r105 = getChildAt(r103);
        measureChild(r105, r100, r110);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        r104 = r104 + ((r105.getMeasuredWidth() + r107.leftMargin) + r107.rightMargin);
        if (r104 <= r101) goto L7;
        post(new l(r105));
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        super.onMeasure(r100, r110);
    }
}
