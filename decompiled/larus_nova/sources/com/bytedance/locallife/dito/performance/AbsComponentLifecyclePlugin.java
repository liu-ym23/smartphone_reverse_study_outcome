package com.bytedance.locallife.dito.performance;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/dito/performance/AbsComponentLifecyclePlugin;", "Lcom/bytedance/locallife/dito/performance/AbsPerformancePlugin;", "<init>", "()V", "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbsComponentLifecyclePlugin extends AbsPerformancePlugin {
    @Override // com.bytedance.locallife.dito.performance.AbsPerformancePlugin, com.bytedance.locallife.dito.core.d0
    public final String getName() {
        return getClass().getName();
    }

    public AbsComponentLifecyclePlugin() {
    }
}
