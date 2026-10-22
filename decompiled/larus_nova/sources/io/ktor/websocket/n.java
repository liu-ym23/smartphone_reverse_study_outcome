package io.ktor.websocket;

import java.nio.ByteBuffer;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes41.dex */
public final class n implements CoroutineScope {

    public static final class a {
        public a() {
            throw null;
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return null;
    }

    public final void a(Continuation r100) {
        if ((r100 instanceof WebSocketWriter$drainQueueAndSerialize$1) == false) goto L7;
        WebSocketWriter$drainQueueAndSerialize$1 r101 = (WebSocketWriter$drainQueueAndSerialize$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 != 0) goto L11;
        ResultKt.throwOnFailure(r103);
        new Ref.ObjectRef();
        throw null;
    L11:
        if (r104 != 1) goto L13;
        Ref.ObjectRef r105 = (Ref.ObjectRef) r101.L$2;
        ByteBuffer r106 = (ByteBuffer) r101.L$1;
        n r107 = (n) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r107.getClass();
        throw null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new WebSocketWriter$drainQueueAndSerialize$1(this, r100);
        goto L8
    }
}
