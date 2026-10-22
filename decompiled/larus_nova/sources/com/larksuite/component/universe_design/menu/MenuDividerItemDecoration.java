package com.larksuite.component.universe_design.menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J(\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/larksuite/component/universe_design/menu/MenuDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dividerPositions", "", "", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "dividerSize", "", "dividerPadding", "borderSize", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "universe-ui-menu_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f285060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f285061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f285062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f285063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f285064e;

    public MenuDividerItemDecoration(final Context r100, List<Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dividerPositions");
        this.f285060a = r101;
        this.f285061b = new UDDimension.Dp(0.5f).toPixels(r100);
        this.f285062c = new UDDimension.Dp(2).toPixels(r100);
        this.f285063d = new UDDimension.Dp(1).toPixels(r100);
        this.f285064e = LazyKt.lazy(new MenuDividerItemDecoration$paint$2(r100));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        int r113 = r111.getChildCount();
        RecyclerView.Adapter r100 = r111.getAdapter();
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = 0;
    L6:
        if (r101 >= r113) goto L19;
        View r102 = r111.getChildAt(r101);
        int r103 = r111.getChildAdapterPosition(r102);
        if (this.f285060a.contains(Integer.valueOf(r103)) == false) goto L18;
        if (r103 == (-1)) goto L18;
        if (r103 < 0) goto L15;
        boolean r104 = true;
        if (r103 >= (r100.getItemCount() - 1)) goto L15;
    L16:
        if (r104 == false) goto L18;
        float r105 = (r102.getLeft() - r111.getPaddingLeft()) + this.f285063d;
        float r106 = r102.getBottom() + this.f285062c;
        r110.drawRect(r105, r106, (r102.getRight() + r111.getPaddingRight()) - this.f285063d, r106 + this.f285061b, (Paint) this.f285064e.getValue());
    L15:
        r104 = false;
    L18:
        r101 = r101 + 1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 != null) goto L5;
        return;
    L5:
        r100.setEmpty();
        if (this.f285060a.contains(Integer.valueOf(r104)) == true) goto L8;
        return;
    L8:
        if (r104 < 0) goto L12;
        boolean r106 = true;
        if (r104 >= (r105.getItemCount() - 1)) goto L12;
    L13:
        if (r106 == false) goto L17;
        r100.set(0, 0, 0, (int) ((this.f285062c * 2) + this.f285061b));
        return;
    L17:
        return;
    L12:
        r106 = false;
        goto L13
    }
}
