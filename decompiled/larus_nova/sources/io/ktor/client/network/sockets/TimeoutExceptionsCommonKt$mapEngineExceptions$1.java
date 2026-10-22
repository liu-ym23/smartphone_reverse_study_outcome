package io.ktor.client.network.sockets;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.b;
import io.ktor.utils.io.u;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lio/ktor/utils/io/u;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.client.network.sockets.TimeoutExceptionsCommonKt$mapEngineExceptions$1", f = "TimeoutExceptionsCommon.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class TimeoutExceptionsCommonKt$mapEngineExceptions$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteReadChannel $input;
    final /* synthetic */ b $replacementChannel;
    int label;

    public TimeoutExceptionsCommonKt$mapEngineExceptions$1(ByteReadChannel r100, b r101, Continuation<? super TimeoutExceptionsCommonKt$mapEngineExceptions$1> r102) {
        this.$input = r100;
        this.$replacementChannel = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TimeoutExceptionsCommonKt$mapEngineExceptions$1(this.$input, this.$replacementChannel, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r100, Continuation<? super Unit> r101) {
        return ((TimeoutExceptionsCommonKt$mapEngineExceptions$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(u r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L13
    L17:
    L16:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        ByteReadChannel r103 = this.$input;     // Catch: Throwable -> L13
        b r104 = this.$replacementChannel;     // Catch: Throwable -> L13
        this.label = 1;     // Catch: Throwable -> L13
        if (ByteReadChannelKt.a(r103, r104, Long.MAX_VALUE, this) != r101) goto L17;
        return r101;
    L13:
        th = move-exception;
        this.$input.cancel(th);
        goto L16
    }
}
