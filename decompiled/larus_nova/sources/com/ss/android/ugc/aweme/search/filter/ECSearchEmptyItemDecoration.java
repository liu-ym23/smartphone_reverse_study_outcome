package com.ss.android.ugc.aweme.search.filter;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchEmptyItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchEmptyItemDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "state");
        super.onDraw(r100, r101, r102);
        int r103 = r101.getChildCount();
        if (r103 <= 0) goto L10;
        View r104 = r101.getChildAt(r103 - 1);
        int r105 = r101.getChildAdapterPosition(r104);
        RecyclerView.Adapter r106 = r101.getAdapter();
        if (r106 != null) goto L7;
        return;
    L7:
        if (r105 != (r106.getItemCount() - 1)) goto L12;
        float r107 = r101.getPaddingLeft();
        float r108 = r104.getBottom();
        RectF r109 = new RectF(r107, r108, r101.getWidth() - r101.getPaddingRight(), 0 + r108);
        Path r110 = new Path();
        r110.addRoundRect(r109, new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        r100.drawPath(r110, null);
        return;
    L12:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 != null) goto L5;
        return;
    L5:
        if (r104 != (r105.getItemCount() - 1)) goto L9;
        r100.bottom = 0;
        return;
    }
}
