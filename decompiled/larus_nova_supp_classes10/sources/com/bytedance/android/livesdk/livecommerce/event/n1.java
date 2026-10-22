package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n1 extends u0 {
    @Override // com.bytedance.android.livesdk.livecommerce.event.ECEventV3
    public final ECEventV3 g(Map r1) {
        super.g(r1);
        return this;
    }

    public final void o(Map r3) {
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        if (r0.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L19;
        int r1 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;     // Catch: Exception -> L14
        String r4 = StringsKt.take(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a.toJson(r3), r0.getEC_LIVE_REPORT_PLATFORM_MAX_LENGTH().intValue());     // Catch: Exception -> L14
        if (r4.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L20;
        f("live_room_params", r4);     // Catch: Exception -> L14
        return;
    L20:
        return;
    L7:
        r2 = false;
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }

    public final void p(Map r1) {
        super.g(r1);
    }

    public final void r(boolean r2) {
        if (r2 == false) goto L4;
        String r3 = BDLocationException.ERROR_TIMEOUT;
    L5:
        f("screen_type", r3);
        return;
    L4:
        r3 = "1";
        goto L5
    }

    public /* synthetic */ n1(String r3, String r4) {
        this(r3, r4, "live_cart_tag", null);
    }

    public n1(String r2, String r3, String r4, RoomContextController r5) {
        super(r5, "livesdk_product_entrance_show");
        f("anchor_id", r2);
        f("room_id", r3);
        f("ecom_entrance_form", r4);
    }

    public final void q(String r1, String r2, String r3, Map r4, Map r5) {
        super.g(r4);
        super.g(r5);
        f("commodity_id", r1);
        f("commodity_type", r2);
        f("product_id", r3);
    }
}
