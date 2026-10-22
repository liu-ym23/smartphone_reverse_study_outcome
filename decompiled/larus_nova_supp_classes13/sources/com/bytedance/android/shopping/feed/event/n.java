package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.shopping.feed.resourcecard.view.PanelsNodeView;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements com.bytedance.android.bst.api.g {
    public final /* synthetic */ Promotion a;
    public final /* synthetic */ View b;
    public final /* synthetic */ rd3.a c;

    public final void a(String r8, Map<Object, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        Intrinsics.checkNotNullParameter(r9, "params");
        FeedProductEventTracker r10 = FeedProductEventTracker.a;
        Context r1 = this.b.getContext();
        rd3.a r3 = this.c;
        ProductFeedViewModel r2 = r3.c;
        Promotion r4 = this.a;
        Map r6 = o.a(r9);
        r10.getClass();
        FeedProductEventTracker.j(r1, r2, r3, r4, null, r6);
    }

    public n(Promotion r1, PanelsNodeView r2, rd3.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
