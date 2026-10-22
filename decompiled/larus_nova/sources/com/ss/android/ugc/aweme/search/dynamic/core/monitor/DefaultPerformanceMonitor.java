package com.ss.android.ugc.aweme.search.dynamic.core.monitor;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.dynamic.core.DynamicCardContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/monitor/DefaultPerformanceMonitor;", "Lcom/ss/android/ugc/aweme/search/dynamic/core/monitor/IPerformanceMonitor;", "Lcom/ss/android/ugc/aweme/search/dynamic/core/DynamicCardContext;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/ss/android/ugc/aweme/search/dynamic/core/DynamicCardContext;", "getContext", "()Lcom/ss/android/ugc/aweme/search/dynamic/core/DynamicCardContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public class DefaultPerformanceMonitor implements IPerformanceMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DynamicCardContext f452718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f452719b;

    public final DefaultPerformanceMonitorAbility a() {
        return (DefaultPerformanceMonitorAbility) this.f452719b.getValue();
    }

    public final DynamicCardContext getContext() {
        return this.f452718a;
    }

    public DefaultPerformanceMonitor(DynamicCardContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f452718a = r100;
        this.f452719b = LazyKt.lazy(new DefaultPerformanceMonitor$monitorAbility$2(this));
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.monitor.IPerformanceMonitor
    public final void j(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        DefaultPerformanceMonitorAbility r102 = a();
        if (r102 == null) goto L6;
        r102.j(r100, r101);
        return;
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.core.monitor.IPerformanceMonitor
    public final void k(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "abilityName");
        DefaultPerformanceMonitorAbility r102 = a();
        if (r102 == null) goto L6;
        r102.k(r100, r101);
        return;
    }
}
