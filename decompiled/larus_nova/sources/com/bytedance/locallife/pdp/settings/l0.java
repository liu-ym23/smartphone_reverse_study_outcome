package com.bytedance.locallife.pdp.settings;

import androidx.core.app.NotificationCompat;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.ss.android.ugc.aweme.trade.goods.entity.PoiTradeSettingEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PoiTradeSettingEntity f261737a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f261738b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f261739c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f261740d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f261741e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f261742f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<String> f261743g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<String> f261744h = null;

    static {
        f261737a = (PoiTradeSettingEntity) HostServiceUtilsKt.g0().a("poi_trade_setting", PoiTradeSettingEntity.class, null);
        new String[]{"aweme://lynxview?channel=goodsdetail_groupon_lynx_components&bundle=main_info_group%2Ftemplate.js&dynamic=1&surl=https%3A%2F%2Flf-dy-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Flifeservice%2Fgoodsdetail%2Fgroupon%2Fgoodsdetail_groupon_lynx_components%2Fmain_info_group%2Ftemplate.js&need_loc_permission_prop=1&enable_screen_config_adapter=1", "aweme://lynxview?channel=goodsdetail_presale_lynx_components&bundle=main_info_group%2Ftemplate.js&dynamic=3&surl=https%3A%2F%2Flf-dy-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Flifeservice%2Fgoodsdetail%2Fpresale%2Fgoodsdetail_presale_lynx_components%2Fmain_info_group%2Ftemplate.js&need_loc_permission_prop=1&enable_screen_config_adapter=1", "aweme://lynxview?channel=groupon_lynx_detail_general_components&bundle=clue_main_info%2Ftemplate.js&dynamic=1&surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F1325%2Fgecko%2Fresource%2Fgroupon_lynx_detail_general_components%2Fclue_main_info%2Ftemplate.js&need_loc_permission_prop=1&enable_screen_config_adapter=1", "aweme://lynxview?channel=groupon_lynx_detail_components&bundle=apply_shop%2Ftemplate.js&dynamic=1&surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F1325%2Fgecko%2Fresource%2Fgroupon_lynx_detail_components%2Fapply_shop%2Ftemplate.js", "aweme://lynxview?channel=groupon_lynx_detail_components&bundle=booking_information%2Ftemplate.js&dynamic=1&surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F1325%2Fgecko%2Fresource%2Fgroupon_lynx_detail_components%2Fbooking_information%2Ftemplate.js", "aweme://lynxview?channel=groupon_lynx_detail_components&bundle=detail_pay_footer%2Ftemplate.js&dynamic=1&surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F1325%2Fgecko%2Fresource%2Fgroupon_lynx_detail_components%2Fdetail_pay_footer%2Ftemplate.js", "aweme://lynxview?channel=groupon_lynx_detail_components&bundle=groupon_detail%2Ftemplate.js&dynamic=1&surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F1325%2Fgecko%2Fresource%2Fgroupon_lynx_detail_components%2Fgroupon_detail%2Ftemplate.js", "aweme://lynxview?channel=groupon_lynx_detail_components&bundle=main_info_group%2Ftemplate.js&dynamic=1&surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F1325%2Fgecko%2Fresource%2Fgroupon_lynx_detail_components%2Fmain_info_group%2Ftemplate.js"};
        f261738b = CollectionsKt.listOf(new String[]{"order_id", "detail_page_scene", com.bytedance.android.ec.core.event.a.KEY_SKU_ID, "specify_poi_id", "enter_from", "detail_enter_page", "item_id"});
        f261739c = CollectionsKt.listOf("activity_id");
        f261740d = CollectionsKt.listOf("mainInfoGroup");
        f261741e = "aweme://lynxview?channel=groupon_lynx_detail_components_secondary&bundle=error_view%2Ftemplate.js&dynamic=1&surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fies%2Fdouyin%2Faweme_trade_lynx%2Fgroupon_lynx_detail_components_secondary%2Ferror_view%2Ftemplate.js";
        f261742f = "aweme://lynxview_popup/?channel=groupon_lynx_detail_components_secondary&bundle=agreement%2Ftemplate.js&dynamic=1&surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F1325%2Fgecko%2Fresource%2Fgroupon_lynx_detail_components_secondary%2Fagreement%2Ftemplate.js&height=272&width=280&mask_color=00000057&use_bdx=1&block_back_press=1";
        f261743g = CollectionsKt.listOf("falcon/poi_mwa/trade_detail?");
        f261744h = CollectionsKt.listOf(new String[]{NotificationCompat.CATEGORY_RECOMMENDATION, "d_delivery_empty_place_holder"});
    }

    public static boolean a() {
        PoiTradeSettingEntity r100 = f261737a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r100.h(), Boolean.TRUE);
    }

    public static boolean b() {
        PoiTradeSettingEntity r100 = f261737a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r100.j(), Boolean.TRUE);
    }

    public static boolean c() {
        PoiTradeSettingEntity r100 = f261737a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r100.E(), Boolean.TRUE);
    }

    public static void d() {
        PoiTradeSettingEntity r100 = f261737a;
        if (r100 == null) goto L7;
        Integer r101 = r100.T();
        if (r101 == null) goto L7;
        r101.intValue();
        return;
    L7:
        int r102 = i0.f261733a;
        Integer r103 = (Integer) HostServiceUtilsKt.y().a("number_of_priority_loads", Integer.TYPE, null);
        if (r103 == null) goto L12;
        r103.intValue();
        return;
    }

    public static boolean e() {
        PoiTradeSettingEntity r100 = f261737a;
        if (r100 == null) goto L7;
        Integer r101 = r100.j0();
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L9:
        if (r102 != 1) goto L12;
        return true;
    L12:
        return false;
    L7:
        r102 = 0;
        goto L9
    }
}
