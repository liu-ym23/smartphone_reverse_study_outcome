package com.bytedance.timon_monitor_impl.basicpipline;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/timon_monitor_impl/basicpipline/ApiBasicModePipeline;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TimonBasicPipelineActionInvoker$basicPipeline$2 extends Lambda implements Function0<ApiBasicModePipeline> {
    public static final TimonBasicPipelineActionInvoker$basicPipeline$2 INSTANCE = null;

    static {
        INSTANCE = new TimonBasicPipelineActionInvoker$basicPipeline$2();
    }

    public TimonBasicPipelineActionInvoker$basicPipeline$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ApiBasicModePipeline invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ApiBasicModePipeline invoke() {
        return ApiBasicModePipeline.INSTANCE;
    }
}
