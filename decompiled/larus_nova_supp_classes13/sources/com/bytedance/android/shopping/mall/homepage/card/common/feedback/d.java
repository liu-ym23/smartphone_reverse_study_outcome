package com.bytedance.android.shopping.mall.homepage.card.common.feedback;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.n;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.mall.homepage.card.live.BaseLiveViewHolder;
import com.bytedance.android.shopping.mall.homepage.card.video.NativeVideoCard;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final Map<String, Object> a(BaseViewHolder r9, FeedbackData r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        int r2 = 0;
        String r4 = "1";
        String r7 = "";
        CommonData.CardCommon r8 = null;
        if ((r9 instanceof NativeVideoCard) == false) goto L45;
        FeedbackData.NegFeedbackStyles r1 = r10.getNegFeedbackStyles();
        if (r1 == null) goto L11;
        FeedbackData.NegFeedbackElement r3 = r1.getType4();
        if (r3 == null) goto L11;
        List<FeedbackData.Item> r5 = r3.getItems();
        if (r5 == null) goto L11;
        int r6 = r5.size();
    L12:
        FeedbackData.NegFeedbackStyles r11 = r10.getNegFeedbackStyles();
        if (r11 == null) goto L19;
        FeedbackData.NegFeedbackElement r12 = r11.getType4();
        if (r12 == null) goto L19;
        Integer r13 = r12.getFirstPageLimit();
        if (r13 == null) goto L19;
        r2 = r13.intValue();
    L19:
        if (r6 > r2) goto L22;
        r4 = "0";
    L22:
        r0.put("with_more", r4);
        NativeVideoCard r14 = (NativeVideoCard) r9;
        VideoCardData r15 = r14.O;
        if (r15 == null) goto L28;
        VideoCardData.Video r16 = r15.getVideo();
        if (r16 == null) goto L28;
        String r17 = r16.getItemId();
        if (r17 == null) goto L28;
    L29:
        r0.put("group_id", r17);
        r0.put("ecom_type", "video");
        VideoCardData r18 = r14.O;
        if (r18 == null) goto L32;
        CommonData.Product r19 = r18.getProduct();
    L33:
        if (r19 == null) goto L35;
        String r20 = r19.getProductId();
    L36:
        VideoCardData r21 = r14.O;
        if (r21 == null) goto L39;
        String r22 = r21.rcPriorityFromProduct();
    L40:
        VideoCardData r110 = r14.O;
        if (r110 == null) goto L93;
        CommonData.CardCommon r111 = r110.getCardCommon();
    L43:
        r8 = r111;
    L93:
        if (r8 == null) goto L96;
        String r112 = r8.getResourceId();
        if (r112 == null) goto L96;
    L97:
        r0.put("resource_id", r112);
        if (r20 != null) goto L100;
        r20 = "";
    L100:
        r0.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r20);
        if (r22 == null) goto L104;
        r7 = r22;
    L104:
        r0.put("recommend_info", r7);
        r0.put("enter_method", "long_press");
        r0.put("outflow_order", Integer.valueOf(ToolsKt.g(r9)));
        r0.put("btm_index", Integer.valueOf(ToolsKt.g(r9) + 1));
        r0.put("request_id", ToolsKt.l(r9));
        r0.put("tab_id", ToolsKt.r(r9));
        r0.put("tab_name", ToolsKt.s(r9));
        ECHybridListItemVO r23 = r9.c;
        if (r23 == null) goto L111;
        n r24 = r23.o;
        if (r24 == null) goto L111;
        Map r25 = r24.f;
        if (r25 == null) goto L111;
        r0.putAll(r25);
    L111:
        r0.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        return r0;
    L96:
        r112 = "";
        goto L97
    L39:
        r22 = null;
        goto L40
    L35:
        r20 = null;
        goto L36
    L32:
        r19 = null;
    L28:
        r17 = "";
    L11:
        r6 = 0;
        goto L12
    L45:
        if ((r9 instanceof BaseLiveViewHolder) == false) goto L92;
        FeedbackData.NegFeedbackStyles r26 = r10.getNegFeedbackStyles();
        if (r26 == null) goto L53;
        FeedbackData.NegFeedbackElement r27 = r26.getType1();
        if (r27 == null) goto L53;
        List<FeedbackData.Item> r28 = r27.getItems();
        if (r28 == null) goto L53;
        int r29 = r28.size();
    L54:
        FeedbackData.NegFeedbackStyles r113 = r10.getNegFeedbackStyles();
        if (r113 == null) goto L61;
        FeedbackData.NegFeedbackElement r114 = r113.getType1();
        if (r114 == null) goto L61;
        Integer r115 = r114.getFirstPageLimit();
        if (r115 == null) goto L61;
        r2 = r115.intValue();
    L61:
        if (r29 > r2) goto L64;
        r4 = "0";
    L64:
        r0.put("with_more", r4);
        BaseLiveViewHolder r116 = (BaseLiveViewHolder) r9;
        LiveCardData r30 = r116.u;
        if (r30 == null) goto L70;
        LiveCardData.Live r31 = r30.getLive();
        if (r31 == null) goto L70;
        String r32 = r31.getRoomId();
        if (r32 == null) goto L70;
    L71:
        r0.put("room_id", r32);
        LiveCardData r33 = r116.u;
        if (r33 == null) goto L77;
        CommonData.User r34 = r33.getUser();
        if (r34 == null) goto L77;
        String r35 = r34.getId();
        if (r35 == null) goto L77;
    L78:
        r0.put("anchor_id", r35);
        r0.put("ecom_type", "live");
        LiveCardData r36 = r116.u;
        if (r36 == null) goto L81;
        CommonData.Product r37 = r36.getProduct();
    L82:
        if (r37 == null) goto L84;
        r20 = r37.getProductId();
    L85:
        LiveCardData r38 = r116.u;
        if (r38 == null) goto L88;
        r22 = r38.rcPriorityFromProduct();
    L89:
        LiveCardData r117 = r116.u;
        if (r117 == null) goto L93;
        r111 = r117.getCardCommon();
        goto L43
    L88:
        r22 = null;
        goto L89
    L84:
        r20 = null;
        goto L85
    L81:
        r37 = null;
    L77:
        r35 = "";
    L70:
        r32 = "";
    L53:
        r29 = 0;
        goto L54
    L92:
        r20 = null;
        r22 = null;
        goto L93
    }

    public static final void c(BaseViewHolder r1, FeedbackData r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$reportFeedbackClose");
        Intrinsics.checkNotNullParameter(r2, "feedbackData");
        Intrinsics.checkNotNullParameter(r3, "closeType");
        Map<String, Object> r4 = a(r1, r2);
        r4.put("close_type", r3);
        ToolsKt.x(r1, "close_ecom_dislike", null, r4, null);
    }

    public static final void b(BaseViewHolder r2, FeedbackData r3, String r4, FeedbackData.Item r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$reportFeedbackClick");
        Intrinsics.checkNotNullParameter(r3, "feedbackData");
        Intrinsics.checkNotNullParameter(r4, "clickArea");
        Map<String, Object> r6 = a(r2, r3);
        r6.put("click_area", r4);
        if (r5 == null) goto L5;
        Integer r0 = r5.getType();
    L6:
        if (r0 == null) goto L11;
        r6.put("confirm_content", String.valueOf(r5.getType().intValue()));
        String r7 = r5.getText();
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        r6.put("confirm_content_text", r7);
    L11:
        ToolsKt.x(r2, "click_ecom_dislike", "c9582.d09069", r6, null);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
