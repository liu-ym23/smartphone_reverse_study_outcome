package com.obric.assistant.performance;

import com.obric.assistant.spi.performance.IObricMemoryReportSPIService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/performance/ObricMemoryReportSPIServiceImpl;", "Lcom/obric/assistant/spi/performance/IObricMemoryReportSPIService;", "<init>", "()V", "changeScene", "", "scene", "", "onStateChange", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMemoryReportSPIServiceImpl implements IObricMemoryReportSPIService {
    public ObricMemoryReportSPIServiceImpl() {
    }

    @Override // com.obric.assistant.spi.performance.IObricMemoryReportSPIService
    public final void a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        IObricMemoryReportService.f390977a.getClass();
        IObricMemoryReportService r102 = IObricMemoryReportService.a.a();
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
