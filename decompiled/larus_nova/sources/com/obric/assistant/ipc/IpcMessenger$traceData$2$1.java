package com.obric.assistant.ipc;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.IpcMessenger$traceData$2$1", f = "IpcMessenger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IpcMessenger$traceData$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $payload;
    final /* synthetic */ String $u;
    final /* synthetic */ Ref.ObjectRef<String> $wakeupStage;
    final /* synthetic */ Ref.BooleanRef $wakeupSuccess;
    int label;

    public IpcMessenger$traceData$2$1(String r100, Ref.ObjectRef<String> r101, Ref.BooleanRef r102, JSONObject r103, Continuation<? super IpcMessenger$traceData$2$1> r104) {
        this.$u = r100;
        this.$wakeupStage = r101;
        this.$wakeupSuccess = r102;
        this.$payload = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new IpcMessenger$traceData$2$1(this.$u, this.$wakeupStage, this.$wakeupSuccess, this.$payload, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((IpcMessenger$traceData$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        Lazy r101 = com.obric.assistant.common.utils.s.f387888a;
        com.obric.assistant.common.utils.s.e(this.$u, this.$wakeupStage.element, this.$wakeupSuccess.element, this.$payload);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
