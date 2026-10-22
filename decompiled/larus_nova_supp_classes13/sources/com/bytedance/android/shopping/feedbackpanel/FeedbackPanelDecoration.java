package com.bytedance.android.shopping.feedbackpanel;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.feedbackpanel.enums.WhereType;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import de3.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/feedbackpanel/FeedbackPanelDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedbackPanelDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final List<c> b;

    public FeedbackPanelDecoration(List<c> r2) {
        Intrinsics.checkNotNullParameter(r2, "itemDataList");
        this.b = r2;
        this.a = com.bytedance.android.shopping.extensions.b.b(8);
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        int r6 = r4.getChildAdapterPosition(r3);
        if (r6 > 0) goto L5;
        return;
    L5:
        if (r6 >= this.b.size()) goto L19;
        c r7 = (c) CollectionsKt.getOrNull(this.b, r6);
        WhereType r8 = null;
        if (r7 == null) goto L9;
        WhereType r9 = r7.d;
    L11:
        if (r9 == WhereType.GROUP_BOTTOM) goto L16;
        if (r7 == null) goto L15;
        r8 = r7.d;
    L15:
        if (r8 == WhereType.GROUP_ONLY_ONE) goto L16;
        return;
    L16:
        r2.bottom = this.a;
        return;
    L9:
        r9 = null;
        goto L11
    }
}
