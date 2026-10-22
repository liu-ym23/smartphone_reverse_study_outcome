package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedSendChannelException;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", i = {0, 0}, l = {155, 158, 163}, m = "flush", n = {"this", "it"}, s = {"L$0", "L$2"})
final class WebSocketWriter$flush$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ n this$0;

    public WebSocketWriter$flush$1(n r100, Continuation<? super WebSocketWriter$flush$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        n r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        WebSocketWriter$flush$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r104);
        Job.Key r106 = Job.Key;
        throw null;
    L9:
        if (r105 != 1) goto L11;
        n.a r107 = (n.a) r103.L$2;
        n.a r108 = (n.a) r103.L$1;
        n r109 = (n) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L23 ClosedSendChannelException -> L25
        n.a r110 = r108;
    L21:
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.label = 3;
        r110.getClass();
        throw null;
    L25:
        r107.getClass();
        throw null;
    L23:
        r107.getClass();
        throw null;
    L11:
        if (r105 == 2) goto L17;
        if (r105 != 3) goto L16;
        ResultKt.throwOnFailure(r104);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r110 = (n.a) r103.L$0;
        ResultKt.throwOnFailure(r104);
        goto L21
    L5:
        r103 = new WebSocketWriter$flush$1(r101, this);
        goto L6
    }
}
