package com.larus.voicecall.impl.autostop;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AutoStopAsrServiceImpl$controller$1 extends FunctionReferenceImpl implements Function1<a3a.a.d, Unit> {
    public AutoStopAsrServiceImpl$controller$1(Object r100) {
        super(1, r100, AutoStopAsrServiceImpl.class, "handleFailure", "handleFailure(Lcom/larus/voicecall/api/autostop/AutoStopAsrEvent$Error;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a3a.a.d r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((AutoStopAsrServiceImpl) this.receiver).b(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a3a.a.d r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
