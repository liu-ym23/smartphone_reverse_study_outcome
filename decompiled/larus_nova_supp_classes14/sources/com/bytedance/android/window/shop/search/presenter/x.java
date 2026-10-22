package com.bytedance.android.window.shop.search.presenter;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ WindowSearchTitlePresenter a;

    public x(WindowSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        int r7 = ep.a.a;
        Context r8 = this.a.u().c();
        String r0 = WindowSearchTitlePresenter.E(this.a).getSearchParam().getEnterFromSecond();
        String r1 = WindowSearchTitlePresenter.E(this.a).getSearchParam().getShopId();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        ep.a.a(r8, r0, r1, "a1.b8121.c478706.d46536");
        WindowSearchTitlePresenter.E(this.a).doEventAction("photo_search_icon_click", "a1.b8121.c478706.d46536", PageFinder.via(this.a.y()), new Pair[]{TuplesKt.to("entrance_info", WindowSearchTitlePresenter.E(this.a).getSearchParam().getEntranceInfo()), TuplesKt.to("current_page", "shop_search_page")});
    }
}
