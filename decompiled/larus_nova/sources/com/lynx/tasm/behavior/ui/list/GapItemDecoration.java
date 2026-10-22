package com.lynx.tasm.behavior.ui.list;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes32.dex */
public class GapItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f382579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f382580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f382581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f382582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f382583e;

    public GapItemDecoration() {
        this.f382579a = true;
        this.f382580b = false;
        this.f382581c = 0;
        this.f382582d = 0;
        this.f382583e = 0;
    }

    public final void h(Rect r100, boolean r101, int r102) {
        if (r101 == false) goto L4;
        return;
    L4:
        int r103 = this.f382583e;
        int r104 = this.f382581c;
        int r105 = (r103 * (r104 - 1)) / r104;
        if (r102 != 0) goto L11;
        if (this.f382579a == false) goto L9;
        r100.right = r105;
        return;
    L9:
        r100.bottom = r105;
        return;
    L11:
        if (r102 != (r104 - 1)) goto L17;
        if (this.f382579a == false) goto L15;
        r100.left = r105;
        return;
    L15:
        r100.top = r105;
        return;
    L17:
        if (this.f382579a == false) goto L19;
        int r106 = r105 / 2;
        r100.left = r106;
        r100.right = r106;
        return;
    L19:
        int r107 = r105 / 2;
        r100.top = r107;
        r100.bottom = r107;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        RecyclerView.Adapter r104 = r102.getAdapter();
        RecyclerView.ViewHolder r105 = r102.getChildViewHolder(r101);
        if ((r104 instanceof UIListAdapter) == true) goto L5;
        return;
    L5:
        if ((r105 instanceof ListViewHolder) == false) goto L46;
        UIListAdapter r106 = (UIListAdapter) r104;
        ListViewHolder r107 = (ListViewHolder) r105;
        int r108 = r107.getAdapterPosition();
        boolean r109 = false;
        if (r108 != 0) goto L9;
    L14:
        boolean r110 = true;
    L16:
        if (this.f382579a == false) goto L22;
        if (r110 == false) goto L19;
        int r111 = 0;
    L20:
        r100.top = r111;
    L32:
        if (this.f382581c <= 1) goto L47;
        View r112 = r107.itemView;
        if (r112 == null) goto L48;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if ((r113 instanceof GridLayoutManager.LayoutParams) == false) goto L42;
        GridLayoutManager.LayoutParams r114 = (GridLayoutManager.LayoutParams) r113;
        if (r114.getSpanSize() != this.f382581c) goto L40;
        r109 = true;
    L40:
        h(r100, r109, r114.getSpanIndex());
        return;
    L42:
        if ((r113 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L50;
        StaggeredGridLayoutManager.LayoutParams r115 = (StaggeredGridLayoutManager.LayoutParams) r113;
        h(r100, r115.isFullSpan(), r115.getSpanIndex());
        return;
    L50:
        return;
    L48:
        return;
    L47:
        return;
    L19:
        r111 = this.f382582d;
        goto L20
    L22:
        if (this.f382580b == false) goto L27;
        if (r110 == false) goto L25;
        int r116 = 0;
    L26:
        r100.right = r116;
        goto L32
    L25:
        r116 = this.f382582d;
        goto L26
    L27:
        if (r110 == false) goto L29;
        int r117 = 0;
    L30:
        r100.left = r117;
        goto L32
    L29:
        r117 = this.f382582d;
        goto L30
    L9:
        if (r108 < this.f382581c) goto L11;
    L13:
        r110 = false;
        goto L16
    L11:
        if (r106.B2(r108) != (-1)) goto L13;
    }
}
