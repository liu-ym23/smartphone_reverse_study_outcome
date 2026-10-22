package com.larus.login.impl.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J(\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J0\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/login/impl/utils/RecyclerViewItemSpacingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemSpace", "Lcom/larus/login/impl/utils/ItemSpace;", "excludeTopBottom", "", "<init>", "(Lcom/larus/login/impl/utils/ItemSpace;Z)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "configGrid", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", GXTemplateKey.FLEXBOX_PADDING, "configStaggeredGrid", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "configGridSpace", "isFullSpan", "isFirstSpan", "isLastSpan", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecyclerViewItemSpacingDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f358304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f358305b;

    public RecyclerViewItemSpacingDecoration(a r100) {
        Intrinsics.checkNotNullParameter(r100, "itemSpace");
        this.f358304a = r100;
        this.f358305b = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        a r104 = this.f358304a;
        boolean r105 = true;
        if (this.f358305b == false) goto L12;
        int r106 = r102.getChildAdapterPosition(r101);
        if (r106 == 0) goto L7;
        r100.top = r104.f358311b;
    L7:
        RecyclerView.Adapter r107 = r102.getAdapter();
        if (r107 != null) goto L10;
    L13:
        RecyclerView.LayoutManager r108 = r102.getLayoutManager();
        if ((r108 instanceof LinearLayoutManager) == false) goto L17;
        r100.left = r104.f358310a;
        r100.right = r104.f358312c;
        return;
    L17:
        if ((r108 instanceof GridLayoutManager) == false) goto L34;
        GridLayoutManager r109 = (GridLayoutManager) r108;
        ViewGroup.LayoutParams r110 = r101.getLayoutParams();
        if ((r110 instanceof GridLayoutManager.LayoutParams) == false) goto L59;
        int r111 = r109.getSpanCount();
        GridLayoutManager.LayoutParams r112 = (GridLayoutManager.LayoutParams) r110;
        if (r112.getSpanSize() != r111) goto L25;
        h(r100, r104, true, false, false);
        return;
    L25:
        if (r112.getSpanIndex() != 0) goto L27;
        boolean r113 = true;
    L29:
        if ((r112.getSpanIndex() + r112.getSpanSize()) == r111) goto L32;
        r105 = false;
    L32:
        h(r100, r104, false, r113, r105);
        return;
    L27:
        r113 = false;
        goto L29
    L59:
        return;
    L34:
        if ((r108 instanceof StaggeredGridLayoutManager) == false) goto L57;
        StaggeredGridLayoutManager r114 = (StaggeredGridLayoutManager) r108;
        ViewGroup.LayoutParams r115 = r101.getLayoutParams();
        if ((r115 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L60;
        StaggeredGridLayoutManager.LayoutParams r116 = (StaggeredGridLayoutManager.LayoutParams) r115;
        if (r116.isFullSpan() == false) goto L41;
    L52:
        h(r100, r104, true, false, false);
        return;
    L41:
        if (r114.getSpanCount() == 1) goto L52;
        if ((r116.getSpanIndex() % r114.getSpanCount()) != 0) goto L46;
        boolean r117 = true;
    L48:
        if ((r116.getSpanIndex() % r114.getSpanCount()) == (r114.getSpanCount() - 1)) goto L51;
        r105 = false;
    L51:
        h(r100, r104, false, r117, r105);
        return;
    L46:
        r117 = false;
        goto L48
    L60:
        return;
    L57:
        return;
    L10:
        if (r106 == (r107.getItemCount() - 1)) goto L13;
        r100.bottom = r104.f358313d;
        goto L13
    L12:
        r100.top = r104.f358311b;
        r100.bottom = r104.f358313d;
        goto L13
    }

    public static void h(Rect r100, a r101, boolean r102, boolean r103, boolean r104) {
        if (r102 == false) goto L5;
        r100.left = r101.f358310a;
        r100.right = r101.f358312c;
        return;
    L5:
        if (r103 == false) goto L7;
        r100.left = r101.f358310a;
    L8:
        if (r104 == false) goto L10;
        r100.right = r101.f358312c;
        return;
    L10:
        r100.right = r101.f358314e / 2;
        return;
    L7:
        r100.left = r101.f358314e / 2;
        goto L8
    }
}
