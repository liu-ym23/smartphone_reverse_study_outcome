package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.promotion.ECUIActivity;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.model.ECUISkuInfo;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(ECUISkuInfo r19, com.bytedance.android.ec.common.api.jump.model.g r20, int r21) {
        Intrinsics.checkNotNullParameter(r19, "ecUISkuInfo");
        Intrinsics.checkNotNullParameter(r20, "promotionParams");
        ql.a r2 = r20.a;
        com.bytedance.android.ec.common.api.jump.model.f r3 = r20.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        gi2.a r4 = (gi2.a) r20.getParamsModel(Reflection.getOrCreateKotlinClass(gi2.a.class));
        LiveRoomParams r5 = r20.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r3 == null) goto L5;
        jf.b r7 = r3.c;
    L6:
        if (r3 == null) goto L8;
        String r6 = r3.e;
    L9:
        LinkedHashMap r8 = new LinkedHashMap();
        Map<String, String> r9 = r19.q;
        if (r9 == null) goto L12;
        r8.putAll(r9);
    L12:
        if (r5 == null) goto L14;
        Map r10 = r5.getReportParams();
    L15:
        if (r10 != null) goto L17;
        r10 = MapsKt.emptyMap();
    L17:
        r8.putAll(r10);
        if (r5 == null) goto L20;
        String r11 = r5.getGroupId();
    L21:
        String r12 = "";
        if (r11 != null) goto L24;
        r11 = "";
    L24:
        r8.put("group_id", r11);
        if (r5 == null) goto L27;
        String r13 = r5.getEnterMethod();
    L28:
        if (r13 != null) goto L30;
        r13 = "";
    L30:
        r8.put("enter_method", r13);
        if (r5 == null) goto L33;
        String r14 = r5.getActionType();
    L34:
        if (r14 != null) goto L36;
        r14 = "";
    L36:
        r8.put("action_type", r14);
        if (r5 == null) goto L39;
        String r15 = r5.getRequestId();
    L40:
        if (r15 != null) goto L42;
        r15 = "";
    L42:
        r8.put("request_id", r15);
        if (r5 == null) goto L45;
        String r16 = r5.getEnterFromMerge();
    L46:
        if (r16 != null) goto L48;
        r16 = "";
    L48:
        r8.put("enter_from_merge", r16);
        if (r5 == null) goto L51;
        String r17 = r5.getSourcePage();
    L52:
        if (r17 != null) goto L54;
        r17 = "";
    L54:
        r8.put("source_page", r17);
        if (r5 == null) goto L57;
        String r18 = r5.getAuthorId();
    L58:
        if (r18 != null) goto L60;
        r18 = "";
    L60:
        r8.put("anchor_id", r18);
        if (r5 == null) goto L63;
        String r22 = r5.getRoomId();
    L64:
        if (r22 != null) goto L66;
        r22 = "";
    L66:
        r8.put("room_id", r22);
        r8.put("entrance_info", r20.getAddToCartEntranceInfo().toString());
        if (r5 == null) goto L69;
        String r1 = r5.getEnterFromMerge();
    L70:
        if (r1 != null) goto L72;
        r1 = "";
    L72:
        r8.put("carrier_source", r1);
        String r23 = r19.f;
        if (r23 != null) goto L75;
        r23 = "";
    L75:
        r8.put("commodity_id", r23);
        String r24 = r19.h;
        if (r24 != null) goto L78;
        r24 = "";
    L78:
        r8.put("product_id", r24);
        String r25 = r19.o;
        if (r25 != null) goto L81;
        r25 = "";
    L81:
        r8.put("commodity_type", r25);
        if (r5 == null) goto L84;
        String r26 = r5.getFollowStatus();
    L85:
        if (r26 != null) goto L87;
        r26 = "";
    L87:
        r8.put("follow_status", r26);
        r8.put("app_id", "1128");
        r8.put("params_for_special", "tppp");
        String r27 = r19.p;
        if (r27 != null) goto L90;
        r27 = "";
    L90:
        r8.put("carrier_type", r27);
        boolean r28 = r19.c;
        String r29 = BDLocationException.ERROR_TIMEOUT;
        if (r28 == false) goto L93;
        Object r30 = BDLocationException.ERROR_TIMEOUT;
    L94:
        r8.put("with_sku", r30);
        ECUIAskExplainInfo r31 = r19.v;
        if (r31 != null) goto L97;
    L99:
        Object r32 = BDLocationException.ERROR_TIMEOUT;
    L100:
        r8.put("is_explain_apply", r32);
        ECUIActivity r33 = r19.getActivity();
        if (r33 == null) goto L103;
        String r34 = String.valueOf(r33.getActivityId());
    L104:
        if (r34 != null) goto L106;
        r34 = "";
    L106:
        r8.put("ecom_tag_activity_id", r34);
        if (r4 == null) goto L109;
        String r35 = r4.b;
    L110:
        if (r35 != null) goto L112;
        r35 = "";
    L112:
        r8.put("live_list_channel", r35);
        ECUICampaign r36 = r19.e;
        if (r36 == null) goto L115;
        Boolean r37 = r36.isGroup();
    L117:
        if (Intrinsics.areEqual(r37, Boolean.TRUE) == false) goto L119;
        Object r38 = "1";
    L120:
        r8.put("is_groupbuying", r38);
        String r39 = r2.getTrackLabelName();
        if (r39 != null) goto L123;
        r39 = "";
    L123:
        r8.put("label_name", r39);
        r8.put("fast_dispatch", "null");
        String r40 = r2.getLabelNameLive();
        if (r40 != null) goto L126;
        r40 = "";
    L126:
        r8.put("label_name_live", r40);
        if (r2.isOnExplaining() == false) goto L129;
        Object r41 = "1";
    L130:
        r8.put("is_explaining", r41);
        r8.put("fast_dispatch", "");
        r8.put("from_entrance", "live_sku_card");
        String r42 = r2.getEcomGroupType();
        if (r42 != null) goto L133;
        r42 = "live";
    L133:
        r8.put("ecom_group_type", r42);
        ECUICampaign r43 = r19.e;
        if (r43 == null) goto L142;
        Handler r44 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        long r110 = SystemClock.elapsedRealtime();
        if (r43.isCampaign().booleanValue() == false) goto L142;
        jf.b r111 = r7;
        if (r43.startTime <= r110) goto L140;
    L143:
        boolean r45 = false;
    L144:
        if (r45 == false) goto L146;
        String r46 = "seckill";
    L147:
        r8.put("product_activity_type", r46);
        ECUIActivity r0 = r19.getActivity();
        if (r0 == null) goto L150;
        String r47 = String.valueOf(r0.getActivityType());
    L151:
        if (r47 != null) goto L153;
        r47 = "";
    L153:
        r8.put("ecom_tag_activity_type", r47);
        if (r21 != 1) goto L156;
        Object r48 = "1";
    L157:
        r8.put("is_shopping_cart", r48);
        if (r2.isCrossborderProduct() == false) goto L160;
        Object r49 = "1";
    L161:
        r8.put("is_crossborder_goods", r49);
        if (r2.isPreSale() == false) goto L164;
        Object r50 = "1";
    L165:
        r8.put("upfront_presell", r50);
        String r51 = r2.getBaseVerifiedCategory();
        if (r51 != null) goto L168;
        r51 = "";
    L168:
        r8.put("base_verified_category", r51);
        if (r2.isOnExplaining() == false) goto L171;
        Object r52 = "1";
    L172:
        r8.put("is_explaining", r52);
        r8.put("local_num", String.valueOf(r2.getLocalNum()));
        r8.put("page_name", "live_room_sku");
        r8.put("source_method", l0.i("enter_method"));
        if (r5 == null) goto L177;
        Function0 r53 = r5.getScreenType();
        if (r53 == null) goto L177;
        String r54 = (String) r53.invoke();
    L178:
        if (r54 != null) goto L180;
        r54 = "";
    L180:
        r8.put("screen_type", r54);
        if (r111 == null) goto L183;
        String r55 = r111.a;
    L184:
        if (r55 != null) goto L186;
        r55 = "";
    L186:
        r8.put("ecom_entrance_form", r55);
        if (r6 != null) goto L189;
        r6 = "";
    L189:
        r8.put("new_source_type", r6);
        r8.put("hot_sale_num", String.valueOf(r2.getHotAtmosphereSaleNum()));
        if (r2.canShowHotAtmosphere() == false) goto L192;
        r29 = "1";
    L192:
        r8.put("is_hot_sale", r29);
        String r56 = r2.getHotSaleTypeStr();
        if (r56 == null) goto L196;
        r12 = r56;
    L196:
        r8.put("hot_sale_type", r12);
        return r8;
    L183:
        r55 = null;
    L177:
        r54 = null;
        goto L178
    L171:
        r52 = BDLocationException.ERROR_TIMEOUT;
        goto L172
    L164:
        r50 = BDLocationException.ERROR_TIMEOUT;
        goto L165
    L160:
        r49 = BDLocationException.ERROR_TIMEOUT;
        goto L161
    L156:
        r48 = BDLocationException.ERROR_TIMEOUT;
        goto L157
    L150:
        r47 = null;
        goto L151
    L146:
        r46 = "nonactivity";
        goto L147
    L140:
        if (r110 > r43.endTime) goto L143;
        r45 = true;
    L142:
        r111 = r7;
        goto L143
    L129:
        r41 = BDLocationException.ERROR_TIMEOUT;
        goto L130
    L119:
        r38 = BDLocationException.ERROR_TIMEOUT;
        goto L120
    L115:
        r37 = null;
        goto L117
    L109:
        r35 = null;
        goto L110
    L103:
        r34 = null;
        goto L104
    L97:
        if (r31.isAsked() != true) goto L99;
        r32 = "1";
        goto L100
    L93:
        r30 = "1";
        goto L94
    L84:
        r26 = null;
        goto L85
    L69:
        r1 = null;
        goto L70
    L63:
        r22 = null;
        goto L64
    L57:
        r18 = null;
        goto L58
    L51:
        r17 = null;
        goto L52
    L45:
        r16 = null;
        goto L46
    L39:
        r15 = null;
        goto L40
    L33:
        r14 = null;
        goto L34
    L27:
        r13 = null;
        goto L28
    L20:
        r11 = null;
        goto L21
    L14:
        r10 = null;
        goto L15
    L8:
        r6 = null;
        goto L9
    L5:
        r7 = null;
        goto L6
    }
}
