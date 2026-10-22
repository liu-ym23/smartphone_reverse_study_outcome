package com.bytedance.android.shopping.store.home;

import android.view.View;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ ECShopFollowBasePresenter a;
    public final /* synthetic */ String b;

    public m(ECShopFollowBasePresenter r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.T().doEventAction("shop_float_layer_click", new Pair[]{TuplesKt.to("container_type", "native"), TuplesKt.to("text", this.b), TuplesKt.to("module_type", "mall_follow_shop_task")});
        this.a.Q();
    }
}
