package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x implements Runnable {
    public final /* synthetic */ PromotionListEventActionImplV2 a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public x(PromotionListEventActionImplV2 r1, com.bytedance.android.ec.common.api.jump.model.g r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        PromotionListEventActionImplV2 r0 = this.a;
        com.bytedance.android.ec.common.api.jump.model.g r1 = this.b;
        String r2 = this.c;
        String r3 = this.d;
        r0.getClass();
        ql.a r5 = r1.a;
        if (r5.canShowAddCart() == false) goto L30;
        com.bytedance.android.ec.common.api.jump.model.f r6 = r1.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        sg2.v r7 = new sg2.v("livesdk_click_sub_to_cart", r1);
        r7.c("click_area", "live_list_card");
        com.bytedance.android.ec.model.response.v r4 = r5.getStepperInfo();
        if (r4 == null) goto L8;
        int r8 = r4.b();
    L9:
        r7.a("cart_num", r8);
        r7.c("cart_track", new JSONObject(r5.getTrackExtra()).optString("cart_track"));     // Catch: Exception -> L12
    L14:
        r7.c("ecom_pitaya_json_str", com.bytedance.android.livesdk.livecommerce.event.r.a(r5));
        r7.c("btm_id", r3);
        if (r6 == null) goto L25;
        String r9 = r6.b;
        if (r9 == null) goto L25;
        Map r10 = EcomBcmTracker.f(PageFinder.via(r9), r7.g());
        if (r10 == null) goto L25;
        LinkedHashMap r11 = new LinkedHashMap(MapsKt.mapCapacity(r10.size()));
        Iterator r12 = r10.entrySet().iterator();
    L22:
        if (r12.hasNext() == false) goto L24;
        Map.Entry r13 = (Map.Entry) r12.next();
        r11.put(r13.getKey(), String.valueOf(r13.getValue()));
        goto L22
    L24:
        r7.d(r11);
    L25:
        PromotionListEventActionImplKt.a(r7, r0.a, r2);
        return;
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L14
    L8:
        r8 = 0;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
