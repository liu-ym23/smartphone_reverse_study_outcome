package com.bytedance.android.livesdk.livecommerce.iron.category;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryLineaLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryLineaLayoutManager extends LinearLayoutManager {
    public CategoryLineaLayoutManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        if (r1 == null) goto L7;
        Context r4 = r1.getContext();
        if (r4 == null) goto L8;
        CenterSmoothScroller r5 = new CenterSmoothScroller(r4);
        r5.setTargetPosition(r3);
        startSmoothScroll(r5);
        return;
    L8:
        return;
    }
}
