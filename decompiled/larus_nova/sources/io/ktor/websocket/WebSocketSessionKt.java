package io.ktor.websocket;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class WebSocketSessionKt {
    public static /* synthetic */ Object b(m r100, Continuation r101) {
        return a(r100, new CloseReason(CloseReason.Codes.NORMAL, ""), r101);
    }

    public static final Object a(m r100, CloseReason r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof WebSocketSessionKt$close$1) == false) goto L7;
        WebSocketSessionKt$close$1 r103 = (WebSocketSessionKt$close$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L19;
        if (r107 == 1) goto L16;
        if (r107 != 2) goto L15;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L28
        goto L27
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r100 = (m) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L28
    L23:
        r103.L$0 = null;     // Catch: Throwable -> L28
        r103.label = 2;     // Catch: Throwable -> L28
        if (r100.hW(r103) != r106) goto L27;
        return r106;
    L19:
        ResultKt.throwOnFailure(r105);
        c.b r108 = new c.b(r101);     // Catch: Throwable -> L28
        r103.L$0 = r100;     // Catch: Throwable -> L28
        r103.label = 1;     // Catch: Throwable -> L28
        if (r100.FQ(r108, r103) != r106) goto L23;
        return r106;
    L27:
        return Unit.INSTANCE;
    L7:
        r103 = new WebSocketSessionKt$close$1(r102);
        goto L8
    }
}
