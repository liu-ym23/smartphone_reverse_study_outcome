package com.larus.flowsdk.common.experiment.generated.flowsdk.business.browser_takeover.impl;

import com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry;
import com.xiaomi.mipush.sdk.MiPushClient;
import ga9.a;
import ga9.e;
import java.util.concurrent.atomic.AtomicReference;
import jv8.b;
import jv8.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002¨\u0006\t"}, d2 = {"Lcom/larus/flowsdk/common/experiment/generated/flowsdk/business/browser_takeover/impl/FlowSDKBusinessBrowserTakeoverImplFlowClientExperimentRegistry;", "Lcom/larus/flowsdk/common/experiment/IFlowClientExperimentRegistry;", "<init>", "()V", MiPushClient.COMMAND_REGISTER, "", "registerAll", "registerConfig0", "registerConfig1", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowSDKBusinessBrowserTakeoverImplFlowClientExperimentRegistry implements IFlowClientExperimentRegistry {
    public FlowSDKBusinessBrowserTakeoverImplFlowClientExperimentRegistry() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void priority() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void register() {
        AtomicReference<a.C5998a> r100 = a.f480591a;
        e r101 = e.f480599a;
        b r102 = new b(0);
        r101.getClass();
        a.j("mobile_browser_screencast_size", "xuchenfei", e.c(r102), false);
        a.j("mobile_browser_takeover_enabled", "zhangyajie.doubao", e.c(new c(0)), false);
    }
}
