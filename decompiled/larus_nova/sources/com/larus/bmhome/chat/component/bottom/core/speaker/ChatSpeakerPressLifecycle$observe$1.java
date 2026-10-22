package com.larus.bmhome.chat.component.bottom.core.speaker;

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
final /* synthetic */ class ChatSpeakerPressLifecycle$observe$1 extends FunctionReferenceImpl implements Function2<e.c, Continuation<? super Unit>, Object>, SuspendFunction {
    public ChatSpeakerPressLifecycle$observe$1(Object r100) {
        super(2, r100, Intrinsics.Kotlin.class, "suspendConversion0", "observe$suspendConversion0(Lkotlin/jvm/functions/Function1;Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerPressLifecycle$Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(e.c r100, Continuation<? super Unit> r101) {
        Function1 r102 = (Function1) this.receiver;
        int r103 = e.f299397k;
        r102.invoke(r100);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(e.c r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }
}
