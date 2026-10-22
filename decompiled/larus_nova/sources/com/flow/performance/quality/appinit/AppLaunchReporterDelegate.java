package com.flow.performance.quality.appinit;

import com.larus.platform.api.IAppLaunchReporter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010\n\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J.\u0010\u000b\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J&\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J6\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J&\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\b2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¨\u0006\u0015"}, d2 = {"Lcom/flow/performance/quality/appinit/AppLaunchReporterDelegate;", "Lcom/larus/platform/api/IAppLaunchReporter;", "<init>", "()V", "reportSenseStart", "", "extraMap", "", "", "", "reportSenseSuccess", "reportSenseFail", "errCode", "", "errMsg", "reportStepStart", "step", "reportStepSuccess", "reportStepFail", "reportEvent", "event", "performance_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLaunchReporterDelegate implements IAppLaunchReporter {
    public AppLaunchReporterDelegate() {
    }

    @Override // com.larus.platform.api.IAppLaunchReporter
    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        AppLaunchTracer.f274169a.b(r100, r101);
    }

    @Override // com.larus.platform.api.IAppLaunchReporter
    public final void c(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        AppLaunchTracer.f274169a.c(r100, r101);
    }

    @Override // com.larus.platform.api.IAppLaunchReporter
    public final void a(String r100, Map<String, ? extends Object> r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "step");
        Intrinsics.checkNotNullParameter(r103, "errMsg");
        AppLaunchTracer.f274169a.a(r100, r101, r102, r103);
    }
}
