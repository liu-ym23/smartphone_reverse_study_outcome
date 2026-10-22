package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.store.shopfeed.list.AbsShopFeedListAdapter;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedLayoutManager;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedListSnapHelper;
import com.bytedance.common.utility.Logger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final RecyclerView r1, Context r2, String r3, RecyclerView.OnScrollListener r4, AbsShopFeedListAdapter r5, ShopFeedListSnapHelper r6, RecyclerView.ItemDecoration r7) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "onScrollListener");
        Intrinsics.checkNotNullParameter(r5, "adapter");
        Intrinsics.checkNotNullParameter(r6, "snapHelper");
        r1.setLayoutManager(new ShopFeedLayoutManager(r2));
        r1.setItemAnimator(null);
        if (r7 == null) goto L5;
        r1.addItemDecoration(r7);
    L5:
        r1.addOnScrollListener(r4);
        r5.registerAdapterDataObserver(new ShopFeedRecyclerViewInitHelper$$special$$inlined$also$lambda$1(r1));
        Unit r8 = Unit.INSTANCE;
        r1.setAdapter(r5);
        r6.attachToRecyclerView(r1);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Logger.e(r3, "initRecyclerView", e);
        dm.a.b r9 = dm.a.a;
        dm.a.a(r3).b("initRecyclerView attachToRecyclerView error", e);
    }
}
