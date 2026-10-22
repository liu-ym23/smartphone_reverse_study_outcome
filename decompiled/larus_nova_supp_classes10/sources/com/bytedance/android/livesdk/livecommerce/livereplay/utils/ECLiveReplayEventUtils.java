package com.bytedance.android.livesdk.livecommerce.livereplay.utils;

import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.ECLiveCommerceModel_ProvideEventServiceFactory;
import com.bytedance.android.livesdk.livecommerce.event.k;
import el2.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveReplayEventUtils {
    public i a;
    public final il.a b;

    public ECLiveReplayEventUtils(il.a r2) {
        Intrinsics.checkNotNullParameter(r2, "eventMap");
        this.b = r2;
        this.a = ECLiveCommerceModel_ProvideEventServiceFactory.proxyProvideEventService(hh2.a.a().f);
    }

    public static void a(Map r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$putNotNull");
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 == null) goto L6;
        r1.put(r2, r3.toString());
        return;
    }

    public final void f(String r2, Map<String, String> r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "params");
        i r0 = this.a;
        if (r0 == null) goto L8;
        k r6 = r0.a(r2);
        if (r6 == null) goto L9;
        r6.g(r3);
        r6.l(r4, r5);
        return;
    L9:
        return;
    }

    public final void b(ml.b r4, String r5, JSONObject r6, Map<String, String> r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "roomInfo");
        Intrinsics.checkNotNullParameter(r5, "liveReplayId");
        Intrinsics.checkNotNullParameter(r6, "ecomLiveParams");
        LinkedHashMap r9 = new LinkedHashMap();
        if (r7 == null) goto L5;
        r9.putAll(r7);
    L5:
        a(r9, "EVENT_ORIGIN_FEATURE", "TEMAI");
        if (r7 == null) goto L8;
        String r2 = r7.get("enter_from_merge");
    L9:
        a(r9, "enter_from_merge", r2);
        if (r7 == null) goto L12;
        String r3 = r7.get("enter_method");
    L13:
        a(r9, "enter_method", r3);
        if (r7 == null) goto L16;
        String r10 = r7.get("action_type");
    L17:
        a(r9, "action_type", r10);
        a(r9, "anchor_id", r4.c());
        a(r9, "room_id", r4.roomId());
        a(r9, "episode_id", r5);
        a(r9, "replay_page_name", r8);
        f("livesdk_ec_live_replay_fold", r9, null, null);
        return;
    L16:
        r10 = null;
        goto L17
    L12:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    }

    public final void e(ml.b r4, String r5, JSONObject r6, Map<String, String> r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "roomInfo");
        Intrinsics.checkNotNullParameter(r5, "liveReplayId");
        Intrinsics.checkNotNullParameter(r6, "ecomLiveParams");
        LinkedHashMap r9 = new LinkedHashMap();
        if (r7 == null) goto L5;
        r9.putAll(r7);
    L5:
        a(r9, "EVENT_ORIGIN_FEATURE", "TEMAI");
        if (r7 == null) goto L8;
        String r2 = r7.get("enter_from_merge");
    L9:
        a(r9, "enter_from_merge", r2);
        if (r7 == null) goto L12;
        String r3 = r7.get("enter_method");
    L13:
        a(r9, "enter_method", r3);
        if (r7 == null) goto L16;
        String r10 = r7.get("action_type");
    L17:
        a(r9, "action_type", r10);
        a(r9, "anchor_id", r4.c());
        a(r9, "room_id", r4.roomId());
        a(r9, "episode_id", r5);
        a(r9, "replay_page_name", r8);
        f("livesdk_ec_live_replay_unfold", r9, null, null);
        return;
    L16:
        r10 = null;
        goto L17
    L12:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    }

    public final void c(ml.b r4, ni2.a r5, String r6, JSONObject r7, Map<String, String> r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r4, "roomInfo");
        Intrinsics.checkNotNullParameter(r5, "model");
        Intrinsics.checkNotNullParameter(r6, "liveReplayId");
        Intrinsics.checkNotNullParameter(r7, "ecomLiveParams");
        LinkedHashMap r12 = new LinkedHashMap();
        if (r8 == null) goto L5;
        r12.putAll(r8);
    L5:
        a(r12, "EVENT_ORIGIN_FEATURE", "TEMAI");
        String r1 = null;
        if (r8 == null) goto L8;
        String r2 = r8.get("enter_from_merge");
    L9:
        a(r12, "enter_from_merge", r2);
        if (r8 == null) goto L12;
        String r3 = r8.get("enter_method");
    L13:
        a(r12, "enter_method", r3);
        if (r8 == null) goto L16;
        String r13 = r8.get("action_type");
    L17:
        a(r12, "action_type", r13);
        a(r12, "anchor_id", r4.c());
        a(r12, "room_id", r4.roomId());
        ECUIPromotion r14 = r5.j;
        if (r14 == null) goto L20;
        String r15 = r14.getProductId();
    L21:
        a(r12, "product_id", r15);
        a(r12, "episode_id", r6);
        ECUIPromotion r16 = r5.j;
        if (r16 == null) goto L24;
        Integer r17 = Integer.valueOf(r16.getIronIndex());
    L25:
        a(r12, "list_num", r17);
        a(r12, "is_from_explain", Integer.valueOf(r5.b ? 1 : 0));
        a(r12, "replay_page_name", r9);
        if (a.b(r9) == false) goto L35;
        ECUIPromotion r18 = r5.j;
        if (r18 == null) goto L30;
        String r19 = r18.getPromotionId();
    L31:
        a(r12, "promotion_id", r19);
        ExplainPlaybackVideoInfo r20 = r5.d;
        if (r20 == null) goto L34;
        r1 = r20.getFragmentId();
    L34:
        a(r12, "fragment_id", r1);
        goto L35
    L30:
        r19 = null;
    L35:
        f("livesdk_ec_live_replay_small_card_click", r12, r10, r11);
        return;
    L24:
        r17 = null;
        goto L25
    L20:
        r15 = null;
        goto L21
    L16:
        r13 = null;
        goto L17
    L12:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    }

    public final void d(final ml.b r14, final ni2.a r15, final String r16, JSONObject r17, final Map<String, String> r18, final String r19, final String r20, final String r21) {
        Intrinsics.checkNotNullParameter(r14, "roomInfo");
        Intrinsics.checkNotNullParameter(r15, "model");
        Intrinsics.checkNotNullParameter(r16, "liveReplayId");
        Intrinsics.checkNotNullParameter(r17, "ecomLiveParams");
        il.a r10 = this.b;
        ECUIPromotion r0 = r15.j;
        if (r0 == null) goto L5;
        String r1 = r0.getPromotionId();
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r10.c("livesdk_ec_live_replay_small_card_show", r1, new ECLiveReplayEventUtils$sendECLiveReplaySmallCardShow$1(this, r18, r14, r15, r16, r19, r20, r21));
        return;
    L5:
        r1 = null;
        goto L6
    }
}
