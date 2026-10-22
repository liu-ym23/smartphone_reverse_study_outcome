package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public static void a(Context r11, String r12, com.bytedance.android.ec.common.api.jump.model.g r13, com.bytedance.android.btm.api.model.d r14, il2.a r15) {
        Intrinsics.checkNotNullParameter(r13, "promotionParams");
        if (r15 == null) goto L6;
        il2.a.C0145a.a(r15, "open_new_bid", null, false, null, null, null, 62);
    L6:
        if (r11 != null) goto L12;
        if (r15 == null) goto L67;
        il2.a r16 = il2.a.C0145a.a(r15, "open_new_bid", null, false, "context_is_null", null, null, 48);
        if (r16 == null) goto L68;
        ((LiveActionTracker) r16).e(false);
        return;
    L68:
        return;
    L67:
        return;
    L12:
        LiveRoomParams r1 = r13.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.f r2 = r13.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        String r3 = null;
        if (r2 == null) goto L15;
        jf.b r4 = r2.c;
    L16:
        String r5 = "";
        if (r1 == null) goto L19;
        Map<String, String> r6 = new sg2.v("", r1).g();
    L20:
        UrlBuilderV2 r7 = new UrlBuilderV2(r12);
        JSONObject r17 = new JSONObject();
        JSONObject r8 = new JSONObject();
        if (r6 == null) goto L26;
        Iterator<Map.Entry<String, String>> r9 = r6.entrySet().iterator();
    L24:
        if (r9.hasNext() == false) goto L26;
        Map.Entry<String, String> r10 = r9.next();
        r8.put(r10.getKey(), r10.getValue());
    L26:
        if (r4 == null) goto L28;
        String r18 = r4.a;
    L29:
        r8.put("ecom_entrance_form", r18);
        r8.put("product_id", r13.a.getProductId());
        if (r1 == null) goto L34;
        Function0 r19 = r1.getScreenType();
        if (r19 == null) goto L34;
        String r20 = (String) r19.invoke();
    L35:
        if (r20 == null) goto L38;
        r5 = r20;
    L38:
        r8.put("screen_type", r5);
        Unit r21 = Unit.INSTANCE;
        r17.put("ecom_live_lynx_log_data", r8);
        JSONObject r22 = new JSONObject();
        JSONObject r23 = new JSONObject();
        r23.put("product_id", r13.a.getProductId());
        r22.put("order_log_data", r23);
        JSONObject r24 = new JSONObject();
        if (r6 == null) goto L44;
        Iterator<Map.Entry<String, String>> r25 = r6.entrySet().iterator();
    L42:
        if (r25.hasNext() == false) goto L44;
        Map.Entry<String, String> r26 = r25.next();
        r24.put(r26.getKey(), r26.getValue());
    L44:
        Unit r27 = Unit.INSTANCE;
        r22.put("order_entrance_info", Uri.encode(r24.toString()));
        r17.put("ecom_live_lynx_data", r22);
        r7.addOrReplaceParam("mega_object", r17.toString());
        int r110 = RoomContextController.h;
        if (r1 == null) goto L47;
        String r111 = r1.getRoomId();
    L48:
        if (r1 == null) goto L50;
        r3 = r1.getRoomUniqueKey();
    L50:
        ECContext r112 = RoomContextController.a.b(r111, r3).r();
        if (r112 == null) goto L59;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r113 = r112.getEcLivePerformanceMonitor();
        if (r113 == null) goto L59;
        ECLivePerformanceMonitor r114 = (ECLivePerformanceMonitor) r113.getValue();
        if (r114 == null) goto L59;
        Long r115 = r114.c;
        if (r115 == null) goto L59;
        r7.addOrReplaceParam("local_watch_duration", SystemClock.elapsedRealtime() - r115.longValue());
    L59:
        BtmUtilsKt.c(r7, BtmUtilsKt.a(r14, r13.getChainParams()));
        String r116 = r7.build();
        Handler r117 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.room.f.b(r11, r116);
        if (r15 == null) goto L69;
        il2.a r118 = il2.a.C0145a.a(r15, "open_new_bid", MapsKt.mapOf(TuplesKt.to("bid_schema", r116)), false, null, null, null, 60);
        if (r118 == null) goto L70;
        ((LiveActionTracker) r118).e(false);
        return;
    L70:
        return;
    L69:
        return;
    L47:
        r111 = null;
    L34:
        r20 = null;
        goto L35
    L28:
        r18 = null;
        goto L29
    L19:
        r6 = null;
        goto L20
    L15:
        r4 = null;
        goto L16
    }
}
