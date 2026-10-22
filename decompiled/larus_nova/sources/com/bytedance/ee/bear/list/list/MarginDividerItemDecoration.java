package com.bytedance.ee.bear.list.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/list/list/MarginDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "orientation", "", "marginStartDp", "marginEndDp", "<init>", "(Landroid/content/Context;III)V", ItemStyle.ITEM_STYLE_DIVIDER, "Landroid/graphics/drawable/Drawable;", "marginStartPx", "marginEndPx", "onDraw", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawVertical", "canvas", "drawHorizontal", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarginDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f228517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f228518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f228519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f228520d;

    public MarginDividerItemDecoration(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f228517a = 1;
        this.f228518b = UIUtils.getDrawable(r100, R.drawable.pad_list_divider);
        this.f228519c = UIHelper.dp2px(r101);
        this.f228520d = UIHelper.dp2px(r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r110) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r110, "state");
        int r102 = 0;
        if (this.f228517a != 1) goto L7;
        int r111 = r101.getPaddingLeft() + this.f228519c;
        int r103 = (r101.getWidth() - r101.getPaddingRight()) - this.f228520d;
        int r104 = r101.getChildCount() - 1;
    L5:
        if (r102 >= r104) goto L10;
        View r105 = r101.getChildAt(r102);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int r107 = r105.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r106)).bottomMargin;
        this.f228518b.setBounds(r111, r107, r103, this.f228518b.getIntrinsicHeight() + r107);
        this.f228518b.draw(r100);
        r102 = r102 + 1;
        goto L5
    L10:
        return;
    L7:
        int r112 = r101.getPaddingTop();
        int r108 = r101.getHeight() - r101.getPaddingBottom();
        int r109 = r101.getChildCount() - 1;
    L8:
        if (r102 >= r109) goto L13;
        View r113 = r101.getChildAt(r102);
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int r115 = r113.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r114)).rightMargin;
        this.f228518b.setBounds(r115, r112, this.f228518b.getIntrinsicWidth() + r115, r108);
        this.f228518b.draw(r100);
        r102 = r102 + 1;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        RecyclerView.Adapter r104 = r102.getAdapter();
        if (r104 == null) goto L7;
        int r105 = r104.getItemCount();
        if (r102.getChildAdapterPosition(r101) != (r105 - 1)) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == false) goto L10;
        return;
    L10:
        if (this.f228517a != 1) goto L12;
        r100.set(0, 0, 0, this.f228518b.getIntrinsicHeight());
        return;
    L12:
        r100.set(0, 0, this.f228518b.getIntrinsicWidth(), 0);
        return;
    L7:
        r106 = false;
        goto L8
    }
}
