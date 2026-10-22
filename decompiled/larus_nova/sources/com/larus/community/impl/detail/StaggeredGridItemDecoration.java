package com.larus.community.impl.detail;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/community/impl/detail/StaggeredGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "edgeSpacing", "headerSpacing", "<init>", "(IIII)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StaggeredGridItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f329193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f329194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f329195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f329196d;

    public StaggeredGridItemDecoration(int r100, int r101, int r102) {
        this.f329193a = r100;
        this.f329194b = r101;
        this.f329195c = r102;
        this.f329196d = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        ViewGroup.LayoutParams r105 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        StaggeredGridLayoutManager.LayoutParams r106 = (StaggeredGridLayoutManager.LayoutParams) r105;
        if (r104 != 0) goto L5;
    L16:
        int r107 = this.f329196d;
        r100.left = r107;
        r100.right = r107;
        return;
    L5:
        if (r106.isFullSpan() == true) goto L16;
        int r108 = r106.getSpanIndex();
        int r109 = this.f329194b;
        int r110 = r109 / 2;
        if (r108 != 0) goto L11;
        r100.left = this.f329195c;
        r100.right = r110;
    L14:
        r100.top = r109;
        r100.bottom = 0;
        return;
    L11:
        if (r108 != (this.f329193a - 1)) goto L13;
        r100.left = r110;
        r100.right = this.f329195c;
        goto L14
    L13:
        r100.left = r110;
        r100.right = r110;
        goto L14
    }
}
