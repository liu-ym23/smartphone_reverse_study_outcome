package com.ss.android.lark.todo.impl.features.chatlist.recyclerView;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.todo.impl.features.chatlist.adapter.PinnedHeaderAdapter;
import w7c.a;

/* JADX INFO: loaded from: classes38.dex */
public class PinnedHeaderItemDecoration extends RecyclerView.ItemDecoration implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f442413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f442414b;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
    }

    public PinnedHeaderItemDecoration() {
        this.f442413a = null;
        this.f442414b = -1;
    }

    @Override // w7c.a
    public final int e() {
        return this.f442414b;
    }

    @Override // w7c.a
    public final Rect f() {
        return this.f442413a;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r110) {
        super.onDrawOver(r100, r101, r110);
        if ((r101.getAdapter() instanceof PinnedHeaderAdapter) == true) goto L5;
        return;
    L5:
        if (r101.getChildCount() <= 0) goto L55;
        PinnedHeaderAdapter r111 = (PinnedHeaderAdapter) r101.getAdapter();
        int r102 = r101.getChildAdapterPosition(r101.getChildAt(0));
    L8:
        if (r102 < 0) goto L13;
        if (r111.A2(r102) == true) goto L14;
        r102 = r102 - 1;
    L14:
        this.f442414b = r102;
        if (r102 == (-1)) goto L45;
        ?? r103 = r111.onCreateViewHolder(r101, r111.getItemViewType(r102));
        r111.onBindViewHolder(r103, r102);
        View r104 = r103.itemView;
        if (r104.isLayoutRequested() == false) goto L27;
        RecyclerView.LayoutParams r105 = (RecyclerView.LayoutParams) r104.getLayoutParams();
        if (r105 == null) goto L26;
        int r106 = View.MeasureSpec.makeMeasureSpec((r101.getMeasuredWidth() - ((ViewGroup.MarginLayoutParams) r105).leftMargin) - ((ViewGroup.MarginLayoutParams) r105).rightMargin, 1073741824);
        int r107 = ((ViewGroup.MarginLayoutParams) r105).height;
        if (r107 <= 0) goto L23;
        int r108 = View.MeasureSpec.makeMeasureSpec(r107, 1073741824);
    L24:
        r104.measure(r106, r108);
        r104.layout(0, 0, r104.getMeasuredWidth(), r104.getMeasuredHeight());
        goto L27
    L23:
        r108 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L24
    L26:
        throw new NullPointerException("PinnedHeaderItemDecoration");
    L27:
        int r109 = 0;
        int r112 = 0;
    L29:
        if (r109 >= r101.getChildCount()) goto L37;
        if (r111.A2(r101.getChildAdapterPosition(r101.getChildAt(r109))) == false) goto L36;
        int r113 = r101.getChildAt(r109).getTop();
        int r114 = r104.getHeight();
        if (r113 >= r114) goto L36;
        if (r113 <= 0) goto L36;
        r112 = r113 - r114;
    L36:
        r109 = r109 + 1;
        goto L29
    L37:
        int r115 = r100.save();
        RecyclerView.LayoutParams r116 = (RecyclerView.LayoutParams) r104.getLayoutParams();
        if (r116 == null) goto L44;
        r100.translate(((ViewGroup.MarginLayoutParams) r116).leftMargin, r112);
        r100.clipRect(0, 0, r101.getWidth(), r104.getMeasuredHeight());
        r104.draw(r100);
        r100.restoreToCount(r115);
        if (this.f442413a != null) goto L42;
        this.f442413a = new Rect();
    L42:
        this.f442413a.set(0, 0, r101.getWidth(), r104.getMeasuredHeight() + r112);
        return;
    L44:
        throw new NullPointerException("PinnedHeaderItemDecoration");
    L45:
        this.f442413a = null;
        return;
    L13:
        r102 = -1;
        goto L14
    }
}
