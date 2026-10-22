package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.Bcm;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelCID;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCardType;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECLiveStruct;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECProductStruct;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.BtmPositionResult;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.UtilsKt;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.b;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.e;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.a a;

    public a(com.bytedance.android.shopping.mall.homepage.card.headercard.a r2) {
        Intrinsics.checkNotNullParameter(r2, "mallContext");
        this.a = r2;
    }

    public static Map a(ChannelVO r20, Map r21) {
        Intrinsics.checkNotNullParameter(r20, "channel");
        Intrinsics.checkNotNullParameter(r21, "globalProps");
        String r3 = r20.getComponentId();
        String r4 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        String r5 = r20.getName();
        ChannelVO.Layout r6 = r20.getLayout();
        if (r6 == null) goto L10;
        Integer r7 = r6.getHSpan();
        if (r7 == null) goto L10;
        int r8 = r7.intValue();
    L11:
        Object r9 = r21.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r9 == null) goto L15;
        String r10 = r9.toString();
        if (r10 == null) goto L15;
    L16:
        Object r1 = r21.get(SimilarProductParam.ENTER_FROM);
        if (r1 == null) goto L20;
        String r2 = r1.toString();
        if (r2 == null) goto L20;
    L22:
        if (r8 == 2) goto L26;
        if (r8 == 4) goto L25;
        String r12 = "single";
    L27:
        Intrinsics.checkNotNullParameter(r20, "channel");
        String r11 = r20.getComponentId();
        if (Intrinsics.areEqual(r11, ChannelCID.SUBSIDE.getValue()) == false) goto L31;
        Map r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("module_name", "百亿补贴"), TuplesKt.to("activity_name", "explosive_subsidy"), TuplesKt.to("resource_id", r20.getResourceId()), TuplesKt.to("component_id", r20.getComponentId())});
    L46:
        Pair[] r14 = new Pair[11];
        r14[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, r10);
        r14[1] = TuplesKt.to("previous_page", r2);
        if (r13 == null) goto L54;
        Object r15 = r13.get("module_name");
        if (r15 == null) goto L54;
        String r16 = r15.toString();
        if (r16 == null) goto L54;
        r5 = r16;
    L54:
        if (r5 != null) goto L56;
        r5 = "";
    L56:
        r14[2] = TuplesKt.to("module_name", r5);
        if (r13 == null) goto L62;
        Object r17 = r13.get("activity_name");
        if (r17 == null) goto L62;
        String r18 = r17.toString();
        if (r18 == null) goto L62;
    L63:
        r14[3] = TuplesKt.to("activity_name", r18);
        r14[4] = TuplesKt.to("component_id", r3);
        String r19 = r20.getResourceId();
        if (r19 == null) goto L67;
        r4 = r19;
    L67:
        r14[5] = TuplesKt.to("resource_id", r4);
        r14[6] = TuplesKt.to("module_id", "activity_list");
        ChannelVO.Data r0 = r20.getData();
        if (r0 == null) goto L70;
        ChannelVO.Animation r110 = r0.getAnimation();
    L71:
        if (r110 != null) goto L73;
        int r22 = 0;
    L74:
        r14[7] = TuplesKt.to("is_need_carousel", Integer.valueOf(r22));
        r14[8] = TuplesKt.to("number_of_pictures", Integer.valueOf(r8));
        r14[9] = TuplesKt.to("is_new_layout", 1);
        r14[10] = TuplesKt.to("product_type", r12);
        return MapsKt.mapOf(r14);
    L73:
        r22 = 1;
        goto L74
    L70:
        r110 = null;
    L62:
        r18 = r3;
        goto L63
    L31:
        if (Intrinsics.areEqual(r11, ChannelCID.BRAND.getValue()) == false) goto L34;
        r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("module_name", "大牌精选"), TuplesKt.to("activity_name", "ecom_brand_channel"), TuplesKt.to("resource_id", r20.getResourceId()), TuplesKt.to("component_id", r20.getComponentId())});
        goto L46
    L34:
        if (Intrinsics.areEqual(r11, ChannelCID.SECKILL.getValue()) == false) goto L37;
        r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("module_name", "秒杀频道"), TuplesKt.to("activity_name", "limited_offer"), TuplesKt.to("resource_id", r20.getResourceId()), TuplesKt.to("component_id", r20.getComponentId())});
        goto L46
    L37:
        if (Intrinsics.areEqual(r11, ChannelCID.LIVE_SQUARE.getValue()) == false) goto L40;
        r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("module_name", "抖音直播"), TuplesKt.to("activity_name", "ecom_live_channel"), TuplesKt.to("resource_id", r20.getResourceId()), TuplesKt.to("component_id", r20.getComponentId())});
        goto L46
    L40:
        if (Intrinsics.areEqual(r11, ChannelCID.NEW_COIN_CHANNEL.getValue()) == false) goto L43;
        r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("activity_name", "gold_coin_channel_new"), TuplesKt.to("resource_id", r20.getResourceId()), TuplesKt.to("component_id", r20.getComponentId())});
        goto L46
    L43:
        if (Intrinsics.areEqual(r11, ChannelCID.DAY_DAY_BUY.getValue()) == false) goto L45;
        r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("module_name", "天天抄底"), TuplesKt.to("activity_name", "daily_bargain_hunting"), TuplesKt.to("resource_id", r20.getResourceId()), TuplesKt.to("component_id", r20.getComponentId())});
        goto L46
    L45:
        r13 = null;
        goto L46
    L25:
        r12 = "big_card";
        goto L27
    L26:
        r12 = "double";
    L20:
        r2 = "";
    L15:
        r10 = "";
    L10:
        r8 = 0;
        goto L11
    }

    public final void b(ChannelVO r20, BtmPositionResult r21, int r22, Map<String, ? extends Object> r23, Map<String, ? extends Object> r24) {
        Map<String, ? extends Object> r3 = r23;
        Intrinsics.checkNotNullParameter(r20, "channel");
        Intrinsics.checkNotNullParameter(r3, "globalProps");
        Map r5 = a(r20, r3);
        Map<String, String> r7 = UtilsKt.a(r20, true, r22);
        Pair[] r9 = new Pair[2];
        r9[0] = TuplesKt.to("name", r20.getName());
        if (r21 == null) goto L5;
        Map<String, Object> r13 = r21.getExtra();
    L6:
        r9[1] = TuplesKt.to("extra", r13);
        Map r10 = MapsKt.mapOf(r9);
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r14 = this.a;
        if (r21 == null) goto L12;
        String r16 = r21.getBtm();
        if (r16 == null) goto L12;
        String r11 = r16;
    L13:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.putAll(r5);
        r6.putAll(r7);
        int r8 = r22 + 1;
        r6.put("click_area", String.valueOf(r8));
        r6.put("bcm_description", r10);
        if (r24 == null) goto L16;
        r6.putAll(r24);
    L16:
        Unit r17 = Unit.INSTANCE;
        e.b(r14, "click_daogou_entrance", r11, r6, r3);
        if (Intrinsics.areEqual(r20.isChannelStatic(), Boolean.FALSE) == false) goto L89;
        if (r22 < 0) goto L89;
        ChannelVO.Data r12 = r20.getData();
        if (r12 == null) goto L24;
        List<ECCommonCard> r15 = r12.getItems();
        if (r15 == null) goto L24;
        ECCommonCard r18 = (ECCommonCard) CollectionsKt.getOrNull(r15, r22);
    L25:
        if (r18 == null) goto L27;
        ECProductStruct r19 = r18.getProduct();
    L28:
        if (r18 == null) goto L30;
        ECLiveStruct r110 = r18.getLive();
    L31:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r111 = this.a;
        if (r21 == null) goto L35;
        String r112 = r21.getBtm();
        if (r112 == null) goto L35;
    L36:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r5);
        Pair[] r25 = new Pair[2];
        r25[0] = TuplesKt.to("name", r20.getName());
        if (r21 == null) goto L39;
        Map<String, Object> r4 = r21.getExtra();
    L40:
        r25[1] = TuplesKt.to("extra", r4);
        r0.put("bcm_description", MapsKt.mapOf(r25));
        r0.put("module_label", "guess_you_like_product");
        if (r18 == null) goto L43;
        Integer r26 = r18.getType();
    L44:
        int r27 = ECCommonCardType.SHOP.getValue();
        if (r26 != null) goto L48;
    L49:
        if (r19 == null) goto L51;
        String r28 = r19.getProductId();
    L53:
        r0.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r28);
        if (r18 == null) goto L57;
        String r29 = r18.recommendFromItem();
        if (r29 == null) goto L57;
    L58:
        r0.put("recommend_info", r29);
        ChannelVO.LogExtra r30 = r20.getLogExtra();
        if (r30 == null) goto L62;
        String r31 = r30.getRequestId();
        if (r31 == null) goto L62;
    L63:
        r0.put("request_id", r31);
        r0.put("click_area", String.valueOf(r8));
        if (r18 == null) goto L66;
        Integer r32 = r18.getType();
    L67:
        int r33 = ECCommonCardType.LIVE.getValue();
        if (r32 != null) goto L71;
    L72:
        if (r110 == null) goto L74;
        String r34 = r110.getRoomId();
    L76:
        r0.put("room_id", r34);
        r0.put("notice_name", r20.getNoticeName(r22));
        if (r19 == null) goto L81;
        ECProductStruct.Extra r2 = r19.getExtra();
        if (r2 == null) goto L81;
        Integer r113 = r2.getProductActivityType();
    L82:
        if (r113 == null) goto L84;
        String r35 = "wanrentuan";
    L85:
        r0.put("picture_type", r35);
        r0.put("bcm_description", r10);
        if (r24 == null) goto L88;
        r0.putAll(r24);
    L88:
        r3 = r23;
        e.b(r111, "click_product_picture", r112, r0, r3);
        goto L89
    L84:
        r35 = "product";
    L81:
        r113 = null;
        goto L82
    L74:
        r34 = null;
        goto L76
    L71:
        if (r32.intValue() != r33) goto L72;
        r34 = "";
        goto L76
    L66:
        r32 = null;
    L62:
        r31 = "";
    L57:
        r29 = "";
        goto L58
    L51:
        r28 = null;
        goto L53
    L48:
        if (r26.intValue() != r27) goto L49;
        r28 = "";
        goto L53
    L43:
        r26 = null;
        goto L44
    L39:
        r4 = null;
    L35:
        r112 = "";
        goto L36
    L30:
        r110 = null;
        goto L31
    L27:
        r19 = null;
    L24:
        r18 = null;
    L89:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r36 = this.a;
        if (r21 == null) goto L95;
        String r37 = r21.getBtm();
        if (r37 == null) goto L95;
        String r114 = r37;
    L96:
        Bcm r1 = r20.getBcm();
        if (r1 == null) goto L100;
        Map<String, Object> r38 = r1.getBcmMap();
        if (r38 == null) goto L100;
    L101:
        e.b(r36, "marketing_click", r114, r38, r3);
        return;
    L100:
        r38 = MapsKt.emptyMap();
    L95:
        r114 = "";
    L12:
        r11 = "";
        goto L13
    L5:
        r13 = null;
        goto L6
    }

    public final void c(ChannelVO r21, BtmPositionResult r22, int r23, Map<String, ? extends Object> r24, Map<String, ? extends Object> r25) {
        Intrinsics.checkNotNullParameter(r21, "channel");
        Intrinsics.checkNotNullParameter(r24, "globalProps");
        String r3 = r21.getComponentId();
        if (r3 != null) goto L5;
        return;
    L5:
        Map r5 = a(r21, r24);
        Pair[] r7 = new Pair[2];
        r7[0] = TuplesKt.to("name", r21.getName());
        if (r22 == null) goto L8;
        Map<String, Object> r11 = r22.getExtra();
    L9:
        r7[1] = TuplesKt.to("extra", r11);
        Map r8 = MapsKt.mapOf(r7);
        if (Intrinsics.areEqual(r3, ChannelCID.SECKILL.getValue()) == false) goto L12;
    L15:
        Map<String, String> r12 = UtilsKt.b(r21, r23, r23 + 1);
    L17:
        if (Intrinsics.areEqual(r21.isChannelStatic(), Boolean.FALSE) == false) goto L90;
        if (r23 < 0) goto L90;
        ChannelVO.Data r4 = r21.getData();
        if (r4 == null) goto L24;
        List<ECCommonCard> r6 = r4.getItems();
        if (r6 == null) goto L24;
        ECCommonCard r9 = (ECCommonCard) CollectionsKt.getOrNull(r6, r23);
    L25:
        if (r9 == null) goto L27;
        ECProductStruct r14 = r9.getProduct();
    L28:
        if (r9 == null) goto L30;
        ECLiveStruct r15 = r9.getLive();
    L31:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r13 = this.a;
        String r18 = "";
        if (r22 == null) goto L35;
        String r19 = r22.getBtm();
        if (r19 == null) goto L35;
    L36:
        LinkedHashMap r10 = new LinkedHashMap();
        r10.putAll(r5);
        Pair[] r16 = new Pair[2];
        r16[0] = TuplesKt.to("name", r21.getName());
        if (r22 == null) goto L39;
        Map<String, Object> r17 = r22.getExtra();
    L40:
        r16[1] = TuplesKt.to("extra", r17);
        r10.put("bcm_description", MapsKt.mapOf(r16));
        r10.put("module_label", "guess_you_like_product");
        if (r9 == null) goto L43;
        Integer r20 = r9.getType();
    L44:
        int r26 = ECCommonCardType.SHOP.getValue();
        if (r20 != null) goto L48;
    L49:
        if (r14 == null) goto L51;
        String r27 = r14.getProductId();
    L53:
        r10.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r27);
        if (r9 == null) goto L57;
        String r28 = r9.recommendFromItem();
        if (r28 == null) goto L57;
    L58:
        r10.put("recommend_info", r28);
        ChannelVO.LogExtra r29 = r21.getLogExtra();
        if (r29 == null) goto L62;
        String r30 = r29.getRequestId();
        if (r30 == null) goto L62;
    L63:
        r10.put("request_id", r30);
        r10.put("click_area", String.valueOf(r23 + 1));
        if (r9 == null) goto L66;
        Integer r31 = r9.getType();
    L67:
        int r32 = ECCommonCardType.LIVE.getValue();
        if (r31 != null) goto L71;
    L72:
        if (r15 == null) goto L74;
        r18 = r15.getRoomId();
    L75:
        String r33 = r18;
    L76:
        r10.put("room_id", r33);
        r10.put("notice_name", r21.getNoticeName(r23));
        if (r14 == null) goto L81;
        ECProductStruct.Extra r0 = r14.getExtra();
        if (r0 == null) goto L81;
        Integer r110 = r0.getProductActivityType();
    L82:
        if (r110 == null) goto L84;
        String r1 = "wanrentuan";
    L85:
        r10.put("picture_type", r1);
        r10.put("bcm_description", r8);
        if (r25 == null) goto L88;
        r10.putAll(r25);
    L88:
        Unit r2 = Unit.INSTANCE;
        e.a(r13, "show_product_picture", r19, r10, r24, r12);
        return;
    L84:
        r1 = "product";
    L81:
        r110 = null;
        goto L82
    L74:
        r33 = null;
        goto L76
    L71:
        if (r31.intValue() == r32) goto L75;
    L66:
        r31 = null;
    L62:
        r30 = "";
    L57:
        r28 = "";
        goto L58
    L51:
        r27 = null;
        goto L53
    L48:
        if (r20.intValue() != r26) goto L49;
        r27 = "";
        goto L53
    L43:
        r20 = null;
        goto L44
    L39:
        r17 = null;
    L35:
        r19 = "";
        goto L36
    L30:
        r15 = null;
        goto L31
    L27:
        r14 = null;
    L24:
        r9 = null;
    L90:
        return;
    L12:
        if (Intrinsics.areEqual(r3, ChannelCID.SUBSIDE.getValue()) == true) goto L15;
        r12 = null;
        goto L17
    L8:
        r11 = null;
        goto L9
    }

    public static void d(a r9, ChannelVO r10, Map r11, boolean r12, BtmData r13, Map r14) {
        Intrinsics.checkNotNullParameter(r10, "channel");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r14, "globalProps");
        String r6 = r10.getComponentId();
        if (r6 == null) goto L27;
        Map r1 = a(r10, r14);
        Integer r2 = r10.getOriginChannelCardFIndex();
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L9:
        BtmPositionResult r15 = b.a(r13, false, r3 - 1, 0, r6, 5);
        Pair[] r4 = new Pair[2];
        r4[0] = TuplesKt.to("name", r10.getName());
        if (r15 == null) goto L12;
        Map<String, Object> r16 = r15.getExtra();
    L13:
        r4[1] = TuplesKt.to("extra", r16);
        Map r17 = MapsKt.mapOf(r4);
        if (r12 == false) goto L16;
        String r5 = "coupon_animation_click";
    L17:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r18 = r9.a;
        if (r15 == null) goto L21;
        String r19 = r15.getBtm();
        if (r19 == null) goto L21;
    L22:
        LinkedHashMap r7 = new LinkedHashMap();
        r7.putAll(r1);
        r7.put("animation_type", "channel");
        r7.put("is_need_carousel", 1);
        if (r12 == false) goto L25;
        r7.put("click_area", "icon");
    L25:
        r7.putAll(r11);
        r7.put("bcm_description", r17);
        Unit r110 = Unit.INSTANCE;
        e.b(r18, r5, r19, r7, r14);
        return;
    L21:
        r19 = "";
        goto L22
    L16:
        r5 = "coupon_animation_show";
        goto L17
    L12:
        r16 = null;
        goto L13
    L8:
        r3 = 1;
        goto L9
    }
}
