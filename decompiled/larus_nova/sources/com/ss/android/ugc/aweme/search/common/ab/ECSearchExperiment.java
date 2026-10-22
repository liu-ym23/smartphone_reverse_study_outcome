package com.ss.android.ugc.aweme.search.common.ab;

import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.search.common.ab.host.TradeFastHostSetting;
import com.ss.android.ugc.aweme.search.common.ab.host.TradeHostSetting;
import com.ss.android.ugc.aweme.search.common.ab.host.TradeHostSettingsCacheManger;
import com.ss.android.ugc.aweme.search.common.config.SearchDialogConfig;
import com.ss.android.ugc.aweme.search.common.result.sug.viewholder.slice.settings.EcSearchSliceSugConfig;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostABService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAbility;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import java.util.ArrayList;
import java.util.Map;
import jj4.a;
import jj4.b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ab/ECSearchExperiment;", "", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchExperiment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f451413a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECSearchExperiment f451414b = null;

    private ECSearchExperiment() {
    }

    static {
        f451414b = new ECSearchExperiment();
        f451413a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ecom_photo_search_product_detail_low_price_main_picture", "photo_single"), TuplesKt.to("ecom_photo_search_product_detail_low_price_component", "photo_single"), TuplesKt.to("ecom_photo_search_cart_similar_single", "photo_single"), TuplesKt.to("ecom_photo_search_cart_similar_more", "photo_single"), TuplesKt.to("ecom_photo_search_video_first_card_bottom", "photo_single"), TuplesKt.to("ecom_photo_search_video_inner_trend", "photo_single"), TuplesKt.to("ecom_photo_search_live_bags", "photo_single"), TuplesKt.to("ecom_photo_search_feed_card", "photo_single"), TuplesKt.to("ecom_photo_search_feed_click_more", "photo_single"), TuplesKt.to("ecom_photo_search_shop_window_feed", "photo_single"), TuplesKt.to("ecom_photo_search_shop_feed_bid", "photo_single"), TuplesKt.to("ecom_photo_search_shop_hot_goods", "photo_single"), TuplesKt.to("ecom_photo_search_shop_lower_goods", "photo_single"), TuplesKt.to("product_detail_address_not_support", "photo_single"), TuplesKt.to("product_detail_sold_out", "photo_single"), TuplesKt.to(ECFindSimilarConfig.ENTER_FROM_VALUE, "photo_single"), TuplesKt.to("ecom_photo_search_goods_limit_multi_sku", "photo_single"), TuplesKt.to("ecom_photo_search_goods_limit_single_sku", "photo_single"), TuplesKt.to("ecom_photo_search_out_sale_have_notice", "photo_single"), TuplesKt.to("ecom_photo_search_out_sale_no_notice", "photo_single"), TuplesKt.to("ecom_photo_search_submit_selected_sold_out", "photo_single"), TuplesKt.to("ecom_photo_search_submit_all_sold_out", "photo_single"), TuplesKt.to("ecom_photo_search_live_product_long_press", "photo_single"), TuplesKt.to("ecom_photo_search_video_slide_up", "photo_single"), TuplesKt.to("order_cannot_buy_find_similar", "photo_single")});
    }

    @SettingPanel("氛围色结果区图片默认裁切对齐iOS-电商Sass")
    public static final int a() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = 1;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L167
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L54
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("ec_ambient_result_background_image_scale");     // Catch: Throwable -> L54
        if (r105 != null) goto L9;
    L51:
        Object r106 = null;
    L52:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L54
    L56:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L167
        if (r108 == null) goto L60;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L167
    L60:
        if (Result.m9455isFailureimpl(r107) == false) goto L63;
        r107 = null;
    L63:
        if ((r107 instanceof Integer) == true) goto L65;
        r107 = null;
    L65:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L167
        if (r109 != null) goto L72;
        r103.getClass();     // Catch: Throwable -> L167
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("ec_ambient_result_background_image_scale");     // Catch: Throwable -> L167
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L167
    L72:
        if (r109 != null) goto L177;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L167
    L157:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L167
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L167
        if (r114 == null) goto L162;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L167
    L162:
        if (Result.m9455isFailureimpl(r113) == false) goto L164;
        r113 = r101;
    L164:
        r109 = r113;
    L165:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger.a("ec_ambient_result_background_image_scale", r109);     // Catch: Throwable -> L167
        goto L177
    L180:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L125
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("ec_ambient_result_background_image_scale");     // Catch: Throwable -> L125
        if (r115 != null) goto L80;
    L122:
        Object r116 = null;
    L123:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L125
    L127:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L157
        if (r118 == null) goto L131;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L157
    L131:
        if (Result.m9455isFailureimpl(r117) == false) goto L134;
        r117 = null;
    L134:
        if ((r117 instanceof Integer) == true) goto L136;
        r117 = null;
    L136:
        r113 = (Integer) r117;     // Catch: Throwable -> L157
        if (r113 != null) goto L164;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L157
        if (r119 == null) goto L146;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L157
        if (r120 == null) goto L146;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L157
        if (r121 == null) goto L146;
        Object r122 = r121.a("ec_ambient_result_background_image_scale", r101);     // Catch: Throwable -> L157
    L147:
        if (r122 != null) goto L149;
    L156:
        r109 = r101;
        goto L165
    L149:
        if ((r122 instanceof Integer) == false) goto L152;
        r104 = r122;
    L152:
        Integer r123 = (Integer) r104;     // Catch: Throwable -> L157
        if (r123 == null) goto L156;
        r109 = r123;
        goto L165
    L146:
        r122 = null;
        goto L147
    L80:
        if ((r115 instanceof Integer) == true) goto L82;
        Object r124 = null;
    L83:
        r116 = (Integer) r124;     // Catch: Throwable -> L125
        if (r116 != null) goto L123;
        if ((r115 instanceof Number) == false) goto L110;
        if (Integer.class != Float.class) goto L95;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L125
        if ((r125 instanceof Integer) == true) goto L93;
        r125 = null;
    L93:
        r116 = (Integer) r125;     // Catch: Throwable -> L125
        goto L123
    L95:
        if (Integer.class != Double.class) goto L101;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L125
        if ((r126 instanceof Integer) == true) goto L99;
        r126 = null;
    L99:
        r116 = (Integer) r126;     // Catch: Throwable -> L125
        goto L123
    L101:
        if (Integer.class != Integer.class) goto L104;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L125
        goto L123
    L104:
        if (Integer.class != Long.class) goto L110;
        Long r127 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L125
        if ((r127 instanceof Integer) == true) goto L108;
        r127 = null;
    L108:
        r116 = (Integer) r127;     // Catch: Throwable -> L125
    L110:
        if ((r115 instanceof JSONObject) == false) goto L112;
    L186:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L118
        Object r128 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L118
        if ((r128 instanceof Integer) == true) goto L116;
        r128 = null;
    L116:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L118
    L120:
        r116 = r129;
        if (Result.m9455isFailureimpl(r116) == false) goto L123;
    L118:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L125
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L125
        goto L120
    L112:
        if ((r115 instanceof JSONArray) == false) goto L122;
    L82:
        r124 = r115;
    L125:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L157
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L177:
        return ((Number) r109).intValue();
    L9:
        if ((r105 instanceof Integer) == true) goto L11;
        Object r132 = null;
    L12:
        r106 = (Integer) r132;     // Catch: Throwable -> L54
        if (r106 != null) goto L52;
        if ((r105 instanceof Number) == false) goto L39;
        if (Integer.class != Float.class) goto L24;
        Float r133 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L54
        if ((r133 instanceof Integer) == true) goto L22;
        r133 = null;
    L22:
        r106 = (Integer) r133;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Integer.class != Double.class) goto L30;
        Double r134 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L54
        if ((r134 instanceof Integer) == true) goto L28;
        r134 = null;
    L28:
        r106 = (Integer) r134;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Integer.class != Integer.class) goto L33;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Integer.class != Long.class) goto L39;
        Long r135 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L54
        if ((r135 instanceof Integer) == true) goto L37;
        r135 = null;
    L37:
        r106 = (Integer) r135;     // Catch: Throwable -> L54
    L39:
        if ((r105 instanceof JSONObject) == false) goto L41;
    L178:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L47
        Object r136 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r136 instanceof Integer) == true) goto L45;
        r136 = null;
    L45:
        Object r137 = Result.m9449constructorimpl((Integer) r136);     // Catch: Throwable -> L47
    L49:
        r106 = r137;
        if (Result.m9455isFailureimpl(r106) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L54
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r105 instanceof JSONArray) == false) goto L51;
    L11:
        r132 = r105;
    L54:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L167
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L172;
        EnsureManager.ensureNotReachHere(r142);
    L172:
        if (Result.m9455isFailureimpl(r141) == true) goto L175;
        r101 = r141;
    L175:
        r109 = r101;
        goto L177
    }

    @SettingPanel("修复文搜首刷曝光埋点多报问题")
    public static final int b() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L167
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L54
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("ec_fix_page_scroll_show");     // Catch: Throwable -> L54
        if (r105 != null) goto L9;
    L51:
        Object r106 = null;
    L52:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L54
    L56:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L167
        if (r108 == null) goto L60;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L167
    L60:
        if (Result.m9455isFailureimpl(r107) == false) goto L63;
        r107 = null;
    L63:
        if ((r107 instanceof Integer) == true) goto L65;
        r107 = null;
    L65:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L167
        if (r109 != null) goto L72;
        r103.getClass();     // Catch: Throwable -> L167
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("ec_fix_page_scroll_show");     // Catch: Throwable -> L167
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L167
    L72:
        if (r109 != null) goto L177;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L167
    L157:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L167
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L167
        if (r114 == null) goto L162;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L167
    L162:
        if (Result.m9455isFailureimpl(r113) == false) goto L164;
        r113 = r101;
    L164:
        r109 = r113;
    L165:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger.a("ec_fix_page_scroll_show", r109);     // Catch: Throwable -> L167
        goto L177
    L180:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L125
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("ec_fix_page_scroll_show");     // Catch: Throwable -> L125
        if (r115 != null) goto L80;
    L122:
        Object r116 = null;
    L123:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L125
    L127:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L157
        if (r118 == null) goto L131;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L157
    L131:
        if (Result.m9455isFailureimpl(r117) == false) goto L134;
        r117 = null;
    L134:
        if ((r117 instanceof Integer) == true) goto L136;
        r117 = null;
    L136:
        r113 = (Integer) r117;     // Catch: Throwable -> L157
        if (r113 != null) goto L164;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L157
        if (r119 == null) goto L146;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L157
        if (r120 == null) goto L146;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L157
        if (r121 == null) goto L146;
        Object r122 = r121.a("ec_fix_page_scroll_show", r101);     // Catch: Throwable -> L157
    L147:
        if (r122 != null) goto L149;
    L156:
        r109 = r101;
        goto L165
    L149:
        if ((r122 instanceof Integer) == false) goto L152;
        r104 = r122;
    L152:
        Integer r123 = (Integer) r104;     // Catch: Throwable -> L157
        if (r123 == null) goto L156;
        r109 = r123;
        goto L165
    L146:
        r122 = null;
        goto L147
    L80:
        if ((r115 instanceof Integer) == true) goto L82;
        Object r124 = null;
    L83:
        r116 = (Integer) r124;     // Catch: Throwable -> L125
        if (r116 != null) goto L123;
        if ((r115 instanceof Number) == false) goto L110;
        if (Integer.class != Float.class) goto L95;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L125
        if ((r125 instanceof Integer) == true) goto L93;
        r125 = null;
    L93:
        r116 = (Integer) r125;     // Catch: Throwable -> L125
        goto L123
    L95:
        if (Integer.class != Double.class) goto L101;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L125
        if ((r126 instanceof Integer) == true) goto L99;
        r126 = null;
    L99:
        r116 = (Integer) r126;     // Catch: Throwable -> L125
        goto L123
    L101:
        if (Integer.class != Integer.class) goto L104;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L125
        goto L123
    L104:
        if (Integer.class != Long.class) goto L110;
        Long r127 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L125
        if ((r127 instanceof Integer) == true) goto L108;
        r127 = null;
    L108:
        r116 = (Integer) r127;     // Catch: Throwable -> L125
    L110:
        if ((r115 instanceof JSONObject) == false) goto L112;
    L186:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L118
        Object r128 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L118
        if ((r128 instanceof Integer) == true) goto L116;
        r128 = null;
    L116:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L118
    L120:
        r116 = r129;
        if (Result.m9455isFailureimpl(r116) == false) goto L123;
    L118:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L125
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L125
        goto L120
    L112:
        if ((r115 instanceof JSONArray) == false) goto L122;
    L82:
        r124 = r115;
    L125:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L157
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L177:
        return ((Number) r109).intValue();
    L9:
        if ((r105 instanceof Integer) == true) goto L11;
        Object r132 = null;
    L12:
        r106 = (Integer) r132;     // Catch: Throwable -> L54
        if (r106 != null) goto L52;
        if ((r105 instanceof Number) == false) goto L39;
        if (Integer.class != Float.class) goto L24;
        Float r133 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L54
        if ((r133 instanceof Integer) == true) goto L22;
        r133 = null;
    L22:
        r106 = (Integer) r133;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Integer.class != Double.class) goto L30;
        Double r134 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L54
        if ((r134 instanceof Integer) == true) goto L28;
        r134 = null;
    L28:
        r106 = (Integer) r134;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Integer.class != Integer.class) goto L33;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Integer.class != Long.class) goto L39;
        Long r135 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L54
        if ((r135 instanceof Integer) == true) goto L37;
        r135 = null;
    L37:
        r106 = (Integer) r135;     // Catch: Throwable -> L54
    L39:
        if ((r105 instanceof JSONObject) == false) goto L41;
    L178:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L47
        Object r136 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r136 instanceof Integer) == true) goto L45;
        r136 = null;
    L45:
        Object r137 = Result.m9449constructorimpl((Integer) r136);     // Catch: Throwable -> L47
    L49:
        r106 = r137;
        if (Result.m9455isFailureimpl(r106) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L54
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r105 instanceof JSONArray) == false) goto L51;
    L11:
        r132 = r105;
    L54:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L167
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L172;
        EnsureManager.ensureNotReachHere(r142);
    L172:
        if (Result.m9455isFailureimpl(r141) == true) goto L175;
        r101 = r141;
    L175:
        r109 = r101;
        goto L177
    }

    @SettingPanel("资源preload距离冷启的时间间隔(秒)")
    public static final int c() {
        ITradeSearchHostService r100 = TradeSearch.c(TradeSearch.f453393a);
        Object r101 = 65;
        Object r102 = null;
        if (r100 == null) goto L8;
        ITradeSearchHostAppInfo r103 = r100.getITradeSearchHostAppInfo();
        if (r103 == null) goto L8;
        if (r103.isAweme() != true) goto L8;
    L14:
        int r104 = TradeFastHostSetting.f451421a;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L178
        TradeHostSettingsCacheManger r106 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L178
        r106.getClass();     // Catch: Throwable -> L65
        Object r107 = TradeHostSettingsCacheManger.f451425c.get("ecom_search_marketing_earliest_preload_interval");     // Catch: Throwable -> L65
        if (r107 != null) goto L20;
    L62:
        Object r108 = null;
    L63:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L65
    L67:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L178
        if (r110 == null) goto L71;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L178
    L71:
        if (Result.m9455isFailureimpl(r109) == false) goto L74;
        r109 = null;
    L74:
        if ((r109 instanceof Integer) == true) goto L76;
        r109 = null;
    L76:
        Object r111 = (Integer) r109;     // Catch: Throwable -> L178
        if (r111 != null) goto L83;
        r106.getClass();     // Catch: Throwable -> L178
        Object r112 = TradeHostSettingsCacheManger.f451424b.get("ecom_search_marketing_earliest_preload_interval");     // Catch: Throwable -> L178
        if ((r112 instanceof Integer) == true) goto L82;
        r112 = null;
    L82:
        r111 = (Integer) r112;     // Catch: Throwable -> L178
    L83:
        if (r111 != null) goto L382;
        int r113 = TradeHostSetting.f451422a;     // Catch: Throwable -> L178
    L168:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L178
        Object r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L178
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);     // Catch: Throwable -> L178
        if (r116 == null) goto L173;
        EnsureManager.ensureNotReachHere(r116);     // Catch: Throwable -> L178
    L173:
        if (Result.m9455isFailureimpl(r115) == false) goto L175;
        r115 = r101;
    L175:
        r111 = r115;
    L176:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L178
        TradeHostSettingsCacheManger.a("ecom_search_marketing_earliest_preload_interval", r111);     // Catch: Throwable -> L178
        goto L382
    L372:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L136
        Object r117 = TradeHostSettingsCacheManger.f451425c.get("ecom_search_marketing_earliest_preload_interval");     // Catch: Throwable -> L136
        if (r117 != null) goto L91;
    L133:
        Object r118 = null;
    L134:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L136
    L138:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L168
        if (r120 == null) goto L142;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L168
    L142:
        if (Result.m9455isFailureimpl(r119) == false) goto L145;
        r119 = null;
    L145:
        if ((r119 instanceof Integer) == true) goto L147;
        r119 = null;
    L147:
        r115 = (Integer) r119;     // Catch: Throwable -> L168
        if (r115 != null) goto L175;
        ITradeSearchHostService r121 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L168
        if (r121 == null) goto L157;
        ITradeSearchHostAbility r122 = r121.getITradeSearchHostAbility();     // Catch: Throwable -> L168
        if (r122 == null) goto L157;
        ITradeSearchHostABService r123 = r122.getHostAB();     // Catch: Throwable -> L168
        if (r123 == null) goto L157;
        Object r124 = r123.a("ecom_search_marketing_earliest_preload_interval", r101);     // Catch: Throwable -> L168
    L158:
        if (r124 != null) goto L160;
    L167:
        r111 = r101;
        goto L176
    L160:
        if ((r124 instanceof Integer) == false) goto L163;
        r102 = r124;
    L163:
        Integer r125 = (Integer) r102;     // Catch: Throwable -> L168
        if (r125 == null) goto L167;
        r111 = r125;
        goto L176
    L157:
        r124 = null;
        goto L158
    L91:
        if ((r117 instanceof Integer) == true) goto L93;
        Object r126 = null;
    L94:
        r118 = (Integer) r126;     // Catch: Throwable -> L136
        if (r118 != null) goto L134;
        if ((r117 instanceof Number) == false) goto L121;
        if (Integer.class != Float.class) goto L106;
        Float r127 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L136
        if ((r127 instanceof Integer) == true) goto L104;
        r127 = null;
    L104:
        r118 = (Integer) r127;     // Catch: Throwable -> L136
        goto L134
    L106:
        if (Integer.class != Double.class) goto L112;
        Double r128 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L136
        if ((r128 instanceof Integer) == true) goto L110;
        r128 = null;
    L110:
        r118 = (Integer) r128;     // Catch: Throwable -> L136
        goto L134
    L112:
        if (Integer.class != Integer.class) goto L115;
        r118 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L136
        goto L134
    L115:
        if (Integer.class != Long.class) goto L121;
        Long r129 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L136
        if ((r129 instanceof Integer) == true) goto L119;
        r129 = null;
    L119:
        r118 = (Integer) r129;     // Catch: Throwable -> L136
    L121:
        if ((r117 instanceof JSONObject) == false) goto L123;
    L360:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L129
        Object r130 = TradeSDKSettingsCacheManager.a().fromJson(r117.toString(), Integer.class);     // Catch: Throwable -> L129
        if ((r130 instanceof Integer) == true) goto L127;
        r130 = null;
    L127:
        Object r131 = Result.m9449constructorimpl((Integer) r130);     // Catch: Throwable -> L129
    L131:
        r118 = r131;
        if (Result.m9455isFailureimpl(r118) == false) goto L134;
    L129:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L136
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L136
        goto L131
    L123:
        if ((r117 instanceof JSONArray) == false) goto L133;
    L93:
        r126 = r117;
    L136:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L168
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L168
    L382:
        return ((Number) r111).intValue();
    L20:
        if ((r107 instanceof Integer) == true) goto L22;
        Object r134 = null;
    L23:
        r108 = (Integer) r134;     // Catch: Throwable -> L65
        if (r108 != null) goto L63;
        if ((r107 instanceof Number) == false) goto L50;
        if (Integer.class != Float.class) goto L35;
        Float r135 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L65
        if ((r135 instanceof Integer) == true) goto L33;
        r135 = null;
    L33:
        r108 = (Integer) r135;     // Catch: Throwable -> L65
        goto L63
    L35:
        if (Integer.class != Double.class) goto L41;
        Double r136 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L65
        if ((r136 instanceof Integer) == true) goto L39;
        r136 = null;
    L39:
        r108 = (Integer) r136;     // Catch: Throwable -> L65
        goto L63
    L41:
        if (Integer.class != Integer.class) goto L44;
        r108 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L65
        goto L63
    L44:
        if (Integer.class != Long.class) goto L50;
        Long r137 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L65
        if ((r137 instanceof Integer) == true) goto L48;
        r137 = null;
    L48:
        r108 = (Integer) r137;     // Catch: Throwable -> L65
    L50:
        if ((r107 instanceof JSONObject) == false) goto L52;
    L370:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L58
        Object r138 = TradeSDKSettingsCacheManager.a().fromJson(r107.toString(), Integer.class);     // Catch: Throwable -> L58
        if ((r138 instanceof Integer) == true) goto L56;
        r138 = null;
    L56:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L58
    L60:
        r108 = r139;
        if (Result.m9455isFailureimpl(r108) == false) goto L63;
    L58:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L65
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L65
        goto L60
    L52:
        if ((r107 instanceof JSONArray) == false) goto L62;
    L22:
        r134 = r107;
    L65:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L178
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L178
    L178:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L183;
        EnsureManager.ensureNotReachHere(r144);
    L183:
        if (Result.m9455isFailureimpl(r143) == true) goto L186;
        r101 = r143;
    L186:
        r111 = r101;
    L8:
        ITradeSearchHostService r145 = TradeSearch.b(0);
        if (r145 == null) goto L188;
        ITradeSearchHostAppInfo r146 = r145.getITradeSearchHostAppInfo();
        if (r146 == null) goto L188;
        if (r146.isLegou() == true) goto L14;
    L188:
        int r147 = TradeFastSDKSetting.f451415a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        TradeSDKSettingsCacheManager r149 = TradeSDKSettingsCacheManager.f451417a;     // Catch: Throwable -> L347
        r149.getClass();     // Catch: Throwable -> L239
        Object r150 = TradeSDKSettingsCacheManager.f451419c.get("ecom_search_marketing_earliest_preload_interval");     // Catch: Throwable -> L239
        if (r150 != null) goto L194;
    L236:
        Object r151 = null;
    L237:
        Object r152 = Result.m9449constructorimpl(r151);     // Catch: Throwable -> L239
    L241:
        Throwable r153 = Result.m9452exceptionOrNullimpl(r152);     // Catch: Throwable -> L347
        if (r153 == null) goto L245;
        EnsureManager.ensureNotReachHere(r153);     // Catch: Throwable -> L347
    L245:
        if (Result.m9455isFailureimpl(r152) == false) goto L248;
        r152 = null;
    L248:
        if ((r152 instanceof Integer) == true) goto L250;
        r152 = null;
    L250:
        Object r154 = (Integer) r152;     // Catch: Throwable -> L347
        if (r154 != null) goto L257;
        r149.getClass();     // Catch: Throwable -> L347
        Object r155 = TradeSDKSettingsCacheManager.f451418b.get("ecom_search_marketing_earliest_preload_interval");     // Catch: Throwable -> L347
        if ((r155 instanceof Integer) == true) goto L256;
        r155 = null;
    L256:
        r154 = (Integer) r155;     // Catch: Throwable -> L347
    L257:
        if (r154 != null) goto L357;
        int r156 = TradeSDKSetting.f451416a;     // Catch: Throwable -> L347
    L336:
        th = move-exception;
        Result.Companion r157 = Result.Companion;     // Catch: Throwable -> L347
        Object r158 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L338:
        Throwable r159 = Result.m9452exceptionOrNullimpl(r158);     // Catch: Throwable -> L347
        if (r159 == null) goto L342;
        EnsureManager.ensureNotReachHere(r159);     // Catch: Throwable -> L347
    L342:
        if (Result.m9455isFailureimpl(r158) == false) goto L344;
        r154 = r101;
    L345:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L347
        TradeSDKSettingsCacheManager.b("ecom_search_marketing_earliest_preload_interval", r154);     // Catch: Throwable -> L347
        goto L357
    L344:
        r154 = r158;
        goto L345
    L358:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L310
        Object r160 = TradeSDKSettingsCacheManager.f451419c.get("ecom_search_marketing_earliest_preload_interval");     // Catch: Throwable -> L310
        if (r160 != null) goto L265;
    L307:
        Object r161 = null;
    L308:
        Object r162 = Result.m9449constructorimpl(r161);     // Catch: Throwable -> L310
    L312:
        Throwable r163 = Result.m9452exceptionOrNullimpl(r162);     // Catch: Throwable -> L336
        if (r163 == null) goto L316;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L336
    L316:
        if (Result.m9455isFailureimpl(r162) == false) goto L319;
        r162 = null;
    L319:
        if ((r162 instanceof Integer) == true) goto L321;
        r162 = null;
    L321:
        Integer r164 = (Integer) r162;     // Catch: Throwable -> L336
        if (r164 == null) goto L324;
        r154 = r164;
        goto L345
    L324:
        b r165 = b.f499326b;     // Catch: Throwable -> L336
        Object r166 = a.a("ecom_search_marketing_earliest_preload_interval", Integer.class, r101, false);     // Catch: Throwable -> L336
        if (r166 != null) goto L328;
        Intrinsics.throwNpe();     // Catch: Throwable -> L336
    L328:
        if ((r166 instanceof Integer) == false) goto L331;
        r102 = r166;
    L331:
        Object r167 = (Integer) r102;     // Catch: Throwable -> L336
        if (r167 != null) goto L334;
        r167 = r101;
    L334:
        r158 = Result.m9449constructorimpl(r167);     // Catch: Throwable -> L336
    L265:
        if ((r160 instanceof Integer) == true) goto L267;
        Object r168 = null;
    L268:
        r161 = (Integer) r168;     // Catch: Throwable -> L310
        if (r161 != null) goto L308;
        if ((r160 instanceof Number) == false) goto L295;
        if (Integer.class != Float.class) goto L280;
        Float r169 = Float.valueOf(((Number) r160).floatValue());     // Catch: Throwable -> L310
        if ((r169 instanceof Integer) == true) goto L278;
        r169 = null;
    L278:
        r161 = (Integer) r169;     // Catch: Throwable -> L310
        goto L308
    L280:
        if (Integer.class != Double.class) goto L286;
        Double r170 = Double.valueOf(((Number) r160).doubleValue());     // Catch: Throwable -> L310
        if ((r170 instanceof Integer) == true) goto L284;
        r170 = null;
    L284:
        r161 = (Integer) r170;     // Catch: Throwable -> L310
        goto L308
    L286:
        if (Integer.class != Integer.class) goto L289;
        r161 = Integer.valueOf(((Number) r160).intValue());     // Catch: Throwable -> L310
        goto L308
    L289:
        if (Integer.class != Long.class) goto L295;
        Long r171 = Long.valueOf(((Number) r160).longValue());     // Catch: Throwable -> L310
        if ((r171 instanceof Integer) == true) goto L293;
        r171 = null;
    L293:
        r161 = (Integer) r171;     // Catch: Throwable -> L310
    L295:
        if ((r160 instanceof JSONObject) == false) goto L297;
    L368:
        Object r172 = TradeSDKSettingsCacheManager.a().fromJson(r160.toString(), Integer.class);     // Catch: Throwable -> L303
        if ((r172 instanceof Integer) == true) goto L301;
        r172 = null;
    L301:
        Object r173 = Result.m9449constructorimpl((Integer) r172);     // Catch: Throwable -> L303
    L305:
        r161 = r173;
        if (Result.m9455isFailureimpl(r161) == false) goto L308;
    L303:
        th = move-exception;
        Result.Companion r174 = Result.Companion;     // Catch: Throwable -> L310
        r173 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L310
        goto L305
    L297:
        if ((r160 instanceof JSONArray) == false) goto L307;
    L267:
        r168 = r160;
    L310:
        th = move-exception;
        Result.Companion r175 = Result.Companion;     // Catch: Throwable -> L336
        r162 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L336
    L357:
        return ((Number) r154).intValue();
    L194:
        if ((r150 instanceof Integer) == true) goto L196;
        Object r176 = null;
    L197:
        r151 = (Integer) r176;     // Catch: Throwable -> L239
        if (r151 != null) goto L237;
        if ((r150 instanceof Number) == false) goto L224;
        if (Integer.class != Float.class) goto L209;
        Float r177 = Float.valueOf(((Number) r150).floatValue());     // Catch: Throwable -> L239
        if ((r177 instanceof Integer) == true) goto L207;
        r177 = null;
    L207:
        r151 = (Integer) r177;     // Catch: Throwable -> L239
        goto L237
    L209:
        if (Integer.class != Double.class) goto L215;
        Double r178 = Double.valueOf(((Number) r150).doubleValue());     // Catch: Throwable -> L239
        if ((r178 instanceof Integer) == true) goto L213;
        r178 = null;
    L213:
        r151 = (Integer) r178;     // Catch: Throwable -> L239
        goto L237
    L215:
        if (Integer.class != Integer.class) goto L218;
        r151 = Integer.valueOf(((Number) r150).intValue());     // Catch: Throwable -> L239
        goto L237
    L218:
        if (Integer.class != Long.class) goto L224;
        Long r179 = Long.valueOf(((Number) r150).longValue());     // Catch: Throwable -> L239
        if ((r179 instanceof Integer) == true) goto L222;
        r179 = null;
    L222:
        r151 = (Integer) r179;     // Catch: Throwable -> L239
    L224:
        if ((r150 instanceof JSONObject) == false) goto L226;
    L366:
        Object r180 = TradeSDKSettingsCacheManager.a().fromJson(r150.toString(), Integer.class);     // Catch: Throwable -> L232
        if ((r180 instanceof Integer) == true) goto L230;
        r180 = null;
    L230:
        Object r181 = Result.m9449constructorimpl((Integer) r180);     // Catch: Throwable -> L232
    L234:
        r151 = r181;
        if (Result.m9455isFailureimpl(r151) == false) goto L237;
    L232:
        th = move-exception;
        Result.Companion r182 = Result.Companion;     // Catch: Throwable -> L239
        r181 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L239
        goto L234
    L226:
        if ((r150 instanceof JSONArray) == false) goto L236;
    L196:
        r176 = r150;
    L239:
        th = move-exception;
        Result.Companion r183 = Result.Companion;     // Catch: Throwable -> L347
        r152 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r184 = Result.Companion;
        Object r185 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r186 = Result.m9452exceptionOrNullimpl(r185);
        if (r186 == null) goto L352;
        EnsureManager.ensureNotReachHere(r186);
    L352:
        if (Result.m9455isFailureimpl(r185) == true) goto L355;
        r101 = r185;
    L355:
        r154 = r101;
        goto L357
    }

    @SettingPanel("商搜商品页首屏加载数量")
    public static final int d() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = 10;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L167
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L54
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("search_commodity_first_load_count");     // Catch: Throwable -> L54
        if (r105 != null) goto L9;
    L51:
        Object r106 = null;
    L52:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L54
    L56:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L167
        if (r108 == null) goto L60;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L167
    L60:
        if (Result.m9455isFailureimpl(r107) == false) goto L63;
        r107 = null;
    L63:
        if ((r107 instanceof Integer) == true) goto L65;
        r107 = null;
    L65:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L167
        if (r109 != null) goto L72;
        r103.getClass();     // Catch: Throwable -> L167
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("search_commodity_first_load_count");     // Catch: Throwable -> L167
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L167
    L72:
        if (r109 != null) goto L177;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L167
    L157:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L167
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L167
        if (r114 == null) goto L162;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L167
    L162:
        if (Result.m9455isFailureimpl(r113) == false) goto L164;
        r113 = r101;
    L164:
        r109 = r113;
    L165:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger.a("search_commodity_first_load_count", r109);     // Catch: Throwable -> L167
        goto L177
    L180:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L125
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("search_commodity_first_load_count");     // Catch: Throwable -> L125
        if (r115 != null) goto L80;
    L122:
        Object r116 = null;
    L123:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L125
    L127:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L157
        if (r118 == null) goto L131;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L157
    L131:
        if (Result.m9455isFailureimpl(r117) == false) goto L134;
        r117 = null;
    L134:
        if ((r117 instanceof Integer) == true) goto L136;
        r117 = null;
    L136:
        r113 = (Integer) r117;     // Catch: Throwable -> L157
        if (r113 != null) goto L164;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L157
        if (r119 == null) goto L146;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L157
        if (r120 == null) goto L146;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L157
        if (r121 == null) goto L146;
        Object r122 = r121.a("search_commodity_first_load_count", r101);     // Catch: Throwable -> L157
    L147:
        if (r122 != null) goto L149;
    L156:
        r109 = r101;
        goto L165
    L149:
        if ((r122 instanceof Integer) == false) goto L152;
        r104 = r122;
    L152:
        Integer r123 = (Integer) r104;     // Catch: Throwable -> L157
        if (r123 == null) goto L156;
        r109 = r123;
        goto L165
    L146:
        r122 = null;
        goto L147
    L80:
        if ((r115 instanceof Integer) == true) goto L82;
        Object r124 = null;
    L83:
        r116 = (Integer) r124;     // Catch: Throwable -> L125
        if (r116 != null) goto L123;
        if ((r115 instanceof Number) == false) goto L110;
        if (Integer.class != Float.class) goto L95;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L125
        if ((r125 instanceof Integer) == true) goto L93;
        r125 = null;
    L93:
        r116 = (Integer) r125;     // Catch: Throwable -> L125
        goto L123
    L95:
        if (Integer.class != Double.class) goto L101;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L125
        if ((r126 instanceof Integer) == true) goto L99;
        r126 = null;
    L99:
        r116 = (Integer) r126;     // Catch: Throwable -> L125
        goto L123
    L101:
        if (Integer.class != Integer.class) goto L104;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L125
        goto L123
    L104:
        if (Integer.class != Long.class) goto L110;
        Long r127 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L125
        if ((r127 instanceof Integer) == true) goto L108;
        r127 = null;
    L108:
        r116 = (Integer) r127;     // Catch: Throwable -> L125
    L110:
        if ((r115 instanceof JSONObject) == false) goto L112;
    L186:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L118
        Object r128 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L118
        if ((r128 instanceof Integer) == true) goto L116;
        r128 = null;
    L116:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L118
    L120:
        r116 = r129;
        if (Result.m9455isFailureimpl(r116) == false) goto L123;
    L118:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L125
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L125
        goto L120
    L112:
        if ((r115 instanceof JSONArray) == false) goto L122;
    L82:
        r124 = r115;
    L125:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L157
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L177:
        return ((Number) r109).intValue();
    L9:
        if ((r105 instanceof Integer) == true) goto L11;
        Object r132 = null;
    L12:
        r106 = (Integer) r132;     // Catch: Throwable -> L54
        if (r106 != null) goto L52;
        if ((r105 instanceof Number) == false) goto L39;
        if (Integer.class != Float.class) goto L24;
        Float r133 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L54
        if ((r133 instanceof Integer) == true) goto L22;
        r133 = null;
    L22:
        r106 = (Integer) r133;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Integer.class != Double.class) goto L30;
        Double r134 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L54
        if ((r134 instanceof Integer) == true) goto L28;
        r134 = null;
    L28:
        r106 = (Integer) r134;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Integer.class != Integer.class) goto L33;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Integer.class != Long.class) goto L39;
        Long r135 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L54
        if ((r135 instanceof Integer) == true) goto L37;
        r135 = null;
    L37:
        r106 = (Integer) r135;     // Catch: Throwable -> L54
    L39:
        if ((r105 instanceof JSONObject) == false) goto L41;
    L178:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L47
        Object r136 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r136 instanceof Integer) == true) goto L45;
        r136 = null;
    L45:
        Object r137 = Result.m9449constructorimpl((Integer) r136);     // Catch: Throwable -> L47
    L49:
        r106 = r137;
        if (Result.m9455isFailureimpl(r106) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L54
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r105 instanceof JSONArray) == false) goto L51;
    L11:
        r132 = r105;
    L54:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L167
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L172;
        EnsureManager.ensureNotReachHere(r142);
    L172:
        if (Result.m9455isFailureimpl(r141) == true) goto L175;
        r101 = r141;
    L175:
        r109 = r101;
        goto L177
    }

    @SettingPanel("电商搜索Server读取测试，服务端实验")
    public static final TradeSearchServerABTest e() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = null;
        Object r102 = new TradeSearchServerABTest(0, 1, null);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L172
        TradeHostSettingsCacheManger r104 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L172
        r104.getClass();     // Catch: Throwable -> L56
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("ec_search_saas_server_ab_test");     // Catch: Throwable -> L56
        if (r105 != null) goto L8;
    L53:
        Object r106 = null;
    L54:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L56
    L58:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L172
        if (r108 == null) goto L62;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L172
    L62:
        if (Result.m9455isFailureimpl(r107) == false) goto L65;
        r107 = null;
    L65:
        if ((r107 instanceof TradeSearchServerABTest) == true) goto L67;
        r107 = null;
    L67:
        Object r109 = (TradeSearchServerABTest) r107;     // Catch: Throwable -> L172
        if (r109 != null) goto L74;
        r104.getClass();     // Catch: Throwable -> L172
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("ec_search_saas_server_ab_test");     // Catch: Throwable -> L172
        if ((r110 instanceof TradeSearchServerABTest) == true) goto L73;
        r110 = null;
    L73:
        r109 = (TradeSearchServerABTest) r110;     // Catch: Throwable -> L172
    L74:
        if (r109 != null) goto L182;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L172
    L162:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L172
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L172
        if (r114 == null) goto L167;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L172
    L167:
        if (Result.m9455isFailureimpl(r113) == false) goto L169;
        r113 = r102;
    L169:
        r109 = r113;
    L170:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L172
        TradeHostSettingsCacheManger.a("ec_search_saas_server_ab_test", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L130
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("ec_search_saas_server_ab_test");     // Catch: Throwable -> L130
        if (r115 != null) goto L82;
    L127:
        Object r116 = null;
    L128:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L130
    L132:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L162
        if (r118 == null) goto L136;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L162
    L136:
        if (Result.m9455isFailureimpl(r117) == false) goto L139;
        r117 = null;
    L139:
        if ((r117 instanceof TradeSearchServerABTest) == true) goto L141;
        r117 = null;
    L141:
        r113 = (TradeSearchServerABTest) r117;     // Catch: Throwable -> L162
        if (r113 != null) goto L169;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L162
        if (r119 == null) goto L151;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L162
        if (r120 == null) goto L151;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L162
        if (r121 == null) goto L151;
        Object r122 = r121.a("ec_search_saas_server_ab_test", r102);     // Catch: Throwable -> L162
    L152:
        if (r122 != null) goto L154;
    L161:
        r109 = r102;
        goto L170
    L154:
        if ((r122 instanceof TradeSearchServerABTest) == false) goto L157;
        r101 = r122;
    L157:
        TradeSearchServerABTest r123 = (TradeSearchServerABTest) r101;     // Catch: Throwable -> L162
        if (r123 == null) goto L161;
        r109 = r123;
        goto L170
    L151:
        r122 = null;
        goto L152
    L82:
        if ((r115 instanceof TradeSearchServerABTest) == true) goto L84;
        Object r124 = null;
    L85:
        r116 = (TradeSearchServerABTest) r124;     // Catch: Throwable -> L130
        if (r116 != null) goto L128;
        if ((r115 instanceof Number) == false) goto L115;
        if (TradeSearchServerABTest.class != Float.class) goto L97;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L130
        if ((r125 instanceof TradeSearchServerABTest) == true) goto L95;
        r125 = null;
    L95:
        r116 = (TradeSearchServerABTest) r125;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (TradeSearchServerABTest.class != Double.class) goto L103;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L130
        if ((r126 instanceof TradeSearchServerABTest) == true) goto L101;
        r126 = null;
    L101:
        r116 = (TradeSearchServerABTest) r126;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (TradeSearchServerABTest.class != Integer.class) goto L109;
        Integer r127 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L130
        if ((r127 instanceof TradeSearchServerABTest) == true) goto L107;
        r127 = null;
    L107:
        r116 = (TradeSearchServerABTest) r127;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (TradeSearchServerABTest.class != Long.class) goto L115;
        Long r128 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L130
        if ((r128 instanceof TradeSearchServerABTest) == true) goto L113;
        r128 = null;
    L113:
        r116 = (TradeSearchServerABTest) r128;     // Catch: Throwable -> L130
    L115:
        if ((r115 instanceof JSONObject) == false) goto L117;
    L193:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L123
        Object r129 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), TradeSearchServerABTest.class);     // Catch: Throwable -> L123
        if ((r129 instanceof TradeSearchServerABTest) == true) goto L121;
        r129 = null;
    L121:
        Object r130 = Result.m9449constructorimpl((TradeSearchServerABTest) r129);     // Catch: Throwable -> L123
    L125:
        r116 = r130;
        if (Result.m9455isFailureimpl(r116) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L130
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r115 instanceof JSONArray) == false) goto L127;
    L84:
        r124 = r115;
    L130:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L162
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L162
    L182:
        return (TradeSearchServerABTest) r109;
    L8:
        if ((r105 instanceof TradeSearchServerABTest) == true) goto L10;
        Object r133 = null;
    L11:
        r106 = (TradeSearchServerABTest) r133;     // Catch: Throwable -> L56
        if (r106 != null) goto L54;
        if ((r105 instanceof Number) == false) goto L41;
        if (TradeSearchServerABTest.class != Float.class) goto L23;
        Float r134 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L56
        if ((r134 instanceof TradeSearchServerABTest) == true) goto L21;
        r134 = null;
    L21:
        r106 = (TradeSearchServerABTest) r134;     // Catch: Throwable -> L56
        goto L54
    L23:
        if (TradeSearchServerABTest.class != Double.class) goto L29;
        Double r135 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L56
        if ((r135 instanceof TradeSearchServerABTest) == true) goto L27;
        r135 = null;
    L27:
        r106 = (TradeSearchServerABTest) r135;     // Catch: Throwable -> L56
        goto L54
    L29:
        if (TradeSearchServerABTest.class != Integer.class) goto L35;
        Integer r136 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L56
        if ((r136 instanceof TradeSearchServerABTest) == true) goto L33;
        r136 = null;
    L33:
        r106 = (TradeSearchServerABTest) r136;     // Catch: Throwable -> L56
        goto L54
    L35:
        if (TradeSearchServerABTest.class != Long.class) goto L41;
        Long r137 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L56
        if ((r137 instanceof TradeSearchServerABTest) == true) goto L39;
        r137 = null;
    L39:
        r106 = (TradeSearchServerABTest) r137;     // Catch: Throwable -> L56
    L41:
        if ((r105 instanceof JSONObject) == false) goto L43;
    L191:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L49
        Object r138 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), TradeSearchServerABTest.class);     // Catch: Throwable -> L49
        if ((r138 instanceof TradeSearchServerABTest) == true) goto L47;
        r138 = null;
    L47:
        Object r139 = Result.m9449constructorimpl((TradeSearchServerABTest) r138);     // Catch: Throwable -> L49
    L51:
        r106 = r139;
        if (Result.m9455isFailureimpl(r106) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L56
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r105 instanceof JSONArray) == false) goto L53;
    L10:
        r133 = r105;
    L56:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L172
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L177;
        EnsureManager.ensureNotReachHere(r144);
    L177:
        if (Result.m9455isFailureimpl(r143) == true) goto L180;
        r102 = r143;
    L180:
        r109 = r102;
        goto L182
    }

    @SettingPanel("商搜商品页吸顶优化")
    public static final int f() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L167
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L54
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("search_commodity_sticky_optimize");     // Catch: Throwable -> L54
        if (r105 != null) goto L9;
    L51:
        Object r106 = null;
    L52:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L54
    L56:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L167
        if (r108 == null) goto L60;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L167
    L60:
        if (Result.m9455isFailureimpl(r107) == false) goto L63;
        r107 = null;
    L63:
        if ((r107 instanceof Integer) == true) goto L65;
        r107 = null;
    L65:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L167
        if (r109 != null) goto L72;
        r103.getClass();     // Catch: Throwable -> L167
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("search_commodity_sticky_optimize");     // Catch: Throwable -> L167
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L167
    L72:
        if (r109 != null) goto L177;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L167
    L157:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L167
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L167
        if (r114 == null) goto L162;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L167
    L162:
        if (Result.m9455isFailureimpl(r113) == false) goto L164;
        r113 = r101;
    L164:
        r109 = r113;
    L165:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger.a("search_commodity_sticky_optimize", r109);     // Catch: Throwable -> L167
        goto L177
    L180:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L125
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("search_commodity_sticky_optimize");     // Catch: Throwable -> L125
        if (r115 != null) goto L80;
    L122:
        Object r116 = null;
    L123:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L125
    L127:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L157
        if (r118 == null) goto L131;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L157
    L131:
        if (Result.m9455isFailureimpl(r117) == false) goto L134;
        r117 = null;
    L134:
        if ((r117 instanceof Integer) == true) goto L136;
        r117 = null;
    L136:
        r113 = (Integer) r117;     // Catch: Throwable -> L157
        if (r113 != null) goto L164;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L157
        if (r119 == null) goto L146;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L157
        if (r120 == null) goto L146;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L157
        if (r121 == null) goto L146;
        Object r122 = r121.a("search_commodity_sticky_optimize", r101);     // Catch: Throwable -> L157
    L147:
        if (r122 != null) goto L149;
    L156:
        r109 = r101;
        goto L165
    L149:
        if ((r122 instanceof Integer) == false) goto L152;
        r104 = r122;
    L152:
        Integer r123 = (Integer) r104;     // Catch: Throwable -> L157
        if (r123 == null) goto L156;
        r109 = r123;
        goto L165
    L146:
        r122 = null;
        goto L147
    L80:
        if ((r115 instanceof Integer) == true) goto L82;
        Object r124 = null;
    L83:
        r116 = (Integer) r124;     // Catch: Throwable -> L125
        if (r116 != null) goto L123;
        if ((r115 instanceof Number) == false) goto L110;
        if (Integer.class != Float.class) goto L95;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L125
        if ((r125 instanceof Integer) == true) goto L93;
        r125 = null;
    L93:
        r116 = (Integer) r125;     // Catch: Throwable -> L125
        goto L123
    L95:
        if (Integer.class != Double.class) goto L101;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L125
        if ((r126 instanceof Integer) == true) goto L99;
        r126 = null;
    L99:
        r116 = (Integer) r126;     // Catch: Throwable -> L125
        goto L123
    L101:
        if (Integer.class != Integer.class) goto L104;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L125
        goto L123
    L104:
        if (Integer.class != Long.class) goto L110;
        Long r127 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L125
        if ((r127 instanceof Integer) == true) goto L108;
        r127 = null;
    L108:
        r116 = (Integer) r127;     // Catch: Throwable -> L125
    L110:
        if ((r115 instanceof JSONObject) == false) goto L112;
    L186:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L118
        Object r128 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L118
        if ((r128 instanceof Integer) == true) goto L116;
        r128 = null;
    L116:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L118
    L120:
        r116 = r129;
        if (Result.m9455isFailureimpl(r116) == false) goto L123;
    L118:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L125
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L125
        goto L120
    L112:
        if ((r115 instanceof JSONArray) == false) goto L122;
    L82:
        r124 = r115;
    L125:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L157
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L177:
        return ((Number) r109).intValue();
    L9:
        if ((r105 instanceof Integer) == true) goto L11;
        Object r132 = null;
    L12:
        r106 = (Integer) r132;     // Catch: Throwable -> L54
        if (r106 != null) goto L52;
        if ((r105 instanceof Number) == false) goto L39;
        if (Integer.class != Float.class) goto L24;
        Float r133 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L54
        if ((r133 instanceof Integer) == true) goto L22;
        r133 = null;
    L22:
        r106 = (Integer) r133;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Integer.class != Double.class) goto L30;
        Double r134 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L54
        if ((r134 instanceof Integer) == true) goto L28;
        r134 = null;
    L28:
        r106 = (Integer) r134;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Integer.class != Integer.class) goto L33;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Integer.class != Long.class) goto L39;
        Long r135 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L54
        if ((r135 instanceof Integer) == true) goto L37;
        r135 = null;
    L37:
        r106 = (Integer) r135;     // Catch: Throwable -> L54
    L39:
        if ((r105 instanceof JSONObject) == false) goto L41;
    L178:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L47
        Object r136 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r136 instanceof Integer) == true) goto L45;
        r136 = null;
    L45:
        Object r137 = Result.m9449constructorimpl((Integer) r136);     // Catch: Throwable -> L47
    L49:
        r106 = r137;
        if (Result.m9455isFailureimpl(r106) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L54
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r105 instanceof JSONArray) == false) goto L51;
    L11:
        r132 = r105;
    L54:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L167
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L172;
        EnsureManager.ensureNotReachHere(r142);
    L172:
        if (Result.m9455isFailureimpl(r141) == true) goto L175;
        r101 = r141;
    L175:
        r109 = r101;
        goto L177
    }

    @SettingPanel("七分屏增加开关配置")
    public static final SearchDialogConfig g() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = new SearchDialogConfig();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L173
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L173
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L57
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("ec_search_saas_dialog_config");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L173
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L173
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof SearchDialogConfig) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (SearchDialogConfig) r107;     // Catch: Throwable -> L173
        if (r109 != null) goto L75;
        r103.getClass();     // Catch: Throwable -> L173
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("ec_search_saas_dialog_config");     // Catch: Throwable -> L173
        if ((r110 instanceof SearchDialogConfig) == true) goto L74;
        r110 = null;
    L74:
        r109 = (SearchDialogConfig) r110;     // Catch: Throwable -> L173
    L75:
        if (r109 != null) goto L183;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L173
    L163:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L173
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L173
        if (r114 == null) goto L168;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L173
    L168:
        if (Result.m9455isFailureimpl(r113) == false) goto L170;
        r113 = r101;
    L170:
        r109 = r113;
    L171:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L173
        TradeHostSettingsCacheManger.a("ec_search_saas_dialog_config", r109);     // Catch: Throwable -> L173
        goto L183
    L186:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L131
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("ec_search_saas_dialog_config");     // Catch: Throwable -> L131
        if (r115 != null) goto L83;
    L128:
        Object r116 = null;
    L129:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L131
    L133:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L163
        if (r118 == null) goto L137;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L163
    L137:
        if (Result.m9455isFailureimpl(r117) == false) goto L140;
        r117 = null;
    L140:
        if ((r117 instanceof SearchDialogConfig) == true) goto L142;
        r117 = null;
    L142:
        r113 = (SearchDialogConfig) r117;     // Catch: Throwable -> L163
        if (r113 != null) goto L170;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L163
        if (r119 == null) goto L152;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L163
        if (r120 == null) goto L152;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L163
        if (r121 == null) goto L152;
        Object r122 = r121.a("ec_search_saas_dialog_config", r101);     // Catch: Throwable -> L163
    L153:
        if (r122 != null) goto L155;
    L162:
        r109 = r101;
        goto L171
    L155:
        if ((r122 instanceof SearchDialogConfig) == false) goto L158;
        r104 = r122;
    L158:
        SearchDialogConfig r123 = (SearchDialogConfig) r104;     // Catch: Throwable -> L163
        if (r123 == null) goto L162;
        r109 = r123;
        goto L171
    L152:
        r122 = null;
        goto L153
    L83:
        if ((r115 instanceof SearchDialogConfig) == true) goto L85;
        Object r124 = null;
    L86:
        r116 = (SearchDialogConfig) r124;     // Catch: Throwable -> L131
        if (r116 != null) goto L129;
        if ((r115 instanceof Number) == false) goto L116;
        if (SearchDialogConfig.class != Float.class) goto L98;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L131
        if ((r125 instanceof SearchDialogConfig) == true) goto L96;
        r125 = null;
    L96:
        r116 = (SearchDialogConfig) r125;     // Catch: Throwable -> L131
        goto L129
    L98:
        if (SearchDialogConfig.class != Double.class) goto L104;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L131
        if ((r126 instanceof SearchDialogConfig) == true) goto L102;
        r126 = null;
    L102:
        r116 = (SearchDialogConfig) r126;     // Catch: Throwable -> L131
        goto L129
    L104:
        if (SearchDialogConfig.class != Integer.class) goto L110;
        Integer r127 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L131
        if ((r127 instanceof SearchDialogConfig) == true) goto L108;
        r127 = null;
    L108:
        r116 = (SearchDialogConfig) r127;     // Catch: Throwable -> L131
        goto L129
    L110:
        if (SearchDialogConfig.class != Long.class) goto L116;
        Long r128 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L131
        if ((r128 instanceof SearchDialogConfig) == true) goto L114;
        r128 = null;
    L114:
        r116 = (SearchDialogConfig) r128;     // Catch: Throwable -> L131
    L116:
        if ((r115 instanceof JSONObject) == false) goto L118;
    L194:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L124
        Object r129 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), SearchDialogConfig.class);     // Catch: Throwable -> L124
        if ((r129 instanceof SearchDialogConfig) == true) goto L122;
        r129 = null;
    L122:
        Object r130 = Result.m9449constructorimpl((SearchDialogConfig) r129);     // Catch: Throwable -> L124
    L126:
        r116 = r130;
        if (Result.m9455isFailureimpl(r116) == false) goto L129;
    L124:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L131
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L131
        goto L126
    L118:
        if ((r115 instanceof JSONArray) == false) goto L128;
    L85:
        r124 = r115;
    L131:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L163
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L183:
        return (SearchDialogConfig) r109;
    L9:
        if ((r105 instanceof SearchDialogConfig) == true) goto L11;
        Object r133 = null;
    L12:
        r106 = (SearchDialogConfig) r133;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (SearchDialogConfig.class != Float.class) goto L24;
        Float r134 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r134 instanceof SearchDialogConfig) == true) goto L22;
        r134 = null;
    L22:
        r106 = (SearchDialogConfig) r134;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (SearchDialogConfig.class != Double.class) goto L30;
        Double r135 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r135 instanceof SearchDialogConfig) == true) goto L28;
        r135 = null;
    L28:
        r106 = (SearchDialogConfig) r135;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (SearchDialogConfig.class != Integer.class) goto L36;
        Integer r136 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r136 instanceof SearchDialogConfig) == true) goto L34;
        r136 = null;
    L34:
        r106 = (SearchDialogConfig) r136;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (SearchDialogConfig.class != Long.class) goto L42;
        Long r137 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r137 instanceof SearchDialogConfig) == true) goto L40;
        r137 = null;
    L40:
        r106 = (SearchDialogConfig) r137;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L192:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L50
        Object r138 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), SearchDialogConfig.class);     // Catch: Throwable -> L50
        if ((r138 instanceof SearchDialogConfig) == true) goto L48;
        r138 = null;
    L48:
        Object r139 = Result.m9449constructorimpl((SearchDialogConfig) r138);     // Catch: Throwable -> L50
    L52:
        r106 = r139;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L57
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r133 = r105;
    L57:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L173
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
    L173:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L178;
        EnsureManager.ensureNotReachHere(r144);
    L178:
        if (Result.m9455isFailureimpl(r143) == true) goto L181;
        r101 = r143;
    L181:
        r109 = r101;
        goto L183
    }

    @SettingPanel("电商搜索lynx卡rawdata和schema取值优化")
    public static final boolean h() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L173
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L173
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L57
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("ec_search_lynx_card_bind_data_get_opt");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L173
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L173
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Boolean) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L173
        if (r109 != null) goto L75;
        r103.getClass();     // Catch: Throwable -> L173
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("ec_search_lynx_card_bind_data_get_opt");     // Catch: Throwable -> L173
        if ((r110 instanceof Boolean) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Boolean) r110;     // Catch: Throwable -> L173
    L75:
        if (r109 != null) goto L183;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L173
    L163:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L173
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L173
        if (r114 == null) goto L168;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L173
    L168:
        if (Result.m9455isFailureimpl(r113) == false) goto L170;
        r113 = r101;
    L170:
        r109 = r113;
    L171:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L173
        TradeHostSettingsCacheManger.a("ec_search_lynx_card_bind_data_get_opt", r109);     // Catch: Throwable -> L173
        goto L183
    L192:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L131
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("ec_search_lynx_card_bind_data_get_opt");     // Catch: Throwable -> L131
        if (r115 != null) goto L83;
    L128:
        Object r116 = null;
    L129:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L131
    L133:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L163
        if (r118 == null) goto L137;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L163
    L137:
        if (Result.m9455isFailureimpl(r117) == false) goto L140;
        r117 = null;
    L140:
        if ((r117 instanceof Boolean) == true) goto L142;
        r117 = null;
    L142:
        r113 = (Boolean) r117;     // Catch: Throwable -> L163
        if (r113 != null) goto L170;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L163
        if (r119 == null) goto L152;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L163
        if (r120 == null) goto L152;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L163
        if (r121 == null) goto L152;
        Object r122 = r121.a("ec_search_lynx_card_bind_data_get_opt", r101);     // Catch: Throwable -> L163
    L153:
        if (r122 != null) goto L155;
    L162:
        r109 = r101;
        goto L171
    L155:
        if ((r122 instanceof Boolean) == false) goto L158;
        r104 = r122;
    L158:
        Boolean r123 = (Boolean) r104;     // Catch: Throwable -> L163
        if (r123 == null) goto L162;
        r109 = r123;
        goto L171
    L152:
        r122 = null;
        goto L153
    L83:
        if ((r115 instanceof Boolean) == true) goto L85;
        Object r124 = null;
    L86:
        r116 = (Boolean) r124;     // Catch: Throwable -> L131
        if (r116 != null) goto L129;
        if ((r115 instanceof Number) == false) goto L116;
        if (Boolean.class != Float.class) goto L98;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L131
        if ((r125 instanceof Boolean) == true) goto L96;
        r125 = null;
    L96:
        r116 = (Boolean) r125;     // Catch: Throwable -> L131
        goto L129
    L98:
        if (Boolean.class != Double.class) goto L104;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L131
        if ((r126 instanceof Boolean) == true) goto L102;
        r126 = null;
    L102:
        r116 = (Boolean) r126;     // Catch: Throwable -> L131
        goto L129
    L104:
        if (Boolean.class != Integer.class) goto L110;
        Integer r127 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L131
        if ((r127 instanceof Boolean) == true) goto L108;
        r127 = null;
    L108:
        r116 = (Boolean) r127;     // Catch: Throwable -> L131
        goto L129
    L110:
        if (Boolean.class != Long.class) goto L116;
        Long r128 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L131
        if ((r128 instanceof Boolean) == true) goto L114;
        r128 = null;
    L114:
        r116 = (Boolean) r128;     // Catch: Throwable -> L131
    L116:
        if ((r115 instanceof JSONObject) == false) goto L118;
    L188:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L124
        Object r129 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), Boolean.class);     // Catch: Throwable -> L124
        if ((r129 instanceof Boolean) == true) goto L122;
        r129 = null;
    L122:
        Object r130 = Result.m9449constructorimpl((Boolean) r129);     // Catch: Throwable -> L124
    L126:
        r116 = r130;
        if (Result.m9455isFailureimpl(r116) == false) goto L129;
    L124:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L131
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L131
        goto L126
    L118:
        if ((r115 instanceof JSONArray) == false) goto L128;
    L85:
        r124 = r115;
    L131:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L163
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L183:
        return ((Boolean) r109).booleanValue();
    L9:
        if ((r105 instanceof Boolean) == true) goto L11;
        Object r133 = null;
    L12:
        r106 = (Boolean) r133;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Boolean.class != Float.class) goto L24;
        Float r134 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r134 instanceof Boolean) == true) goto L22;
        r134 = null;
    L22:
        r106 = (Boolean) r134;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Boolean.class != Double.class) goto L30;
        Double r135 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r135 instanceof Boolean) == true) goto L28;
        r135 = null;
    L28:
        r106 = (Boolean) r135;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Boolean.class != Integer.class) goto L36;
        Integer r136 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r136 instanceof Boolean) == true) goto L34;
        r136 = null;
    L34:
        r106 = (Boolean) r136;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Boolean.class != Long.class) goto L42;
        Long r137 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r137 instanceof Boolean) == true) goto L40;
        r137 = null;
    L40:
        r106 = (Boolean) r137;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L186:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L50
        Object r138 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r138 instanceof Boolean) == true) goto L48;
        r138 = null;
    L48:
        Object r139 = Result.m9449constructorimpl((Boolean) r138);     // Catch: Throwable -> L50
    L52:
        r106 = r139;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L57
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r133 = r105;
    L57:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L173
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
    L173:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L178;
        EnsureManager.ensureNotReachHere(r144);
    L178:
        if (Result.m9455isFailureimpl(r143) == true) goto L181;
        r101 = r143;
    L181:
        r109 = r101;
        goto L183
    }

    @SettingPanel("键盘返回控制")
    public static final String i() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = "";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L173
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L173
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L57
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("ec_search_middle_keyboard_strategy");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L173
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L173
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof String) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (String) r107;     // Catch: Throwable -> L173
        if (r109 != null) goto L75;
        r103.getClass();     // Catch: Throwable -> L173
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("ec_search_middle_keyboard_strategy");     // Catch: Throwable -> L173
        if ((r110 instanceof String) == true) goto L74;
        r110 = null;
    L74:
        r109 = (String) r110;     // Catch: Throwable -> L173
    L75:
        if (r109 != null) goto L183;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L173
    L163:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L173
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L173
        if (r114 == null) goto L168;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L173
    L168:
        if (Result.m9455isFailureimpl(r113) == false) goto L170;
        r113 = "";
    L170:
        r109 = r113;
    L171:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L173
        TradeHostSettingsCacheManger.a("ec_search_middle_keyboard_strategy", r109);     // Catch: Throwable -> L173
        goto L183
    L192:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L131
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("ec_search_middle_keyboard_strategy");     // Catch: Throwable -> L131
        if (r115 != null) goto L83;
    L128:
        Object r116 = null;
    L129:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L131
    L133:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L163
        if (r118 == null) goto L137;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L163
    L137:
        if (Result.m9455isFailureimpl(r117) == false) goto L140;
        r117 = null;
    L140:
        if ((r117 instanceof String) == true) goto L142;
        r117 = null;
    L142:
        r113 = (String) r117;     // Catch: Throwable -> L163
        if (r113 != null) goto L170;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L163
        if (r119 == null) goto L152;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L163
        if (r120 == null) goto L152;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L163
        if (r121 == null) goto L152;
        Object r122 = r121.a("ec_search_middle_keyboard_strategy", "");     // Catch: Throwable -> L163
    L153:
        if (r122 != null) goto L155;
    L162:
        r109 = "";
        goto L171
    L155:
        if ((r122 instanceof String) == false) goto L158;
        r104 = r122;
    L158:
        String r123 = (String) r104;     // Catch: Throwable -> L163
        if (r123 == null) goto L162;
        r109 = r123;
        goto L171
    L152:
        r122 = null;
        goto L153
    L83:
        if ((r115 instanceof String) == true) goto L85;
        Object r124 = null;
    L86:
        r116 = (String) r124;     // Catch: Throwable -> L131
        if (r116 != null) goto L129;
        if ((r115 instanceof Number) == false) goto L116;
        if (String.class != Float.class) goto L98;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L131
        if ((r125 instanceof String) == true) goto L96;
        r125 = null;
    L96:
        r116 = (String) r125;     // Catch: Throwable -> L131
        goto L129
    L98:
        if (String.class != Double.class) goto L104;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L131
        if ((r126 instanceof String) == true) goto L102;
        r126 = null;
    L102:
        r116 = (String) r126;     // Catch: Throwable -> L131
        goto L129
    L104:
        if (String.class != Integer.class) goto L110;
        Integer r127 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L131
        if ((r127 instanceof String) == true) goto L108;
        r127 = null;
    L108:
        r116 = (String) r127;     // Catch: Throwable -> L131
        goto L129
    L110:
        if (String.class != Long.class) goto L116;
        Long r128 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L131
        if ((r128 instanceof String) == true) goto L114;
        r128 = null;
    L114:
        r116 = (String) r128;     // Catch: Throwable -> L131
    L116:
        if ((r115 instanceof JSONObject) == false) goto L118;
    L188:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L124
        Object r129 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), String.class);     // Catch: Throwable -> L124
        if ((r129 instanceof String) == true) goto L122;
        r129 = null;
    L122:
        Object r130 = Result.m9449constructorimpl((String) r129);     // Catch: Throwable -> L124
    L126:
        r116 = r130;
        if (Result.m9455isFailureimpl(r116) == false) goto L129;
    L124:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L131
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L131
        goto L126
    L118:
        if ((r115 instanceof JSONArray) == false) goto L128;
    L85:
        r124 = r115;
    L131:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L163
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L183:
        return (String) r109;
    L9:
        if ((r105 instanceof String) == true) goto L11;
        Object r133 = null;
    L12:
        r106 = (String) r133;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (String.class != Float.class) goto L24;
        Float r134 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r134 instanceof String) == true) goto L22;
        r134 = null;
    L22:
        r106 = (String) r134;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (String.class != Double.class) goto L30;
        Double r135 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r135 instanceof String) == true) goto L28;
        r135 = null;
    L28:
        r106 = (String) r135;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (String.class != Integer.class) goto L36;
        Integer r136 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r136 instanceof String) == true) goto L34;
        r136 = null;
    L34:
        r106 = (String) r136;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (String.class != Long.class) goto L42;
        Long r137 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r137 instanceof String) == true) goto L40;
        r137 = null;
    L40:
        r106 = (String) r137;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L186:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L50
        Object r138 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), String.class);     // Catch: Throwable -> L50
        if ((r138 instanceof String) == true) goto L48;
        r138 = null;
    L48:
        Object r139 = Result.m9449constructorimpl((String) r138);     // Catch: Throwable -> L50
    L52:
        r106 = r139;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L57
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r133 = r105;
    L57:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L173
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
    L173:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L178;
        EnsureManager.ensureNotReachHere(r144);
    L178:
        if (Result.m9455isFailureimpl(r143) == true) goto L181;
        r101 = r143;
    L181:
        r109 = r101;
        goto L183
    }

    @SettingPanel("电商搜索slice sug配置")
    public static final EcSearchSliceSugConfig j() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = new EcSearchSliceSugConfig();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L173
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L173
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L57
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("ec_search_slice_sug_config");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L173
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L173
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof EcSearchSliceSugConfig) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (EcSearchSliceSugConfig) r107;     // Catch: Throwable -> L173
        if (r109 != null) goto L75;
        r103.getClass();     // Catch: Throwable -> L173
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("ec_search_slice_sug_config");     // Catch: Throwable -> L173
        if ((r110 instanceof EcSearchSliceSugConfig) == true) goto L74;
        r110 = null;
    L74:
        r109 = (EcSearchSliceSugConfig) r110;     // Catch: Throwable -> L173
    L75:
        if (r109 != null) goto L183;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L173
    L163:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L173
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L173
        if (r114 == null) goto L168;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L173
    L168:
        if (Result.m9455isFailureimpl(r113) == false) goto L170;
        r113 = r101;
    L170:
        r109 = r113;
    L171:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L173
        TradeHostSettingsCacheManger.a("ec_search_slice_sug_config", r109);     // Catch: Throwable -> L173
        goto L183
    L186:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L131
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("ec_search_slice_sug_config");     // Catch: Throwable -> L131
        if (r115 != null) goto L83;
    L128:
        Object r116 = null;
    L129:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L131
    L133:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L163
        if (r118 == null) goto L137;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L163
    L137:
        if (Result.m9455isFailureimpl(r117) == false) goto L140;
        r117 = null;
    L140:
        if ((r117 instanceof EcSearchSliceSugConfig) == true) goto L142;
        r117 = null;
    L142:
        r113 = (EcSearchSliceSugConfig) r117;     // Catch: Throwable -> L163
        if (r113 != null) goto L170;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L163
        if (r119 == null) goto L152;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L163
        if (r120 == null) goto L152;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L163
        if (r121 == null) goto L152;
        Object r122 = r121.a("ec_search_slice_sug_config", r101);     // Catch: Throwable -> L163
    L153:
        if (r122 != null) goto L155;
    L162:
        r109 = r101;
        goto L171
    L155:
        if ((r122 instanceof EcSearchSliceSugConfig) == false) goto L158;
        r104 = r122;
    L158:
        EcSearchSliceSugConfig r123 = (EcSearchSliceSugConfig) r104;     // Catch: Throwable -> L163
        if (r123 == null) goto L162;
        r109 = r123;
        goto L171
    L152:
        r122 = null;
        goto L153
    L83:
        if ((r115 instanceof EcSearchSliceSugConfig) == true) goto L85;
        Object r124 = null;
    L86:
        r116 = (EcSearchSliceSugConfig) r124;     // Catch: Throwable -> L131
        if (r116 != null) goto L129;
        if ((r115 instanceof Number) == false) goto L116;
        if (EcSearchSliceSugConfig.class != Float.class) goto L98;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L131
        if ((r125 instanceof EcSearchSliceSugConfig) == true) goto L96;
        r125 = null;
    L96:
        r116 = (EcSearchSliceSugConfig) r125;     // Catch: Throwable -> L131
        goto L129
    L98:
        if (EcSearchSliceSugConfig.class != Double.class) goto L104;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L131
        if ((r126 instanceof EcSearchSliceSugConfig) == true) goto L102;
        r126 = null;
    L102:
        r116 = (EcSearchSliceSugConfig) r126;     // Catch: Throwable -> L131
        goto L129
    L104:
        if (EcSearchSliceSugConfig.class != Integer.class) goto L110;
        Integer r127 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L131
        if ((r127 instanceof EcSearchSliceSugConfig) == true) goto L108;
        r127 = null;
    L108:
        r116 = (EcSearchSliceSugConfig) r127;     // Catch: Throwable -> L131
        goto L129
    L110:
        if (EcSearchSliceSugConfig.class != Long.class) goto L116;
        Long r128 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L131
        if ((r128 instanceof EcSearchSliceSugConfig) == true) goto L114;
        r128 = null;
    L114:
        r116 = (EcSearchSliceSugConfig) r128;     // Catch: Throwable -> L131
    L116:
        if ((r115 instanceof JSONObject) == false) goto L118;
    L194:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L124
        Object r129 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), EcSearchSliceSugConfig.class);     // Catch: Throwable -> L124
        if ((r129 instanceof EcSearchSliceSugConfig) == true) goto L122;
        r129 = null;
    L122:
        Object r130 = Result.m9449constructorimpl((EcSearchSliceSugConfig) r129);     // Catch: Throwable -> L124
    L126:
        r116 = r130;
        if (Result.m9455isFailureimpl(r116) == false) goto L129;
    L124:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L131
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L131
        goto L126
    L118:
        if ((r115 instanceof JSONArray) == false) goto L128;
    L85:
        r124 = r115;
    L131:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L163
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L183:
        return (EcSearchSliceSugConfig) r109;
    L9:
        if ((r105 instanceof EcSearchSliceSugConfig) == true) goto L11;
        Object r133 = null;
    L12:
        r106 = (EcSearchSliceSugConfig) r133;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (EcSearchSliceSugConfig.class != Float.class) goto L24;
        Float r134 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r134 instanceof EcSearchSliceSugConfig) == true) goto L22;
        r134 = null;
    L22:
        r106 = (EcSearchSliceSugConfig) r134;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (EcSearchSliceSugConfig.class != Double.class) goto L30;
        Double r135 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r135 instanceof EcSearchSliceSugConfig) == true) goto L28;
        r135 = null;
    L28:
        r106 = (EcSearchSliceSugConfig) r135;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (EcSearchSliceSugConfig.class != Integer.class) goto L36;
        Integer r136 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r136 instanceof EcSearchSliceSugConfig) == true) goto L34;
        r136 = null;
    L34:
        r106 = (EcSearchSliceSugConfig) r136;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (EcSearchSliceSugConfig.class != Long.class) goto L42;
        Long r137 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r137 instanceof EcSearchSliceSugConfig) == true) goto L40;
        r137 = null;
    L40:
        r106 = (EcSearchSliceSugConfig) r137;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L192:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L50
        Object r138 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), EcSearchSliceSugConfig.class);     // Catch: Throwable -> L50
        if ((r138 instanceof EcSearchSliceSugConfig) == true) goto L48;
        r138 = null;
    L48:
        Object r139 = Result.m9449constructorimpl((EcSearchSliceSugConfig) r138);     // Catch: Throwable -> L50
    L52:
        r106 = r139;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L57
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r133 = r105;
    L57:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L173
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
    L173:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L178;
        EnsureManager.ensureNotReachHere(r144);
    L178:
        if (Result.m9455isFailureimpl(r143) == true) goto L181;
        r101 = r143;
    L181:
        r109 = r101;
        goto L183
    }

    @SettingPanel("筛排栏首屏数据bind延迟优化")
    public static final long k() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = 0L;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L167
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L54
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("ec_search_tab_filter_bind_delay_exp");     // Catch: Throwable -> L54
        if (r105 != null) goto L9;
    L51:
        Object r106 = null;
    L52:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L54
    L56:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L167
        if (r108 == null) goto L60;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L167
    L60:
        if (Result.m9455isFailureimpl(r107) == false) goto L63;
        r107 = null;
    L63:
        if ((r107 instanceof Long) == true) goto L65;
        r107 = null;
    L65:
        Object r109 = (Long) r107;     // Catch: Throwable -> L167
        if (r109 != null) goto L72;
        r103.getClass();     // Catch: Throwable -> L167
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("ec_search_tab_filter_bind_delay_exp");     // Catch: Throwable -> L167
        if ((r110 instanceof Long) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Long) r110;     // Catch: Throwable -> L167
    L72:
        if (r109 != null) goto L177;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L167
    L157:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L167
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L167
        if (r114 == null) goto L162;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L167
    L162:
        if (Result.m9455isFailureimpl(r113) == false) goto L164;
        r113 = r101;
    L164:
        r109 = r113;
    L165:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger.a("ec_search_tab_filter_bind_delay_exp", r109);     // Catch: Throwable -> L167
        goto L177
    L180:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L125
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("ec_search_tab_filter_bind_delay_exp");     // Catch: Throwable -> L125
        if (r115 != null) goto L80;
    L122:
        Object r116 = null;
    L123:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L125
    L127:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L157
        if (r118 == null) goto L131;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L157
    L131:
        if (Result.m9455isFailureimpl(r117) == false) goto L134;
        r117 = null;
    L134:
        if ((r117 instanceof Long) == true) goto L136;
        r117 = null;
    L136:
        r113 = (Long) r117;     // Catch: Throwable -> L157
        if (r113 != null) goto L164;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L157
        if (r119 == null) goto L146;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L157
        if (r120 == null) goto L146;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L157
        if (r121 == null) goto L146;
        Object r122 = r121.a("ec_search_tab_filter_bind_delay_exp", r101);     // Catch: Throwable -> L157
    L147:
        if (r122 != null) goto L149;
    L156:
        r109 = r101;
        goto L165
    L149:
        if ((r122 instanceof Long) == false) goto L152;
        r104 = r122;
    L152:
        Long r123 = (Long) r104;     // Catch: Throwable -> L157
        if (r123 == null) goto L156;
        r109 = r123;
        goto L165
    L146:
        r122 = null;
        goto L147
    L80:
        if ((r115 instanceof Long) == true) goto L82;
        Object r124 = null;
    L83:
        r116 = (Long) r124;     // Catch: Throwable -> L125
        if (r116 != null) goto L123;
        if ((r115 instanceof Number) == false) goto L110;
        if (Long.class != Float.class) goto L95;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L125
        if ((r125 instanceof Long) == true) goto L93;
        r125 = null;
    L93:
        r116 = (Long) r125;     // Catch: Throwable -> L125
        goto L123
    L95:
        if (Long.class != Double.class) goto L101;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L125
        if ((r126 instanceof Long) == true) goto L99;
        r126 = null;
    L99:
        r116 = (Long) r126;     // Catch: Throwable -> L125
        goto L123
    L101:
        if (Long.class != Integer.class) goto L107;
        Integer r127 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L125
        if ((r127 instanceof Long) == true) goto L105;
        r127 = null;
    L105:
        r116 = (Long) r127;     // Catch: Throwable -> L125
        goto L123
    L107:
        if (Long.class != Long.class) goto L110;
        r116 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L125
    L110:
        if ((r115 instanceof JSONObject) == false) goto L112;
    L186:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L118
        Object r128 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), Long.class);     // Catch: Throwable -> L118
        if ((r128 instanceof Long) == true) goto L116;
        r128 = null;
    L116:
        Object r129 = Result.m9449constructorimpl((Long) r128);     // Catch: Throwable -> L118
    L120:
        r116 = r129;
        if (Result.m9455isFailureimpl(r116) == false) goto L123;
    L118:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L125
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L125
        goto L120
    L112:
        if ((r115 instanceof JSONArray) == false) goto L122;
    L82:
        r124 = r115;
    L125:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L157
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L177:
        return ((Number) r109).longValue();
    L9:
        if ((r105 instanceof Long) == true) goto L11;
        Object r132 = null;
    L12:
        r106 = (Long) r132;     // Catch: Throwable -> L54
        if (r106 != null) goto L52;
        if ((r105 instanceof Number) == false) goto L39;
        if (Long.class != Float.class) goto L24;
        Float r133 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L54
        if ((r133 instanceof Long) == true) goto L22;
        r133 = null;
    L22:
        r106 = (Long) r133;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Long.class != Double.class) goto L30;
        Double r134 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L54
        if ((r134 instanceof Long) == true) goto L28;
        r134 = null;
    L28:
        r106 = (Long) r134;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Long.class != Integer.class) goto L36;
        Integer r135 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L54
        if ((r135 instanceof Long) == true) goto L34;
        r135 = null;
    L34:
        r106 = (Long) r135;     // Catch: Throwable -> L54
        goto L52
    L36:
        if (Long.class != Long.class) goto L39;
        r106 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L54
    L39:
        if ((r105 instanceof JSONObject) == false) goto L41;
    L178:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L47
        Object r136 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), Long.class);     // Catch: Throwable -> L47
        if ((r136 instanceof Long) == true) goto L45;
        r136 = null;
    L45:
        Object r137 = Result.m9449constructorimpl((Long) r136);     // Catch: Throwable -> L47
    L49:
        r106 = r137;
        if (Result.m9455isFailureimpl(r106) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L54
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r105 instanceof JSONArray) == false) goto L51;
    L11:
        r132 = r105;
    L54:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L167
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L172;
        EnsureManager.ensureNotReachHere(r142);
    L172:
        if (Result.m9455isFailureimpl(r141) == true) goto L175;
        r101 = r141;
    L175:
        r109 = r101;
        goto L177
    }

    @SettingPanel("商搜设计语言2.0 电商标准化UI 单筛选行间距")
    public static final int l() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = 8;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L167
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L54
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("ec_search_filter_single_line_gap");     // Catch: Throwable -> L54
        if (r105 != null) goto L9;
    L51:
        Object r106 = null;
    L52:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L54
    L56:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L167
        if (r108 == null) goto L60;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L167
    L60:
        if (Result.m9455isFailureimpl(r107) == false) goto L63;
        r107 = null;
    L63:
        if ((r107 instanceof Integer) == true) goto L65;
        r107 = null;
    L65:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L167
        if (r109 != null) goto L72;
        r103.getClass();     // Catch: Throwable -> L167
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("ec_search_filter_single_line_gap");     // Catch: Throwable -> L167
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L167
    L72:
        if (r109 != null) goto L177;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L167
    L157:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L167
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L167
        if (r114 == null) goto L162;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L167
    L162:
        if (Result.m9455isFailureimpl(r113) == false) goto L164;
        r113 = r101;
    L164:
        r109 = r113;
    L165:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger.a("ec_search_filter_single_line_gap", r109);     // Catch: Throwable -> L167
        goto L177
    L180:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L125
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("ec_search_filter_single_line_gap");     // Catch: Throwable -> L125
        if (r115 != null) goto L80;
    L122:
        Object r116 = null;
    L123:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L125
    L127:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L157
        if (r118 == null) goto L131;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L157
    L131:
        if (Result.m9455isFailureimpl(r117) == false) goto L134;
        r117 = null;
    L134:
        if ((r117 instanceof Integer) == true) goto L136;
        r117 = null;
    L136:
        r113 = (Integer) r117;     // Catch: Throwable -> L157
        if (r113 != null) goto L164;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L157
        if (r119 == null) goto L146;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L157
        if (r120 == null) goto L146;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L157
        if (r121 == null) goto L146;
        Object r122 = r121.a("ec_search_filter_single_line_gap", r101);     // Catch: Throwable -> L157
    L147:
        if (r122 != null) goto L149;
    L156:
        r109 = r101;
        goto L165
    L149:
        if ((r122 instanceof Integer) == false) goto L152;
        r104 = r122;
    L152:
        Integer r123 = (Integer) r104;     // Catch: Throwable -> L157
        if (r123 == null) goto L156;
        r109 = r123;
        goto L165
    L146:
        r122 = null;
        goto L147
    L80:
        if ((r115 instanceof Integer) == true) goto L82;
        Object r124 = null;
    L83:
        r116 = (Integer) r124;     // Catch: Throwable -> L125
        if (r116 != null) goto L123;
        if ((r115 instanceof Number) == false) goto L110;
        if (Integer.class != Float.class) goto L95;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L125
        if ((r125 instanceof Integer) == true) goto L93;
        r125 = null;
    L93:
        r116 = (Integer) r125;     // Catch: Throwable -> L125
        goto L123
    L95:
        if (Integer.class != Double.class) goto L101;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L125
        if ((r126 instanceof Integer) == true) goto L99;
        r126 = null;
    L99:
        r116 = (Integer) r126;     // Catch: Throwable -> L125
        goto L123
    L101:
        if (Integer.class != Integer.class) goto L104;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L125
        goto L123
    L104:
        if (Integer.class != Long.class) goto L110;
        Long r127 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L125
        if ((r127 instanceof Integer) == true) goto L108;
        r127 = null;
    L108:
        r116 = (Integer) r127;     // Catch: Throwable -> L125
    L110:
        if ((r115 instanceof JSONObject) == false) goto L112;
    L186:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L118
        Object r128 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L118
        if ((r128 instanceof Integer) == true) goto L116;
        r128 = null;
    L116:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L118
    L120:
        r116 = r129;
        if (Result.m9455isFailureimpl(r116) == false) goto L123;
    L118:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L125
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L125
        goto L120
    L112:
        if ((r115 instanceof JSONArray) == false) goto L122;
    L82:
        r124 = r115;
    L125:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L157
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L177:
        return ((Number) r109).intValue();
    L9:
        if ((r105 instanceof Integer) == true) goto L11;
        Object r132 = null;
    L12:
        r106 = (Integer) r132;     // Catch: Throwable -> L54
        if (r106 != null) goto L52;
        if ((r105 instanceof Number) == false) goto L39;
        if (Integer.class != Float.class) goto L24;
        Float r133 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L54
        if ((r133 instanceof Integer) == true) goto L22;
        r133 = null;
    L22:
        r106 = (Integer) r133;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Integer.class != Double.class) goto L30;
        Double r134 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L54
        if ((r134 instanceof Integer) == true) goto L28;
        r134 = null;
    L28:
        r106 = (Integer) r134;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Integer.class != Integer.class) goto L33;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Integer.class != Long.class) goto L39;
        Long r135 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L54
        if ((r135 instanceof Integer) == true) goto L37;
        r135 = null;
    L37:
        r106 = (Integer) r135;     // Catch: Throwable -> L54
    L39:
        if ((r105 instanceof JSONObject) == false) goto L41;
    L178:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L47
        Object r136 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r136 instanceof Integer) == true) goto L45;
        r136 = null;
    L45:
        Object r137 = Result.m9449constructorimpl((Integer) r136);     // Catch: Throwable -> L47
    L49:
        r106 = r137;
        if (Result.m9455isFailureimpl(r106) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L54
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r105 instanceof JSONArray) == false) goto L51;
    L11:
        r132 = r105;
    L54:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L167
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L172;
        EnsureManager.ensureNotReachHere(r142);
    L172:
        if (Result.m9455isFailureimpl(r141) == true) goto L175;
        r101 = r141;
    L175:
        r109 = r101;
        goto L177
    }

    @SettingPanel("排序筛选器是否强制左对齐")
    public static final boolean m() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L173
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L173
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L57
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("sort_and_filter_is_force_left_aligned");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L173
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L173
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Boolean) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L173
        if (r109 != null) goto L75;
        r103.getClass();     // Catch: Throwable -> L173
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("sort_and_filter_is_force_left_aligned");     // Catch: Throwable -> L173
        if ((r110 instanceof Boolean) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Boolean) r110;     // Catch: Throwable -> L173
    L75:
        if (r109 != null) goto L183;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L173
    L163:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L173
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L173
        if (r114 == null) goto L168;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L173
    L168:
        if (Result.m9455isFailureimpl(r113) == false) goto L170;
        r113 = r101;
    L170:
        r109 = r113;
    L171:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L173
        TradeHostSettingsCacheManger.a("sort_and_filter_is_force_left_aligned", r109);     // Catch: Throwable -> L173
        goto L183
    L184:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L131
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("sort_and_filter_is_force_left_aligned");     // Catch: Throwable -> L131
        if (r115 != null) goto L83;
    L128:
        Object r116 = null;
    L129:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L131
    L133:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L163
        if (r118 == null) goto L137;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L163
    L137:
        if (Result.m9455isFailureimpl(r117) == false) goto L140;
        r117 = null;
    L140:
        if ((r117 instanceof Boolean) == true) goto L142;
        r117 = null;
    L142:
        r113 = (Boolean) r117;     // Catch: Throwable -> L163
        if (r113 != null) goto L170;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L163
        if (r119 == null) goto L152;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L163
        if (r120 == null) goto L152;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L163
        if (r121 == null) goto L152;
        Object r122 = r121.a("sort_and_filter_is_force_left_aligned", r101);     // Catch: Throwable -> L163
    L153:
        if (r122 != null) goto L155;
    L162:
        r109 = r101;
        goto L171
    L155:
        if ((r122 instanceof Boolean) == false) goto L158;
        r104 = r122;
    L158:
        Boolean r123 = (Boolean) r104;     // Catch: Throwable -> L163
        if (r123 == null) goto L162;
        r109 = r123;
        goto L171
    L152:
        r122 = null;
        goto L153
    L83:
        if ((r115 instanceof Boolean) == true) goto L85;
        Object r124 = null;
    L86:
        r116 = (Boolean) r124;     // Catch: Throwable -> L131
        if (r116 != null) goto L129;
        if ((r115 instanceof Number) == false) goto L116;
        if (Boolean.class != Float.class) goto L98;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L131
        if ((r125 instanceof Boolean) == true) goto L96;
        r125 = null;
    L96:
        r116 = (Boolean) r125;     // Catch: Throwable -> L131
        goto L129
    L98:
        if (Boolean.class != Double.class) goto L104;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L131
        if ((r126 instanceof Boolean) == true) goto L102;
        r126 = null;
    L102:
        r116 = (Boolean) r126;     // Catch: Throwable -> L131
        goto L129
    L104:
        if (Boolean.class != Integer.class) goto L110;
        Integer r127 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L131
        if ((r127 instanceof Boolean) == true) goto L108;
        r127 = null;
    L108:
        r116 = (Boolean) r127;     // Catch: Throwable -> L131
        goto L129
    L110:
        if (Boolean.class != Long.class) goto L116;
        Long r128 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L131
        if ((r128 instanceof Boolean) == true) goto L114;
        r128 = null;
    L114:
        r116 = (Boolean) r128;     // Catch: Throwable -> L131
    L116:
        if ((r115 instanceof JSONObject) == false) goto L118;
    L192:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L124
        Object r129 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), Boolean.class);     // Catch: Throwable -> L124
        if ((r129 instanceof Boolean) == true) goto L122;
        r129 = null;
    L122:
        Object r130 = Result.m9449constructorimpl((Boolean) r129);     // Catch: Throwable -> L124
    L126:
        r116 = r130;
        if (Result.m9455isFailureimpl(r116) == false) goto L129;
    L124:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L131
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L131
        goto L126
    L118:
        if ((r115 instanceof JSONArray) == false) goto L128;
    L85:
        r124 = r115;
    L131:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L163
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L183:
        return ((Boolean) r109).booleanValue();
    L9:
        if ((r105 instanceof Boolean) == true) goto L11;
        Object r133 = null;
    L12:
        r106 = (Boolean) r133;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Boolean.class != Float.class) goto L24;
        Float r134 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r134 instanceof Boolean) == true) goto L22;
        r134 = null;
    L22:
        r106 = (Boolean) r134;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Boolean.class != Double.class) goto L30;
        Double r135 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r135 instanceof Boolean) == true) goto L28;
        r135 = null;
    L28:
        r106 = (Boolean) r135;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Boolean.class != Integer.class) goto L36;
        Integer r136 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r136 instanceof Boolean) == true) goto L34;
        r136 = null;
    L34:
        r106 = (Boolean) r136;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Boolean.class != Long.class) goto L42;
        Long r137 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r137 instanceof Boolean) == true) goto L40;
        r137 = null;
    L40:
        r106 = (Boolean) r137;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L190:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L50
        Object r138 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r138 instanceof Boolean) == true) goto L48;
        r138 = null;
    L48:
        Object r139 = Result.m9449constructorimpl((Boolean) r138);     // Catch: Throwable -> L50
    L52:
        r106 = r139;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L57
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r133 = r105;
    L57:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L173
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
    L173:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L178;
        EnsureManager.ensureNotReachHere(r144);
    L178:
        if (Result.m9455isFailureimpl(r143) == true) goto L181;
        r101 = r143;
    L181:
        r109 = r101;
        goto L183
    }

    @SettingPanel("极简商品卡")
    public static final boolean n() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L173
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L173
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L57
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("is_simplified_product_bg");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L173
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L173
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Boolean) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L173
        if (r109 != null) goto L75;
        r103.getClass();     // Catch: Throwable -> L173
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("is_simplified_product_bg");     // Catch: Throwable -> L173
        if ((r110 instanceof Boolean) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Boolean) r110;     // Catch: Throwable -> L173
    L75:
        if (r109 != null) goto L183;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L173
    L163:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L173
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L173
        if (r114 == null) goto L168;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L173
    L168:
        if (Result.m9455isFailureimpl(r113) == false) goto L170;
        r113 = r101;
    L170:
        r109 = r113;
    L171:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L173
        TradeHostSettingsCacheManger.a("is_simplified_product_bg", r109);     // Catch: Throwable -> L173
        goto L183
    L192:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L131
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("is_simplified_product_bg");     // Catch: Throwable -> L131
        if (r115 != null) goto L83;
    L128:
        Object r116 = null;
    L129:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L131
    L133:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L163
        if (r118 == null) goto L137;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L163
    L137:
        if (Result.m9455isFailureimpl(r117) == false) goto L140;
        r117 = null;
    L140:
        if ((r117 instanceof Boolean) == true) goto L142;
        r117 = null;
    L142:
        r113 = (Boolean) r117;     // Catch: Throwable -> L163
        if (r113 != null) goto L170;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L163
        if (r119 == null) goto L152;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L163
        if (r120 == null) goto L152;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L163
        if (r121 == null) goto L152;
        Object r122 = r121.a("is_simplified_product_bg", r101);     // Catch: Throwable -> L163
    L153:
        if (r122 != null) goto L155;
    L162:
        r109 = r101;
        goto L171
    L155:
        if ((r122 instanceof Boolean) == false) goto L158;
        r104 = r122;
    L158:
        Boolean r123 = (Boolean) r104;     // Catch: Throwable -> L163
        if (r123 == null) goto L162;
        r109 = r123;
        goto L171
    L152:
        r122 = null;
        goto L153
    L83:
        if ((r115 instanceof Boolean) == true) goto L85;
        Object r124 = null;
    L86:
        r116 = (Boolean) r124;     // Catch: Throwable -> L131
        if (r116 != null) goto L129;
        if ((r115 instanceof Number) == false) goto L116;
        if (Boolean.class != Float.class) goto L98;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L131
        if ((r125 instanceof Boolean) == true) goto L96;
        r125 = null;
    L96:
        r116 = (Boolean) r125;     // Catch: Throwable -> L131
        goto L129
    L98:
        if (Boolean.class != Double.class) goto L104;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L131
        if ((r126 instanceof Boolean) == true) goto L102;
        r126 = null;
    L102:
        r116 = (Boolean) r126;     // Catch: Throwable -> L131
        goto L129
    L104:
        if (Boolean.class != Integer.class) goto L110;
        Integer r127 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L131
        if ((r127 instanceof Boolean) == true) goto L108;
        r127 = null;
    L108:
        r116 = (Boolean) r127;     // Catch: Throwable -> L131
        goto L129
    L110:
        if (Boolean.class != Long.class) goto L116;
        Long r128 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L131
        if ((r128 instanceof Boolean) == true) goto L114;
        r128 = null;
    L114:
        r116 = (Boolean) r128;     // Catch: Throwable -> L131
    L116:
        if ((r115 instanceof JSONObject) == false) goto L118;
    L188:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L124
        Object r129 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), Boolean.class);     // Catch: Throwable -> L124
        if ((r129 instanceof Boolean) == true) goto L122;
        r129 = null;
    L122:
        Object r130 = Result.m9449constructorimpl((Boolean) r129);     // Catch: Throwable -> L124
    L126:
        r116 = r130;
        if (Result.m9455isFailureimpl(r116) == false) goto L129;
    L124:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L131
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L131
        goto L126
    L118:
        if ((r115 instanceof JSONArray) == false) goto L128;
    L85:
        r124 = r115;
    L131:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L163
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L183:
        return ((Boolean) r109).booleanValue();
    L9:
        if ((r105 instanceof Boolean) == true) goto L11;
        Object r133 = null;
    L12:
        r106 = (Boolean) r133;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Boolean.class != Float.class) goto L24;
        Float r134 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r134 instanceof Boolean) == true) goto L22;
        r134 = null;
    L22:
        r106 = (Boolean) r134;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Boolean.class != Double.class) goto L30;
        Double r135 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r135 instanceof Boolean) == true) goto L28;
        r135 = null;
    L28:
        r106 = (Boolean) r135;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Boolean.class != Integer.class) goto L36;
        Integer r136 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r136 instanceof Boolean) == true) goto L34;
        r136 = null;
    L34:
        r106 = (Boolean) r136;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Boolean.class != Long.class) goto L42;
        Long r137 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r137 instanceof Boolean) == true) goto L40;
        r137 = null;
    L40:
        r106 = (Boolean) r137;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L186:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L50
        Object r138 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r138 instanceof Boolean) == true) goto L48;
        r138 = null;
    L48:
        Object r139 = Result.m9449constructorimpl((Boolean) r138);     // Catch: Throwable -> L50
    L52:
        r106 = r139;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L57
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r133 = r105;
    L57:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L173
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
    L173:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L178;
        EnsureManager.ensureNotReachHere(r144);
    L178:
        if (Result.m9455isFailureimpl(r143) == true) goto L181;
        r101 = r143;
    L181:
        r109 = r101;
        goto L183
    }

    @SettingPanel("图搜Lynx预加载单列场景配置")
    public static final Map<String, String> o() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = f451413a;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L177
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L177
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L57
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("photo_search_lynx_preload_single_config");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L177
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L177
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if (TypeIntrinsics.isMutableMap(r107) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Map) r107;     // Catch: Throwable -> L177
        if (r109 != null) goto L71;
    L73:
        r103.getClass();     // Catch: Throwable -> L177
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("photo_search_lynx_preload_single_config");     // Catch: Throwable -> L177
        if (TypeIntrinsics.isMutableMap(r110) == true) goto L76;
        r110 = null;
    L76:
        r109 = (Map) r110;     // Catch: Throwable -> L177
    L77:
        if (r109 != null) goto L187;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L177
    L167:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L177
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L177
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L177
        if (r114 == null) goto L172;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L177
    L172:
        if (Result.m9455isFailureimpl(r113) == false) goto L174;
        r113 = r101;
    L174:
        r109 = r113;
    L175:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L177
        TradeHostSettingsCacheManger.a("photo_search_lynx_preload_single_config", r109);     // Catch: Throwable -> L177
        goto L187
    L190:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L133
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("photo_search_lynx_preload_single_config");     // Catch: Throwable -> L133
        if (r115 != null) goto L85;
    L130:
        Object r116 = null;
    L131:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L133
    L135:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L167
        if (r118 == null) goto L139;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L167
    L139:
        if (Result.m9455isFailureimpl(r117) == false) goto L142;
        r117 = null;
    L142:
        if (TypeIntrinsics.isMutableMap(r117) == true) goto L144;
        r117 = null;
    L144:
        r113 = (Map) r117;     // Catch: Throwable -> L167
        if (r113 != null) goto L147;
    L149:
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L167
        if (r119 == null) goto L156;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L167
        if (r120 == null) goto L156;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L167
        if (r121 == null) goto L156;
        Object r122 = r121.a("photo_search_lynx_preload_single_config", r101);     // Catch: Throwable -> L167
    L157:
        if (r122 != null) goto L159;
    L166:
        r109 = r101;
        goto L175
    L159:
        if (TypeIntrinsics.isMutableMap(r122) == false) goto L162;
        r104 = r122;
    L162:
        Map r123 = (Map) r104;     // Catch: Throwable -> L167
        if (r123 == null) goto L166;
        r109 = r123;
        goto L175
    L156:
        r122 = null;
        goto L157
    L147:
        if (TypeIntrinsics.isMutableMap(r113) == false) goto L149;
    L85:
        if (TypeIntrinsics.isMutableMap(r115) == true) goto L87;
        Object r124 = null;
    L88:
        r116 = (Map) r124;     // Catch: Throwable -> L133
        if (r116 != null) goto L131;
        if ((r115 instanceof Number) == false) goto L118;
        if (Map.class != Float.class) goto L100;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L133
        if (TypeIntrinsics.isMutableMap(r125) == true) goto L98;
        r125 = null;
    L98:
        r116 = (Map) r125;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Map.class != Double.class) goto L106;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L133
        if (TypeIntrinsics.isMutableMap(r126) == true) goto L104;
        r126 = null;
    L104:
        r116 = (Map) r126;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Map.class != Integer.class) goto L112;
        Integer r127 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L133
        if (TypeIntrinsics.isMutableMap(r127) == true) goto L110;
        r127 = null;
    L110:
        r116 = (Map) r127;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Map.class != Long.class) goto L118;
        Long r128 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L133
        if (TypeIntrinsics.isMutableMap(r128) == true) goto L116;
        r128 = null;
    L116:
        r116 = (Map) r128;     // Catch: Throwable -> L133
    L118:
        if ((r115 instanceof JSONObject) == false) goto L120;
    L194:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L126
        Object r129 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), Map.class);     // Catch: Throwable -> L126
        if (TypeIntrinsics.isMutableMap(r129) == true) goto L124;
        r129 = null;
    L124:
        Object r130 = Result.m9449constructorimpl((Map) r129);     // Catch: Throwable -> L126
    L128:
        r116 = r130;
        if (Result.m9455isFailureimpl(r116) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L133
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r115 instanceof JSONArray) == false) goto L130;
    L87:
        r124 = r115;
    L133:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L167
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L187:
        return (Map) r109;
    L71:
        if (TypeIntrinsics.isMutableMap(r109) == false) goto L73;
    L9:
        if (TypeIntrinsics.isMutableMap(r105) == true) goto L11;
        Object r133 = null;
    L12:
        r106 = (Map) r133;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Map.class != Float.class) goto L24;
        Float r134 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r134) == true) goto L22;
        r134 = null;
    L22:
        r106 = (Map) r134;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Map.class != Double.class) goto L30;
        Double r135 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r135) == true) goto L28;
        r135 = null;
    L28:
        r106 = (Map) r135;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Map.class != Integer.class) goto L36;
        Integer r136 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r136) == true) goto L34;
        r136 = null;
    L34:
        r106 = (Map) r136;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Map.class != Long.class) goto L42;
        Long r137 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r137) == true) goto L40;
        r137 = null;
    L40:
        r106 = (Map) r137;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L192:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L50
        Object r138 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), Map.class);     // Catch: Throwable -> L50
        if (TypeIntrinsics.isMutableMap(r138) == true) goto L48;
        r138 = null;
    L48:
        Object r139 = Result.m9449constructorimpl((Map) r138);     // Catch: Throwable -> L50
    L52:
        r106 = r139;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L57
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r133 = r105;
    L57:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L177
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L177
    L177:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L182;
        EnsureManager.ensureNotReachHere(r144);
    L182:
        if (Result.m9455isFailureimpl(r143) == true) goto L185;
        r101 = r143;
    L185:
        r109 = r101;
        goto L187
    }

    @SettingPanel("图搜承接页变更")
    public static final int p() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = 1;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L167
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L54
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("photo_search_result_page_change");     // Catch: Throwable -> L54
        if (r105 != null) goto L9;
    L51:
        Object r106 = null;
    L52:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L54
    L56:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L167
        if (r108 == null) goto L60;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L167
    L60:
        if (Result.m9455isFailureimpl(r107) == false) goto L63;
        r107 = null;
    L63:
        if ((r107 instanceof Integer) == true) goto L65;
        r107 = null;
    L65:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L167
        if (r109 != null) goto L72;
        r103.getClass();     // Catch: Throwable -> L167
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("photo_search_result_page_change");     // Catch: Throwable -> L167
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L167
    L72:
        if (r109 != null) goto L177;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L167
    L157:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L167
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L167
        if (r114 == null) goto L162;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L167
    L162:
        if (Result.m9455isFailureimpl(r113) == false) goto L164;
        r113 = r101;
    L164:
        r109 = r113;
    L165:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger.a("photo_search_result_page_change", r109);     // Catch: Throwable -> L167
        goto L177
    L180:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L125
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("photo_search_result_page_change");     // Catch: Throwable -> L125
        if (r115 != null) goto L80;
    L122:
        Object r116 = null;
    L123:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L125
    L127:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L157
        if (r118 == null) goto L131;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L157
    L131:
        if (Result.m9455isFailureimpl(r117) == false) goto L134;
        r117 = null;
    L134:
        if ((r117 instanceof Integer) == true) goto L136;
        r117 = null;
    L136:
        r113 = (Integer) r117;     // Catch: Throwable -> L157
        if (r113 != null) goto L164;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L157
        if (r119 == null) goto L146;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L157
        if (r120 == null) goto L146;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L157
        if (r121 == null) goto L146;
        Object r122 = r121.a("photo_search_result_page_change", r101);     // Catch: Throwable -> L157
    L147:
        if (r122 != null) goto L149;
    L156:
        r109 = r101;
        goto L165
    L149:
        if ((r122 instanceof Integer) == false) goto L152;
        r104 = r122;
    L152:
        Integer r123 = (Integer) r104;     // Catch: Throwable -> L157
        if (r123 == null) goto L156;
        r109 = r123;
        goto L165
    L146:
        r122 = null;
        goto L147
    L80:
        if ((r115 instanceof Integer) == true) goto L82;
        Object r124 = null;
    L83:
        r116 = (Integer) r124;     // Catch: Throwable -> L125
        if (r116 != null) goto L123;
        if ((r115 instanceof Number) == false) goto L110;
        if (Integer.class != Float.class) goto L95;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L125
        if ((r125 instanceof Integer) == true) goto L93;
        r125 = null;
    L93:
        r116 = (Integer) r125;     // Catch: Throwable -> L125
        goto L123
    L95:
        if (Integer.class != Double.class) goto L101;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L125
        if ((r126 instanceof Integer) == true) goto L99;
        r126 = null;
    L99:
        r116 = (Integer) r126;     // Catch: Throwable -> L125
        goto L123
    L101:
        if (Integer.class != Integer.class) goto L104;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L125
        goto L123
    L104:
        if (Integer.class != Long.class) goto L110;
        Long r127 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L125
        if ((r127 instanceof Integer) == true) goto L108;
        r127 = null;
    L108:
        r116 = (Integer) r127;     // Catch: Throwable -> L125
    L110:
        if ((r115 instanceof JSONObject) == false) goto L112;
    L186:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L118
        Object r128 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L118
        if ((r128 instanceof Integer) == true) goto L116;
        r128 = null;
    L116:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L118
    L120:
        r116 = r129;
        if (Result.m9455isFailureimpl(r116) == false) goto L123;
    L118:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L125
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L125
        goto L120
    L112:
        if ((r115 instanceof JSONArray) == false) goto L122;
    L82:
        r124 = r115;
    L125:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L157
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L177:
        return ((Number) r109).intValue();
    L9:
        if ((r105 instanceof Integer) == true) goto L11;
        Object r132 = null;
    L12:
        r106 = (Integer) r132;     // Catch: Throwable -> L54
        if (r106 != null) goto L52;
        if ((r105 instanceof Number) == false) goto L39;
        if (Integer.class != Float.class) goto L24;
        Float r133 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L54
        if ((r133 instanceof Integer) == true) goto L22;
        r133 = null;
    L22:
        r106 = (Integer) r133;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Integer.class != Double.class) goto L30;
        Double r134 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L54
        if ((r134 instanceof Integer) == true) goto L28;
        r134 = null;
    L28:
        r106 = (Integer) r134;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Integer.class != Integer.class) goto L33;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Integer.class != Long.class) goto L39;
        Long r135 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L54
        if ((r135 instanceof Integer) == true) goto L37;
        r135 = null;
    L37:
        r106 = (Integer) r135;     // Catch: Throwable -> L54
    L39:
        if ((r105 instanceof JSONObject) == false) goto L41;
    L178:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L47
        Object r136 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r136 instanceof Integer) == true) goto L45;
        r136 = null;
    L45:
        Object r137 = Result.m9449constructorimpl((Integer) r136);     // Catch: Throwable -> L47
    L49:
        r106 = r137;
        if (Result.m9455isFailureimpl(r106) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L54
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r105 instanceof JSONArray) == false) goto L51;
    L11:
        r132 = r105;
    L54:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L167
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L172;
        EnsureManager.ensureNotReachHere(r142);
    L172:
        if (Result.m9455isFailureimpl(r141) == true) goto L175;
        r101 = r141;
    L175:
        r109 = r101;
        goto L177
    }

    public static boolean r() {
        int r100 = TradeFastHostSetting.f451421a;
        Object r101 = 1;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger r103 = TradeHostSettingsCacheManger.f451423a;     // Catch: Throwable -> L167
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L54
        Object r105 = TradeHostSettingsCacheManger.f451425c.get("ec_search_sug_session_enable");     // Catch: Throwable -> L54
        if (r105 != null) goto L9;
    L51:
        Object r106 = null;
    L52:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L54
    L56:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L167
        if (r108 == null) goto L60;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L167
    L60:
        if (Result.m9455isFailureimpl(r107) == false) goto L63;
        r107 = null;
    L63:
        if ((r107 instanceof Integer) == true) goto L65;
        r107 = null;
    L65:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L167
        if (r109 != null) goto L72;
        r103.getClass();     // Catch: Throwable -> L167
        Object r110 = TradeHostSettingsCacheManger.f451424b.get("ec_search_sug_session_enable");     // Catch: Throwable -> L167
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L167
    L72:
        if (r109 != null) goto L177;
        int r111 = TradeHostSetting.f451422a;     // Catch: Throwable -> L167
    L157:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L167
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L167
        if (r114 == null) goto L162;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L167
    L162:
        if (Result.m9455isFailureimpl(r113) == false) goto L164;
        r113 = r101;
    L164:
        r109 = r113;
    L165:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L167
        TradeHostSettingsCacheManger.a("ec_search_sug_session_enable", r109);     // Catch: Throwable -> L167
        goto L177
    L183:
        TradeHostSettingsCacheManger.f451423a.getClass();     // Catch: Throwable -> L125
        Object r115 = TradeHostSettingsCacheManger.f451425c.get("ec_search_sug_session_enable");     // Catch: Throwable -> L125
        if (r115 != null) goto L80;
    L122:
        Object r116 = null;
    L123:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L125
    L127:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L157
        if (r118 == null) goto L131;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L157
    L131:
        if (Result.m9455isFailureimpl(r117) == false) goto L134;
        r117 = null;
    L134:
        if ((r117 instanceof Integer) == true) goto L136;
        r117 = null;
    L136:
        r113 = (Integer) r117;     // Catch: Throwable -> L157
        if (r113 != null) goto L164;
        ITradeSearchHostService r119 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L157
        if (r119 == null) goto L146;
        ITradeSearchHostAbility r120 = r119.getITradeSearchHostAbility();     // Catch: Throwable -> L157
        if (r120 == null) goto L146;
        ITradeSearchHostABService r121 = r120.getHostAB();     // Catch: Throwable -> L157
        if (r121 == null) goto L146;
        Object r122 = r121.a("ec_search_sug_session_enable", r101);     // Catch: Throwable -> L157
    L147:
        if (r122 != null) goto L149;
    L156:
        r109 = r101;
        goto L165
    L149:
        if ((r122 instanceof Integer) == false) goto L152;
        r104 = r122;
    L152:
        Integer r123 = (Integer) r104;     // Catch: Throwable -> L157
        if (r123 == null) goto L156;
        r109 = r123;
        goto L165
    L146:
        r122 = null;
        goto L147
    L80:
        if ((r115 instanceof Integer) == true) goto L82;
        Object r124 = null;
    L83:
        r116 = (Integer) r124;     // Catch: Throwable -> L125
        if (r116 != null) goto L123;
        if ((r115 instanceof Number) == false) goto L110;
        if (Integer.class != Float.class) goto L95;
        Float r125 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L125
        if ((r125 instanceof Integer) == true) goto L93;
        r125 = null;
    L93:
        r116 = (Integer) r125;     // Catch: Throwable -> L125
        goto L123
    L95:
        if (Integer.class != Double.class) goto L101;
        Double r126 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L125
        if ((r126 instanceof Integer) == true) goto L99;
        r126 = null;
    L99:
        r116 = (Integer) r126;     // Catch: Throwable -> L125
        goto L123
    L101:
        if (Integer.class != Integer.class) goto L104;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L125
        goto L123
    L104:
        if (Integer.class != Long.class) goto L110;
        Long r127 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L125
        if ((r127 instanceof Integer) == true) goto L108;
        r127 = null;
    L108:
        r116 = (Integer) r127;     // Catch: Throwable -> L125
    L110:
        if ((r115 instanceof JSONObject) == false) goto L112;
    L189:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L118
        Object r128 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L118
        if ((r128 instanceof Integer) == true) goto L116;
        r128 = null;
    L116:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L118
    L120:
        r116 = r129;
        if (Result.m9455isFailureimpl(r116) == false) goto L123;
    L118:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L125
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L125
        goto L120
    L112:
        if ((r115 instanceof JSONArray) == false) goto L122;
    L82:
        r124 = r115;
    L125:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L157
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L177:
        if (((Number) r109).intValue() != 0) goto L193;
        return false;
    L193:
        return true;
    L9:
        if ((r105 instanceof Integer) == true) goto L11;
        Object r132 = null;
    L12:
        r106 = (Integer) r132;     // Catch: Throwable -> L54
        if (r106 != null) goto L52;
        if ((r105 instanceof Number) == false) goto L39;
        if (Integer.class != Float.class) goto L24;
        Float r133 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L54
        if ((r133 instanceof Integer) == true) goto L22;
        r133 = null;
    L22:
        r106 = (Integer) r133;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Integer.class != Double.class) goto L30;
        Double r134 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L54
        if ((r134 instanceof Integer) == true) goto L28;
        r134 = null;
    L28:
        r106 = (Integer) r134;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Integer.class != Integer.class) goto L33;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Integer.class != Long.class) goto L39;
        Long r135 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L54
        if ((r135 instanceof Integer) == true) goto L37;
        r135 = null;
    L37:
        r106 = (Integer) r135;     // Catch: Throwable -> L54
    L39:
        if ((r105 instanceof JSONObject) == false) goto L41;
    L181:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L47
        Object r136 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r136 instanceof Integer) == true) goto L45;
        r136 = null;
    L45:
        Object r137 = Result.m9449constructorimpl((Integer) r136);     // Catch: Throwable -> L47
    L49:
        r106 = r137;
        if (Result.m9455isFailureimpl(r106) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L54
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r105 instanceof JSONArray) == false) goto L51;
    L11:
        r132 = r105;
    L54:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L167
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L172;
        EnsureManager.ensureNotReachHere(r142);
    L172:
        if (Result.m9455isFailureimpl(r141) == true) goto L175;
        r101 = r141;
    L175:
        r109 = r101;
        goto L177
    }

    @JvmStatic
    public static final ArrayList<EcSearchSliceSugConfig.PreloadConfig> q() {
        ArrayList<EcSearchSliceSugConfig.PreloadConfig> r100 = j().d();
        if (r100.isEmpty() == false) goto L5;
        EcSearchSliceSugConfig.PreloadConfig r101 = new EcSearchSliceSugConfig.PreloadConfig();
        r101.h();
        r101.i();
        r101.g();
        r101.j();
        Unit r102 = Unit.INSTANCE;
        r100.add(r101);
    L5:
        return r100;
    }
}
