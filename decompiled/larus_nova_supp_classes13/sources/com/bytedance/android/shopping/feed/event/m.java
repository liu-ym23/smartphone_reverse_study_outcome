package com.bytedance.android.shopping.feed.event;

import android.view.View;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.BaseCardDetailView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements com.bytedance.android.bst.api.g {
    public final /* synthetic */ PromotionProductStruct a;
    public final /* synthetic */ ProductFeedViewModel b;
    public final /* synthetic */ View c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ Map i;

    public final void a(String r17, Map<Object, ? extends Object> r18) {
        Intrinsics.checkNotNullParameter(r17, "eventName");
        Intrinsics.checkNotNullParameter(r18, "params");
        FeedProductEventTracker.o(FeedProductEventTracker.a, this.b, this.c.getContext(), this.a, this.d, this.e, this.f, this.g, null, this.h, false, this.i, o.a(r18), 512);
    }

    public m(PromotionProductStruct r1, ProductFeedViewModel r2, BaseCardDetailView r3, String r4, String r5, String r6, Map r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = null;
        this.e = r4;
        this.f = true;
        this.g = r5;
        this.h = r6;
        this.i = r7;
    }
}
