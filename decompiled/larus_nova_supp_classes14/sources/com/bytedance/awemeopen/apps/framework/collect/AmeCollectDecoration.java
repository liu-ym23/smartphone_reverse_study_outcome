package com.bytedance.awemeopen.apps.framework.collect;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/AmeCollectDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AmeCollectDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    public AmeCollectDecoration(int r1) {
        this.a = r1;
    }

    public final void getItemOffsets(Rect r5, View r6, RecyclerView r7, RecyclerView.State r8) {
        Intrinsics.checkNotNullParameter(r5, "outRect");
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r8, "state");
        GridLayoutManager r9 = r7.getLayoutManager();
        GridLayoutManager.LayoutParams r1 = null;
        if ((r9 instanceof GridLayoutManager) == false) goto L5;
        GridLayoutManager r10 = r9;
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if ((r0 instanceof GridLayoutManager.LayoutParams) == false) goto L11;
        r1 = (GridLayoutManager.LayoutParams) r0;
    L11:
        if (r1 != null) goto L13;
        return;
    L13:
        int r11 = r10.getSpanCount();
        if (1 != r1.getSpanSize()) goto L21;
        int r2 = r1.getSpanIndex();
        int r3 = this.a;
        r5.left = (r2 * r3) / r11;
        r5.right = r3 - (((r2 + 1) * r3) / r11);
        if (r7.getChildAdapterPosition(r6) > 2) goto L18;
        int r12 = 0;
    L19:
        r5.top = r12;
        return;
    L18:
        r12 = this.a;
        goto L19
    L21:
        return;
    L5:
        r10 = null;
        goto L6
    }
}
