package com.larus.flowsdk.common.experiment.generated.flowsdk.business.context_window.impl;

import com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry;
import com.xiaomi.mipush.sdk.MiPushClient;
import ga9.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002¨\u0006\n"}, d2 = {"Lcom/larus/flowsdk/common/experiment/generated/flowsdk/business/context_window/impl/FlowSDKBusinessContextWindowImplFlowClientExperimentRegistry;", "Lcom/larus/flowsdk/common/experiment/IFlowClientExperimentRegistry;", "<init>", "()V", MiPushClient.COMMAND_REGISTER, "", "registerAll", "registerProperty0", "registerProperty1", "registerProperty2", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowSDKBusinessContextWindowImplFlowClientExperimentRegistry implements IFlowClientExperimentRegistry {
    public FlowSDKBusinessContextWindowImplFlowClientExperimentRegistry() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void priority() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void register() {
        a.i("context_window_membership_quota_enable", "anson.wu@bytedance.com", true);
        a.i("context_window_usage_action_bar_enabled", "anson.wu@bytedance.com", true);
        a.i("context_window_usage_enabled", "anson.wu@bytedance.com", true);
    }
}
