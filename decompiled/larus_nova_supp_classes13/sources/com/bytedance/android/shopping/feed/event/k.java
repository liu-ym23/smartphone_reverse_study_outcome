package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements com.bytedance.android.bst.api.g {
    public final /* synthetic */ Promotion a;
    public final /* synthetic */ View b;
    public final /* synthetic */ rd3.a c;

    public final void a(String r4, Map<Object, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "params");
        FeedProductEventTracker r6 = FeedProductEventTracker.a;
        Context r0 = this.b.getContext();
        rd3.a r1 = this.c;
        Promotion r2 = this.a;
        Map r7 = o.a(r5);
        r6.getClass();
        FeedProductEventTracker.P(r0, r1, r2, null, r7);
    }

    public k(Promotion r1, View r2, rd3.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
