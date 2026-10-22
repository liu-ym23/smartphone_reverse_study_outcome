package com.bytedance.ee.bear.bitable.statistic.business.openfile.sharerecord;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.plugin.BitableReportPlugin;
import com.bytedance.ee.bear.bitable.statistic.j;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tu4.e;
import tu4.f;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements f {
    public b() {
    }

    @Override // tu4.f
    public final j a() {
        return new a();
    }

    @Override // tu4.f
    public final void b(e r100, BitableReportPlugin.ReportModel r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (Intrinsics.areEqual(r101.getEvent(), "BITABLE_SDK_CURRENT_LOAD_COST") == false) goto L14;
        JSONObject r102 = r101.getExtra();
        if (r102 == null) goto L7;
        Object r103 = r102.remove("SDK_COST");
    L9:
        if ((r103 instanceof JSONObject) == false) goto L15;
        String r104 = r100.e();
        if (r104 == null) goto L16;
        tu4.b.m(r104, r101.getTime(), (Map) r103);
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r103 = null;
        goto L9
    }
}
