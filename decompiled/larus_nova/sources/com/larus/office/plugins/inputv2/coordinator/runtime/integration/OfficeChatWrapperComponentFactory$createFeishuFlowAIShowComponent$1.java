package com.larus.office.plugins.inputv2.coordinator.runtime.integration;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OfficeChatWrapperComponentFactory$createFeishuFlowAIShowComponent$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public OfficeChatWrapperComponentFactory$createFeishuFlowAIShowComponent$1(Object r100) {
        super(1, r100, com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h.class, "onMessagesSent", "onMessagesSent(I)V", 0);
    }

    public final void invoke(int r100) {
        com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h r101 = (com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h) this.receiver;
        r101.getClass();
        r101.f362973e = RangesKt.coerceAtLeast(r100, 1);
        r101.f362974f = 0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }
}
