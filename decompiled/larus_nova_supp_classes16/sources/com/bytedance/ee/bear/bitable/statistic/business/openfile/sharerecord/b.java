package com.bytedance.ee.bear.bitable.statistic.business.openfile.sharerecord;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.plugin.BitableReportPlugin;
import com.bytedance.ee.bear.bitable.statistic.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tu4.e;
import tu4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements f {
    public b() {
    }

    @Override // tu4.f
    public final j a() {
        return new a();
    }

    @Override // tu4.f
    public final void b(e r4, BitableReportPlugin.ReportModel r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "model");
        if (Intrinsics.areEqual(r5.getEvent(), "BITABLE_SDK_CURRENT_LOAD_COST") == false) goto L14;
        JSONObject r0 = r5.getExtra();
        if (r0 == null) goto L7;
        Object r1 = r0.remove("SDK_COST");
    L9:
        if ((r1 instanceof JSONObject) == false) goto L15;
        String r6 = r4.e();
        if (r6 == null) goto L16;
        tu4.b.m(r6, r5.getTime(), (Map) r1);
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r1 = null;
        goto L9
    }
}
