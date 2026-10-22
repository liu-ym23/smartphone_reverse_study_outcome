package com.bytedance.android.shopping.searchsimilar.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/view/ProductFrameDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFrameDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;

    public ProductFrameDecoration() {
        this.a = com.bytedance.android.shopping.extensions.b.b(12);
        this.b = com.bytedance.android.shopping.extensions.b.b(16);
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        RecyclerView.Adapter r6 = r4.getAdapter();
        if (r6 == null) goto L5;
        int r7 = r6.getItemCount();
    L6:
        if (r7 != 0) goto L8;
        return;
    L8:
        if (r4.getChildAdapterPosition(r3) != 0) goto L10;
        r2.left = this.b;
        return;
    L10:
        r2.left = this.a;
        if (r4.getChildAdapterPosition(r3) != (r7 - 1)) goto L16;
        r2.right = this.b;
        return;
    L16:
        return;
    L5:
        r7 = 0;
        goto L6
    }
}
