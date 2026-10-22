package com.larus.asr.session.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AsrEngineStartPreComponent$startWithNormalAsr$1 extends FunctionReferenceImpl implements Function1<byte[], Unit> {
    public AsrEngineStartPreComponent$startWithNormalAsr$1(Object r100) {
        super(1, r100, b.class, "onAudioData", "onAudioData([B)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(byte[] r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(byte[] r100) {
        ((b) this.receiver).a(r100);
    }
}
