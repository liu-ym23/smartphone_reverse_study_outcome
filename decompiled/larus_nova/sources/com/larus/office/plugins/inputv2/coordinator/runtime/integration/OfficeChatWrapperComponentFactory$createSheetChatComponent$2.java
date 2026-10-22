package com.larus.office.plugins.inputv2.coordinator.runtime.integration;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OfficeChatWrapperComponentFactory$createSheetChatComponent$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public OfficeChatWrapperComponentFactory$createSheetChatComponent$2(Object r100) {
        super(1, r100, com.larus.office.plugins.inputv2.coordinator.document.e.class, "clearReplayCache", "clearReplayCache(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        com.larus.office.plugins.inputv2.coordinator.document.e r101 = (com.larus.office.plugins.inputv2.coordinator.document.e) this.receiver;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "reason");
        Intrinsics.checkNotNullParameter(r100, "reason");
        r101.f362791d = false;
        r101.f362792e = null;
        r101.f362793f = null;
        r101.f362794g = null;
        r101.b(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
