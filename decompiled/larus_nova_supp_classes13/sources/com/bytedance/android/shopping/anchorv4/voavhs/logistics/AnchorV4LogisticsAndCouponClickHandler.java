package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.utils.r;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.internal.LinkedTreeMap;
import fi3.n;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorV4LogisticsAndCouponClickHandler implements com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public final Lazy a;
    public final AnchorV4VM b;
    public final Context c;
    public com.bytedance.android.shopping.anchorv4.voavhs.logistics.a d;
    public final CommonMeta e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r1, Object r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final Context getContext() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(final View r21, Action r22, Object r23) {
        Intrinsics.checkNotNullParameter(r21, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r22, "action");
        String r0 = r22.getId();
        if (r0 != null) goto L6;
    L337:
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r1 = this.d;
        if (r1 == null) goto L392;
        AnchorV4LogisticsAndCouponMeta r2 = r1.c;
        if (r2 == null) goto L402;
        AnchorV4LogisticsAndCouponBusinessMeta r3 = r2.getBusinessMeta();
        if (r3 == null) goto L403;
        List<String> r4 = r3.getLogisticsJumpUrls();
        if (r4 == null) goto L404;
        Iterator<T> r5 = r4.iterator();
        int r6 = 0;
    L347:
        if (r5.hasNext() == false) goto L405;
        Object r9 = r5.next();
        int r10 = r6 + 1;
        if (r6 >= 0) goto L351;
        CollectionsKt.throwIndexOverflow();
    L351:
        String r11 = (String) r9;
        if (Intrinsics.areEqual("logistics_and_coupon_logistics_event_id_" + r6, r22.getId()) == false) goto L391;
        if (k.c(r11) == false) goto L391;
        Context r12 = this.c;
        if ((r12 instanceof Activity) == true) goto L359;
        r12 = null;
    L359:
        if (((Activity) r12) != null) goto L361;
    L364:
        int r13 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r14 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r14 == null) goto L391;
        Pair[] r15 = new Pair[2];
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r16 = this.d;
        if (r16 == null) goto L377;
        AnchorV4LogisticsAndCouponMeta r17 = r16.c;
        if (r17 == null) goto L377;
        AnchorV4LogisticsAndCouponBusinessMeta r18 = r17.getBusinessMeta();
        if (r18 == null) goto L377;
        List<Integer> r19 = r18.getLogisticsTextType();
        if (r19 == null) goto L377;
        Integer r110 = (Integer) CollectionsKt.getOrNull(r19, r6);
        if (r110 == null) goto L377;
        String r111 = String.valueOf(r110.intValue());
    L378:
        r15[0] = TuplesKt.to("text_type", r111);
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r112 = this.d;
        if (r112 == null) goto L389;
        AnchorV4LogisticsAndCouponMeta r113 = r112.c;
        if (r113 == null) goto L389;
        AnchorV4LogisticsAndCouponBusinessMeta r114 = r113.getBusinessMeta();
        if (r114 == null) goto L389;
        List<Integer> r115 = r114.getLogisticsType();
        if (r115 == null) goto L389;
        Integer r7 = (Integer) ListProtector.get(r115, r6);
        if (r7 == null) goto L389;
        String r8 = String.valueOf(r7.intValue());
    L390:
        r15[1] = TuplesKt.to("type", r8);
        r14.c = MapsKt.mapOf(r15);
        AnchorV4TrackerImpl.b(r14, "click_logistics_module", false, null, false, null, 30);
    L389:
        r8 = null;
    L377:
        r111 = null;
        goto L378
    L361:
        if (StringsKt.startsWith$default(r11, "sslocal://webcast", false, 2, null) == false) goto L363;
        JSONObject r116 = new JSONObject();
        r116.put("identifier", this.b.getSessionId());
        com.bytedance.android.shopping.anchorv4.containers.b.b(this.c, r11, r116, false);
        goto L364
    L363:
        p.a.d(r11, (Activity) this.c);
    L391:
        r6 = r10;
        goto L347
    L405:
        return;
    L404:
        return;
    L403:
        return;
    L402:
        return;
    L392:
        return;
    L6:
        switch(r0.hashCode()) {
            case -2046874933: goto L281;
            case -755574267: goto L255;
            case -619436570: goto L239;
            case 24426383: goto L167;
            case 298367646: goto L156;
            case 1142813652: goto L22;
            case 2110419926: goto L9;
            default: goto L337;
        };
    L9:
        if (r0.equals("logistics_and_coupon_guarantee_header_event_id") == false) goto L337;
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r20 = this.d;
        if (r20 == null) goto L337;
        AnchorV4LogisticsAndCouponMeta r24 = r20.c;
        if (r24 == null) goto L337;
        AnchorV4LogisticsAndCouponBusinessMeta r25 = r24.getBusinessMeta();
        if (r25 == null) goto L337;
        String r117 = r25.getGuaranteeHeaderUrl();
        if (r117 == null) goto L337;
        ECLiveHybridUtil.k(this.c, r117, false, false, false, null, 252);
        int r26 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r27 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r27 == null) goto L337;
        AnchorV4TrackerImpl.b(r27, "wuyou_service_info_bar_click", false, null, false, null, 30);
        goto L337
    L22:
        if (r0.equals("logistics_and_coupon_coupon_event_id") == false) goto L337;
        JSONObject r28 = new JSONObject();
        CommonMeta r29 = this.e;
        if (r29 == null) goto L26;
        String r30 = r29.getPromotionId();
    L27:
        r28.put(PdpOpenThirdParam.KEY_PROMOTION_ID, r30);
        CommonMeta r31 = this.e;
        if (r31 == null) goto L30;
        String r32 = r31.getProductId();
    L31:
        r28.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r32);
        CommonMeta r33 = this.e;
        if (r33 == null) goto L34;
        String r34 = r33.getShopId();
    L35:
        r28.put("shop_id", r34);
        CommonMeta r35 = this.e;
        if (r35 == null) goto L38;
        String r36 = r35.getAuthorId();
    L39:
        r28.put("author_id", r36);
        CommonMeta r37 = this.e;
        if (r37 == null) goto L42;
        String r38 = r37.getSecAuthorId();
    L43:
        r28.put(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID, r38);
        CommonMeta r39 = this.e;
        if (r39 == null) goto L46;
        String r40 = r39.getPayType();
    L47:
        r28.put("pay_type", r40);
        CommonMeta r41 = this.e;
        if (r41 == null) goto L50;
        Integer r42 = Integer.valueOf(r41.getProductType());
    L51:
        r28.put("product_type", r42);
        CommonMeta r43 = this.e;
        if (r43 == null) goto L54;
        Integer r44 = Integer.valueOf(r43.getPresellType());
    L55:
        r28.put("presell_type", r44);
        CommonMeta r45 = this.e;
        if (r45 == null) goto L58;
        Long r46 = r45.getDiscountMinPrice();
    L59:
        r28.put("discount_price", r46);
        CommonMeta r47 = this.e;
        if (r47 == null) goto L62;
        String r48 = r47.getRequestAdditions();
    L63:
        r28.put("request_additions", r48);
        CommonMeta r49 = this.e;
        if (r49 == null) goto L66;
        String r50 = r49.getMarketingChannel();
    L67:
        r28.put("marketing_channel", r50);
        CommonMeta r51 = this.e;
        if (r51 == null) goto L70;
        String r52 = r51.getLiveRoomId();
    L71:
        r28.put("live_room_id", r52);
        int r53 = com.bytedance.android.shopping.anchorv4.containers.b.a;
        CommonMeta r54 = this.e;
        AnchorV4VM r55 = this.b;
        if (r55 == null) goto L74;
        LinkedTreeMap r56 = r55.trackMeta();
    L75:
        r28.put("log_data", com.bytedance.android.shopping.anchorv4.containers.b.a(r54, r56));
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r57 = this.d;
        if (r57 == null) goto L96;
        AnchorV4LogisticsAndCouponMeta r58 = r57.c;
        if (r58 == null) goto L96;
        AnchorV4LogisticsAndCouponBusinessMeta r59 = r58.getBusinessMeta();
        if (r59 == null) goto L96;
        String r60 = r59.getCouponMeta();
        if (r60 == null) goto L96;
        JSONObject r61 = z1.g(r60);
        if (r61 == null) goto L96;
        JSONObject r62 = r61.optJSONObject("business_meta");
        if (r62 == null) goto L90;
        JSONObject r118 = r62.optJSONObject("deposit_presale_activity");
        if (r118 == null) goto L90;
        r28.put("deposit_presale_activity", r118);
    L90:
        if (r62 == null) goto L94;
        JSONObject r119 = r62.optJSONObject("subsidized_activity");
        if (r119 == null) goto L94;
        r28.put("subsidized_activity", r119);
    L94:
        if (r62 == null) goto L96;
        r28.put("min_price", r62.optLong("min_price_with_pre_activity"));
    L96:
        r28.put("identifier", AnchorV4DataManager.d);
        CommonMeta r63 = this.e;
        if (r63 == null) goto L99;
        String r64 = r63.getChannelId();
    L100:
        r28.put("channel_id", r64);
        CommonMeta r65 = this.e;
        if (r65 == null) goto L103;
        Integer r66 = r65.getChannelType();
    L104:
        r28.put("channel_type", r66);
        Context r67 = this.c;
        String r68 = ECSettingKeys.m0();
        int r120 = this.b.getPanelHeightPercent();
        if (r120 <= 0) goto L107;
        r68 = l0.a(r68, "height_percent", String.valueOf(r120));
    L107:
        boolean r121 = this.b.pageStatus().h;
        com.bytedance.android.shopping.anchorv4.containers.b.b(r67, r68, r28, false);
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r69 = this.d;
        if (r69 == null) goto L124;
        AnchorV4LogisticsAndCouponMeta r70 = r69.c;
        if (r70 == null) goto L124;
        AnchorV4LogisticsAndCouponBusinessMeta r71 = r70.getBusinessMeta();
        if (r71 == null) goto L124;
        String r72 = r71.getCouponMeta();
        if (r72 == null) goto L124;
        int r73 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r74 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r74 == null) goto L124;
        JSONObject r75 = z1.g(r72);
        if (r75 == null) goto L122;
        JSONObject r76 = r75.optJSONObject("track_meta");
        if (r76 == null) goto L122;
        Map r77 = z1.j(r76);
    L123:
        r74.c = r77;
        AnchorV4TrackerImpl.b(r74, "product_coupon_click", false, null, false, null, 30);
    L122:
        r77 = null;
    L124:
        CommonMeta r78 = this.b.commonMeta();
        if (r78 == null) goto L131;
        String r79 = r78.getEntranceInfo();
        if (r79 == null) goto L131;
        JSONObject r80 = z1.g(r79);
        if (r80 == null) goto L131;
        String r122 = r80.optString("log_extra");
    L132:
        CommonMeta r81 = this.b.commonMeta();
        if (r81 == null) goto L337;
        String r123 = h73.a.b(r81);
        if (r123 == null) goto L337;
        g r82 = AdLogUtils.a;
        CommonMeta r84 = this.b.commonMeta();
        if (r84 == null) goto L139;
        Map<String, ? extends Object> r124 = h73.a.a(r84);
    L140:
        Intrinsics.checkNotNullParameter(r123, "cid");
        if (r123.length() != 0) goto L143;
        boolean r85 = true;
    L144:
        if (r85 == true) goto L337;
        ECAppInfoService r86 = ECAppInfoService.e;
        if (we.a.a == false) goto L149;
    L154:
        AdLogUtils.a().d("otherclick", null, Long.valueOf(CastLongProtector.parseLong(r123)), r122);
        goto L337
    L149:
        if (r86.n() == true) goto L154;
        g r87 = AdLogUtils.a;
        if (r87 == null) goto L337;
        r87.d("product_detail_ad", "otherclick", "coupon", r123, r122, r124, null, "umeng");
        goto L337
    L143:
        r85 = false;
        goto L144
    L139:
        r124 = null;
    L131:
        r122 = null;
        goto L132
    L103:
        r66 = null;
        goto L104
    L99:
        r64 = null;
        goto L100
    L74:
        r56 = null;
        goto L75
    L70:
        r52 = null;
        goto L71
    L66:
        r50 = null;
        goto L67
    L62:
        r48 = null;
        goto L63
    L58:
        r46 = null;
        goto L59
    L54:
        r44 = null;
        goto L55
    L50:
        r42 = null;
        goto L51
    L46:
        r40 = null;
        goto L47
    L42:
        r38 = null;
        goto L43
    L38:
        r36 = null;
        goto L39
    L34:
        r34 = null;
        goto L35
    L30:
        r32 = null;
        goto L31
    L26:
        r30 = null;
        goto L27
    L156:
        if (r0.equals("logistics_and_coupon_choose_panel_event_id") == false) goto L337;
        String r88 = r22.getMeta();
        if (r88 != null) goto L161;
        r88 = "{}";
    L161:
        if (Intrinsics.areEqual(new JSONObject(r88).optString("sku_from"), "spec") == false) goto L165;
        this.b.showSku(new n(null, 4, null, 13));
        int r89 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r90 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r90 == null) goto L337;
        AnchorV4TrackerImpl.b(r90, "click_product_sku", false, null, false, null, 30);
        goto L337
    L165:
        this.b.showSku(new n(null, 1, null, 13));
        goto L337
    L167:
        if (r0.equals("logistics_and_coupon_service_event_id") == false) goto L337;
        JSONObject r91 = new JSONObject();
        JSONObject r125 = new JSONObject();
        Result.Companion r92 = Result.Companion;     // Catch: Throwable -> L179
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r126 = this.d;     // Catch: Throwable -> L179
        if (r126 == null) goto L176;
        AnchorV4LogisticsAndCouponMeta r127 = r126.c;     // Catch: Throwable -> L179
        if (r127 == null) goto L176;
        AnchorV4LogisticsAndCouponBusinessMeta r128 = r127.getBusinessMeta();     // Catch: Throwable -> L179
        if (r128 == null) goto L176;
        String r129 = r128.getServices();     // Catch: Throwable -> L179
    L177:
        Object r94 = Result.constructor-impl(new JSONArray(r129));     // Catch: Throwable -> L179
    L182:
        if (Result.isFailure-impl(r94) == false) goto L184;
        r94 = null;
    L184:
        r125.put("services", r94);
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r130 = this.d;     // Catch: Throwable -> L195
        if (r130 == null) goto L192;
        AnchorV4LogisticsAndCouponMeta r131 = r130.c;     // Catch: Throwable -> L195
        if (r131 == null) goto L192;
        AnchorV4LogisticsAndCouponBusinessMeta r132 = r131.getBusinessMeta();     // Catch: Throwable -> L195
        if (r132 == null) goto L192;
        String r133 = r132.getSpecialService();     // Catch: Throwable -> L195
    L193:
        Object r95 = Result.constructor-impl(new JSONArray(r133));     // Catch: Throwable -> L195
    L198:
        if (Result.isFailure-impl(r95) == false) goto L200;
        r95 = null;
    L200:
        r125.put("special_services", r95);
        Unit r96 = Unit.INSTANCE;
        r91.put("data", r125);
        r91.put("identifier", this.b.getSessionId());
        int r97 = com.bytedance.android.shopping.anchorv4.containers.b.a;
        CommonMeta r98 = this.e;
        AnchorV4VM r134 = this.b;
        if (r134 == null) goto L203;
        LinkedTreeMap r135 = r134.trackMeta();
    L204:
        r91.put("log_data", com.bytedance.android.shopping.anchorv4.containers.b.a(r98, r135));
        Context r99 = this.c;
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r136 = this.d;
        if (r136 == null) goto L217;
        AnchorV4LogisticsAndCouponMeta r137 = r136.c;
        if (r137 == null) goto L217;
        AnchorV4LogisticsAndCouponBusinessMeta r138 = r137.getBusinessMeta();
        if (r138 == null) goto L217;
        String r139 = r138.getServicePanelUrl();
        if (r139 == null) goto L217;
        if (k.c(r139) == true) goto L216;
        r139 = null;
    L216:
        if (r139 == null) goto L217;
    L221:
        boolean r140 = this.b.pageStatus().h;
        com.bytedance.android.shopping.anchorv4.containers.b.b(r99, r139, r91, false);
        String r100 = BtmSDK.INSTANCE.obtainEventBtmParams(new BtmItemBuilder("a1.b8094.c0581.d5511", null, 2, null).withView(r21).build());
        int r101 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r141 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r141 == null) goto L337;
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r102 = this.d;
        if (r102 == null) goto L228;
        AnchorV4LogisticsAndCouponMeta r103 = r102.c;
        if (r103 == null) goto L228;
        LinkedTreeMap<String, Object> r104 = r103.getTrackMeta();
    L229:
        r141.d = r104;
        Pair[] r105 = new Pair[2];
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r106 = this.d;
        if (r106 == null) goto L236;
        AnchorV4LogisticsAndCouponMeta r107 = r106.c;
        if (r107 == null) goto L236;
        AnchorV4LogisticsAndCouponBusinessMeta r108 = r107.getBusinessMeta();
        if (r108 == null) goto L236;
        String r109 = r108.getServiceTypes();
    L237:
        r105[0] = TuplesKt.to("service_type", r109);
        r105[1] = TuplesKt.to("btm_id", r100);
        r141.c = MapsKt.mapOf(r105);
        AnchorV4TrackerImpl.b(r141, "click_product_service", false, null, false, null, 30);
    L236:
        r109 = null;
    L228:
        r104 = null;
    L217:
        lh3.a r142 = (lh3.a) this.a.getValue();
        if (r142 == null) goto L220;
        r139 = r142.b();
        goto L221
    L220:
        r139 = null;
        goto L221
    L203:
        r135 = null;
    L192:
        r133 = null;
    L195:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        r95 = Result.constructor-impl(ResultKt.createFailure(th));
    L176:
        r129 = null;
    L179:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        r94 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L182
    L239:
        if (r0.equals("logistics_and_coupon_newbie_service_event_id") == false) goto L337;
        Activity r145 = ECAppInfoService.e.getCurrentActivity();
        if (r145 == null) goto L251;
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r146 = this.d;
        if (r146 == null) goto L249;
        AnchorV4LogisticsAndCouponMeta r147 = r146.c;
        if (r147 == null) goto L249;
        AnchorV4LogisticsAndCouponBusinessMeta r148 = r147.getBusinessMeta();
        if (r148 == null) goto L249;
        String r149 = r148.getNewbieServiceUrl();
    L250:
        r.a(r149, r145);
    L249:
        r149 = null;
    L251:
        int r150 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r151 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r151 == null) goto L337;
        AnchorV4TrackerImpl.b(r151, "click_product_service", false, null, false, null, 30);
        goto L337
    L255:
        if (r0.equals("logistics_and_coupon_pick_car_model") == false) goto L337;
        Context r152 = this.c;
        if ((r152 instanceof Activity) == true) goto L259;
        r152 = null;
    L259:
        Activity r153 = (Activity) r152;
        if (r153 == null) goto L337;
        p r154 = p.a;
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r155 = this.d;
        if (r155 == null) goto L268;
        AnchorV4LogisticsAndCouponMeta r156 = r155.c;
        if (r156 == null) goto L268;
        AnchorV4LogisticsAndCouponBusinessMeta r157 = r156.getBusinessMeta();
        if (r157 == null) goto L268;
        String r158 = r157.getCarModelLink();
    L269:
        r154.d(r158, r153);
        int r159 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r160 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r160 == null) goto L337;
        Pair[] r161 = new Pair[3];
        r161[0] = TuplesKt.to("module_name", "adaptation");
        r161[1] = TuplesKt.to("module_location", CarAdaptationLocation.Logistics.getModuleLocation());
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r162 = this.d;
        if (r162 == null) goto L278;
        AnchorV4LogisticsAndCouponMeta r163 = r162.c;
        if (r163 == null) goto L278;
        AnchorV4LogisticsAndCouponBusinessMeta r164 = r163.getBusinessMeta();
        if (r164 == null) goto L278;
        String r165 = r164.getHasAddCar();
    L279:
        r161[2] = TuplesKt.to("module_status", r165);
        r160.c = MapsKt.mapOf(r161);
        AnchorV4TrackerImpl.b(r160, "pd_page_module_click", false, null, false, null, 30);
    L278:
        r165 = null;
    L268:
        r158 = null;
        goto L269
    L281:
        if (r0.equals("logistics_and_coupon_installment_event_id") == false) goto L337;
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r166 = this.d;
        if (r166 == null) goto L291;
        AnchorV4LogisticsAndCouponMeta r167 = r166.c;
        if (r167 == null) goto L291;
        AnchorV4LogisticsAndCouponBusinessMeta r168 = r167.getBusinessMeta();
        if (r168 == null) goto L291;
        OpenInfoMeta r169 = r168.getOpenInfoMeta();
        if (r169 == null) goto L291;
        final String r170 = r169.getPageType();
    L292:
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r171 = this.d;
        if (r171 == null) goto L337;
        AnchorV4LogisticsAndCouponMeta r172 = r171.c;
        if (r172 == null) goto L337;
        AnchorV4LogisticsAndCouponBusinessMeta r173 = r172.getBusinessMeta();
        if (r173 == null) goto L337;
        OpenInfoMeta r174 = r173.getOpenInfoMeta();
        if (r174 == null) goto L337;
        final String r175 = r174.getUrl();
        if (r175 == null) goto L337;
        Activity r176 = ECAppInfoService.e.getCurrentActivity();
        if (r176 == null) goto L337;
        String r177 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b8094.c0581.d6278", Boolean.TRUE).withView(r21).build());
        if (Intrinsics.areEqual(r170, "H5") == false) goto L311;
        m0 r178 = new m0(r175);
        r178.b("entrance_location", "product_detail");
        p.a.d(r178.c(), r176);
        int r179 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r180 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r180 == null) goto L328;
        r180.c = MapsKt.mapOf(TuplesKt.to("btm_id", r177));
        AnchorV4TrackerImpl.b(r180, "click_fxh_activity", false, null, false, null, 30);
    L328:
        int r181 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r182 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r182 == null) goto L337;
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r183 = this.d;
        if (r183 == null) goto L335;
        AnchorV4LogisticsAndCouponMeta r184 = r183.c;
        if (r184 == null) goto L335;
        LinkedTreeMap<String, Object> r185 = r184.getTrackMeta();
    L336:
        r182.d = r185;
        r182.c = MapsKt.mapOf(TuplesKt.to("btm_id", r177));
        AnchorV4TrackerImpl.b(r182, "product_detail_campaign_entrance_click", false, null, false, null, 30);
    L335:
        r185 = null;
        goto L336
    L311:
        if (Intrinsics.areEqual(r170, "Lynx") == false) goto L328;
        int r186 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r187 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r187 == null) goto L327;
        Pair[] r188 = new Pair[2];
        r188[0] = TuplesKt.to("btm_id", r177);
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r189 = this.d;
        if (r189 == null) goto L323;
        AnchorV4LogisticsAndCouponMeta r190 = r189.c;
        if (r190 == null) goto L323;
        AnchorV4LogisticsAndCouponBusinessMeta r191 = r190.getBusinessMeta();
        if (r191 == null) goto L323;
        OpenInfoMeta r192 = r191.getOpenInfoMeta();
        if (r192 == null) goto L323;
        String r193 = r192.getDesc();
    L324:
        if (r193 != null) goto L326;
        r193 = "";
    L326:
        r188[1] = TuplesKt.to("button_name", r193);
        r187.c = MapsKt.mapOf(r188);
        AnchorV4TrackerImpl.b(r187, "click_payafteruse_campaign", false, null, false, null, 30);
    L323:
        r193 = null;
    L327:
        ih3.g.b.f0(this.c, r175, new AnchorV4LogisticsAndCouponClickHandler$openInstallment$$inlined$apply$lambda$1(this, r21, r170, r175));
    L291:
        r170 = null;
        goto L292
    }

    public AnchorV4LogisticsAndCouponClickHandler(AnchorV4VM r2, Context r3, com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r4, CommonMeta r5) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.a = LazyKt.lazy(AnchorV4LogisticsAndCouponClickHandler$hybridConfig$2.INSTANCE);
    }
}
