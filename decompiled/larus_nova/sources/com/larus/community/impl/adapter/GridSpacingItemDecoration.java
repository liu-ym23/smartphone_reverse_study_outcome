package com.larus.community.impl.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/larus/community/impl/adapter/GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "isStaggeredGridLayoutManager", "", "<init>", "(IILjava/lang/Boolean;)V", "Ljava/lang/Boolean;", "updateSpanCount", "", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f328799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f328800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f328801c;

    public GridSpacingItemDecoration(int r100, int r101, Boolean r102) {
        this.f328799a = r100;
        this.f328800b = r101;
        this.f328801c = r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        Boolean r104 = this.f328801c;
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r105) == false) goto L5;
        ViewGroup.LayoutParams r106 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        RecyclerView.LayoutParams r107 = (StaggeredGridLayoutManager.LayoutParams) r106;
    L7:
        if (Intrinsics.areEqual(this.f328801c, r105) == true) goto L9;
        int r108 = r102.getChildAdapterPosition(r101);
        int r109 = this.f328799a;
        int r110 = r108 % r109;
        if (r109 <= 2) goto L30;
        if (r110 != 0) goto L26;
        int r111 = this.f328800b;
        r100.left = r111 / 2;
        r100.right = r111 / 2;
        r100.top = r111 / 2;
        r100.bottom = r111 / 2;
        return;
    L26:
        if (r110 != (r109 - 1)) goto L28;
        int r112 = this.f328800b;
        r100.left = r112 / 2;
        r100.right = r112 / 2;
        r100.top = r112 / 2;
        r100.bottom = r112 / 2;
        return;
    L28:
        int r113 = this.f328800b;
        r100.left = r113 / 2;
        r100.right = r113 / 2;
        r100.top = r113 / 2;
        r100.bottom = r113 / 2;
        return;
    L30:
        if (r110 != 0) goto L32;
        r100.left = 0;
        int r114 = this.f328800b;
        r100.right = r114 / 2;
        r100.top = r114 / 2;
        r100.bottom = r114 / 2;
        return;
    L32:
        int r115 = this.f328800b;
        r100.left = r115 / 2;
        r100.right = 0;
        r100.top = r115 / 2;
        r100.bottom = r115 / 2;
        return;
    L9:
        if (this.f328799a <= 2) goto L18;
        StaggeredGridLayoutManager.LayoutParams r116 = (StaggeredGridLayoutManager.LayoutParams) r107;
        if (r116.getSpanIndex() != 0) goto L14;
        int r117 = this.f328800b;
        r100.left = r117 / 2;
        r100.right = r117 / 2;
        r100.top = r117 / 2;
        r100.bottom = r117 / 2;
        return;
    L14:
        if (r116.getSpanIndex() != (this.f328799a - 1)) goto L16;
        int r118 = this.f328800b;
        r100.left = r118 / 2;
        r100.right = r118 / 2;
        r100.top = r118 / 2;
        r100.bottom = r118 / 2;
        return;
    L16:
        int r119 = this.f328800b;
        r100.left = r119 / 2;
        r100.right = r119 / 2;
        r100.top = r119 / 2;
        r100.bottom = r119 / 2;
        return;
    L18:
        if (((StaggeredGridLayoutManager.LayoutParams) r107).getSpanIndex() != 0) goto L20;
        int r120 = this.f328800b;
        r100.left = r120 / 2;
        r100.right = r120 / 2;
        r100.top = r120 / 2;
        r100.bottom = r120 / 2;
        return;
    L20:
        int r121 = this.f328800b;
        r100.left = r121 / 2;
        r100.right = r121 / 2;
        r100.top = r121 / 2;
        r100.bottom = r121 / 2;
        return;
    L5:
        ViewGroup.LayoutParams r122 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r122, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        r107 = (GridLayoutManager.LayoutParams) r122;
        goto L7
    }
}
