package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u implements View.OnClickListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ ShopSearchResultTopBarPresenter b;

    public u(View r1, ShopSearchResultTopBarPresenter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r9 = zm.d.a;
        zm.d.a(this.b.u().c(), this.b.F().getSearchParam().getEnterFromSecond(), this.b.F().getSearchParam().getShopId(), "a1.b7881.c59185.d28713", null);
        this.b.F().doAnyEventActionWithBtm("a1.b7881.c59185.d28713", PageFinder.via(this.a), "photo_search_icon_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("entrance_info", this.b.F().getSearchParam().getEntranceInfo()), TuplesKt.to("current_page", "shop_search_page")}), new Pair[0]);
    }
}
