package com.larus.ugc.feed.impl.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/larus/ugc/feed/impl/adapter/GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "isStaggeredGridLayoutManager", "", "<init>", "(IILjava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f374636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f374637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f374638c;

    public GridSpacingItemDecoration(int r100, int r101, Boolean r102) {
        this.f374636a = r100;
        this.f374637b = r101;
        this.f374638c = r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        boolean r104 = true;
        if (Intrinsics.areEqual(this.f374638c, Boolean.TRUE) == false) goto L33;
        ViewGroup.LayoutParams r105 = r101.getLayoutParams();
        if ((r105 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L7;
        StaggeredGridLayoutManager.LayoutParams r106 = (StaggeredGridLayoutManager.LayoutParams) r105;
    L9:
        if (this.f374636a <= 2) goto L25;
        if (r106 != null) goto L12;
    L14:
        boolean r107 = false;
    L15:
        if (r107 == false) goto L17;
        int r108 = this.f374637b;
        r100.left = r108 / 2;
        r100.right = r108 / 2;
        r100.top = r108 / 2;
        r100.bottom = r108 / 2;
        return;
    L17:
        if (r106 != null) goto L19;
    L21:
        r104 = false;
    L22:
        if (r104 == false) goto L24;
        int r109 = this.f374637b;
        r100.left = r109 / 2;
        r100.right = r109 / 2;
        r100.top = r109 / 2;
        r100.bottom = r109 / 2;
        return;
    L24:
        int r110 = this.f374637b;
        r100.left = r110 / 2;
        r100.right = r110 / 2;
        r100.top = r110 / 2;
        r100.bottom = r110 / 2;
        return;
    L19:
        if (r106.getSpanIndex() != (this.f374636a - 1)) goto L21;
    L12:
        if (r106.getSpanIndex() != 0) goto L14;
        r107 = true;
        goto L15
    L25:
        if (r106 != null) goto L27;
    L29:
        r104 = false;
    L30:
        if (r104 == false) goto L32;
        int r111 = this.f374637b;
        r100.left = r111 / 2;
        r100.right = r111 / 2;
        r100.top = r111 / 2;
        r100.bottom = r111 / 2;
        return;
    L32:
        int r112 = this.f374637b;
        r100.left = r112 / 2;
        r100.right = r112 / 2;
        r100.top = r112 / 2;
        r100.bottom = r112 / 2;
        return;
    L27:
        if (r106.getSpanIndex() != 0) goto L29;
    L7:
        r106 = null;
        goto L9
    L33:
        int r113 = r102.getChildAdapterPosition(r101);
        int r114 = this.f374636a;
        int r115 = r113 % r114;
        if (r114 <= 2) goto L41;
        if (r115 != 0) goto L38;
        int r116 = this.f374637b;
        r100.left = r116 / 2;
        r100.right = r116 / 2;
        r100.top = r116 / 2;
        r100.bottom = r116 / 2;
        return;
    L38:
        if (r115 != (r114 - 1)) goto L40;
        int r117 = this.f374637b;
        r100.left = r117 / 2;
        r100.right = r117 / 2;
        r100.top = r117 / 2;
        r100.bottom = r117 / 2;
        return;
    L40:
        int r118 = this.f374637b;
        r100.left = r118 / 2;
        r100.right = r118 / 2;
        r100.top = r118 / 2;
        r100.bottom = r118 / 2;
        return;
    L41:
        if (r115 != 0) goto L43;
        r100.left = 0;
        int r119 = this.f374637b;
        r100.right = r119 / 2;
        r100.top = r119 / 2;
        r100.bottom = r119 / 2;
        return;
    L43:
        int r120 = this.f374637b;
        r100.left = r120 / 2;
        r100.right = 0;
        r100.top = r120 / 2;
        r100.bottom = r120 / 2;
    }
}
