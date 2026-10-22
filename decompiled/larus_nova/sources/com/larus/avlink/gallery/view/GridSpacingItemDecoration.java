package com.larus.avlink.gallery.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/larus/avlink/gallery/view/GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "isStaggeredGridLayoutManager", "", "<init>", "(IILjava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f292873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f292874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f292875c;

    public GridSpacingItemDecoration(int r100, Boolean r101) {
        this.f292873a = 3;
        this.f292874b = r100;
        this.f292875c = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = 0;
        if (r104 >= 0) goto L5;
    L7:
        boolean r106 = false;
    L8:
        Boolean r107 = this.f292875c;
        Boolean r108 = Boolean.TRUE;
        if (Intrinsics.areEqual(r107, r108) == false) goto L11;
        ViewGroup.LayoutParams r109 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        RecyclerView.LayoutParams r110 = (StaggeredGridLayoutManager.LayoutParams) r109;
    L13:
        if (Intrinsics.areEqual(this.f292875c, r108) == true) goto L15;
        int r111 = this.f292873a;
        int r112 = r104 % r111;
        if (r111 <= 2) goto L67;
        if (r112 != 0) goto L56;
        int r113 = this.f292874b;
        r100.left = r113 / 2;
        r100.right = r113 / 2;
        if (r106 == true) goto L54;
        r105 = r113 / 2;
    L54:
        r100.top = r105;
        r100.bottom = r113 / 2;
        return;
    L56:
        if (r112 != (r111 - 1)) goto L62;
        int r114 = this.f292874b;
        r100.left = r114 / 2;
        r100.right = r114 / 2;
        if (r106 == true) goto L61;
        r105 = r114 / 2;
    L61:
        r100.top = r105;
        r100.bottom = r114 / 2;
        return;
    L62:
        int r115 = this.f292874b;
        r100.left = r115 / 2;
        r100.right = r115 / 2;
        if (r106 == true) goto L66;
        r105 = r115 / 2;
    L66:
        r100.top = r105;
        r100.bottom = r115 / 2;
        return;
    L67:
        if (r112 != 0) goto L73;
        r100.left = 0;
        int r116 = this.f292874b;
        r100.right = r116 / 2;
        if (r106 == true) goto L72;
        r105 = r116 / 2;
    L72:
        r100.top = r105;
        r100.bottom = r116 / 2;
        return;
    L73:
        int r117 = this.f292874b;
        r100.left = r117 / 2;
        r100.right = 0;
        if (r106 == true) goto L77;
        r105 = r117 / 2;
    L77:
        r100.top = r105;
        r100.bottom = r117 / 2;
        return;
    L15:
        if (this.f292873a <= 2) goto L36;
        StaggeredGridLayoutManager.LayoutParams r118 = (StaggeredGridLayoutManager.LayoutParams) r110;
        if (r118.getSpanIndex() != 0) goto L24;
        int r119 = this.f292874b;
        r100.left = r119 / 2;
        r100.right = r119 / 2;
        if (r106 == true) goto L22;
        r105 = r119 / 2;
    L22:
        r100.top = r105;
        r100.bottom = r119 / 2;
        return;
    L24:
        if (r118.getSpanIndex() != (this.f292873a - 1)) goto L30;
        int r120 = this.f292874b;
        r100.left = r120 / 2;
        r100.right = r120 / 2;
        if (r106 == true) goto L29;
        r105 = r120 / 2;
    L29:
        r100.top = r105;
        r100.bottom = r120 / 2;
        return;
    L30:
        int r121 = this.f292874b;
        r100.left = r121 / 2;
        r100.right = r121 / 2;
        if (r106 == true) goto L34;
        r105 = r121 / 2;
    L34:
        r100.top = r105;
        r100.bottom = r121 / 2;
        return;
    L36:
        if (((StaggeredGridLayoutManager.LayoutParams) r110).getSpanIndex() != 0) goto L42;
        int r122 = this.f292874b;
        r100.left = r122 / 2;
        r100.right = r122 / 2;
        if (r106 == true) goto L41;
        r105 = r122 / 2;
    L41:
        r100.top = r105;
        r100.bottom = r122 / 2;
        return;
    L42:
        int r123 = this.f292874b;
        r100.left = r123 / 2;
        r100.right = r123 / 2;
        if (r106 == true) goto L46;
        r105 = r123 / 2;
    L46:
        r100.top = r105;
        r100.bottom = r123 / 2;
        return;
    L11:
        ViewGroup.LayoutParams r124 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        r110 = (GridLayoutManager.LayoutParams) r124;
        goto L13
    L5:
        if (r104 >= this.f292873a) goto L7;
        r106 = true;
        goto L8
    }
}
