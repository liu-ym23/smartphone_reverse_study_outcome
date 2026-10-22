package com.bytedance.android.shopping.sku.common.monitor.business;

import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuBusinessMonitor {
    public int a;
    public boolean b;
    public long c;
    public final JSONObject d;

    public static final class a {
    }

    static {
    }

    public SkuBusinessMonitor(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "baseParams");
        this.d = r3;
        this.c = System.currentTimeMillis();
    }

    public final void a(boolean r3, com.bytedance.kmp.ec.yata.common.biz.callback.a r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        this.a = 0;
        this.b = r3;
        this.c = System.currentTimeMillis();
        JSONObject r0 = new JSONObject();
        r0.put("show_loading", r3 ? 1 : 0);
        r0.put("trigger", r4.b);
        r0.put("operator_type", r4.c);
        Unit r5 = Unit.INSTANCE;
        b("loading_start", r0);
    }

    public final void b(String r3, JSONObject r4) {
        final JSONObject r0 = x0.a(this.d);
        r0.put("type", r3);
        r0.put("extra", r4);
        g.a.logV3("sku_business_monitor", r0);
        Lazy r5 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataBusiness", new SkuBusinessMonitor$reportBusiness$1(r0));
    }
}
