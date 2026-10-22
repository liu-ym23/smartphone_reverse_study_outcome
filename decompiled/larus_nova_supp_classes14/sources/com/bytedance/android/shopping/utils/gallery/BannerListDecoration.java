package com.bytedance.android.shopping.utils.gallery;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/utils/gallery/BannerListDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerListDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    public BannerListDecoration(int r1) {
        this.a = r1;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        int r6 = r4.getChildAdapterPosition(r3);
        RecyclerView.Adapter r7 = r4.getAdapter();
        if (r7 == null) goto L5;
        int r8 = r7.getItemCount();
    L6:
        if (r6 != 0) goto L9;
        r2.left = 0;
        r2.right = this.a / 2;
        return;
    L9:
        if (r6 != (r8 - 1)) goto L11;
        r2.left = this.a / 2;
        r2.right = 0;
        return;
    L11:
        int r9 = this.a;
        r2.left = r9 / 2;
        r2.right = r9 / 2;
        return;
    L5:
        r8 = 0;
        goto L6
    }
}
