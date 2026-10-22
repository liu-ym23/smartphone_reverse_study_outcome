package com.bytedance.android.shopping.store.status;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.store.status.c;
import com.bytedance.android.ec.store.status.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopAggregatePageLoadingStatusView extends d {
    public final Map<? extends com.bytedance.android.ec.store.status.b, c<? extends View>> a() {
        return MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.store.status.b.c.a, new c(new ECShopAggregatePageLoadingStatusView$provideImpl$1(this), null, 6)));
    }

    public ECShopAggregatePageLoadingStatusView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
