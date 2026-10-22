package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b2 implements View.OnClickListener {
    public final /* synthetic */ ECShopSliceTopBarPresenter a;

    public b2(ECShopSliceTopBarPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        int r0 = zm.d.a;
        zm.d.a(this.a.u().c(), (String) this.a.T().getStoreParam().getPassThroughParam("enter_from_second"), String.valueOf(this.a.T().getStoreParam().getShopId()), "a1.b6269.c5887.d51683", r7);
        this.a.T().doAnyEventActionWithBtm("a1.b6269.c5887.d51683", PageFinder.via(this.a.y()), "photo_search_icon_click", MapsKt.mapOf(TuplesKt.to("current_page", "shop_search_page")), new Pair[0]);
    }
}
