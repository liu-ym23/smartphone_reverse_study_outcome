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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/awemeopen/apps/framework/card/view/AosHorScrollVideoCardView$1$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosHorScrollVideoCardView$1$1 extends RecyclerView.ItemDecoration {
    public AosHorScrollVideoCardView$1$1() {
    }

    public static DisplayMetrics h(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        if (r104 != 0) goto L5;
        r100.left = MathKt.roundToInt(TypedValue.applyDimension(1, 16, h(Resources.getSystem())));
        r100.right = MathKt.roundToInt(TypedValue.applyDimension(1, 8, h(Resources.getSystem())));
        return;
    L5:
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 == null) goto L8;
        int r106 = r105.getItemCount();
    L10:
        if (r104 != (r106 - 1)) goto L12;
        r100.left = MathKt.roundToInt(TypedValue.applyDimension(1, 0, h(Resources.getSystem())));
        r100.right = MathKt.roundToInt(TypedValue.applyDimension(1, 16, h(Resources.getSystem())));
        return;
    L12:
        r100.left = MathKt.roundToInt(TypedValue.applyDimension(1, 0, h(Resources.getSystem())));
        r100.right = MathKt.roundToInt(TypedValue.applyDimension(1, 8, h(Resources.getSystem())));
        return;
    L8:
        r106 = 0;
        goto L10
    }
}
