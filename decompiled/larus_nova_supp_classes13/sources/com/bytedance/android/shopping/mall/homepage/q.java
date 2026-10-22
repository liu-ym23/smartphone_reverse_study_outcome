package com.bytedance.android.shopping.mall.homepage;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.api.mall.IECNativeHomeArgument;
import com.bytedance.android.shopping.api.mall.common.tools.v;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q implements Runnable {
    public final /* synthetic */ ECMallFragment a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ Uri c;

    public q(ECMallFragment r1, Map r2, Uri r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        JSONObject r0 = new JSONObject();
        Object r1 = this.b.get("schema");
        if (r1 == null) goto L5;
        r0.putOpt("schema", r1);
    L5:
        Object r2 = this.b.get("gd_label");
        if (r2 == null) goto L8;
        r0.putOpt("gd_label", r2);
    L8:
        IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
        if (r3 == null) goto L13;
        yj.k r4 = r3.getIHybridHostEventService();
        if (r4 == null) goto L13;
        r4.logV3("mall_page_card_enter_by_schema", r0);
    L13:
        JSONObject r5 = com.bytedance.android.ec.hybrid.list.util.k.b(v.f(this.c));
        String r6 = r5.optString("traffic_from");
        if (com.bytedance.forest.utils.h.a(r6) == true) goto L17;
        r6 = null;
    L17:
        if (r6 == null) goto L19;
        String r7 = "enter_".concat(r6);
    L20:
        this.a.getClass();
        Object r8 = MapsKt.emptyMap().get(SimilarProductParam.ENTER_FROM);
        if (r8 == null) goto L23;
        r5.putOpt(SimilarProductParam.ENTER_FROM, r8);
    L23:
        JSONObject r9 = new JSONObject();
        r9.put("business", "mall");
        r9.put("location", r7);
        r9.put("in_schema", r5);
        IECNativeHomeArgument r10 = this.a.ma0();
        if (r10 == null) goto L28;
        Long r11 = r10.getNaOfflineVersion();
        if (r11 == null) goto L28;
        long r12 = r11.longValue();
    L29:
        r9.put("gecko_id", r12);
        IHybridHostService r13 = com.bytedance.android.ec.hybrid.a.h();
        if (r13 == null) goto L35;
        yj.k r14 = r13.getIHybridHostEventService();
        if (r14 == null) goto L36;
        r14.logV3("schema_report", r9);
        return;
    L36:
        return;
    L35:
        return;
    L28:
        r12 = -1;
        goto L29
    L19:
        r7 = "enter";
        goto L20
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
