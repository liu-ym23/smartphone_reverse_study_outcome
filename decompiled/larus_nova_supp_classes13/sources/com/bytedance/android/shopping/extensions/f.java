package com.bytedance.android.shopping.extensions;

import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static void a(ViewGroup r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$addViewWithMatchMatchLayoutParams");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        r3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r2.addView(r3);
    }

    public static void b(ViewGroup r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$addViewWithMatchWrapLayoutParams");
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r3.addView(r4);
    }

    public static final void e(TextView r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$setTextWeight");
        if (r3 != null) goto L5;
        r2.getPaint().setStrokeWidth(0.0f);
        r2.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        return;
    L5:
        r2.getPaint().setStrokeWidth((Math.max(400, r3.intValue()) - 400) / 150);
        r2.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public static final void c(ViewGroup r3, View r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$addViewWithWrapMatchLayoutParams");
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        r4.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        if (r5 == null) goto L5;
        r3.addView(r4, r5.intValue());
        return;
    L5:
        r3.addView(r4);
    }

    public static final void d(LinearLayout r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$setEmptyDivider");
        ShapeDrawable r0 = new ShapeDrawable();
        r0.getPaint().setColor(0);
        r3.setShowDividers(r5);
        r0.setIntrinsicWidth(r4);
        Unit r6 = Unit.INSTANCE;
        r3.setDividerDrawable(r0);
    }
}
