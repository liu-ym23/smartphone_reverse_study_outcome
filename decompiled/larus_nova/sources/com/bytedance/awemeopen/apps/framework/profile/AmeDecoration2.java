package com.bytedance.awemeopen.apps.framework.profile;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/AmeDecoration2;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AmeDecoration2 extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f197286a;

    public AmeDecoration2(int r100) {
        this.f197286a = r100;
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
        if (1 != r105.getSpanSize()) goto L17;
        int r109 = r105.getSpanIndex();
        int r110 = this.f197286a;
        r100.left = (r109 * r110) / r108;
        r100.right = r110 - (((r109 + 1) * r110) / r108);
        r100.top = r110;
        return;
    L17:
        return;
    L5:
        r106 = null;
        goto L6
    }
}
