package com.bytedance.locallife.live.goodsshelves.topbar.view;

import android.view.View;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLocalLifeMultiStoreShelfTopBar f259949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f259950b;

    public a(LiveLocalLifeMultiStoreShelfTopBar r100, String r101) {
        this.f259949a = r100;
        this.f259950b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(r100) == false) goto L5;
        return;
    L5:
        LiveLocalLifeMultiStoreShelfTopBar r101 = this.f259949a;
        String r102 = this.f259950b;
        int r103 = LiveLocalLifeMultiStoreShelfTopBar.f259913g;
        r101.getClass();
        if (r102 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        r102 = "aweme://lynxview/?channel=poi_ng_order_center&is_life_poi=1&bundle=template.js&hide_nav_bar=1&trans_status_bar=1&dynamic=1&use_gecko_first=1&surl=https%3A%2F%2Flf-normal-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Flife%2Fgroupon%2Fresource%2Fpoi_ng_order_center%2Ftemplate.js&page_type_opt=lite_page&enable_lynx_predecode=1&loader_name=forest&opt_sku_tag=1&enter_from=poi_page&enter_method=click_bottom_button&sale_channel=city_groupon.channel_page.default&auto_landing=1&ab_params=permission_keeper_location%2Cpage_related_recommend_product_new_arch%2Clife_service_order_detail_prefetch_optimize&enable_code_cache=1&optimize_v1=4&enable_pad_compat=1&enable_font_scale=0";
    L14:
        LiveLifeSaaSUtil.k().openSchema(r101.getContext(), r102);
        LiveLocalLifeMultiStoreShelfTopBar.a("live_life_order_entrance_click", null);
        return;
    L8:
        if (r102.length() == 0) goto L11;
        r104 = false;
        goto L12
    }
}
