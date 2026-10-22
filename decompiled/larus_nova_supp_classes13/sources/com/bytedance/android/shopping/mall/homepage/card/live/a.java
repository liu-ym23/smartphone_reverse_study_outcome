package com.bytedance.android.shopping.mall.homepage.card.live;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final long b(BaseViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getAdCreativeId");
        ECHybridListItemVO r3 = r2.c;
        Object r0 = null;
        if (r3 == null) goto L9;
        com.bytedance.android.ec.hybrid.list.entity.n r4 = r3.o;
        if (r4 == null) goto L9;
        HashMap r5 = r4.b;
        if (r5 == null) goto L9;
        Object r6 = r5.get("ad_common_data");
    L11:
        if ((r6 instanceof Map) == true) goto L13;
        r6 = null;
    L13:
        Map r7 = (Map) r6;
        if (r7 == null) goto L16;
        Object r8 = r7.get("creative_id");
    L18:
        if ((r8 instanceof Double) == false) goto L21;
        r0 = r8;
    L21:
        Double r1 = (Double) r0;
        if (r1 != null) goto L26;
        return 0;
    L26:
        return (long) r1.doubleValue();
    L16:
        r8 = null;
    L9:
        r6 = null;
        goto L11
    }

    public static final String c(BaseViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getAdLogExtra");
        ECHybridListItemVO r3 = r2.c;
        Object r0 = null;
        if (r3 == null) goto L9;
        com.bytedance.android.ec.hybrid.list.entity.n r4 = r3.o;
        if (r4 == null) goto L9;
        HashMap r5 = r4.b;
        if (r5 == null) goto L9;
        Object r6 = r5.get("ad_common_data");
    L11:
        if ((r6 instanceof Map) == true) goto L13;
        r6 = null;
    L13:
        Map r7 = (Map) r6;
        if (r7 == null) goto L16;
        Object r8 = r7.get("log_extra");
    L18:
        if ((r8 instanceof String) == false) goto L21;
        r0 = r8;
    L21:
        String r1 = (String) r0;
        if (r1 != null) goto L25;
        return "";
    L25:
        return r1;
    L16:
        r8 = null;
    L9:
        r6 = null;
        goto L11
    }

    public static final void a(BaseLiveViewHolder r4, String r5, Map<String, ? extends Object> r6) {
        LiveCardData r0 = r4.u;
        k93.g r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = r0.isAd();
    L7:
        if ((!Intrinsics.areEqual(r2, Boolean.TRUE)) == false) goto L9;
        return;
    L9:
        Intrinsics.checkNotNullParameter(r4, "$this$baseCommonAdReport");
        Intrinsics.checkNotNullParameter(r5, "actionName");
        ECHybridListItemVO r3 = ((BaseViewHolder) r4).c;
        if (r3 != null) goto L12;
    L14:
        if (r3 == null) goto L16;
        com.bytedance.android.ec.hybrid.list.entity.n r7 = r3.o;
    L17:
        com.bytedance.android.ec.hybrid.list.ability.a r8 = ((BaseViewHolder) r4).b;
        if (r8 == null) goto L20;
        r1 = (k93.g) r8.getAbility(k93.g.class);
    L20:
        d(r7, r5, r6, r1);
        return;
    L16:
        r7 = null;
        goto L17
    L12:
        if (r3.w != true) goto L14;
        return;
    L5:
        r2 = null;
        goto L7
    }

    public static final void e(NativeLiveCard r1, boolean r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$reportFeedAdClick");
        Map r4 = MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r3)));
        if (r2 == false) goto L5;
        a(r1, "feed_ad_realtime_click_card", r4);
        a(r1, "feed_ad_live_click_source_card", r4);
        return;
    L5:
        a(r1, "feed_ad_realtime_click_video", r4);
        a(r1, "feed_ad_live_click_source_video", r4);
    }

    public static final void d(com.bytedance.android.ec.hybrid.list.entity.n r17, String r18, Map<String, ? extends Object> r19, k93.g r20) {
        Intrinsics.checkNotNullParameter(r18, "actionName");
        if (r17 == null) goto L7;
        Map r3 = r17.d;
        if (r3 == null) goto L7;
        Object r1 = r3.get(r18);
    L9:
        if ((r1 instanceof Map) == true) goto L11;
        r1 = null;
    L11:
        Map r10 = (Map) r1;
        if (r10 != null) goto L14;
        return;
    L14:
        HashMap r0 = r17.b;
        if (r0 == null) goto L17;
        Object r2 = r0.get("ad_common_data");
    L19:
        if ((r2 instanceof Map) == true) goto L21;
        r2 = null;
    L21:
        Map r11 = (Map) r2;
        if (r11 != null) goto L24;
        return;
    L24:
        Object r4 = r10.get("tag");
        if ((r4 instanceof String) == true) goto L27;
        r4 = null;
    L27:
        String r5 = (String) r4;
        Object r6 = r10.get("label");
        if ((r6 instanceof String) == true) goto L30;
        r6 = null;
    L30:
        String r12 = (String) r6;
        Object r7 = r10.get("refer");
        if ((r7 instanceof String) == true) goto L33;
        r7 = null;
    L33:
        String r8 = (String) r7;
        LinkedHashMap r13 = new LinkedHashMap();
        Object r9 = r10.get("ad_extra_data");
        if ((r9 instanceof Map) == true) goto L36;
        r9 = null;
    L36:
        Map<? extends String, ? extends Object> r14 = (Map) r9;
        if (r14 != null) goto L39;
        r14 = MapsKt.emptyMap();
    L39:
        r13.putAll(r14);
        if (r19 == null) goto L42;
        r13.putAll(r19);
    L42:
        Object r15 = r11.get("category");
        if ((r15 instanceof String) == true) goto L45;
        r15 = null;
    L45:
        String r16 = (String) r15;
        Object r21 = r11.get("creative_id");
        if ((r21 instanceof Double) == true) goto L48;
        r21 = null;
    L48:
        Double r110 = (Double) r21;
        Object r22 = r11.get("log_extra");
        if ((r22 instanceof String) == true) goto L51;
        r22 = null;
    L51:
        String r111 = (String) r22;
        Object r23 = r11.get("group_id");
        if ((r23 instanceof Double) == true) goto L54;
        r23 = null;
    L54:
        Double r24 = (Double) r23;
        if (r20 == null) goto L72;
        if (r5 != null) goto L58;
        String r25 = "";
    L59:
        if (r12 != null) goto L61;
        String r26 = "";
    L62:
        if (r110 == null) goto L67;
        String r27 = String.valueOf((long) r110.doubleValue());
        if (r27 == null) goto L67;
        String r28 = r27;
    L68:
        if (r24 == null) goto L70;
        String r29 = String.valueOf(r24.doubleValue());
    L71:
        r20.adReport(r25, r26, r8, r28, r111, r13, r29, r16);
        goto L72
    L70:
        r29 = null;
    L67:
        r28 = "";
        goto L68
    L61:
        r26 = r12;
        goto L62
    L58:
        r25 = r5;
    L72:
        Object r30 = r10.get("need_third_track");
        if ((r30 instanceof Boolean) == true) goto L75;
        r30 = null;
    L75:
        Boolean r31 = Boolean.TRUE;
        if (Intrinsics.areEqual((Boolean) r30, r31) == false) goto L100;
        Object r32 = r10.get("is_click_event");
        if ((r32 instanceof Boolean) == true) goto L81;
        r32 = null;
    L81:
        if (Intrinsics.areEqual((Boolean) r32, r31) == false) goto L86;
        Object r33 = r11.get("click_track_url_list");
        if ((r33 instanceof List) == true) goto L85;
        r33 = null;
    L85:
        List<String> r34 = (List) r33;
    L90:
        List<String> r35 = r34;
        if (r20 == null) goto L101;
        if (r12 != null) goto L94;
        String r36 = "";
    L95:
        if (r110 == null) goto L97;
        Long r37 = Long.valueOf((long) r110.doubleValue());
    L98:
        r20.adThirdTrackReport(r36, r35, r37, r111, new JSONObject(r13));
        return;
    L97:
        r37 = null;
        goto L98
    L94:
        r36 = r12;
        goto L95
    L101:
        return;
    L86:
        Object r38 = r11.get("track_url_list");
        if ((r38 instanceof List) == true) goto L89;
        r38 = null;
    L89:
        r34 = (List) r38;
        goto L90
    L100:
        return;
    L17:
        r2 = null;
    L7:
        r1 = null;
        goto L9
    }
}
