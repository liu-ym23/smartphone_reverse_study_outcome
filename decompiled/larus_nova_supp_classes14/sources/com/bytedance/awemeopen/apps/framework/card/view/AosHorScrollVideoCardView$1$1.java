package com.bytedance.awemeopen.apps.framework.card.view;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/awemeopen/apps/framework/card/view/AosHorScrollVideoCardView$1$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosHorScrollVideoCardView$1$1 extends RecyclerView.ItemDecoration {
    public AosHorScrollVideoCardView$1$1() {
    }

    public static DisplayMetrics h(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public final void getItemOffsets(Rect r4, View r5, RecyclerView r6, RecyclerView.State r7) {
        Intrinsics.checkNotNullParameter(r4, "outRect");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "state");
        super.getItemOffsets(r4, r5, r6, r7);
        int r8 = r6.getChildAdapterPosition(r5);
        if (r8 != 0) goto L5;
        r4.left = MathKt.roundToInt(TypedValue.applyDimension(1, 16, h(Resources.getSystem())));
        r4.right = MathKt.roundToInt(TypedValue.applyDimension(1, 8, h(Resources.getSystem())));
        return;
    L5:
        RecyclerView.Adapter r9 = r6.getAdapter();
        if (r9 == null) goto L8;
        int r10 = r9.getItemCount();
    L10:
        if (r8 != (r10 - 1)) goto L12;
        r4.left = MathKt.roundToInt(TypedValue.applyDimension(1, 0, h(Resources.getSystem())));
        r4.right = MathKt.roundToInt(TypedValue.applyDimension(1, 16, h(Resources.getSystem())));
        return;
    L12:
        r4.left = MathKt.roundToInt(TypedValue.applyDimension(1, 0, h(Resources.getSystem())));
        r4.right = MathKt.roundToInt(TypedValue.applyDimension(1, 8, h(Resources.getSystem())));
        return;
    L8:
        r10 = 0;
        goto L10
    }
}
