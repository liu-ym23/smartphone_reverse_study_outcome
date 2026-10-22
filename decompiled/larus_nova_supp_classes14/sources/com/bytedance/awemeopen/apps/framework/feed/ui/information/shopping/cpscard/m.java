package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.cpscard;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m extends LinearLayout {
    public m(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
    }

    public static DisplayMetrics a(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r9, int r10) {
        int r0 = View.MeasureSpec.getSize(r9);
        int r1 = getChildCount();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L8;
        final View r4 = getChildAt(r2);
        measureChild(r4, r9, r10);
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        r3 = r3 + ((r4.getMeasuredWidth() + r6.leftMargin) + r6.rightMargin);
        if (r3 <= r0) goto L7;
        post(new l(r4));
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        super.onMeasure(r9, r10);
    }
}
