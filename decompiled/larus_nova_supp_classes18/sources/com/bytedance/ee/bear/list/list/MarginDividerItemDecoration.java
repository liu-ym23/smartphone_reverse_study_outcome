package com.bytedance.ee.bear.list.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/list/list/MarginDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "orientation", "", "marginStartDp", "marginEndDp", "<init>", "(Landroid/content/Context;III)V", "divider", "Landroid/graphics/drawable/Drawable;", "marginStartPx", "marginEndPx", "onDraw", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawVertical", "canvas", "drawHorizontal", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarginDividerItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final Drawable b;
    public final int c;
    public final int d;

    public MarginDividerItemDecoration(Context r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = 1;
        this.b = UIUtils.getDrawable(r2, 2131247157);
        this.c = UIHelper.dp2px(r3);
        this.d = UIHelper.dp2px(r4);
    }

    public final void onDraw(Canvas r8, RecyclerView r9, RecyclerView.State r10) {
        Intrinsics.checkNotNullParameter(r8, "c");
        Intrinsics.checkNotNullParameter(r9, "parent");
        Intrinsics.checkNotNullParameter(r10, "state");
        int r2 = 0;
        if (this.a != 1) goto L7;
        int r11 = r9.getPaddingLeft() + this.c;
        int r0 = (r9.getWidth() - r9.getPaddingRight()) - this.d;
        int r3 = r9.getChildCount() - 1;
    L5:
        if (r2 >= r3) goto L10;
        View r4 = r9.getChildAt(r2);
        RecyclerView.LayoutParams r5 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int r6 = r4.getBottom() + ((ViewGroup.MarginLayoutParams) r5).bottomMargin;
        this.b.setBounds(r11, r6, r0, this.b.getIntrinsicHeight() + r6);
        this.b.draw(r8);
        r2 = r2 + 1;
        goto L5
    L10:
        return;
    L7:
        int r12 = r9.getPaddingTop();
        int r1 = r9.getHeight() - r9.getPaddingBottom();
        int r7 = r9.getChildCount() - 1;
    L8:
        if (r2 >= r7) goto L13;
        View r13 = r9.getChildAt(r2);
        RecyclerView.LayoutParams r14 = r13.getLayoutParams();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int r15 = r13.getRight() + ((ViewGroup.MarginLayoutParams) r14).rightMargin;
        this.b.setBounds(r15, r12, this.b.getIntrinsicWidth() + r15, r1);
        this.b.draw(r8);
        r2 = r2 + 1;
        goto L8
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "state");
        RecyclerView.Adapter r7 = r5.getAdapter();
        if (r7 == null) goto L7;
        int r8 = r7.getItemCount();
        if (r5.getChildAdapterPosition(r4) != (r8 - 1)) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == false) goto L10;
        return;
    L10:
        if (this.a != 1) goto L12;
        r3.set(0, 0, 0, this.b.getIntrinsicHeight());
        return;
    L12:
        r3.set(0, 0, this.b.getIntrinsicWidth(), 0);
        return;
    L7:
        r9 = false;
        goto L8
    }
}
