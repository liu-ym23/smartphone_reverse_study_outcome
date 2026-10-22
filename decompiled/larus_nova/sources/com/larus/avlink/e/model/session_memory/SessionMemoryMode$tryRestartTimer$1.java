package com.larus.avlink.e.model.session_memory;

import com.larus.avlink.n1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.e.model.session_memory.SessionMemoryMode$tryRestartTimer$1", f = "SessionMemoryMode.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
public final class SessionMemoryMode$tryRestartTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SessionMemoryMode this$0;

    public SessionMemoryMode$tryRestartTimer$1(SessionMemoryMode r100, Continuation<? super SessionMemoryMode$tryRestartTimer$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SessionMemoryMode$tryRestartTimer$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SessionMemoryMode$tryRestartTimer$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L11;
        if (r102 != 1) goto L10;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L7
    L18:
    L17:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r100);
        SessionMemoryMode r103 = this.this$0;     // Catch: Exception -> L7
        this.label = 1;     // Catch: Exception -> L7
        if (SessionMemoryMode.a(r103, this) != r101) goto L18;
        return r101;
    L7:
        e = move-exception;
        n1.c("SessionMemoryMode", "An error occurred while try to stop timer loop.", e);
        goto L17
    }
}
