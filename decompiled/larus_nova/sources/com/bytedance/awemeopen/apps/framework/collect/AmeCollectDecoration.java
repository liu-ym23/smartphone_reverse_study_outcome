package com.bytedance.awemeopen.apps.framework.collect;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/AmeCollectDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AmeCollectDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f193938a;

    public AmeCollectDecoration(int r100) {
        this.f193938a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        RecyclerView.LayoutManager r104 = r102.getLayoutManager();
        GridLayoutManager.LayoutParams r105 = null;
        if ((r104 instanceof GridLayoutManager) == false) goto L5;
        GridLayoutManager r106 = (GridLayoutManager) r104;
    L6:
        if (r106 != null) goto L8;
        return;
    L8:
        ViewGroup.LayoutParams r107 = r101.getLayoutParams();
        if ((r107 instanceof GridLayoutManager.LayoutParams) == false) goto L11;
        r105 = (GridLayoutManager.LayoutParams) r107;
    L11:
        if (r105 != null) goto L13;
        return;
    L13:
        int r108 = r106.getSpanCount();
        if (1 != r105.getSpanSize()) goto L21;
        int r109 = r105.getSpanIndex();
        int r110 = this.f193938a;
        r100.left = (r109 * r110) / r108;
        r100.right = r110 - (((r109 + 1) * r110) / r108);
        if (r102.getChildAdapterPosition(r101) > 2) goto L18;
        int r111 = 0;
    L19:
        r100.top = r111;
        return;
    L18:
        r111 = this.f193938a;
        goto L19
    L21:
        return;
    L5:
        r106 = null;
        goto L6
    }
}
