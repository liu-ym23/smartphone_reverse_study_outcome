package com.bytedance.android.shopping.sku.common.monitor.chain;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.monitor.listener.e;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.repo.a;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ph3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataOpenSkuChain {
    public static void a() {
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataOpenSkuChain", SkuYataOpenSkuChain$destroy$1.INSTANCE);
        Set r1 = ECProcessMonitor.a;
        ECProcessMonitor.p().j.invoke();
    }

    public static void b() {
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataOpenSkuChain", SkuYataOpenSkuChain$onSkuPageStart$1.INSTANCE);
        Set r1 = ECProcessMonitor.a;
        ECProcessMonitor.p().k();
    }

    public SkuYataOpenSkuChain(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "baseParams");
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataOpenSkuChain", AnonymousClass1.INSTANCE);
        Set r1 = ECProcessMonitor.a;
        ActionRateListener.c(ECProcessMonitor.p(), r5, null, true, 2);
    }

    public final void c(b r4, a r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Lazy r7 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataOpenSkuChain", SkuYataOpenSkuChain$onSkuRequestEnd$1.INSTANCE);
        Set r8 = ECProcessMonitor.a;
        e r9 = ECProcessMonitor.p();
        JSONObject r0 = new JSONObject();
        if (r5 == null) goto L5;
        String r1 = f.b(r5);
    L6:
        r0.put("log_id", r1);
        Unit r2 = Unit.INSTANCE;
        r9.a(r0);
        if (r6 != null) goto L13;
        if (r5 == null) goto L13;
        if (f.d(r5) != true) goto L13;
        r9.g();
        return;
    L13:
        if (r5 == null) goto L19;
        Integer r3 = r5.a();
        if (r3 == null) goto L17;
        int r10 = r3.intValue();
    L18:
        r9.j(Integer.valueOf(r10), r5.b());
        goto L19
    L17:
        r10 = -1;
    L19:
        if (r6 == null) goto L23;
        r9.j(-1, r6.getMessage());
        return;
    L23:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
