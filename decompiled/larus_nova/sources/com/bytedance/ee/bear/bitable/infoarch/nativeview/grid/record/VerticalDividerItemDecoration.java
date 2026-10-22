package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.record;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/record/VerticalDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dividerSize", "", "<init>", "(Landroid/content/Context;I)V", "getDividerSize", "()I", "dividerColor", "paint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VerticalDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f213585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f213586b;

    public VerticalDividerItemDecoration(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f213585a = r101;
        int r102 = ContextCompat.getColor(r100, R.color.line_divider_default);
        Paint r103 = new Paint();
        this.f213586b = r103;
        r103.setColor(r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        int r113 = r111.getPaddingLeft();
        int r100 = r111.getWidth() - r111.getPaddingRight();
        int r101 = r111.getChildCount() - 1;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        View r103 = r111.getChildAt(r102);
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int r105 = r103.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r104)).bottomMargin;
        r110.drawRect(r113, r105, r100, this.f213585a + r105, this.f213586b);
        r102 = r102 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 == null) goto L5;
        int r106 = r105.getItemCount();
    L7:
        if (r104 == (r106 - 1)) goto L10;
        r100.set(0, 0, 0, this.f213585a);
        return;
    L10:
        return;
    L5:
        r106 = -1;
        goto L7
    }
}
