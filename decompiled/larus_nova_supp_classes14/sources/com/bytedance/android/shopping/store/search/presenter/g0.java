package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0 implements View.OnClickListener {
    public final /* synthetic */ ShopSearchTitlePresenter a;

    public g0(ShopSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        int r7 = zm.d.a;
        zm.d.a(this.a.u().c(), this.a.E().getSearchParam().getEnterFromSecond(), this.a.E().getSearchParam().getShopId(), "a1.b8121.c478706.d46536", null);
        this.a.E().doEventAction("photo_search_icon_click", new Pair[]{TuplesKt.to("entrance_info", this.a.E().getSearchParam().getEntranceInfo()), TuplesKt.to("current_page", "shop_search_page"), TuplesKt.to("btm_id", new BtmItemBuilder("a1.b8121.c478706.d46536", null, 2, null).withPageFinder(PageFinder.via(this.a.y())).obtainEventBtmParams())});
    }
}
