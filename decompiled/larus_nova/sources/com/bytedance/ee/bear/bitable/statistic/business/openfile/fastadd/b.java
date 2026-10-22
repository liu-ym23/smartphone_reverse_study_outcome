package com.bytedance.ee.bear.bitable.statistic.business.openfile.fastadd;

import com.bytedance.ee.bear.bitable.plugin.BitableReportPlugin;
import com.bytedance.ee.bear.bitable.statistic.j;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import tu4.e;
import tu4.f;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements f {
    public b() {
    }

    @Override // tu4.f
    public final void b(e r100, BitableReportPlugin.ReportModel r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    }

    @Override // tu4.f
    public final j a() {
        return new a();
    }
}
