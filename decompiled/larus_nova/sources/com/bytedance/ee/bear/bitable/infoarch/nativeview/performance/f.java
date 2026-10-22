package com.bytedance.ee.bear.bitable.infoarch.nativeview.performance;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.plugin.BitableReportPlugin;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.l;
import com.bytedance.ee.bear.bitable.statistic.m;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements BitableReportPlugin.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f213683a;

    @Override // com.bytedance.ee.bear.bitable.plugin.BitableReportPlugin.c
    public final void a(DocumentPluginHost r100) {
    }

    @Override // com.bytedance.ee.bear.bitable.plugin.BitableReportPlugin.c
    public final void b(DocumentPluginHost r100) {
    }

    public f() {
        this.f213683a = org.koin.java.a.d(m.class);
    }

    @Override // com.bytedance.ee.bear.bitable.plugin.BitableReportPlugin.c
    public final void c(BitableReportPlugin.ReportModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        JSONObject r101 = r100.getExtra();
        if (r101 == null) goto L8;
        String r102 = r101.getString("traceId");
        if (r102 == null) goto L9;
        m r103 = (m) this.f213683a.getValue();
        BitableStatisticEventModel$NormalPointModel.a r104 = BitableStatisticEventModel$NormalPointModel.Companion;
        String r105 = r100.getEvent();
        long r106 = r100.getTime();
        HashMap r107 = new HashMap();
        r104.getClass();
        BitableStatisticEventModel$NormalPointModel r108 = BitableStatisticEventModel$NormalPointModel.a.b(r105, r106, true, r107);
        r108.addExtras(r101);
        Unit r109 = Unit.INSTANCE;
        r103.addNormalPoint(r102, r108);
        l.a((m) this.f213683a.getValue(), r102);
        return;
    L9:
        return;
    }
}
