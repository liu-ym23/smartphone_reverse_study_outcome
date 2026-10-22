package com.larus.abtest.test;

import com.bytedance.dataplatform.o;
import com.larus.abtest.api.IGlobalExposureStarter;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import ij4.b;
import kotlin.Metadata;
import l38.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/larus/abtest/test/GlobalExposureTest;", "Lcom/larus/abtest/api/IGlobalExposureStarter;", "<init>", "()V", "TAG", "", "triggerExperimentExposureOnAppLaunch", "", "testABTestExperimentFetch", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlobalExposureTest implements IGlobalExposureStarter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f286088a;

    @Override // com.larus.abtest.api.IGlobalExposureStarter
    public final void a() {
        if (AppHost.f326268a.isOversea() == false) goto L5;
        a r100 = (a) o.d("abtest_local_experiment_oversea", a.class, new a(false, 0, null, 31), false, true, new ij4.a("com.larus.abtest.test.AbSdkTestLocalExperimentOversea", new String[]{"abtest_local_experiment", "abtest_local_experiment_oversea"}, new b[]{new b("75210808", new a(false, 1, "vid1", 24)), new b("75210809", new a(true, 2, "vid2", 24))}));
        FLogger.f375446a.i(this.f286088a, "testABTestExperimentFetch Oversea, Local: " + r100);
        return;
    L5:
        a r101 = (a) o.d("abtest_local_experiment", a.class, new a(false, 0, null, 31), false, true, new ij4.a("com.larus.abtest.test.AbSdkTestLocalExperiment", new String[]{"abtest_local_experiment", "abtest_local_experiment_oversea"}, new b[]{new b("15245585", new a(false, 1, "vid1", 24)), new b("15245586", new a(true, 2, "vid2", 24))}));
        FLogger.f375446a.i(this.f286088a, "testABTestExperimentFetch Non-Oversea, Local: " + r101);
    }

    public GlobalExposureTest() {
        this.f286088a = "AbTestGlobalExposure";
    }
}
