package com.larus.office.plugins.inputv2;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AIChatPluginV2$bridgeRegistry$2$5 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public AIChatPluginV2$bridgeRegistry$2$5(Object r100) {
        super(1, r100, com.larus.office.plugins.inputv2.coordinator.document.c.class, "markAiEditTriggered", "markAiEditTriggered(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        com.larus.office.plugins.inputv2.coordinator.document.c r101 = (com.larus.office.plugins.inputv2.coordinator.document.c) this.receiver;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "reason");
        r101.f362780f = true;
        r101.f362781g = true;
        FLogger.f375446a.i("OfficeAnswerState", "标记 AI Edit, reason=" + r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
