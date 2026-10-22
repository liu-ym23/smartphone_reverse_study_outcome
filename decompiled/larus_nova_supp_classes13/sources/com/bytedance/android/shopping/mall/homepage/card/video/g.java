package com.bytedance.android.shopping.mall.homepage.card.video;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.n;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.common.tools.l;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final void b(NativeVideoCard r3, Map<String, Object> r4) {
        r4.put("outflow_order", String.valueOf(ToolsKt.g(r3)));
        VideoCardData r0 = r3.O;
        String r1 = "";
        if (r0 == null) goto L8;
        CommonData.CardCommon r2 = r0.getCardCommon();
        if (r2 == null) goto L8;
        String r5 = r2.getResourceId();
        if (r5 == null) goto L8;
    L9:
        r4.put("resource_id", r5);
        VideoCardData r6 = r3.O;
        if (r6 == null) goto L15;
        CommonData.Product r7 = r6.getProduct();
        if (r7 == null) goto L15;
        String r8 = r7.getProductId();
        if (r8 == null) goto L15;
    L16:
        r4.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r8);
        r4.put("tab_id", ToolsKt.r(r3));
        r4.put("tab_name", ToolsKt.s(r3));
        VideoCardData r9 = r3.O;
        if (r9 == null) goto L22;
        String r10 = r9.rcPriorityFromProduct();
        if (r10 == null) goto L22;
        r1 = r10;
    L22:
        r4.put("recommend_info", r1);
        r4.put("request_id", ToolsKt.l(r3));
        VideoCardData r11 = r3.O;
        if (r11 == null) goto L27;
        CommonData.Extra r12 = r11.getExtra();
        if (r12 == null) goto L27;
        Boolean r13 = r12.isLifeCard();
    L29:
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == false) goto L31;
        r4.put("is_life", "1");
    L31:
        ToolsKt.C(r4, ((BaseViewHolder) r3).c);
        return;
    L27:
        r13 = null;
    L15:
        r8 = "";
    L8:
        r5 = "";
        goto L9
    }

    public static final void e(NativeVideoCard r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$reportVideoCardClick");
        ECHybridListItemVO r0 = ((BaseViewHolder) r5).c;
        if (r0 == null) goto L7;
        n r1 = r0.o;
        if (r1 == null) goto L7;
        List r2 = r1.e;
    L8:
        List r3 = r2;
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == true) goto L22;
        com.bytedance.android.ec.hybrid.list.ability.a r7 = ((BaseViewHolder) r5).b;
        if (r7 == null) goto L49;
        com.bytedance.android.ec.hybrid.list.ability.d r8 = (com.bytedance.android.ec.hybrid.list.ability.d) r7.getAbility(com.bytedance.android.ec.hybrid.list.ability.d.class);
        if (r8 == null) goto L50;
        r8.Fr(r5, ToolsKt.g(r5), null, null);
        return;
    L50:
        return;
    L49:
        return;
    L22:
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r9.put("ecom_type", "video");
        VideoCardData r10 = r5.O;
        if (r10 == null) goto L28;
        VideoCardData.Video r11 = r10.getVideo();
        if (r11 == null) goto L28;
        String r12 = r11.getItemId();
        if (r12 == null) goto L28;
    L29:
        r9.put("group_id", r12);
        r9.put("btm_index", Integer.valueOf(ToolsKt.g(r5) + 1));
        r9.put("is_other_channel", "effective_ad");
        r9.put("ecom_type_second", "video");
        r9.put("bcm_description", MapsKt.mapOf(TuplesKt.to("type", "video")));
        ECHybridListItemVO r13 = ((BaseViewHolder) r5).c;
        if (r13 == null) goto L36;
        com.bytedance.android.ec.hybrid.list.entity.dto.a r14 = r13.D;
        if (r14 == null) goto L36;
        String r15 = r14.d;
        if (r15 == null) goto L36;
        r9.put("session_id", r15);
    L36:
        b(r5, r9);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L39
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L39
        r17.putOpt("type", "video");     // Catch: Throwable -> L39
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L39
    L42:
        if (Result.exceptionOrNull-impl(r18) == null) goto L45;
        r18 = new JSONObject();
    L45:
        ToolsKt.x(r5, "click_ecom_card", r6, r9, (JSONObject) r18);
        return;
    L39:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        r12 = "";
        goto L29
    L11:
        if (r3.isEmpty() == true) goto L14;
        r4 = false;
    L7:
        r2 = null;
        goto L8
    }

    public static final void f(NativeVideoCard r6, String r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        String r2 = "1";
        r0.put("is_auto_play", "1");
        r0.put("ecom_entrance_form", "cover_card");
        r0.put("entrance_type", "video");
        VideoCardData r1 = r6.O;
        if (r1 == null) goto L8;
        VideoCardData.Video r3 = r1.getVideo();
        if (r3 == null) goto L8;
        String r4 = r3.getItemId();
        if (r4 == null) goto L8;
    L9:
        r0.put("group_id", r4);
        VideoCardData r5 = r6.O;
        if (r5 == null) goto L15;
        CommonData.User r8 = r5.getUser();
        if (r8 == null) goto L15;
        String r9 = r8.getId();
        if (r9 == null) goto L15;
    L16:
        r0.put("author_id", r9);
        VideoCardData r10 = r6.O;
        if (r10 == null) goto L20;
        String r11 = r10.rcPriorityFromProduct();
        if (r11 == null) goto L20;
    L21:
        r0.put("recommend_info", r11);
        VideoCardData r12 = r6.O;
        if (r12 == null) goto L26;
        CommonData.User r13 = r12.getUser();
        if (r13 == null) goto L26;
        Boolean r14 = r13.isFollowed();
    L28:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == true) goto L31;
        r2 = "0";
    L31:
        r0.put(PdpOpenThirdParam.KEY_FOLLOW_STATUS, r2);
        VideoCardData r15 = r6.O;
        if (r15 == null) goto L37;
        CommonData.Product r16 = r15.getProduct();
        if (r16 == null) goto L37;
        String r17 = r16.getPromotionId();
        if (r17 == null) goto L37;
    L38:
        r0.put("commodity_id", r17);
        StringBuilder r18 = new StringBuilder("");
        VideoCardData r19 = r6.O;
        if (r19 == null) goto L45;
        CommonData.Product r20 = r19.getProduct();
        if (r20 == null) goto L45;
        Integer r21 = r20.getCommodityType();
        if (r21 == null) goto L45;
        int r22 = r21.intValue();
    L46:
        r18.append(r22);
        r0.put("commodity_type", r18.toString());
        b(r6, r0);
        ToolsKt.x(r6, r7, null, r0, null);
        return;
    L45:
        r22 = 0;
    L37:
        r17 = "";
    L26:
        r14 = null;
    L20:
        r11 = "";
    L15:
        r9 = "";
    L8:
        r4 = "";
        goto L9
    }

    public static void c(NativeVideoBigCard r16, int r17, int r18, String r19, int r20) {
        if ((r20 & 2) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r20 & 4) == 0) goto L9;
        String r0 = "";
    L11:
        if ((r20 & 8) == 0) goto L13;
        int r5 = 1;
    L14:
        Intrinsics.checkNotNullParameter(r16, "$this$reportPerformancePlayResult");
        Intrinsics.checkNotNullParameter(r0, "errorMsg");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L47
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L47
        int r7 = f93.a.a;     // Catch: Throwable -> L47
        f93.a.c(r13, r16.x);     // Catch: Throwable -> L47
        r13.putOpt("type", "PLAYER_RESULT_LOG");     // Catch: Throwable -> L47
        r13.putOpt("EVENT_ORIGIN_FEATURE", "TEMAI");     // Catch: Throwable -> L47
        r13.putOpt("log_id", ToolsKt.l(r16));     // Catch: Throwable -> L47
        if (r17 != 2) goto L18;
        r13.putOpt("error_msg", r0);     // Catch: Throwable -> L47
    L18:
        long r8 = r16.y;     // Catch: Throwable -> L47
        long r10 = r16.z;     // Catch: Throwable -> L47
        VideoCardData r9 = r16.v;     // Catch: Throwable -> L47
        if (r9 == null) goto L26;
        VideoCardData.Video r11 = r9.getVideo();     // Catch: Throwable -> L47
        if (r11 == null) goto L26;
        String r12 = r11.getId();     // Catch: Throwable -> L47
        if (r12 == null) goto L26;
        String r14 = r12;
    L27:
        VideoCardData r15 = r16.v;     // Catch: Throwable -> L47
        if (r15 == null) goto L35;
        VideoCardData.Video r21 = r15.getVideo();     // Catch: Throwable -> L47
        if (r21 == null) goto L35;
        String r22 = r21.getItemId();     // Catch: Throwable -> L47
        if (r22 == null) goto L35;
        String r110 = r22;
    L36:
        VideoCardData r23 = r16.v;     // Catch: Throwable -> L47
        if (r23 == null) goto L44;
        CommonData.Product r24 = r23.getProduct();     // Catch: Throwable -> L47
        if (r24 == null) goto L44;
        String r25 = r24.getProductId();     // Catch: Throwable -> L47
        if (r25 == null) goto L44;
        String r111 = r25;
    L45:
        r13.putOpt("detail", a(r17, r4, r5, r8, r10, r14, r110, r111));     // Catch: Throwable -> L47
        Object r1 = Result.constructor-impl(r13);     // Catch: Throwable -> L47
    L50:
        if (Result.exceptionOrNull-impl(r1) == null) goto L53;
        r1 = new JSONObject();
    L53:
        l r3 = l.a;
        l.b(r3, (JSONObject) r1, r16.A, false, 12);
        return;
    L44:
        r111 = "";
    L35:
        r110 = "";
    L26:
        r14 = "";
    L47:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L13:
        r5 = 0;
        goto L14
    L9:
        r0 = r19;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }

    public static void d(NativeVideoCard r16, int r17, int r18, String r19, int r20, int r21) {
        if ((r21 & 2) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r21 & 4) == 0) goto L9;
        String r0 = "";
    L11:
        if ((r21 & 8) == 0) goto L13;
        int r5 = 1;
    L14:
        Intrinsics.checkNotNullParameter(r16, "$this$reportPerformancePlayResult");
        Intrinsics.checkNotNullParameter(r0, "errorMsg");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L47
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L47
        r13.putOpt("type", "PLAYER_RESULT_LOG");     // Catch: Throwable -> L47
        r13.putOpt("EVENT_ORIGIN_FEATURE", "TEMAI");     // Catch: Throwable -> L47
        r13.putOpt("log_id", ToolsKt.l(r16));     // Catch: Throwable -> L47
        if (r17 != 2) goto L18;
        r13.putOpt("error_msg", r0);     // Catch: Throwable -> L47
    L18:
        long r8 = r16.V;     // Catch: Throwable -> L47
        long r10 = r16.W;     // Catch: Throwable -> L47
        VideoCardData r7 = r16.O;     // Catch: Throwable -> L47
        if (r7 == null) goto L26;
        VideoCardData.Video r9 = r7.getVideo();     // Catch: Throwable -> L47
        if (r9 == null) goto L26;
        String r11 = r9.getId();     // Catch: Throwable -> L47
        if (r11 == null) goto L26;
        String r12 = r11;
    L27:
        VideoCardData r14 = r16.O;     // Catch: Throwable -> L47
        if (r14 == null) goto L35;
        VideoCardData.Video r15 = r14.getVideo();     // Catch: Throwable -> L47
        if (r15 == null) goto L35;
        String r22 = r15.getItemId();     // Catch: Throwable -> L47
        if (r22 == null) goto L35;
        String r110 = r22;
    L36:
        VideoCardData r23 = r16.O;     // Catch: Throwable -> L47
        if (r23 == null) goto L44;
        CommonData.Product r24 = r23.getProduct();     // Catch: Throwable -> L47
        if (r24 == null) goto L44;
        String r25 = r24.getProductId();     // Catch: Throwable -> L47
        if (r25 == null) goto L44;
        String r111 = r25;
    L45:
        JSONObject r3 = a(r17, r4, r5, r8, r10, r12, r110, r111);     // Catch: Throwable -> L47
        r3.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, r16.y1);     // Catch: Throwable -> L47
        r3.putOpt(SimilarProductParam.ENTER_FROM, r16.G1);     // Catch: Throwable -> L47
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L47
        r13.putOpt("detail", r3);     // Catch: Throwable -> L47
        Object r1 = Result.constructor-impl(r13);     // Catch: Throwable -> L47
    L50:
        if (Result.exceptionOrNull-impl(r1) == null) goto L53;
        r1 = new JSONObject();
    L53:
        l r27 = l.a;
        l.b(r27, (JSONObject) r1, r16.k1, false, 12);
        return;
    L44:
        r111 = "";
    L35:
        r110 = "";
    L26:
        r12 = "";
    L47:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L13:
        r5 = r20;
        goto L14
    L9:
        r0 = r19;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }

    public static final JSONObject a(int r3, int r4, int r5, long r6, long r8, String r10, String r11, String r12) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.putOpt("play_result", Integer.valueOf(r3));     // Catch: Throwable -> L7
        r1.putOpt("t_start_time", Long.valueOf(r6));     // Catch: Throwable -> L7
        r1.putOpt("t_first_frame_time", Long.valueOf(r8));     // Catch: Throwable -> L7
        r1.putOpt("player_type", "video");     // Catch: Throwable -> L7
        r1.putOpt("vid", r10);     // Catch: Throwable -> L7
        r1.putOpt("video_item_id", r11);     // Catch: Throwable -> L7
        r1.putOpt(PdpOpenThirdParam.KEY_PRODUCT_ID, r12);     // Catch: Throwable -> L7
        r1.putOpt("is_demotion", Integer.valueOf(r5));     // Catch: Throwable -> L7
        if (r3 != 2) goto L5;
        r1.putOpt("error_code", Integer.valueOf(r4));     // Catch: Throwable -> L7
    L5:
        Object r7 = Result.constructor-impl(r1);     // Catch: Throwable -> L7
    L10:
        if (Result.exceptionOrNull-impl(r7) == null) goto L14;
        r7 = new JSONObject();
    L14:
        return (JSONObject) r7;
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
