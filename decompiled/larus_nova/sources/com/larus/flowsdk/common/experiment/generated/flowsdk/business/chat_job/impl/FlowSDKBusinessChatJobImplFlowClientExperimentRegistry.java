package com.larus.flowsdk.common.experiment.generated.flowsdk.business.chat_job.impl;

import com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry;
import com.xiaomi.mipush.sdk.MiPushClient;
import ga9.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"Lcom/larus/flowsdk/common/experiment/generated/flowsdk/business/chat_job/impl/FlowSDKBusinessChatJobImplFlowClientExperimentRegistry;", "Lcom/larus/flowsdk/common/experiment/IFlowClientExperimentRegistry;", "<init>", "()V", MiPushClient.COMMAND_REGISTER, "", "registerAll", "registerProperty0", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowSDKBusinessChatJobImplFlowClientExperimentRegistry implements IFlowClientExperimentRegistry {
    public FlowSDKBusinessChatJobImplFlowClientExperimentRegistry() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void priority() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void register() {
        a.l("enable_lark_event", "zhangkun.locas", "0", false);
    }
}
