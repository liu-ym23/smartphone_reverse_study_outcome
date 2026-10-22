package com.bytedance.rts.kmp.foundation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.rts.kmp.foundation.RTSMessageLooper$postMacroTask$1", f = "Timer.kt", i = {}, l = {84, 90}, m = "invokeSuspend", n = {}, s = {})
final class RTSMessageLooper$postMacroTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ o $task;
    int label;
    final /* synthetic */ k this$0;

    public RTSMessageLooper$postMacroTask$1(k r1, o r2, Continuation<? super RTSMessageLooper$postMacroTask$1> r3) {
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RTSMessageLooper$postMacroTask$1(null, null, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 != 0) goto L5;
        ResultKt.throwOnFailure(r4);
        throw null;
    L5:
        if (r0 != 1) goto L7;
    L10:
        ResultKt.throwOnFailure(r4);
        throw null;
    L7:
        if (r0 == 2) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
