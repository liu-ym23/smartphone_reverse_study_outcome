package com.bytedance.android.shopping.feed.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.response.anchorv3.ProductTaxStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionCrossBorderStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionIPActivity;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.api.LubanParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static JSONObject c(AnchorV3Param r7) {
        JSONObject r0 = new JSONObject();
        String r2 = null;
        if (r7 == null) goto L11;
        a(r0, PdpOpenThirdParam.KEY_SOURCE_PAGE, r7.getRequestParam().getSourcePage());
        a(r0, "previous_page", null);
        a(r0, "enter_method", r7.getEnterMethod());
        a(r0, "from_group_id", null);
        Integer r3 = r7.getFollowStatus();
        if (r3 == null) goto L7;
        String r4 = String.valueOf(r3.intValue());
    L8:
        a(r0, PdpOpenThirdParam.KEY_FOLLOW_STATUS, r4);
        a(r0, "author_id", r7.getAuthorId());
        a(r0, "group_id", r7.getRequestParam().getItemId());
        a(r0, PdpOpenThirdParam.KEY_ITEM_ID, null);
        a(r0, "search_id", g33.b.b.S(r7.getRequestParam().getSourcePage()));
        String r5 = r7.getEntranceInfo();
        if (r5 == null) goto L11;
        JSONObject r6 = new JSONObject(r5);
        a(r0, "carrier_source", r6.optString("carrier_source"));
        a(r0, "source_method", r6.optString("source_method"));
        r0.put("entrance_info", r5);
        goto L11
    L7:
        r4 = null;
    L11:
        if (r7 == null) goto L15;
        ECAdLogExtra r8 = r7.getAdLogExtra();
        if (r8 == null) goto L15;
        String r9 = r8.getAdExtraData();
    L16:
        a(r0, "ad_extra_data", r9);
        if (r7 == null) goto L23;
        ECAdLogExtra r10 = r7.getAdLogExtra();
        if (r10 == null) goto L23;
        String r11 = r10.getGroupId();
        if (r11 == null) goto L23;
    L24:
        a(r0, "group_id", r11);
        if (r7 == null) goto L30;
        ECAdLogExtra r1 = r7.getAdLogExtra();
        if (r1 == null) goto L30;
        String r12 = r1.getLogExtra();
        if (r12 == null) goto L30;
    L34:
        a(r0, "log_extra", r12);
        if (r7 == null) goto L41;
        ECAdLogExtra r13 = r7.getAdLogExtra();
        if (r13 == null) goto L41;
        String r14 = r13.getCreativeId();
        if (r14 == null) goto L41;
        r2 = r14;
    L46:
        a(r0, "creative_id", r2);
        if (r7 == null) goto L58;
        PromotionProductStruct r15 = r7.getCurrentPromotion();
        if (r15 == null) goto L58;
        PromotionProductExtraStruct r16 = r15.getExtraInfo();
        if (r16 == null) goto L58;
        String r17 = r16.getLogExtra();
        if (r17 == null) goto L58;
        JSONObject r18 = com.bytedance.android.shopping.extensions.k.w(r17);
        if (r18 == null) goto L58;
        String r19 = r18.optString("avl_discount");
        if (r19 == null) goto L58;
    L59:
        a(r0, "avl_discount", r19);
        return r0;
    L58:
        r19 = "0";
    L41:
        ECAdInfo r20 = g33.b.b.A(null);
        if (r20 == null) goto L46;
        Long r21 = r20.getCid();
        if (r21 == null) goto L46;
        r2 = String.valueOf(r21.longValue());
    L30:
        ECAdInfo r22 = g33.b.b.A(null);
        if (r22 == null) goto L33;
        r12 = r22.getLogExtra();
        goto L34
    L33:
        r12 = null;
    L23:
        r11 = null;
    L15:
        r9 = null;
        goto L16
    }

    public static JSONObject b(PromotionProductStruct r11, AnchorV3Param r12) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L120
        if (r11 == null) goto L7;
        PromotionProductPrivilegesStruct r1 = r11.getPrivilegeInfo();     // Catch: Exception -> L120
        if (r1 == null) goto L7;
        r0.put("data", tv5.a.b(r1));     // Catch: Exception -> L120
    L7:
        if (r11 == null) goto L15;
        PromotionProductPriceStruct r2 = r11.getProductPrice();     // Catch: Exception -> L120
        if (r2 == null) goto L15;
        PromotionDiscountPrice r3 = r2.getDiscountPrice();     // Catch: Exception -> L120
        if (r3 == null) goto L15;
        Long r4 = r3.getMinPrice();     // Catch: Exception -> L120
        if (r4 == null) goto L15;
        r0.put("discount_price", r4.longValue());     // Catch: Exception -> L120
    L15:
        Object r5 = null;
        if (r11 == null) goto L20;
        PromotionProductBaseStruct r6 = r11.getBaseInfo();     // Catch: Exception -> L120
        if (r6 == null) goto L20;
        String r7 = r6.getPromotionId();     // Catch: Exception -> L120
    L21:
        r0.put(PdpOpenThirdParam.KEY_PROMOTION_ID, r7);     // Catch: Exception -> L120
        if (r11 == null) goto L26;
        PromotionProductBaseStruct r8 = r11.getBaseInfo();     // Catch: Exception -> L120
        if (r8 == null) goto L26;
        String r9 = r8.getProductId();     // Catch: Exception -> L120
    L27:
        r0.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r9);     // Catch: Exception -> L120
        if (r12 == null) goto L30;
        String r10 = r12.getAuthorId();     // Catch: Exception -> L120
    L31:
        r0.put("author_id", r10);     // Catch: Exception -> L120
        if (r12 == null) goto L34;
        String r13 = r12.getSecAuthorId();     // Catch: Exception -> L120
    L35:
        r0.put(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID, r13);     // Catch: Exception -> L120
        r0.put("raw_data", tv5.a.b(r11));     // Catch: Exception -> L120
        r0.put("log_data", c(r12));     // Catch: Exception -> L120
        int r14 = c.a;     // Catch: Exception -> L120
        if (r11 == null) goto L38;
        ActivityVO r15 = f53.a.c(r11);     // Catch: Exception -> L120
    L40:
        if (r15 != null) goto L42;
    L44:
        boolean r16 = false;
    L45:
        if (r11 == null) goto L47;
        PromotionProductPriceStruct r17 = r11.getProductPrice();     // Catch: Exception -> L120
    L48:
        if (r15 == null) goto L50;
        int r18 = r15.getActivityType();     // Catch: Exception -> L120
    L51:
        if (r11 == null) goto L57;
        PromotionProductPrivilegesStruct r19 = r11.getPrivilegeInfo();     // Catch: Exception -> L120
        if (r19 == null) goto L57;
        PromotionProductActivitiesStruct r20 = r19.getActivities();     // Catch: Exception -> L120
        if (r20 == null) goto L57;
        PromotionIPActivity r21 = r20.getIpActivity();     // Catch: Exception -> L120
    L58:
        if (r11 == null) goto L62;
        PromotionProductBaseStruct r22 = r11.getBaseInfo();     // Catch: Exception -> L120
        if (r22 == null) goto L62;
        boolean r23 = r22.isSoldOut();     // Catch: Exception -> L120
    L63:
        r0.put("min_price", c.h(r17, r18, r16, r21, r23));     // Catch: Exception -> L120
        if (r12 != null) goto L66;
    L68:
        String r24 = "half_screen";
    L69:
        r0.put("page_type", r24);     // Catch: Exception -> L120
        r0.put("coupon_discount", true);     // Catch: Exception -> L120
        if (r12 == null) goto L74;
        AnchorV3PromotionRequestParam r25 = r12.getRequestParam();     // Catch: Exception -> L120
        if (r25 == null) goto L74;
        String r26 = r25.getRequestAdditions();     // Catch: Exception -> L120
    L75:
        r0.put("request_additions", r26);     // Catch: Exception -> L120
        if (r12 != null) goto L79;
    L85:
        r0.put("is_luban", 0);     // Catch: Exception -> L120
    L86:
        if (r11 == null) goto L92;
        PromotionProductExtraStruct r110 = r11.getExtraInfo();     // Catch: Exception -> L120
        if (r110 == null) goto L92;
        PromotionCrossBorderStruct r111 = r110.getCrossborderInfo();     // Catch: Exception -> L120
        if (r111 == null) goto L92;
        JSONObject r112 = tv5.a.b(r111);     // Catch: Exception -> L120
    L125:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L103
        if (r11 == null) goto L100;
        PromotionProductBaseStruct r28 = r11.getBaseInfo();     // Catch: Throwable -> L103
        if (r28 == null) goto L100;
        ProductTaxStruct r29 = r28.getTaxInfo();     // Catch: Throwable -> L103
        if (r29 == null) goto L100;
        String r30 = r29.getTaxDescribe();     // Catch: Throwable -> L103
    L101:
        Object r31 = Result.constructor-impl(new JSONObject(r30));     // Catch: Throwable -> L103
    L106:
        if (Result.isFailure-impl(r31) == true) goto L109;
        r5 = r31;
    L109:
        JSONObject r32 = (JSONObject) r5;     // Catch: Exception -> L120
        if (r32 == null) goto L112;
        r112.put("tax_describe", r32);     // Catch: Exception -> L120
    L112:
        r0.put("crossborder_data", r112);     // Catch: Exception -> L120
        if (r11 == null) goto L127;
        PromotionProductExtraStruct r113 = r11.getExtraInfo();     // Catch: Exception -> L120
        if (r113 == null) goto L128;
        List r114 = r113.getShoppingGuideAttr();     // Catch: Exception -> L120
        if (r114 == null) goto L129;
        r0.put("shopping_guide_attr", new JSONArray(new Gson().toJson(r114)));     // Catch: Exception -> L120
        return r0;
    L129:
        return r0;
    L128:
        return r0;
    L127:
        return r0;
    L100:
        r30 = null;
    L103:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Exception -> L120
        r31 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L120
    L92:
        r112 = new JSONObject();     // Catch: Exception -> L120
        goto L125
    L79:
        if (r12.isLuban() != true) goto L85;
        r0.put("is_luban", 1);     // Catch: Exception -> L120
        LubanParam r115 = r12.getRequestParam().getLubanParam();     // Catch: Exception -> L120
        if (r115 == null) goto L83;
        String r116 = r115.getPageId();     // Catch: Exception -> L120
    L84:
        r0.put("page_id", r116);     // Catch: Exception -> L120
        goto L86
    L83:
        r116 = null;
    L74:
        r26 = null;
        goto L75
    L66:
        if (r12.isFullScreen() != true) goto L68;
        r24 = "full_screen";
    L62:
        r23 = false;
    L57:
        r21 = null;
        goto L58
    L50:
        r18 = -1;
        goto L51
    L47:
        r17 = null;
        goto L48
    L42:
        if ((System.currentTimeMillis() / ((long) 1000)) >= r15.getStartTime()) goto L44;
        r16 = true;
        goto L45
    L38:
        r15 = null;
        goto L40
    L34:
        r13 = null;
        goto L35
    L30:
        r10 = null;
    L26:
        r9 = null;
    L20:
        r7 = null;
    L120:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return new JSONObject();
    }

    public static void a(JSONObject r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$appendParam");
        Intrinsics.checkNotNullParameter(r2, "key");
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        if (r3 == null) goto L6;
        r1.put(r2, r0.a(r3));
        return;
    }
}
