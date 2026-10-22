package com.bytedance.ee.bear.bitable.homepage.chart.home;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.homepage.chart.home.chartitem.ChartView;
import com.bytedance.ee.bear.bitable.homepage.chart.home.loading.ChartListLoadingView;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/home/ChartListDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "gap", "", "radius", "", "paint", "Landroid/graphics/Paint;", "corners", "", "moveWithItem", "", "getMoveWithItem", "()Z", "setMoveWithItem", "(Z)V", "isNeedDecorate", "view", "Landroid/view/View;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChartListDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f212486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f212487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f212488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f212489d;

    public ChartListDecoration() {
        this.f212486a = UIHelper.dp2px(12.0f);
        float r100 = UIHelper.dp2px(20.0f);
        Paint r101 = new Paint();
        r101.setColor(LarkContext.getApplication().getResources().getColor(R.color.bitable_homepage_chart_bg_color));
        this.f212487b = r101;
        this.f212488c = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r100, r100, r100, r100};
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        int r113 = r111.getChildCount();
        RecyclerView.LayoutManager r100 = r111.getLayoutManager();
        if (r100 != null) goto L5;
        return;
    L5:
        RecyclerView.Adapter r101 = r111.getAdapter();
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = 0;
    L9:
        if (r102 >= r113) goto L34;
        View r103 = r111.getChildAt(r102);
        boolean r104 = true;
        if (r100.getPosition(r103) != (r101.getItemCount() - 1)) goto L13;
        boolean r105 = true;
    L14:
        Intrinsics.checkNotNull(r103);
        if ((r103 instanceof ChartView) == false) goto L17;
    L20:
        if (r104 == false) goto L33;
        if (this.f212489d == false) goto L24;
        int r106 = (int) (r103.getTranslationY() + 0.5f);
    L25:
        int r107 = r100.getDecoratedTop(r103) + r106;
        if (r105 == false) goto L28;
        int r108 = r103.getBottom();
    L29:
        int r109 = r108 + r106;
        RectF r114 = new RectF(r100.getDecoratedLeft(r103), r107, r100.getDecoratedRight(r103), r109);
        if (r105 == false) goto L32;
        Path r115 = new Path();
        r115.addRoundRect(r114, this.f212488c, Path.Direction.CW);
        r110.drawPath(r115, this.f212487b);
        goto L33
    L32:
        r110.drawRect(r114, this.f212487b);
        goto L33
    L28:
        r108 = r100.getDecoratedBottom(r103);
        goto L29
    L24:
        r106 = 0;
    L33:
        r102 = r102 + 1;
        goto L9
    L17:
        if ((r103 instanceof ChartListLoadingView) == true) goto L20;
        r104 = false;
        goto L20
    L13:
        r105 = false;
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        if ((r101 instanceof ChartView) == false) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        r100.set(0, 0, 0, this.f212486a);
        return;
    L11:
        r100.set(0, 0, 0, 0);
        return;
    L5:
        if ((r101 instanceof ChartListLoadingView) == true) goto L8;
        r104 = false;
        goto L9
    }
}
