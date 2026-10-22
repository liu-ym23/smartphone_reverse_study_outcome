package com.larus.voicecall.impl.continue_talk;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$suspendCoroutine$2", f = "ChatContinuousTalkComponent.kt", i = {0}, l = {1201}, m = "invokeSuspend", n = {"block$iv"}, s = {"L$0"})
final class ChatContinuousTalkComponent$suspendCoroutine$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    final /* synthetic */ Function1<Continuation<Object>, Unit> $callback;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatContinuousTalkComponent$suspendCoroutine$2(Function1<? super Continuation<Object>, Unit> r100, Continuation<? super ChatContinuousTalkComponent$suspendCoroutine$2> r101) {
        this.$callback = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatContinuousTalkComponent$suspendCoroutine$2(this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<Object> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<Object> r101) {
        return ((ChatContinuousTalkComponent$suspendCoroutine$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Function1 r103 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r100);
    L13:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Function1<Continuation<Object>, Unit> r104 = this.$callback;
        this.L$0 = r104;
        this.label = 1;
        kotlinx.coroutines.j r105 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r105.C();
        r104.invoke(r105);
        r100 = r105.B();
        if (r100 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r100 != r101) goto L13;
        return r101;
    }
}
