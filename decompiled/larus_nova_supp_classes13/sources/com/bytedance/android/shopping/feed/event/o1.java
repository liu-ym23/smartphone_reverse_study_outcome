package com.bytedance.android.shopping.feed.event;

import android.text.TextUtils;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.response.anchorv3.PromotionAppointment;
import com.bytedance.android.ec.model.response.anchorv3.PromotionPreSale;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductButtonStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionSubsidizedActivity;
import com.bytedance.android.ec.model.response.anchorv3.SeckillInfo;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.CombinationStruct;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.ImageComponent;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.dto.FallbackPage;
import com.bytedance.android.shopping.anchorv3.utils.CommerceButtonUtil;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.widget.ProductFeedDividerView;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o1 {
    public static final /* synthetic */ int b = 0;
    public final HashMap<String, String> a;

    public static final class a {
        public static o1 a(AnchorV3Param r17, String r18) {
            Intrinsics.checkNotNullParameter(r17, "param");
            r17.setEntranceInfo(EcomBcmTracker.b(PageFinder.via(r18), r17.getEntranceInfo()));
            o1 r2 = new o1();
            r2.c(PdpOpenThirdParam.KEY_SOURCE_PAGE, r17.getRequestParam().getSourcePage(), "");
            PromotionProductBaseStruct r0 = r17.getCurrentPromotion().getBaseInfo();
            if (r0 == null) goto L5;
            String r1 = r0.getPromotionId();
        L6:
            r2.c("commodity_id", r1, "");
            PromotionProductBaseStruct r3 = r17.getCurrentPromotion().getBaseInfo();
            if (r3 == null) goto L9;
            String r4 = r3.getProductId();
        L10:
            r2.c(PdpOpenThirdParam.KEY_PRODUCT_ID, r4, "");
            PromotionProductBaseStruct r5 = r17.getCurrentPromotion().getBaseInfo();
            if (r5 == null) goto L15;
            Integer r6 = r5.getPromotionSource();
            if (r6 == null) goto L15;
            String r7 = String.valueOf(r6.intValue());
        L16:
            r2.c("commodity_type", r7, "");
            r2.c(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page", "");
            r2.c("ecom_entrance_form", r17.getEComEntranceFrom(), "");
            r2.c("group_id", r17.getRequestParam().getItemId(), "");
            int r8 = com.bytedance.android.shopping.track.a.a;
            Integer r9 = r17.getFollowStatus();
            String r10 = r17.getAuthorId();
            String r11 = "1";
            if (r9 != null) goto L19;
        L32:
            String r12 = null;
        L33:
            r2.c(PdpOpenThirdParam.KEY_FOLLOW_STATUS, r12, "0");
            r2.c("ad_type", r17.getAdType(), "0");
            r2.c("chnid", r17.getRequestParam().getSourcePage(), "");
            JSONObject r13 = com.bytedance.android.shopping.extensions.k.w(r17.getEntranceInfo());
            if (r17.getCurrentPromotion().hasSecKillActivity() == true) goto L36;
            String r14 = null;
        L40:
            PromotionProductExtraStruct r15 = r17.getCurrentPromotion().getExtraInfo();
            if (r15 == null) goto L43;
            Boolean r16 = r15.getNeedCheck();
        L45:
            if (Intrinsics.areEqual(r16, Boolean.FALSE) == false) goto L47;
            Object r19 = "0";
        L48:
            if (r13 == null) goto L51;
            r13.put("with_sku", r19);
        L51:
            if (r14 == null) goto L54;
            if (r13 == null) goto L54;
            r13.put("product_activity_type", r14);
        L54:
            int r20 = com.bytedance.android.shopping.anchorv3.utils.y.a;
            PromotionProductStruct r21 = r17.getCurrentPromotion();
            if (r21 == null) goto L61;
            PromotionProductPrivilegesStruct r22 = r21.getPrivilegeInfo();
            if (r22 == null) goto L61;
            PromotionProductActivitiesStruct r23 = r22.getActivities();
            if (r23 == null) goto L61;
            PromotionDepositPresaleActivity r24 = r23.getDepositPresaleActivity();
        L62:
            if (r24 == null) goto L64;
            boolean r25 = true;
        L66:
            if (r25 == false) goto L69;
            if (r13 == null) goto L71;
            r13.put("upfront_presell", "1");
        L71:
            if (r13 == null) goto L73;
            r13.put("brand_verified", com.bytedance.android.shopping.anchorv3.utils.y.d(r17.getCurrentPromotion()));
        L73:
            if (r13 == null) goto L80;
            ECLogExtraData r26 = r17.getLogExtraData();
            if (r26 == null) goto L77;
            String r27 = r26.getLabelNameFromLive();
        L78:
            r13.put("label_name", com.bytedance.android.shopping.anchorv3.utils.y.j(r27, r17.getCurrentPromotion()));
            goto L80
        L77:
            r27 = null;
        L80:
            if (r13 == null) goto L87;
            ECLogExtraData r110 = r17.getLogExtraData();
            if (r110 == null) goto L84;
            String r111 = r110.getBaseVerifiedCategory();
        L85:
            r13.put("base_verified_category", com.bytedance.android.shopping.anchorv3.utils.y.b(r111, r17.getCurrentPromotion()));
            goto L87
        L84:
            r111 = null;
        L87:
            if (r13 == null) goto L93;
            ECLogExtraData r112 = r17.getLogExtraData();
            if (r112 == null) goto L91;
            String r113 = r112.getLabelNameLive();
        L92:
            r13.put("label_name_live", r113);
            goto L93
        L91:
            r113 = null;
        L93:
            if (r13 == null) goto L103;
            PromotionProductStruct r114 = r17.getCurrentPromotion();
            if (r114 == null) goto L101;
            PromotionProductBaseStruct r115 = r114.getBaseInfo();
            if (r115 == null) goto L101;
            if (r115.getSoldStatus() != 2) goto L101;
            int r116 = 1;
        L102:
            r13.put("is_under_stock", r116);
        L101:
            r116 = 0;
        L103:
            if (r13 == null) goto L105;
            r13.put("is_replay", com.bytedance.android.shopping.anchorv3.utils.y.p(r17.getCurrentPromotion()));
        L105:
            if (r13 == null) goto L108;
            r13.put("is_with_video", com.bytedance.android.shopping.anchorv3.utils.y.h(r17.getCurrentPromotion()));
        L108:
            if (r13 == null) goto L110;
            r13.put("is_package_sale", com.bytedance.android.shopping.anchorv3.utils.y.t(r17.getCurrentPromotion()));
        L110:
            Pair r117 = com.bytedance.android.shopping.anchorv3.utils.y.n(r17.getCurrentPromotion());
            String r28 = (String) r117.component1();
            String r118 = (String) r117.component2();
            if (r13 == null) goto L113;
            r13.put("upfront_presell", r118);
        L113:
            if (r13 == null) goto L115;
            r13.put("is_activity_banner", r28);
        L115:
            PromotionProductPrivilegesStruct r29 = r17.getCurrentPromotion().getPrivilegeInfo();
            if (r29 == null) goto L120;
            PromotionProductActivitiesStruct r30 = r29.getActivities();
            if (r30 == null) goto L120;
            PromotionSubsidizedActivity r31 = r30.getSubsidizedActivity();
        L122:
            if (r31 == null) goto L125;
            if (r13 == null) goto L125;
            r13.put("subsidized_activity", r17.getRequestParam().getMarketChannel() + "_million_discount");
        L125:
            ECLogExtraData r32 = r17.getLogExtraData();
            if (r32 == null) goto L136;
            String r33 = r32.getThreeDLogData();
            if (r33 == null) goto L136;
            if (com.bytedance.android.shopping.extensions.k.c(r33) == true) goto L133;
            r33 = null;
        L133:
            if (r33 == null) goto L136;
            if (r13 == null) goto L136;
            r13.put("source_3d", r33);
        L136:
            if (r13 == null) goto L145;
            PromotionProductExtraStruct r34 = r17.getCurrentPromotion().getExtraInfo();
            if (r34 == null) goto L140;
            ImageComponent r35 = r34.getCombination();
        L141:
            if (r35 == null) goto L143;
            int r36 = 1;
        L144:
            r13.put("is_exist_match_tab", r36);
            goto L145
        L143:
            r36 = 0;
            goto L144
        L140:
            r35 = null;
        L145:
            PromotionProductExtraStruct r37 = r17.getCurrentPromotion().getExtraInfo();
            if (r37 == null) goto L155;
            ImageComponent r38 = r37.getCombination();
            if (r38 == null) goto L155;
            CombinationStruct r39 = r38.getCombinationStruct();
            if (r39 == null) goto L155;
            String r40 = r39.getCombinationId();
            if (r40 == null) goto L155;
            if (r13 == null) goto L155;
            r13.put("combination_id", r40);
        L155:
            r2.c("entrance_info", String.valueOf(r13), "");
            PromotionProductStruct r41 = r17.getCurrentPromotion();
            Intrinsics.checkNotNullParameter(r41, "$this$getVirtualFlag");
            if (r41.isVirtualGood() == false) goto L158;
            String r42 = "1";
        L159:
            r2.c("virtual_commodity_flag", r42, "");
            PromotionProductStruct r43 = r17.getCurrentPromotion();
            Intrinsics.checkNotNullParameter(r43, "$this$getCouponFlag");
            if (r43.hasCoupon() == false) goto L162;
            String r44 = "1";
        L163:
            r2.c("with_coupon", r44, "");
            PromotionProductStruct r45 = r17.getCurrentPromotion();
            Intrinsics.checkNotNullParameter(r45, "$this$getButtonStatus");
            int r119 = CommerceButtonUtil.a;
            Intrinsics.checkNotNullParameter(r45, "productStruct");
            PromotionProductPrivilegesStruct r120 = r45.getPrivilegeInfo();
            if (r120 == null) goto L168;
            PromotionProductActivitiesStruct r121 = r120.getActivities();
            if (r121 == null) goto L168;
            PromotionPreSale r122 = r121.getPresaleActivity();
        L169:
            if (r122 == null) goto L171;
            CommerceButtonUtil.ButtonStatus r46 = CommerceButtonUtil.ButtonStatus.PRE_SELL;
        L199:
            r2.c("button_status", r46.getType(), "");
            r2.c("cash_rebate", com.bytedance.android.shopping.track.b.a(r17.getCurrentPromotion()), "");
            r2.c("author_id", r17.getAuthorId(), "");
            if (r17.isLuban() == false) goto L202;
            String r47 = String.valueOf(1);
        L203:
            r2.c("is_ad", r47, "");
            if (r17.isLuban() == false) goto L206;
            String r48 = String.valueOf(1);
        L207:
            r2.c("is_ad_event", r48, "");
            r2.c("campaign_sub_type", com.bytedance.android.shopping.anchorv3.utils.y.f(r17.getCurrentPromotion()), "");
            JSONObject r49 = com.bytedance.android.shopping.extensions.k.w(String.valueOf(r13));
            if (r49 == null) goto L210;
            r2.c("carrier_source", r49.optString("carrier_source"), "");
            r2.c("source_method", r49.optString("source_method"), "");
            r2.c("product_activity_type", r49.optString("product_activity_type"), "");
            r2.c("ecom_group_type", r49.optString("ecom_group_type"), "");
            r2.b("from_entrance", r49.optString("from_entrance"));
            r2.b("recommend_info", r49.optString("recommend_info"));
            r2.b("request_id", r49.optString("request_id"));
            r2.b("is_package_sale", r49.optString("is_package_sale"));
            r2.b("subsidized_activity", r49.optString("subsidized_activity"));
            r2.b("share_content", r49.optString("share_content"));
            r2.b("share_object", r49.optString("share_object"));
            r2.b("share_type", r49.optString("share_type"));
            r2.b("share_previous_page", r49.optString("share_previous_page"));
            r2.b("is_show_new_coupon", r49.optString("is_show_new_coupon"));
            r2.b("im_group_id", r49.optString("im_group_id"));
            r2.b("share_id", r49.optString("share_id"));
            r2.b("from_user_id", r49.optString("from_user_id"));
            r2.b("aweme_type", r49.optString("aweme_type"));
            r2.b("fast_type", r49.optString("fast_type"));
            r2.b("ecom_icon", r49.optString("ecom_icon"));
            r2.b("similar_type", r49.optString("similar_type"));
            r2.b("ecom_tag_type", r49.optString("ecom_tag_type"));
            r2.b("module_label", r49.optString("module_label"));
            r2.b("friends_ecom_tag", r49.optString("friends_ecom_tag"));
        L210:
            JSONObject r50 = com.bytedance.android.shopping.extensions.k.u(r17.getEntranceInfo());
            String r51 = r17.getV3EventsAdditions();
            if (r51 == null) goto L220;
            JSONObject r52 = com.bytedance.android.shopping.extensions.k.w(r51);
            if (r52 == null) goto L220;
            r52.put("show_dou_campaign", r50.optString("show_dou_campaign"));
            String r123 = r52.optString("transmissible_json");
            if (r123 == null) goto L219;
            JSONObject r124 = com.bytedance.android.shopping.extensions.k.w(r123);
            if (r124 == null) goto L219;
            r124.put("show_dou_campaign", r50.optString("show_dou_campaign"));
            r52.put("transmissible_json", r124.toString());
        L219:
            r17.setV3EventsAdditions(r52.toString());
        L220:
            String r53 = r17.getV3EventsAdditions();
            if (r53 == null) goto L223;
            JSONObject r54 = com.bytedance.android.shopping.extensions.k.w(r53);
        L224:
            if (r54 == null) goto L235;
            Iterator<String> r55 = r54.keys();
        L287:
        L233:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L235
        L227:
            if (r55.hasNext() == false) goto L235;
            String r56 = r55.next();     // Catch: Exception -> L233
            if (r56 == null) goto L232;
            String r57 = r56;     // Catch: Exception -> L233
            r2.b(r57, r54.optString(r57));     // Catch: Exception -> L233
            goto L287
        L232:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L233
        L235:
            List r58 = r17.getCurrentPromotion().getBuyButtonInfos();
            if (r58 != null) goto L238;
        L243:
            Integer r59 = null;
        L244:
            if (r59 != null) goto L247;
        L249:
            String r60 = "0";
        L250:
            r2.c("oneyuan_button", r60, "");
            int r61 = com.bytedance.android.shopping.anchorv3.utils.y.a;
            if (com.bytedance.android.shopping.anchorv3.utils.y.r(r17.getCurrentPromotion()) == false) goto L253;
            String r62 = "1";
        L254:
            r2.c("is_crossborder_goods", r62, "");
            r2.c("goods_type", com.bytedance.android.shopping.anchorv3.utils.y.g(r17.getCurrentPromotion()), "");
            ECLogExtraData r63 = r17.getLogExtraData();
            if (r63 == null) goto L257;
            String r64 = r63.getLabelNameLive();
        L258:
            r2.c("label_name_live", r64, "");
            ECLogExtraData r65 = r17.getLogExtraData();
            if (r65 == null) goto L261;
            String r66 = r65.getBaseVerifiedCategory();
        L262:
            r2.c("base_verified_category", com.bytedance.android.shopping.anchorv3.utils.y.b(r66, r17.getCurrentPromotion()), "");
            if (r17.isLuban() == false) goto L268;
            r2.c("tag", "views_product_item", "");
            ECAdLogExtra r67 = r17.getAdLogExtra();
            if (r67 == null) goto L267;
            r2.c("value", r67.getCreativeId().toString(), "");
            r2.c("log_extra", r67.getLogExtra(), "");
        L267:
            r2.c("category", "umeng", "");
        L268:
            r2.c(PdpOpenThirdParam.KEY_ITEM_ID, r17.getVideoId(), "");
            FallbackPage r68 = r17.getFallbackPage();
            if (r68 != null) goto L271;
        L273:
            r2.c("product_status", r11, "");
            int r69 = ProductFeedDividerView.j;
            r2.c("inflow_product_card_mode", ProductFeedDividerView.c.a(0), "");
            PromotionProductExtraStruct r70 = r17.getCurrentPromotion().getExtraInfo();
            if (r70 == null) goto L278;
            String r71 = r70.getLogExtra();
            if (r71 == null) goto L278;
            String r72 = com.bytedance.android.shopping.extensions.k.u(r71).optString("standard_track_param");
        L279:
            r2.c("standard_track_param", r72, "");
            PromotionProductExtraStruct r73 = r17.getCurrentPromotion().getExtraInfo();
            if (r73 == null) goto L284;
            String r74 = r73.getLogExtra();
            if (r74 == null) goto L284;
            String r75 = com.bytedance.android.shopping.extensions.k.u(r74).optString("standard_product_marketing_param");
        L285:
            r2.c("standard_product_marketing_param", r75, "");
            return r2;
        L284:
            r75 = null;
        L278:
            r72 = null;
            goto L279
        L271:
            if (r68.getShow() != true) goto L273;
            r11 = "0";
            goto L273
        L261:
            r66 = null;
            goto L262
        L257:
            r64 = null;
            goto L258
        L253:
            r62 = "0";
            goto L254
        L247:
            if (r59.intValue() != 1) goto L249;
            r60 = "1";
            goto L250
        L238:
            if ((!r58.isEmpty()) == true) goto L241;
            r58 = null;
        L241:
            if (r58 == null) goto L243;
            r59 = ((PromotionProductButtonStruct) ListProtector.get(r58, 0)).getBuriedPointType();
            goto L244
        L223:
            r54 = null;
            goto L224
        L206:
            r48 = String.valueOf(0);
            goto L207
        L202:
            r47 = String.valueOf(0);
            goto L203
        L171:
            PromotionProductPrivilegesStruct r125 = r45.getPrivilegeInfo();
            if (r125 == null) goto L176;
            PromotionProductActivitiesStruct r126 = r125.getActivities();
            if (r126 == null) goto L176;
            PromotionAppointment r127 = r126.getAppointActivity();
        L177:
            if (r127 == null) goto L179;
            r46 = CommerceButtonUtil.ButtonStatus.APPOINTMENT;
            goto L199
        L179:
            PromotionProductPrivilegesStruct r128 = r45.getPrivilegeInfo();
            if (r128 == null) goto L184;
            PromotionProductActivitiesStruct r129 = r128.getActivities();
            if (r129 == null) goto L184;
            SeckillInfo r130 = r129.getSecKillActivity();
        L185:
            if (r130 == null) goto L187;
            r46 = CommerceButtonUtil.ButtonStatus.SEC_KILL;
            goto L199
        L187:
            PromotionProductBaseStruct r131 = r45.getBaseInfo();
            if (r131 != null) goto L190;
        L198:
            r46 = CommerceButtonUtil.ButtonStatus.OFF_SALE;
            goto L199
        L190:
            if (r131.getStatus() != 2) goto L198;
            PromotionProductBaseStruct r76 = r45.getBaseInfo();
            if (r76 != null) goto L195;
        L197:
            r46 = CommerceButtonUtil.ButtonStatus.CAN_BUY;
            goto L199
        L195:
            if (r76.isSoldOut() != true) goto L197;
            r46 = CommerceButtonUtil.ButtonStatus.SELL_OUT;
        L184:
            r130 = null;
        L176:
            r127 = null;
        L168:
            r122 = null;
            goto L169
        L162:
            r44 = "0";
            goto L163
        L158:
            r42 = "0";
        L120:
            r31 = null;
            goto L122
        L69:
            if (r13 == null) goto L71;
            r13.put("upfront_presell", "0");
            goto L71
        L64:
            r25 = false;
        L61:
            r24 = null;
            goto L62
        L47:
            r19 = "1";
            goto L48
        L43:
            r16 = null;
            goto L45
        L36:
            if (r17.getCurrentPromotion().isInSecKillActivity() == false) goto L38;
            r14 = "seckill";
            goto L40
        L38:
            r14 = "pre_seckill";
            goto L40
        L19:
            if (r9.intValue() == (-1)) goto L32;
            int r132 = com.bytedance.android.ec.core.utils.h2.a;
            if (r10 == null) goto L23;
            boolean r77 = Intrinsics.areEqual(com.bytedance.android.ec.sdk.helper.r.a.f(), r10);
        L24:
            if (r77 == true) goto L32;
            if (r9.intValue() != 1) goto L28;
        L31:
            r12 = "1";
            goto L33
        L28:
            if (r9.intValue() == 2) goto L31;
            r12 = "0";
            goto L33
        L23:
            r77 = false;
        L15:
            r7 = null;
            goto L16
        L9:
            r4 = null;
            goto L10
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
    }

    public o1() {
        this.a = new HashMap();
    }

    public final void a(com.bytedance.android.ec.core.event.a r5, List<String> r6) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r6 == null) goto L13;
        HashMap r0 = new HashMap();
        Iterator<T> r1 = this.a.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) r1.next();
        if (r6.contains(r2) == true) goto L6;
        String r3 = this.a.get(r2);
        if (r3 == null) goto L6;
        String r4 = (String) r0.put(r2, r3);
        goto L6
    L12:
        r5.appendExtraParams(r0);
        return;
    L13:
        r5.appendExtraParams(this.a);
    }

    public final void b(String r3, String r4) {
        HashMap<String, String> r0 = this.a;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (TextUtils.equals("null", r4) == true) goto L9;
        Intrinsics.checkNotNull(r4);
        r0.put(r3, r4);
        return;
    }

    public final void c(String r3, String r4, String r5) {
        HashMap<String, String> r0 = this.a;
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L8:
        r4 = r5;
    L9:
        r0.put(r3, r4);
        return;
    L5:
        if (TextUtils.equals("null", r4) == true) goto L8;
        Intrinsics.checkNotNull(r4);
        goto L9
    }
}
