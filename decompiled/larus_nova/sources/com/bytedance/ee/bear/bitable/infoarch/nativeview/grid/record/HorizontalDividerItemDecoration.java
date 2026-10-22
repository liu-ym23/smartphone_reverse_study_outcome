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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J(\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/record/HorizontalDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dividerSize", "", "skipFirstDivider", "", "<init>", "(Landroid/content/Context;IZ)V", "getDividerSize", "()I", "getSkipFirstDivider", "()Z", "dividerColor", "paint", "Landroid/graphics/Paint;", "isDraw", "setDraw", "(Z)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f213581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f213582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f213583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f213584d;

    public /* synthetic */ HorizontalDividerItemDecoration(Context r100) {
        this(r100, (int) Math.ceil(r100.getResources().getDimension(R.dimen.bitable_native_view_divider_size)), true);
    }

    public HorizontalDividerItemDecoration(Context r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f213581a = r101;
        this.f213582b = r102;
        int r103 = ContextCompat.getColor(r100, R.color.line_divider_default);
        Paint r104 = new Paint();
        this.f213583c = r104;
        this.f213584d = true;
        r104.setColor(r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        if (this.f213584d == true) goto L5;
        return;
    L5:
        int r113 = r111.getPaddingTop();
        int r100 = r111.getHeight() - r111.getPaddingBottom();
        int r101 = r111.getChildCount() - 1;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L13;
        View r103 = r111.getChildAt(r102);
        if (this.f213582b == true) goto L10;
    L11:
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int r105 = r103.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r104)).rightMargin;
        r110.drawRect(r105, r113, this.f213581a + r105, r100, this.f213583c);
    L12:
        r102 = r102 + 1;
        goto L6
    L10:
        if (r111.getChildAdapterPosition(r103) == 0) goto L12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        if (this.f213582b == true) goto L5;
    L7:
        r100.set(0, 0, this.f213581a, 0);
        return;
    L5:
        if (r104 >= 1) goto L7;
        r100.set(0, 0, 0, 0);
    }
}
