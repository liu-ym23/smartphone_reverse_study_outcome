package com.larus.init.task.experiment;

import ga9.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class FlowClientExperimentSettingsRuntime$dict$1 extends FunctionReferenceImpl implements Function2<String, f<?>, Object> {
    public FlowClientExperimentSettingsRuntime$dict$1(Object r100) {
        super(2, r100, FlowClientExperimentSettingsRuntime.class, "loadValue", "loadValue(Ljava/lang/String;Lcom/larus/flowsdk/common/experiment/FlowExperimentRegisterInfo;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r100, f<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        return FlowClientExperimentSettingsRuntime.g((FlowClientExperimentSettingsRuntime) this.receiver, r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String r100, f<?> r101) {
        return invoke2(r100, r101);
    }
}
