package com.larus.bmhome.miniartifact.listpage.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/adapter/MiniArtifactGridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "<init>", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactGridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f312583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f312584b;

    public MiniArtifactGridSpacingItemDecoration(int r100, int r101) {
        this.f312583a = r100;
        this.f312584b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        StaggeredGridLayoutManager.LayoutParams r105 = (StaggeredGridLayoutManager.LayoutParams) r104;
        if (this.f312583a <= 2) goto L15;
        if (r105.isFullSpan() == false) goto L8;
        r100.left = 0;
        r100.right = 0;
        r100.top = 0;
        r100.bottom = 0;
        return;
    L8:
        if (r105.getSpanIndex() != 0) goto L11;
        int r106 = this.f312584b;
        r100.left = r106 / 2;
        r100.right = r106 / 2;
        r100.top = r106 / 2;
        r100.bottom = r106 / 2;
        return;
    L11:
        if (r105.getSpanIndex() != (this.f312583a - 1)) goto L13;
        int r107 = this.f312584b;
        r100.left = r107 / 2;
        r100.right = r107 / 2;
        r100.top = r107 / 2;
        r100.bottom = r107 / 2;
        return;
    L13:
        int r108 = this.f312584b;
        r100.left = r108 / 2;
        r100.right = r108 / 2;
        r100.top = r108 / 2;
        r100.bottom = r108 / 2;
        return;
    L15:
        if (r105.isFullSpan() == false) goto L18;
        r100.left = 0;
        r100.right = 0;
        r100.top = 0;
        r100.bottom = 0;
        return;
    L18:
        if (r105.getSpanIndex() != 0) goto L20;
        r100.left = 0;
        int r109 = this.f312584b;
        r100.right = r109 / 2;
        r100.top = r109 / 2;
        r100.bottom = r109 / 2;
        return;
    L20:
        int r110 = this.f312584b;
        r100.left = r110 / 2;
        r100.right = 0;
        r100.top = r110 / 2;
        r100.bottom = r110 / 2;
    }
}
