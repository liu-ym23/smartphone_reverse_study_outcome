package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/toolarea/FixedLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FixedLinearLayoutManager extends LinearLayoutManager {
    public FixedLinearLayoutManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, 0, false);
    }

    public final void onLayoutChildren(RecyclerView.Recycler r1, RecyclerView.State r2) {
        super.onLayoutChildren(r1, r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
    }

    public final int scrollHorizontallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        return super.scrollHorizontallyBy(r1, r2, r3);
    L4:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return 0;
    }
}
