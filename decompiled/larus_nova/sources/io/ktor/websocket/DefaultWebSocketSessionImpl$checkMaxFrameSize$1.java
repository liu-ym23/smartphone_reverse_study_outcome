package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", i = {0}, l = {327}, m = "checkMaxFrameSize", n = {"size"}, s = {"I$0"})
final class DefaultWebSocketSessionImpl$checkMaxFrameSize$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    public DefaultWebSocketSessionImpl$checkMaxFrameSize$1(DefaultWebSocketSessionImpl r100, Continuation<? super DefaultWebSocketSessionImpl$checkMaxFrameSize$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DefaultWebSocketSessionImpl.a(this.this$0, null, null, this);
    }
}
