package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionSuccess;
import com.bytedance.android.livesdk.livecommerce.room.controller.w;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;
import sg2.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(Context r9, ECV2AuctionSuccess r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        Map<String, String> r0 = new c().c.a;
        JSONObject r1 = new JSONObject();
        int r2 = m0.a;     // Catch: Exception -> L7
        JSONObject r3 = tv5.a.a(m0.a.a, r10);     // Catch: Exception -> L7
    L9:
        r1.put("result", r3);
        JSONObject r4 = new JSONObject();
        r4.put("product_id", String.valueOf(r10.productId));
        Unit r5 = Unit.INSTANCE;
        r1.put("order_log_data", r4);
        JSONObject r6 = new JSONObject();
        HashMap r7 = (HashMap) r0;
        Iterator r8 = r7.entrySet().iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        Map.Entry r11 = (Map.Entry) r8.next();
        r6.put((String) r11.getKey(), r11.getValue());
        goto L11
    L13:
        int r12 = w.h;
        r6.put("ecom_scene_id", w.a.b());
        Unit r13 = Unit.INSTANCE;
        r1.put("order_entrance_info", r6);
        JSONObject r14 = new JSONObject();
        Iterator r15 = r7.entrySet().iterator();
    L15:
        if (r15.hasNext() == false) goto L17;
        Map.Entry r16 = (Map.Entry) r15.next();
        r14.put((String) r16.getKey(), r16.getValue());
        goto L15
    L17:
        r14.put("product_id", String.valueOf(r10.productId));
        r14.put("screen_type", l0.m(null, null));
        int r17 = t.a;
        Uri.Builder r18 = UriProtector.parse(EComABUtils.getLynxUrlConfig().a()).buildUpon();
        JSONObject r19 = new JSONObject();
        r19.put("ecom_live_lynx_log_data", r14);
        r19.put("ecom_live_lynx_data", r1);
        Unit r20 = Unit.INSTANCE;
        r18.appendQueryParameter("mega_object", r19.toString());
        ECLiveHybridUtil.k(r9, r18.toString(), false, false, false, null, 252);
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r3 = new JSONObject();
        goto L9
    }
}
