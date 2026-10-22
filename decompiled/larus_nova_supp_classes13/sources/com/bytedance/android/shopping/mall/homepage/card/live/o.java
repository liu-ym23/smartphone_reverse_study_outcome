package com.bytedance.android.shopping.mall.homepage.card.live;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o {
    public static void d(NativeLiveCard r29, boolean r30, String r31) {
        Intrinsics.checkNotNullParameter(r29, "$this$reportLiveClick");
        ECHybridListItemVO r2 = ((BaseViewHolder) r29).c;
        if (r2 == null) goto L7;
        com.bytedance.android.ec.hybrid.list.entity.n r3 = r2.o;
        if (r3 == null) goto L7;
        List r4 = r3.e;
    L8:
        List r5 = r4;
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == true) goto L21;
        com.bytedance.android.ec.hybrid.list.ability.a r1 = ((BaseViewHolder) r29).b;
        if (r1 == null) goto L264;
        com.bytedance.android.ec.hybrid.list.ability.d r7 = (com.bytedance.android.ec.hybrid.list.ability.d) r1.getAbility(com.bytedance.android.ec.hybrid.list.ability.d.class);
        if (r7 == null) goto L265;
        r7.Fr(r29, ToolsKt.g(r29), null, null);
        return;
    L265:
        return;
    L264:
        return;
    L21:
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("btm_index", Integer.valueOf(ToolsKt.g(r29) + 1));
        r8.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r8.put("ecom_type", "live");
        LiveCardData r9 = r29.u;
        if (r9 == null) goto L27;
        LiveCardData.Live r10 = r9.getLive();
        if (r10 == null) goto L27;
        String r11 = r10.getRoomId();
        if (r11 == null) goto L27;
    L28:
        r8.put("room_id", r11);
        r8.put("outflow_order", String.valueOf(ToolsKt.g(r29)));
        LiveCardData r12 = r29.u;
        if (r12 == null) goto L34;
        CommonData.CardCommon r13 = r12.getCardCommon();
        if (r13 == null) goto L34;
        String r14 = r13.getResourceId();
        if (r14 == null) goto L34;
    L35:
        r8.put("resource_id", r14);
        LiveCardData r15 = r29.u;
        if (r15 == null) goto L41;
        CommonData.Product r16 = r15.getProduct();
        if (r16 == null) goto L41;
        String r17 = r16.getProductId();
        if (r17 == null) goto L41;
    L42:
        r8.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r17);
        r8.put("tab_id", ToolsKt.r(r29));
        r8.put("tab_name", ToolsKt.s(r29));
        LiveCardData r18 = r29.u;
        if (r18 == null) goto L46;
        String r19 = r18.rcPriorityFromProduct();
        if (r19 == null) goto L46;
    L47:
        r8.put("recommend_info", r19);
        r8.put("request_id", ToolsKt.l(r29));
        LiveCardData r20 = r29.u;
        if (r20 == null) goto L54;
        LiveCardData.Live r21 = r20.getLive();
        if (r21 == null) goto L54;
        Integer r22 = r21.getStatus();
        if (r22 == null) goto L54;
        int r23 = r22.intValue();
    L55:
        r8.put("live_status", Integer.valueOf(r23));
        LiveCardData r24 = r29.u;
        if (r24 == null) goto L60;
        LiveCardData.Live r25 = r24.getLive();
        if (r25 == null) goto L60;
        String r26 = r25.isGuessInstant();
    L62:
        if (r26 != null) goto L64;
        r26 = "";
    L64:
        r8.put("is_guess_instant", r26);
        LiveCardData r27 = r29.u;
        if (r27 == null) goto L69;
        CommonData.Store r28 = r27.getStore();
        if (r28 == null) goto L69;
        String r32 = r28.getDistancePoint();
    L71:
        if (r32 != null) goto L73;
        r32 = "";
    L73:
        r8.put("store_to_user", r32);
        LiveCardData r33 = r29.u;
        if (r33 == null) goto L78;
        LiveCardData.Live r34 = r33.getLive();
        if (r34 == null) goto L78;
        String r35 = r34.getArriveTimePoint();
    L80:
        if (r35 != null) goto L82;
        r35 = "";
    L82:
        r8.put("delivery_time", r35);
        ECHybridListItemVO r36 = ((BaseViewHolder) r29).c;
        if (r36 == null) goto L90;
        com.bytedance.android.ec.hybrid.list.entity.dto.a r37 = r36.D;
        if (r37 == null) goto L90;
        String r38 = r37.d;
        if (r38 == null) goto L90;
        r8.put("session_id", r38);
    L90:
        LiveCardData r39 = r29.u;
        if (r39 == null) goto L93;
        Boolean r40 = r39.isAd();
    L94:
        Boolean r110 = Boolean.TRUE;
        if (Intrinsics.areEqual(r40, r110) == false) goto L97;
        r8.put("is_other_channel", "effective_ad");
    L97:
        r8.put("bcm_description", MapsKt.mapOf(TuplesKt.to("type", "live")));
        LiveCardData r111 = r29.u;
        if (r111 == null) goto L102;
        CommonData.Extra r112 = r111.getExtra();
        if (r112 == null) goto L102;
        Boolean r113 = r112.isLifeCard();
    L104:
        if (Intrinsics.areEqual(r113, r110) == false) goto L106;
        r8.put("is_life", "1");
    L106:
        LiveCardData r114 = r29.u;
        if (r114 == null) goto L109;
        String r115 = r114.isInstantRecCard();
    L111:
        if (r115 != null) goto L113;
        r115 = "";
    L113:
        r8.put("is_instant_rec_card", r115);
        ToolsKt.C(r8, ((BaseViewHolder) r29).c);
        ToolsKt.x(r29, "click_ecom_card", r31, r8, new JSONObject().put("type", "live"));
        LinkedHashMap r41 = new LinkedHashMap();
        r41.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        LiveCardData r42 = r29.u;
        if (r42 == null) goto L119;
        CommonData.User r43 = r42.getUser();
        if (r43 == null) goto L119;
        String r44 = r43.getId();
        if (r44 == null) goto L119;
    L120:
        r41.put("anchor_id", r44);
        LiveCardData r45 = r29.u;
        if (r45 == null) goto L127;
        LiveCardData.Live r46 = r45.getLive();
        if (r46 == null) goto L127;
        Integer r47 = r46.getStatus();
        if (r47 == null) goto L127;
        int r48 = r47.intValue();
    L128:
        r41.put("live_status", String.valueOf(r48));
        LiveCardData r49 = r29.u;
        if (r49 == null) goto L134;
        LiveCardData.Live r50 = r49.getLive();
        if (r50 == null) goto L134;
        String r51 = r50.getRoomId();
        if (r51 == null) goto L134;
    L135:
        r41.put("room_id", r51);
        if (r30 == false) goto L138;
        r41.put("click_area", "product");
    L139:
        LiveCardData r52 = r29.u;
        if (r52 == null) goto L145;
        CommonData.Product r53 = r52.getProduct();
        if (r53 == null) goto L145;
        String r54 = r53.getPromotionId();
        if (r54 == null) goto L145;
    L146:
        r41.put("commodity_id", r54);
        LiveCardData r55 = r29.u;
        if (r55 == null) goto L153;
        CommonData.Product r56 = r55.getProduct();
        if (r56 == null) goto L153;
        Integer r57 = r56.getCommodityType();
        if (r57 == null) goto L153;
        int r116 = r57.intValue();
    L154:
        r41.put("commodity_type", Integer.valueOf(r116));
        LiveCardData r58 = r29.u;
        if (r58 == null) goto L160;
        CommonData.CardCommon r59 = r58.getCardCommon();
        if (r59 == null) goto L160;
        String r60 = r59.getResourceId();
        if (r60 == null) goto L160;
    L161:
        r41.put("resource_id", r60);
        LiveCardData r61 = r29.u;
        if (r61 == null) goto L165;
        String r62 = r61.rcPriorityFromProduct();
        if (r62 == null) goto L165;
    L166:
        r41.put("recommend_info", r62);
        LiveCardData r63 = r29.u;
        if (r63 == null) goto L172;
        CommonData.Product r64 = r63.getProduct();
        if (r64 == null) goto L172;
        String r65 = r64.getProductId();
        if (r65 == null) goto L172;
    L173:
        r41.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r65);
        LiveCardData r66 = r29.u;
        if (r66 == null) goto L178;
        CommonData.User r67 = r66.getUser();
        if (r67 == null) goto L178;
        Boolean r68 = r67.isFollowed();
    L180:
        if (Intrinsics.areEqual(r68, r110) == false) goto L182;
        String r69 = "1";
    L183:
        r41.put(PdpOpenThirdParam.KEY_FOLLOW_STATUS, r69);
        Lazy r70 = HybridAppInfoService.a;
        if (HybridAppInfoService.m() == false) goto L193;
        LiveCardData r71 = r29.u;
        if (r71 == null) goto L188;
        Boolean r72 = r71.isAd();
    L190:
        if (Intrinsics.areEqual(r72, r110) == false) goto L194;
        String r73 = "ad_link_order_center";
    L199:
        r41.put("enter_from_merge", r73);
        r41.put("_param_live_platform", "live");
        r41.put("action_type", "click");
        r41.put("click_order", Integer.valueOf(ToolsKt.g(r29)));
        r41.put("request_id", ToolsKt.l(r29));
        r41.put("outflow_order", Integer.valueOf(ToolsKt.g(r29)));
        r41.put("tab_id", ToolsKt.r(r29));
        r41.put("tab_name", ToolsKt.s(r29));
        r41.put("entrance_type", "live");
        LiveCardData r74 = r29.u;
        if (r74 == null) goto L204;
        LiveCardData.Live r75 = r74.getLive();
        if (r75 == null) goto L204;
        String r76 = r75.isGuessInstant();
    L205:
        if (r76 != null) goto L207;
        r76 = "";
    L207:
        r41.put("is_guess_instant", r76);
        LiveCardData r77 = r29.u;
        if (r77 == null) goto L212;
        CommonData.Store r78 = r77.getStore();
        if (r78 == null) goto L212;
        String r79 = r78.getDistancePoint();
    L213:
        if (r79 != null) goto L215;
        r79 = "";
    L215:
        r41.put("store_to_user", r79);
        LiveCardData r80 = r29.u;
        if (r80 == null) goto L220;
        LiveCardData.Live r81 = r80.getLive();
        if (r81 == null) goto L220;
        String r82 = r81.getArriveTimePoint();
    L221:
        if (r82 != null) goto L223;
        r82 = "";
    L223:
        r41.put("delivery_time", r82);
        LiveCardData r84 = r29.u;
        if (r84 == null) goto L226;
        String r85 = r84.isInstantRecCard();
    L227:
        if (r85 != null) goto L229;
        String r86 = "";
    L230:
        r41.put("is_instant_rec_card", r86);
        LiveCardData r87 = r29.u;
        if (r87 == null) goto L233;
        Boolean r88 = r87.isAd();
    L235:
        if (Intrinsics.areEqual(r88, r110) == false) goto L237;
        r41.put("is_other_channel", "effective_ad");
        r41.put("creative_id", Long.valueOf(a.b(r29)));
        r41.put("log_extra", a.c(r29));
    L237:
        LiveCardData r89 = r29.u;
        if (r89 == null) goto L242;
        CommonData.Extra r90 = r89.getExtra();
        if (r90 == null) goto L242;
        Boolean r91 = r90.isLifeCard();
    L244:
        if (Intrinsics.areEqual(r91, r110) == false) goto L247;
        r41.put("is_life", "1");
    L247:
        if (HybridAppInfoService.m() == false) goto L250;
    L260:
        String r92 = "h5";
    L262:
        r41.put("enter_method", r92);
        ToolsKt.C(r41, ((BaseViewHolder) r29).c);
        ToolsKt.x(r29, "anchor_card_click", r31, r41, new JSONObject().put("type", "live"));
        return;
    L250:
        if (HybridAppInfoService.i() == false) goto L261;
        LiveCardData r94 = r29.u;
        if (r94 == null) goto L256;
        CommonData.Extra r95 = r94.getExtra();
        if (r95 == null) goto L256;
        Boolean r96 = r95.isLifeCard();
    L258:
        if (Intrinsics.areEqual(r96, r110) == false) goto L260;
        r92 = "life_h5";
    L256:
        r96 = null;
        goto L258
    L261:
        r92 = "long_press";
    L242:
        r91 = null;
        goto L244
    L233:
        r88 = null;
        goto L235
    L229:
        r86 = r85;
        goto L230
    L226:
        r85 = null;
    L220:
        r82 = null;
    L212:
        r79 = null;
    L204:
        r76 = null;
    L194:
        r73 = "order_center";
        goto L199
    L188:
        r72 = null;
        goto L190
    L193:
        if (Intrinsics.areEqual(ToolsKt.k(r29).get(PdpOpenThirdParam.KEY_PAGE_NAME), "order_homepage") == true) goto L194;
        if (Intrinsics.areEqual(ToolsKt.k(r29).get(PdpOpenThirdParam.KEY_PAGE_NAME), "popup_mall_homepage") == false) goto L198;
        r73 = "guessyoulike_popup_mall_homepage";
        goto L199
    L198:
        r73 = MallPageName.X_TAB_MALL;
        goto L199
    L182:
        r69 = "0";
    L178:
        r68 = null;
    L172:
        r65 = "";
    L165:
        r62 = "";
    L160:
        r60 = "";
    L153:
        r116 = 0;
    L145:
        r54 = "";
        goto L146
    L138:
        r41.put("click_area", "blank");
    L134:
        r51 = "";
    L127:
        r48 = 0;
    L119:
        r44 = "";
        goto L120
    L109:
        r115 = null;
    L102:
        r113 = null;
        goto L104
    L93:
        r40 = null;
    L78:
        r35 = null;
    L69:
        r32 = null;
    L60:
        r26 = null;
    L54:
        r23 = 0;
    L46:
        r19 = "";
    L41:
        r17 = "";
    L34:
        r14 = "";
    L27:
        r11 = "";
        goto L28
    L11:
        if (r5.isEmpty() == true) goto L14;
        r6 = false;
    L7:
        r4 = null;
        goto L8
    }

    public static void a(BaseViewHolder r5, LiveCardData r6, VideoCardData r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r7 = null;
    L8:
        Intrinsics.checkNotNullParameter(r5, "$this$ClickInsertCard");
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r9.put("ecom_type", "live");
        r9.put("component_id", "80");
        r9.put("module_name", "承接卡片");
        if (r6 == null) goto L21;
        LiveCardData.Live r3 = r6.getLive();
        if (r3 == null) goto L14;
        String r4 = r3.getRoomId();
        if (r4 == null) goto L14;
    L15:
        r9.put("room_id", r4);
        CommonData.Product r10 = r6.getProduct();
        if (r10 == null) goto L19;
        String r11 = r10.getProductId();
        if (r11 == null) goto L19;
    L20:
        r9.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r11);
        String r12 = "c9582.d6936";
    L22:
        if (r7 == null) goto L34;
        VideoCardData.Video r13 = r7.getVideo();
        if (r13 == null) goto L27;
        String r14 = r13.getId();
        if (r14 == null) goto L27;
    L28:
        r9.put("video_id", r14);
        CommonData.Product r15 = r7.getProduct();
        if (r15 == null) goto L32;
        String r16 = r15.getProductId();
        if (r16 == null) goto L32;
    L33:
        r9.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r16);
        r12 = "c9582.d3197";
    L32:
        r16 = "";
    L27:
        r14 = "";
    L34:
        r9.put("click_area", "");
        ToolsKt.x(r5, "click_insert_card", r12, r9, null);
        return;
    L19:
        r11 = "";
    L14:
        r4 = "";
        goto L15
    L21:
        r12 = "";
        goto L22
    }

    public static void b(BaseLiveViewHolder r6, int r7, int r8, String r9, int r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        r8 = 0;
    L5:
        String r2 = "";
        if ((r11 & 4) == 0) goto L9;
        r9 = "";
    L9:
        if ((r11 & 8) == 0) goto L11;
        r10 = 1;
    L11:
        Intrinsics.checkNotNullParameter(r6, "$this$livePlayPerformanceReport");
        Intrinsics.checkNotNullParameter(r9, "errorMsg");
        JSONObject r12 = new JSONObject();
        r12.put("type", "PLAYER_RESULT_LOG");
        r12.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        if (r7 != 2) goto L14;
        r12.put("error_msg", r9);
    L14:
        JSONObject r13 = new JSONObject();
        r13.put("play_result", r7);
        r13.putOpt("t_state_change_time", r6.y);
        r13.put("t_start_time", r6.z);
        r13.put("t_first_frame_time", r6.A);
        r13.put("player_type", "live");
        LiveCardData r3 = r6.u;
        if (r3 == null) goto L20;
        LiveCardData.Live r4 = r3.getLive();
        if (r4 == null) goto L20;
        String r5 = r4.getRoomId();
        if (r5 == null) goto L20;
    L21:
        r13.put("room_id", r5);
        LiveCardData r14 = r6.u;
        if (r14 == null) goto L29;
        CommonData.Product r15 = r14.getProduct();
        if (r15 == null) goto L29;
        String r16 = r15.getProductId();
        if (r16 == null) goto L29;
        r2 = r16;
    L29:
        r13.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        r13.put("is_demotion", r10);
        r13.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, r6.K);
        r13.putOpt(SimilarProductParam.ENTER_FROM, r6.L);
        if (r7 != 2) goto L32;
        r13.put("error_code", r8);
    L32:
        Unit r17 = Unit.INSTANCE;
        r12.put("detail", r13);
        r12.put("log_id", ToolsKt.l(r6));
        com.bytedance.android.shopping.api.mall.common.tools.l.b(com.bytedance.android.shopping.api.mall.common.tools.l.a, r12, r6.H, false, 12);
        return;
    L20:
        r5 = "";
        goto L21
    }

    public static void c(NativeLiveBigCard r6, int r7, int r8, String r9, int r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        r8 = 0;
    L5:
        String r2 = "";
        if ((r11 & 4) == 0) goto L9;
        r9 = "";
    L9:
        if ((r11 & 8) == 0) goto L11;
        r10 = 1;
    L11:
        Intrinsics.checkNotNullParameter(r6, "$this$livePlayPerformanceReport");
        Intrinsics.checkNotNullParameter(r9, "errorMsg");
        JSONObject r12 = new JSONObject();
        r12.put("type", "PLAYER_RESULT_LOG");
        r12.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        if (r7 != 2) goto L14;
        r12.put("error_msg", r9);
    L14:
        JSONObject r13 = new JSONObject();
        r13.put("play_result", r7);
        r13.putOpt("t_state_change_time", r6.y);
        r13.put("t_start_time", r6.z);
        r13.put("t_first_frame_time", r6.A);
        r13.put("player_type", "live");
        LiveCardData r3 = r6.u;
        if (r3 == null) goto L20;
        LiveCardData.Live r4 = r3.getLive();
        if (r4 == null) goto L20;
        String r5 = r4.getRoomId();
        if (r5 == null) goto L20;
    L21:
        r13.put("room_id", r5);
        LiveCardData r14 = r6.u;
        if (r14 == null) goto L29;
        CommonData.Product r15 = r14.getProduct();
        if (r15 == null) goto L29;
        String r16 = r15.getProductId();
        if (r16 == null) goto L29;
        r2 = r16;
    L29:
        r13.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        r13.put("is_demotion", r10);
        if (r7 != 2) goto L32;
        r13.put("error_code", r8);
    L32:
        Unit r17 = Unit.INSTANCE;
        r12.put("detail", r13);
        r12.put("log_id", ToolsKt.l(r6));
        int r18 = f93.a.a;
        f93.a.c(r12, r6.S);
        com.bytedance.android.shopping.api.mall.common.tools.l.b(com.bytedance.android.shopping.api.mall.common.tools.l.a, r12, r6.H, false, 12);
        return;
    L20:
        r5 = "";
        goto L21
    }
}
