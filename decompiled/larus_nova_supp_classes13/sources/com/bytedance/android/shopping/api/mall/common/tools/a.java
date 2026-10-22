package com.bytedance.android.shopping.api.mall.common.tools;

import com.bytedance.android.ec.hybrid.data.gecko.HybridForestLoader;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.api.mall.IECNativeHomeService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;

    public a(String r1, String r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        IECNativeHomeService r0 = (IECNativeHomeService) ServiceManager.get().getService(IECNativeHomeService.class);
        if (r0 != null) goto L5;
    L7:
        Long r1 = null;
    L8:
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("schema", this.a);
        String r3 = this.b;
        Object r4 = "";
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r2.put("btmToken", r3);
        Object r5 = this.c.get("scene");
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r2.put("scene", r5);
        Object r6 = this.c.get("btm");
        if (r6 == null) goto L18;
        r4 = r6;
    L18:
        r2.put("btm_str", r4);
        Object r7 = this.c.get("auto_half_page");
        if (r7 != null) goto L21;
        r7 = Boolean.FALSE;
    L21:
        r2.put("auto_half_page", r7);
        if (r1 == null) goto L24;
        long r8 = r1.longValue();
    L25:
        r2.put("gecko_version", Long.valueOf(r8));
        IHybridHostService r9 = com.bytedance.android.ec.hybrid.a.h();
        if (r9 == null) goto L31;
        yj.k r10 = r9.getIHybridHostEventService();
        if (r10 == null) goto L32;
        r10.logV3("mall_open_schema_token_report", com.bytedance.android.ec.hybrid.list.util.k.b(r2));
        return;
    L32:
        return;
    L31:
        return;
    L24:
        r8 = -1;
        goto L25
    L5:
        if (r0.b() == null) goto L7;
        Map r11 = HybridForestLoader.a;
        r1 = HybridForestLoader.b(NativeMallGeckoHelper.b());
        goto L8
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
