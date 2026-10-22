package com.larus.flowsdk.common.experiment.generated.business.e_commerce.impl;

import com.bytedance.android.ec.host.impl.c0;
import com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry;
import com.xiaomi.mipush.sdk.MiPushClient;
import ga9.a;
import ga9.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002¨\u0006\t"}, d2 = {"Lcom/larus/flowsdk/common/experiment/generated/business/e_commerce/impl/BusinessECommerceImplFlowClientExperimentRegistry;", "Lcom/larus/flowsdk/common/experiment/IFlowClientExperimentRegistry;", "<init>", "()V", MiPushClient.COMMAND_REGISTER, "", "registerAll", "registerProperty0", "registerConfig0", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BusinessECommerceImplFlowClientExperimentRegistry implements IFlowClientExperimentRegistry {
    public BusinessECommerceImplFlowClientExperimentRegistry() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void priority() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void register() {
        a.k("ecom_ai_chat_answer_intent_logic", "sunzhenghui", 1, true);
        e r100 = e.f480599a;
        c0 r101 = new c0(null);
        r100.getClass();
        a.j("ecom_saas_ai_input_config", "zhaoruolei.123", e.c(r101), true);
    }
}
