package com.bytedance.bdnavigationsdk.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.bdnavigationsdk.utils.CallbackQueue$1", f = "CallbackQueue.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
final class CallbackQueue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ a this$0;

    public CallbackQueue$1(a r100, Continuation<? super CallbackQueue$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CallbackQueue$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CallbackQueue$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0036 -> B:13:0x003b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ChannelIterator<Function0<Unit>> r103 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r100);
        ChannelIterator<Function0<Unit>> r104 = r103;
        Object r105 = r101;
        CallbackQueue$1 r106 = this;
    L14:
        if (((Boolean) r100).booleanValue() == false) goto L22;
        r104.next().invoke();     // Catch: Throwable -> L18
    L20:
        CallbackQueue$1 r107 = r106;
        r101 = r105;
        ChannelIterator<Function0<Unit>> r108 = r104;
    L9:
        r107.L$0 = r108;
        r107.label = 1;
        Object r109 = r108.hasNext(r107);
        if (r109 != r101) goto L12;
        return r101;
    L12:
        Object r110 = r101;
        r106 = r107;
        r100 = r109;
        r104 = r108;
        r105 = r110;
    L18:
        th = move-exception;
        com.bytedance.bdnavigationsdk.e r111 = r84.a.f536505a;
        r84.a.b("Unhandled exception in navigation callback", th, 1);
        goto L20
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        r108 = this.this$0.f200374b.iterator();
        r107 = this;
        goto L9
    }
}
