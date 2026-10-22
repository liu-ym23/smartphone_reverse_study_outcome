package com.larus.bmhome.chat.component.bottom.voice.service;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class VoiceMixInputService$observeAudioData$1 extends FunctionReferenceImpl implements Function2<byte[], Continuation<? super Unit>, Object>, SuspendFunction {
    public VoiceMixInputService$observeAudioData$1(Object r100) {
        super(2, r100, Intrinsics.Kotlin.class, "suspendConversion0", "observeAudioData$suspendConversion0$7(Lkotlin/jvm/functions/Function1;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(byte[] r100, Continuation<? super Unit> r101) {
        ((Function1) this.receiver).invoke(r100);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(byte[] r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }
}
