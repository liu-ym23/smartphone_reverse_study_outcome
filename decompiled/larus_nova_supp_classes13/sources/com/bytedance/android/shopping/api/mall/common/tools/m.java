package com.bytedance.android.shopping.api.mall.common.tools;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.apm.ApmAgent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements Runnable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ Integer b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;

    public m(JSONObject r1, Integer r2, boolean r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        l r0 = l.a;
        JSONObject r1 = this.a;
        r0.getClass();
        l.c(r1);
        l.d(this.a);
        Integer r2 = this.b;
        if (r2 != null) goto L5;
    L7:
        IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
        if (r3 == null) goto L13;
        yj.g r4 = r3.getHostAB();
        if (r4 == null) goto L13;
        r4.l();
    L13:
        if (this.c == false) goto L25;
        Object r5 = this.a.opt("type");
        if (Intrinsics.areEqual(r5, "PERFORMANCE_LOG") == false) goto L22;
        if (this.d == false) goto L19;
        String r6 = "ec_perf_duration_mall_homepage";
    L20:
        AppLogNewUtils.onEventV3(r6, this.a);
        return;
    L19:
        r6 = "ec_perf_duration_mall_gul";
        goto L20
    L22:
        if (Intrinsics.areEqual(r5, "LOADMORE_PERFORMANCE_LOG") == false) goto L27;
        AppLogNewUtils.onEventV3("ec_perf_duration_mall_feed_loadmore", this.a);
        return;
    L27:
        return;
    L25:
        return;
    L5:
        if (r2.intValue() != 1) goto L7;
        ApmAgent.monitorEvent("ies_ecommerce_client_custom_log", this.a, null, null);
        goto L7
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
