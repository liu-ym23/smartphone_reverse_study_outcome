package com.larus.asr.session.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AsrEngineStartPreComponent$startWithNormalAsr$4 extends FunctionReferenceImpl implements Function4<String, String, Long, Integer, Unit> {
    public AsrEngineStartPreComponent$startWithNormalAsr$4(Object r100) {
        super(4, r100, b.class, "onFailure", "onFailure(Ljava/lang/String;Ljava/lang/String;JI)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(String r100, String r101, Long r102, Integer r110) {
        invoke(r100, r101, r102.longValue(), r110.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String r100, String r101, long r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        ((b) this.receiver).c(r100, r101, r110, r111);
    }
}
