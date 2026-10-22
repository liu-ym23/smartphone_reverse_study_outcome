package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/channels/ChannelResult;", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g<? extends Unit>>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ SendChannel<Object> $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    int label;

    public ChannelsKt__ChannelsKt$trySendBlocking$2(SendChannel<Object> r100, Object r101, Continuation<? super ChannelsKt__ChannelsKt$trySendBlocking$2> r102) {
        this.$this_trySendBlocking = r100;
        this.$element = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 r102 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super g<? extends Unit>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super g<Unit>> r101) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L18:
        if (Result.m9456isSuccessimpl(r103) == false) goto L20;
        g.c r104 = g.f504696b;
        Object r105 = Unit.INSTANCE;
    L22:
        return new g(r105);
    L20:
        g.c r106 = g.f504696b;
        r105 = new g.a(Result.m9452exceptionOrNullimpl(r103));
        goto L22
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r107 = (CoroutineScope) this.L$0;
        SendChannel<Object> r108 = this.$this_trySendBlocking;
        Object r109 = this.$element;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r108.send(r109, this) != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
