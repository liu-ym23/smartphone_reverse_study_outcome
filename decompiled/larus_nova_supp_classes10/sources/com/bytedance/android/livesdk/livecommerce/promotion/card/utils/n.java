package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements Runnable {
    public final /* synthetic */ PromotionListEventActionImpl a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public n(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        PromotionListEventActionImpl r0 = this.a;
        com.bytedance.android.ec.common.api.jump.model.g r1 = this.b;
        String r2 = this.c;
        String r3 = this.d;
        r0.getClass();
        ECUIPromotion r5 = r1.a;
        if (r5 == null) goto L30;
        ECUIPromotion r6 = r5;
        if (r6.canShowAddCart() == false) goto L34;
        com.bytedance.android.ec.common.api.jump.model.f r7 = r1.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        sg2.v r8 = new sg2.v("livesdk_click_sub_to_cart", r1);
        r8.c("click_area", "live_list_card");
        com.bytedance.android.ec.model.response.v r4 = r6.stepperInfo;
        if (r4 == null) goto L10;
        int r9 = r4.b();
    L11:
        r8.a("cart_num", r9);
        r8.c("cart_track", new JSONObject(r6.getTrackExtra()).optString("cart_track"));     // Catch: Exception -> L14
    L16:
        r8.c("ecom_pitaya_json_str", com.bytedance.android.livesdk.livecommerce.event.r.a(r6));
        r8.c("btm_id", r3);
        if (r7 == null) goto L27;
        String r10 = r7.b;
        if (r10 == null) goto L27;
        Map r11 = EcomBcmTracker.f(PageFinder.via(r10), r8.g());
        if (r11 == null) goto L27;
        LinkedHashMap r12 = new LinkedHashMap(MapsKt.mapCapacity(r11.size()));
        Iterator r13 = r11.entrySet().iterator();
    L24:
        if (r13.hasNext() == false) goto L26;
        Map.Entry r14 = (Map.Entry) r13.next();
        r12.put(r14.getKey(), String.valueOf(r14.getValue()));
        goto L24
    L26:
        r8.d(r12);
    L27:
        PromotionListEventActionImplKt.a(r8, r0.a, r2);
        return;
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L16
    L10:
        r9 = 0;
        goto L11
    L34:
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
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
