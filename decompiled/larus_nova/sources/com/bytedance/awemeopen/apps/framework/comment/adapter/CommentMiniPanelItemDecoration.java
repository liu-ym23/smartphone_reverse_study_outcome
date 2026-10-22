package com.bytedance.awemeopen.apps.framework.comment.adapter;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/adapter/CommentMiniPanelItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentMiniPanelItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f194098a;

    public CommentMiniPanelItemDecoration() {
        Resources r100 = Resources.getSystem();
        this.f194098a = MathKt.roundToInt(TypedValue.applyDimension(1, 32, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
        Resources r101 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = 0;
        int r106 = ((d0.d(r102.getContext()) - 0) - (this.f194098a * 8)) / 9;
        r100.right = r106;
        if (r104 != 0) goto L5;
        r105 = r106;
    L5:
        r100.left = r105;
    }
}
