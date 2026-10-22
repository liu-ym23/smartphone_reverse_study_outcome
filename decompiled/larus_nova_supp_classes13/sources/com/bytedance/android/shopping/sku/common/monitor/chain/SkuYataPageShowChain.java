package com.bytedance.android.shopping.sku.common.monitor.chain;

import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.repo.a;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pi.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataPageShowChain {
    public int a;
    public final JSONObject b;

    public final void a() {
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataPageShowChain", SkuYataPageShowChain$onSkuPageStart$1.INSTANCE);
        int r1 = ECSdk.a;
        b r2 = (b) ECSdk.a(b.class);
        if (r2 == null) goto L6;
        r2.monitorEvent("ec_perf_page_start_sku_panel", this.b, null, null);
        return;
    }

    public SkuYataPageShowChain(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "baseParams");
        this.b = r2;
    }

    public final void b(ph3.b r4, a r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Lazy r7 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataPageShowChain", SkuYataPageShowChain$onSkuRequestEnd$1.INSTANCE);
        int r8 = this.a + 1;
        this.a = r8;
        if (r8 <= 1) goto L6;
        return;
    L6:
        if (r6 != null) goto L13;
        if (r5 == null) goto L13;
        if (f.d(r5) != true) goto L13;
        int r9 = ECSdk.a;
        b r10 = (b) ECSdk.a(b.class);
        if (r10 == null) goto L17;
        JSONObject r11 = x0.a(this.b);
        r11.put("status", "0");
        Unit r12 = Unit.INSTANCE;
        r10.monitorEvent("ec_perf_page_show_sku_panel", r11, null, null);
        return;
    L17:
        return;
    L13:
        int r13 = ECSdk.a;
        b r14 = (b) ECSdk.a(b.class);
        if (r14 == null) goto L19;
        JSONObject r15 = x0.a(this.b);
        r15.put("status", "1");
        Unit r16 = Unit.INSTANCE;
        r14.monitorEvent("ec_perf_page_show_sku_panel", r15, null, null);
        return;
    }
}
