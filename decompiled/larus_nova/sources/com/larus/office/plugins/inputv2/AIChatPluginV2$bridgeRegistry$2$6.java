package com.larus.office.plugins.inputv2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AIChatPluginV2$bridgeRegistry$2$6 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public AIChatPluginV2$bridgeRegistry$2$6(Object r100) {
        super(1, r100, com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h.class, "onFeishuRequestType", "onFeishuRequestType(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h r101 = (com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h) this.receiver;
        r101.f362972d = r100;
        if (Intrinsics.areEqual(r100, "recommend") == false) goto L6;
        String r102 = "DOCAIRecommendQuestion";
    L9:
        r101.c(r102);
        return;
    L6:
        if (Intrinsics.areEqual(r100, "meeting") == false) goto L8;
        r102 = "DOCAIMINUTESASK";
        goto L9
    L8:
        r102 = "DOCAISidebar";
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
