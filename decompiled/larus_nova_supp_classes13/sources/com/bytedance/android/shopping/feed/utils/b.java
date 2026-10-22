package com.bytedance.android.shopping.feed.utils;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
    }

    public static String d(String r5) {
        JSONObject r6 = z1.g(r5);
        if (r6 == null) goto L11;
        JSONObject r2 = z1.g(r6.optString("entrance_info"));
        if (r2 == null) goto L7;
        r2.put("ecom_group_type", "product_card");
    L7:
        if (r2 == null) goto L9;
        String r3 = r2.toString();
    L10:
        r6.put("entrance_info", r3);
        goto L11
    L9:
        r3 = null;
    L11:
        if (r6 != null) goto L13;
        return null;
    L13:
        return r6.toString();
    }

    public static boolean e(String r2) {
        if (r2 == null) goto L10;
        JSONObject r3 = z1.g(r2);
        if (r3 == null) goto L10;
        if (Intrinsics.areEqual(r3.optString("module_label"), "guess_you_like_product") == false) goto L10;
        if (r3.optBoolean("is_product_flow_page") == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static String b(String r3, rd3.a r4) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        Uri.Builder r5 = UriProtector.parse(r3).buildUpon();
        r5.appendQueryParameter("entrance_location", "product_flow_page_store_card");
        if (r4 == null) goto L12;
        ProductFeedViewModel r1 = r4.c;
        if (r1 == null) goto L12;
        AnchorV3Param r2 = r1.m907getAnchorV3Param();
        if (r2 == null) goto L12;
        ECLogExtraData r6 = r2.getLogExtraData();
        if (r6 == null) goto L12;
        String r7 = r6.getEnterFrom();
        if (r7 == null) goto L12;
    L13:
        r5.appendQueryParameter("store_source_page", r7);
        if (r4 == null) goto L24;
        ProductFeedViewModel r8 = r4.c;
        if (r8 == null) goto L24;
        AnchorV3Param r9 = r8.m907getAnchorV3Param();
        if (r9 == null) goto L24;
        String r10 = r9.getEntranceInfo();
        if (r10 == null) goto L24;
        JSONObject r11 = z1.g(r10);
        if (r11 == null) goto L24;
        String r12 = r11.optString("source_method", "");
    L25:
        r5.appendQueryParameter("store_source_method", r12);
        r5.appendQueryParameter("store_group_type", "video");
        r5.appendQueryParameter("store_type", "shop");
        return r5.toString();
    L24:
        r12 = null;
    L12:
        r7 = "";
        goto L13
    }

    public static String a(rd3.a r15, String r16, AnchorV3Param r17) {
        JSONObject r1 = new JSONObject();
        if (r15 == null) goto L5;
        boolean r2 = r15.e;
    L6:
        String r3 = null;
        if (r15 == null) goto L11;
        Promotion r4 = r15.f();
        if (r4 == null) goto L11;
        PromotionProductStruct r5 = r4.getPromotionInfo();
    L13:
        if (r2 == false) goto L45;
        r1.put("module_label", "guess_you_like_product");
        if (r15 == null) goto L19;
        rd3.g r6 = r15.d();
        if (r6 == null) goto L19;
        String r7 = r6.a();
    L20:
        r1.put("recommend_info", r7);
        if (r15 == null) goto L23;
        String r8 = r15.d;
    L24:
        r1.put("request_id", r8);
        if (r15 == null) goto L27;
        Integer r9 = Integer.valueOf(r15.f);
    L28:
        r1.put("display_rank", r9);
        if (r15 == null) goto L31;
        String r10 = r15.c();
    L32:
        r1.put("ecom_type", r10);
        r1.put("is_product_flow_page", true);
        r1.put("ecom_group_type", "product_card");
        ArrayList r11 = new ArrayList();
        if (a2.b(r16) == false) goto L42;
        if (r16 == null) goto L42;
        List r12 = StringsKt.split$default(r16, new String[]{","}, false, 0, 6, null);
        if (r12 == null) goto L42;
        Iterator r13 = r12.iterator();
    L39:
        if (r13.hasNext() == false) goto L42;
        r11.add((String) r13.next());
    L42:
        if (r11.contains("1064") == true) goto L44;
        r11.add("1061");
    L44:
        r1.put("ecom_scene_id", CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, null, 62, null));
    L46:
        if (r15 == null) goto L51;
        ProductFeedViewModel r14 = r15.c;
        if (r14 == null) goto L51;
        AnchorV3Param r18 = r14.m907getAnchorV3Param();
        if (r18 == null) goto L51;
    L52:
        if (r18 == null) goto L54;
        String r19 = r18.getAuthorId();
    L55:
        r1.put("author_id", r19);
        if (r15 == null) goto L58;
        String r20 = r15.m;
    L59:
        r1.put("inflow_product_card_mode", r20);
        if (r15 == null) goto L65;
        ProductFeedViewModel r0 = r15.c;
        if (r0 == null) goto L65;
        AnchorV3Param r21 = r0.m907getAnchorV3Param();
        if (r21 == null) goto L65;
    L66:
        if (r21 == null) goto L70;
        ECLogExtraData r22 = r21.getLogExtraData();
        if (r22 == null) goto L70;
        r3 = r22.getInflowRecommendType();
    L70:
        r1.put("inflow_recommend_type", r3);
        if (r5 == null) goto L84;
        PromotionProductExtraStruct r23 = r5.getExtraInfo();
        if (r23 == null) goto L84;
        String r24 = r23.getEntranceInfo();
        if (r24 == null) goto L84;
        JSONObject r25 = z1.g(r24);
        if (r25 == null) goto L84;
        Iterator<String> r26 = r25.keys();
        if (r26 == null) goto L84;
    L81:
        if (r26.hasNext() == false) goto L84;
        String r27 = r26.next();
        r1.put(r27, r25.get(r27));
    L84:
        return r1.toString();
    L65:
        r21 = r17;
        goto L66
    L58:
        r20 = null;
        goto L59
    L54:
        r19 = null;
    L51:
        r18 = r17;
        goto L52
    L31:
        r10 = null;
        goto L32
    L27:
        r9 = null;
        goto L28
    L23:
        r8 = null;
    L19:
        r7 = null;
        goto L20
    L45:
        r1.put("ecom_group_type", "video");
    L11:
        r5 = null;
        goto L13
    L5:
        r2 = false;
        goto L6
    }

    public static String c(PromotionProductStruct r2, AnchorV3Param r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "promotionProductStruct");
        Object r0 = null;
        if (r3 == null) goto L17;
        String r5 = r3.getEntranceInfo();
        if (r5 == null) goto L17;
        JSONObject r6 = z1.g(r5);
        if (r6 == null) goto L17;
        if (r4 == false) goto L11;
        r6.put("ecom_group_type", "product_card");
        r6.put("module_label", "guess_you_like_product");
    L12:
        PromotionProductBaseStruct r7 = r2.getBaseInfo();
        if (r7 == null) goto L15;
        r0 = r7.getPromotionId();
    L15:
        r0 = r6.put(PdpOpenThirdParam.KEY_PROMOTION_ID, r0);
        goto L17
    L11:
        r6.put("ecom_group_type", "video");
    L17:
        return String.valueOf(r0);
    }
}
