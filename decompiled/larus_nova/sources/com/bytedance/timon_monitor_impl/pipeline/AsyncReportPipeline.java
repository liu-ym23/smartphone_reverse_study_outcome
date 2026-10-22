package com.bytedance.timon_monitor_impl.pipeline;

import com.bytedance.timonbase.pipeline.TimonPipeline;

/* JADX INFO: loaded from: classes3.dex */
public final class AsyncReportPipeline extends TimonPipeline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AsyncReportPipeline f270755a = null;

    static {
        f270755a = new AsyncReportPipeline();
    }

    public AsyncReportPipeline() {
        super("AsyncReportPipeline");
    }

    @Override // com.bytedance.timonbase.pipeline.TimonPipeline, com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(final dh7.c r100) {
        com.bytedance.helios.common.utils.d.f().post(new AnonymousClass1(r100));
        return true;
    }

    @Override // com.bytedance.timonbase.pipeline.TimonPipeline, com.bytedance.timon.pipeline.TimonSystem
    public final boolean preInvoke(final dh7.c r100) {
        com.bytedance.helios.common.utils.d.f().post(new RunnableC106601(r100));
        return true;
    }
}
