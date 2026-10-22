package com.bytedance.android.window.shop.search.presenter;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ WindowSearchResultTopBarPresenter b;

    public o(View r1, WindowSearchResultTopBarPresenter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r9 = ep.a.a;
        Context r10 = this.b.u().c();
        String r0 = this.b.F().getSearchParam().getEnterFromSecond();
        String r1 = this.b.F().getSearchParam().getShopId();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        ep.a.a(r10, r0, r1, "a1.b7881.c59185.d28713");
        this.b.F().doAnyEventActionWithBtm("a1.b7881.c59185.d28713", PageFinder.via(this.a), "photo_search_icon_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("entrance_info", this.b.F().getSearchParam().getEntranceInfo()), TuplesKt.to("current_page", "shop_search_page")}), new Pair[0]);
    }
}
