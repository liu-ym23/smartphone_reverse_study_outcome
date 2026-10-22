package com.bytedance.awemeopen.apps.framework.profile;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/AmeDecoration2;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AmeDecoration2 extends RecyclerView.ItemDecoration {
    public final int a;

    public AmeDecoration2(int r1) {
        this.a = r1;
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "state");
        GridLayoutManager r7 = r5.getLayoutManager();
        GridLayoutManager.LayoutParams r0 = null;
        if ((r7 instanceof GridLayoutManager) == false) goto L5;
        GridLayoutManager r8 = r7;
    L6:
        if (r8 != null) goto L8;
        return;
    L8:
        ViewGroup.LayoutParams r9 = r4.getLayoutParams();
        if ((r9 instanceof GridLayoutManager.LayoutParams) == false) goto L11;
        r0 = (GridLayoutManager.LayoutParams) r9;
    L11:
        if (r0 != null) goto L13;
        return;
    L13:
        int r10 = r8.getSpanCount();
        if (1 != r0.getSpanSize()) goto L17;
        int r11 = r0.getSpanIndex();
        int r1 = this.a;
        r3.left = (r11 * r1) / r10;
        r3.right = r1 - (((r11 + 1) * r1) / r10);
        r3.top = r1;
        return;
    L17:
        return;
    L5:
        r8 = null;
        goto L6
    }
}
