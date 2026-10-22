package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ ql.a f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;

    public l(boolean r1, com.bytedance.android.ec.common.api.jump.model.g r2, String r3, int r4, int r5, ql.a r6, String r7, String r8, String r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public final void a() {
        if (this.a == false) goto L5;
        String r1 = "livesdk_edit_add_cart_product_num_success";
    L6:
        sg2.v r2 = new sg2.v(r1, this.b);
        r2.c(LocationMonitorConst.TYPE, this.c);
        r2.a("cart_num", this.d);
        r2.a("status_code", this.e);
        r2.c("cart_track", new JSONObject(this.f.getTrackExtra()).optString("cart_track"));     // Catch: Exception -> L9
    L11:
        int r0 = com.bytedance.android.livesdk.livecommerce.event.r.a;
        r2.c("ecom_pitaya_json_str", com.bytedance.android.livesdk.livecommerce.event.r.a(this.f));
        r2.c("btm_id", this.g);
        String r3 = this.h;
        if (r3 == null) goto L20;
        Map r4 = EcomBcmTracker.f(PageFinder.via(r3), r2.g());
        if (r4 == null) goto L20;
        LinkedHashMap r5 = new LinkedHashMap(MapsKt.mapCapacity(r4.size()));
        Iterator r6 = r4.entrySet().iterator();
    L17:
        if (r6.hasNext() == false) goto L19;
        Map.Entry r7 = (Map.Entry) r6.next();
        r5.put(r7.getKey(), String.valueOf(r7.getValue()));
        goto L17
    L19:
        r2.d(r5);
    L20:
        r2.i(this.i);
        return;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L11
    L5:
        r1 = "livesdk_edit_add_cart_product_num_fail";
        goto L6
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
