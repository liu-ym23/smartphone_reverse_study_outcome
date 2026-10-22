package com.bytedance.android.shopping.sku.inner.ultimate;

import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.sku.CpsParams;
import com.bytedance.android.ec.model.sku.DefaultSelect;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.sku.inner.repo.model.SkuPassThroughItem;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public final SkuParams a;
    public final boolean b;

    public final Map<String, Object> a() {
        if (this.b == false) goto L5;
        int r1 = k.a;
        Map r2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("track_client_entrance_info", (String) this.a.getEventParams().get("entrance_info")), TuplesKt.to("track_client", k.b(this.a.getEventParams()).toString()), TuplesKt.to("api_sku_entrance_info", this.a.getEntranceInfo())});
    L6:
        Pair[] r7 = new Pair[1];
        Pair[] r9 = new Pair[9];
        Pair[] r11 = new Pair[7];
        String r12 = this.a.getProductId();
        if ((r12 instanceof String) == true) goto L9;
        r12 = null;
    L9:
        r11[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r12);
        String r13 = this.a.getPromotionId();
        if (r13 == null) goto L207;
        r11[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PROMOTION_ID, r13);
        String r14 = this.a.getCommodityType();
        if (r14 == null) goto L14;
        Integer r15 = StringsKt.toIntOrNull(r14);
    L16:
        if ((r15 instanceof Integer) == true) goto L18;
        r15 = null;
    L18:
        r11[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, r15);
        r11[3] = TuplesKt.to("is_multi", Boolean.valueOf(this.a.isMulti()));
        String r10 = this.a.getShopId();
        if ((r10 instanceof String) == true) goto L21;
        r10 = null;
    L21:
        r11[4] = TuplesKt.to("shop_id", r10);
        String r16 = this.a.getCombinationId();
        if ((r16 instanceof String) == true) goto L24;
        r16 = null;
    L24:
        r11[5] = TuplesKt.to("combination_id", r16);
        DefaultSelect r17 = this.a.getDefaultSelect();
        if (r17 == null) goto L27;
        String r18 = r17.getSkuId();
    L29:
        if ((r18 instanceof String) == true) goto L31;
        r18 = null;
    L31:
        r11[6] = TuplesKt.to("hot_sale_sku_id", r18);
        r9[0] = TuplesKt.to("product_info", MapsKt.mapOf(r11));
        Pair[] r19 = new Pair[16];
        String r110 = this.a.getAuthorId();
        if (r110 == null) goto L205;
        r19[0] = TuplesKt.to("author_id", r110);
        String r111 = this.a.getSecAuthorId();
        if (r111 == null) goto L203;
        r19[1] = TuplesKt.to(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID, r111);
        String r112 = this.a.getItemId();
        if ((r112 instanceof String) == true) goto L38;
        r112 = null;
    L38:
        r19[2] = TuplesKt.to(PdpOpenThirdParam.KEY_ITEM_ID, r112);
        String r113 = this.a.getRoomId();
        if ((r113 instanceof String) == true) goto L41;
        r113 = null;
    L41:
        r19[3] = TuplesKt.to("live_room_id", r113);
        r19[4] = TuplesKt.to("is_group_buy", Boolean.valueOf(this.a.isGroupingBuy()));
        String r114 = String.valueOf(this.a.getActionType());
        if (r114 == null) goto L201;
        r19[5] = TuplesKt.to("action_type", r114);
        String r115 = String.valueOf(this.a.getSceneType());
        if (r115 == null) goto L199;
        r19[6] = TuplesKt.to("scene_type", r115);
        DefaultSelect r116 = this.a.getDefaultSelect();
        if (r116 == null) goto L48;
        String r117 = r116.getLastSelectedSkuId();
    L50:
        if ((r117 instanceof String) == true) goto L52;
        r117 = null;
    L52:
        r19[7] = TuplesKt.to("sku_id", r117);
        DefaultSelect r118 = this.a.getDefaultSelect();
        if (r118 == null) goto L55;
        Integer r119 = r118.getType();
    L57:
        if ((r119 instanceof Integer) == true) goto L59;
        r119 = null;
    L59:
        r19[8] = TuplesKt.to("hot_sale_type", r119);
        Lazy r120 = SkuPerformanceOpt.a;
        BuyNowPerformanceOpt.l();
        r19[9] = TuplesKt.to(PdpOpenThirdParam.KEY_ORDER_URL, null);
        if (BuyNowPerformanceOpt.a() == false) goto L62;
        String r121 = null;
    L63:
        r19[10] = TuplesKt.to("detail_url", r121);
        r19[11] = TuplesKt.to("auto_apply_coupon", Boolean.FALSE);
        List r122 = this.a.getBenefitLabels();
        if ((r122 instanceof List) == true) goto L66;
        r122 = null;
    L66:
        r19[12] = TuplesKt.to("coupon_tags", r122);
        JSONObject r123 = new JSONObject();
        r123.put(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, this.a.getCommodityType());
        r123.put(PdpOpenThirdParam.KEY_PRODUCT_ID, this.a.getProductId());
        r123.put(PdpOpenThirdParam.KEY_PROMOTION_ID, this.a.getPromotionId());
        Unit r8 = Unit.INSTANCE;
        r19[13] = TuplesKt.to("live_product_raw_data", r123.toString());
        String r20 = this.a.getSelectCarId();
        if ((r20 instanceof String) == true) goto L69;
        r20 = null;
    L69:
        r19[14] = TuplesKt.to("car_id", r20);
        r19[15] = TuplesKt.to("ngroup_buy_token", this.a.getNGroupBuyToken());
        r9[1] = TuplesKt.to("biz_context", MapsKt.mapOf(r19));
        String r21 = this.a.getReceiveAddressId();
        if ((r21 instanceof String) == true) goto L72;
        r21 = null;
    L72:
        r9[2] = TuplesKt.to("user_info", MapsKt.mapOf(TuplesKt.to("user_addr_id", r21)));
        Pair[] r22 = new Pair[15];
        SkuRestoreState r124 = this.a.getSkuState();
        if (r124 == null) goto L75;
        String[] r125 = r124.getSelectSkuKeys();
    L77:
        if ((r125 instanceof String[]) == true) goto L79;
        r125 = null;
    L79:
        r22[0] = TuplesKt.to("default_spec_id", r125);
        DefaultSelect r126 = this.a.getDefaultSelect();
        if (r126 == null) goto L82;
        Long r127 = r126.getBuyNum();
    L84:
        if ((r127 instanceof Long) == true) goto L86;
        r127 = null;
    L86:
        r22[1] = TuplesKt.to("default_count", r127);
        SkuPoiInfo r128 = this.a.getPoiInfo();
        if ((r128 instanceof SkuPoiInfo) == true) goto L89;
        r128 = null;
    L89:
        r22[2] = TuplesKt.to("poi_info", r128);
        Boolean r129 = this.a.getPopOnWindow();
        if ((r129 instanceof Boolean) == true) goto L92;
        r129 = null;
    L92:
        r22[3] = TuplesKt.to("pop_on_window", r129);
        String r130 = this.a.getSkuSessionId();
        if ((r130 instanceof String) == true) goto L95;
        r130 = null;
    L95:
        r22[4] = TuplesKt.to("sku_session_id", r130);
        r22[5] = TuplesKt.to("scroll_to_installment", Boolean.valueOf(this.a.getScrollToDouInstallment()));
        String r131 = this.a.getMaskBackgroundColor();
        if ((r131 instanceof String) == true) goto L98;
        r131 = null;
    L98:
        r22[6] = TuplesKt.to("mask_background_color", r131);
        DefaultSelect r132 = this.a.getDefaultSelect();
        if (r132 == null) goto L101;
        Boolean r133 = Boolean.valueOf(r132.getDisableServerSpecsDefaultSelect());
    L103:
        if ((r133 instanceof Boolean) == true) goto L105;
        r133 = null;
    L105:
        r22[7] = TuplesKt.to("disable_server_specs_default_select", r133);
        Integer r134 = this.a.getTermCount();
        if (r134 == null) goto L108;
        String r135 = String.valueOf(r134.intValue());
    L110:
        if ((r135 instanceof String) == true) goto L112;
        r135 = null;
    L112:
        r22[8] = TuplesKt.to("dou_installment_term", r135);
        Integer r136 = this.a.getSpecMode();
        if ((r136 instanceof Integer) == true) goto L115;
        r136 = null;
    L115:
        r22[9] = TuplesKt.to("spec_mode", r136);
        Long r137 = this.a.getSpecModeTime();
        if (r137 == null) goto L118;
        String r138 = String.valueOf(r137.longValue());
    L120:
        if ((r138 instanceof String) == true) goto L122;
        r138 = null;
    L122:
        r22[10] = TuplesKt.to("spec_mode_time", r138);
        r22[11] = TuplesKt.to("panel_width", Integer.valueOf(b.b(false)));
        r22[12] = TuplesKt.to("panel_height", Integer.valueOf(b.a()));
        r22[13] = TuplesKt.to("height_percent", this.a.getHeightPercent());
        if (BuyNowPerformanceOpt.a() == false) goto L125;
        Boolean r139 = Boolean.valueOf(a2.b(this.a.getDetailUrl()));
    L126:
        r22[14] = TuplesKt.to("show_detail_entrance", r139);
        r9[3] = TuplesKt.to("client_params", MapsKt.mutableMapOf(r22));
        Pair[] r23 = new Pair[8];
        SkuExtraData r140 = this.a.getSkuExtraData();
        if (r140 == null) goto L129;
        String r141 = r140.getMarketChannel();
    L131:
        if ((r141 instanceof String) == true) goto L133;
        r141 = null;
    L133:
        r23[0] = TuplesKt.to("marketing_channel", r141);
        String r142 = this.a.getEnterFrom();
        if ((r142 instanceof String) == true) goto L136;
        r142 = null;
    L136:
        r23[1] = TuplesKt.to(SimilarProductParam.ENTER_FROM, r142);
        String r143 = this.a.getChannelId();
        if ((r143 instanceof String) == true) goto L139;
        r143 = null;
    L139:
        r23[2] = TuplesKt.to("channel_id", r143);
        Integer r144 = this.a.getChannelType();
        if (r144 == null) goto L142;
        String r145 = String.valueOf(r144.intValue());
    L144:
        if ((r145 instanceof String) == true) goto L146;
        r145 = null;
    L146:
        r23[3] = TuplesKt.to("channel_type", r145);
        Integer r146 = this.a.getTouTiaoAppId();
        if (r146 == null) goto L149;
        String r147 = String.valueOf(r146.intValue());
    L151:
        if ((r147 instanceof String) == true) goto L153;
        r147 = null;
    L153:
        r23[4] = TuplesKt.to("toutiao_app_id", r147);
        String r148 = this.a.getEcomEntranceForm();
        if ((r148 instanceof String) == true) goto L156;
        r148 = null;
    L156:
        r23[5] = TuplesKt.to("ecom_entrance_form", r148);
        String r149 = this.a.getProductSourcePage();
        if ((r149 instanceof String) == true) goto L159;
        r149 = null;
    L159:
        r23[6] = TuplesKt.to("product_source_page", r149);
        String r150 = this.a.getBizCampaignType();
        if ((r150 instanceof String) == true) goto L162;
        r150 = null;
    L162:
        r23[7] = TuplesKt.to("biz_campaign_type", r150);
        r9[4] = TuplesKt.to("chain_info", MapsKt.mapOf(r23));
        Pair[] r4 = new Pair[3];
        ECAdLogExtra r24 = this.a.getAdLogExtra();
        if ((r24 instanceof ECAdLogExtra) == true) goto L165;
        r24 = null;
    L165:
        r4[0] = TuplesKt.to("ad_params", r24);
        ECBoltParam r25 = this.a.getBoltParam();
        if ((r25 instanceof ECBoltParam) == true) goto L168;
        r25 = null;
    L168:
        r4[1] = TuplesKt.to("bolt_param", r25);
        CpsParams r26 = this.a.getCpsParams();
        if ((r26 instanceof CpsParams) == true) goto L171;
        r26 = null;
    L171:
        r4[2] = TuplesKt.to("cps_params", r26);
        r9[5] = TuplesKt.to("custom_params", MapsKt.mapOf(r4));
        Boolean r3 = this.a.getOpenWithSass();
        if ((r3 instanceof Boolean) == true) goto L174;
        r3 = null;
    L174:
        r9[6] = TuplesKt.to("platform_params", MapsKt.mapOf(TuplesKt.to("open_with_saas", r3)));
        if (this.b == false) goto L177;
        List r5 = CollectionsKt.emptyList();
    L192:
        r9[7] = TuplesKt.to("pass_through", r5);
        r9[8] = TuplesKt.to("order_params", com.bytedance.android.shopping.sku.outer.business.ultimate.c.a(this.a, true));
        Map r6 = MapsKt.mutableMapOf(r9);
        Iterator r27 = r2.entrySet().iterator();
    L194:
        if (r27.hasNext() == false) goto L196;
        Map.Entry r28 = (Map.Entry) r27.next();
        r6.put(r28.getKey(), r28.getValue());
        goto L194
    L196:
        Unit r29 = Unit.INSTANCE;
        r7[0] = TuplesKt.to("sku_schema_param", r6);
        return MapsKt.mutableMapOf(r7);
    L177:
        String r30 = (String) this.a.getEventParams().get("entrance_info");
        this.a.getEventParams();
        LinkedHashMap r31 = new LinkedHashMap();
        BuyNowPerformanceOpt.l();
        r31.put("track.client", new UltimateBuySkuParamForMulti$getPassThrough$1(this).invoke());
        r31.put("api.sku.entrance_info", new UltimateBuySkuParamForMulti$getPassThrough$2(this).invoke());
        ArrayList r32 = new ArrayList(r31.size());
        Iterator r33 = r31.entrySet().iterator();
    L179:
        if (r33.hasNext() == false) goto L191;
        Map.Entry r34 = (Map.Entry) r33.next();
        if (Intrinsics.areEqual((String) r34.getKey(), "track.client") == false) goto L189;
        List r151 = CollectionsKt.listOf(r34.getKey());
        Object r152 = r34.getValue();
        if ((r152 instanceof String) == true) goto L185;
        r152 = null;
    L185:
        String r153 = (String) r152;
        Object r35 = r34.getValue();
        if ((r35 instanceof Map) == true) goto L188;
        r35 = null;
    L188:
        SkuPassThroughItem r154 = new SkuPassThroughItem(r151, r153, (Map) r35);
    L190:
        r32.add(r154);
        goto L179
    L189:
        r154 = new SkuPassThroughItem(CollectionsKt.listOf(r34.getKey()), String.valueOf(r34.getValue()), null, 4, null);
        goto L190
    L191:
        r5 = r32;
        goto L192
    L149:
        r147 = null;
        goto L151
    L142:
        r145 = null;
        goto L144
    L129:
        r141 = null;
        goto L131
    L125:
        r139 = null;
        goto L126
    L118:
        r138 = null;
        goto L120
    L108:
        r135 = null;
        goto L110
    L101:
        r133 = null;
        goto L103
    L82:
        r127 = null;
        goto L84
    L75:
        r125 = null;
        goto L77
    L62:
        r121 = this.a.getDetailUrl();
        goto L63
    L55:
        r119 = null;
        goto L57
    L48:
        r117 = null;
        goto L50
    L199:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L201:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L203:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L205:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L27:
        r18 = null;
        goto L29
    L14:
        r15 = null;
        goto L16
    L207:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L5:
        r2 = MapsKt.emptyMap();
        goto L6
    }

    public i(SkuParams r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "skuParams");
        this.a = r2;
        this.b = r3;
    }
}
