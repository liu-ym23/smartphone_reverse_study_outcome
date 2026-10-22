package com.larus.asr.session.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AsrEngineStartPreComponent$startWithNormalAsr$3 extends FunctionReferenceImpl implements Function1<com.larus.audio.b, Unit> {
    public AsrEngineStartPreComponent$startWithNormalAsr$3(Object r100) {
        super(1, r100, b.class, "onSuccess", "onSuccess(Lcom/larus/audio/AsrSuccessResult;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.larus.audio.b r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((b) this.receiver).d(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.larus.audio.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
