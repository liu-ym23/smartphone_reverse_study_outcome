package com.larus.community.impl.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003J(\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/community/impl/adapter/LoadingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "<init>", "(II)V", "updateSpanCount", "", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadingItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f328802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f328803b;

    public LoadingItemDecoration(int r100, int r101) {
        this.f328802a = r100;
        this.f328803b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = this.f328802a;
        int r106 = r104 % r105;
        boolean r107 = true;
        if (r106 != 0) goto L6;
        r100.left = 0;
        r100.right = this.f328803b / 2;
    L9:
        if (r104 == 0) goto L12;
        if (r104 == 1) goto L12;
        r100.top = this.f328803b / 2;
    L13:
        RecyclerView.Adapter r108 = r102.getAdapter();
        if (r108 != null) goto L16;
    L18:
        boolean r109 = false;
    L19:
        if (r109 == true) goto L29;
        RecyclerView.Adapter r110 = r102.getAdapter();
        if (r110 != null) goto L23;
    L25:
        r107 = false;
    L26:
        if (r107 == true) goto L29;
        r100.bottom = this.f328803b / 2;
        return;
    L23:
        if (r104 != (r110.getItemCount() - 2)) goto L25;
    L29:
        r100.bottom = 0;
        return;
    L16:
        if (r104 != (r108.getItemCount() - 1)) goto L18;
        r109 = true;
    L12:
        r100.top = 0;
        goto L13
    L6:
        if (r106 != (r105 - 1)) goto L8;
        r100.left = this.f328803b / 2;
        r100.right = 0;
        goto L9
    L8:
        int r111 = this.f328803b;
        r100.left = r111 / 2;
        r100.right = r111 / 2;
        goto L9
    }
}
