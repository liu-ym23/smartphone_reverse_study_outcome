package com.bytedance.caijing.sdk.infra.base.event;

import com.bytedance.caijing.sdk.infra.base.api.plugin.event.ICJReporter;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0016J4\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/event/CJReporterServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/event/ICJReporter;", "()V", "reportBizEvent", "", "eventName", "", "evtParams", "", "", "occurrenceTime", "", "ignoreActionHash", "", "reportCJBizModuleStart", "bizModule", "eventParams", "", "reportMonitorEvent", "cj-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJReporterServiceImpl implements ICJReporter {
    public CJReporterServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.event.ICJReporter
    public void reportCJBizModuleStart(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "bizModule");
        CJReporter r102 = CJReporter.f202294a;
        Set<String> r103 = CJContext.f202254w;
        if (r101 != null) goto L5;
        r101 = new LinkedHashMap();
    L5:
        r102.j(r100, CJContext.c.a(r100, "", "", r101));
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.event.ICJReporter
    public void reportBizEvent(String r110, Map<String, ? extends Object> r111, long r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "evtParams");
        CJReporter r100 = CJReporter.f202294a;
        Set<String> r101 = CJContext.f202254w;
        CJReporter.g(CJContext.c.a("ICJReporter", "", "", new LinkedHashMap()), r110, r111, null, r112, r113);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.event.ICJReporter
    public void reportMonitorEvent(String r110, Map<String, ? extends Object> r111, long r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "evtParams");
        CJReporter r100 = CJReporter.f202294a;
        Set<String> r101 = CJContext.f202254w;
        CJReporter.n(CJContext.c.a("ICJReporter", "", "", new LinkedHashMap()), r110, r111, null, r112, r113);
    }
}
