package io.ktor.websocket;

import io.ktor.util.cio.ChannelWriteException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.u0;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", i = {0, 0, 1, 1}, l = {46, 48}, m = "writeLoop", n = {"this", "buffer", "this", "buffer"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class WebSocketWriter$writeLoop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ n this$0;

    public WebSocketWriter$writeLoop$1(n r100, Continuation<? super WebSocketWriter$writeLoop$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00b6: INVOKE (r9 I:java.lang.Object) VIRTUAL call: java.lang.Object.getClass():java.lang.Class A[Catch: all -> 0x00c3, MD:():java.lang.Class<?> (c), TRY_ENTER] (LINE:16777398), block:B:37:0x00b6 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00ba: INVOKE (r9 I:java.lang.Object) VIRTUAL call: java.lang.Object.getClass():java.lang.Class A[Catch: all -> 0x00c3, MD:():java.lang.Class<?> (c)] (LINE:16777402), block:B:39:0x00ba */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00c3: INVOKE (r9 I:java.lang.Object) VIRTUAL call: java.lang.Object.getClass():java.lang.Class A[MD:():java.lang.Class<?> (c)] (LINE:16777411), block:B:41:0x00c3 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        n r111 = this.this$0;
        r111.getClass();
        int r100 = this.label;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r100 - Integer.MIN_VALUE;
        WebSocketWriter$writeLoop$1 r101 = this;
    L6:
        Object r112 = r101.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r101.label;
        if (r103 != 0) goto L45;
        ResultKt.throwOnFailure(r112);
        throw null;
    L45:
        if (r103 == 1) goto L19;
        if (r103 != 2) goto L18;
        ChannelIterator r104 = (ChannelIterator) r101.L$2;
        ByteBuffer r105 = (ByteBuffer) r101.L$1;
        n r106 = (n) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: ChannelWriteException -> L33 Throwable -> L37
        if (((Boolean) r112).booleanValue() == true) goto L35;
        r101.L$0 = r106;     // Catch: ChannelWriteException -> L33 Throwable -> L37
        r101.L$1 = r105;     // Catch: ChannelWriteException -> L33 Throwable -> L37
        r101.L$2 = r104;     // Catch: ChannelWriteException -> L33 Throwable -> L37
        r101.label = 1;     // Catch: ChannelWriteException -> L33 Throwable -> L37
        r112 = r104.hasNext(r101);     // Catch: ChannelWriteException -> L33 Throwable -> L37
        if (r112 != r102) goto L22;
        return r102;
    L22:
        if (((Boolean) r112).booleanValue() == false) goto L35;
        Object r113 = r104.next();     // Catch: ChannelWriteException -> L33 Throwable -> L37
        if ((r113 instanceof c) == false) goto L26;
        c r114 = (c) r113;     // Catch: ChannelWriteException -> L33 Throwable -> L37
        r101.L$0 = r106;     // Catch: ChannelWriteException -> L33 Throwable -> L37
        r101.L$1 = r105;     // Catch: ChannelWriteException -> L33 Throwable -> L37
        r101.L$2 = r104;     // Catch: ChannelWriteException -> L33 Throwable -> L37
        r101.label = 2;     // Catch: ChannelWriteException -> L33 Throwable -> L37
        r106.a(r101);     // Catch: ChannelWriteException -> L33 Throwable -> L37
        throw null;     // Catch: ChannelWriteException -> L33 Throwable -> L37
    L26:
        if ((r113 instanceof n.a) == false) goto L30;
        ((n.a) r113).getClass();     // Catch: ChannelWriteException -> L33 Throwable -> L37
        throw null;     // Catch: ChannelWriteException -> L33 Throwable -> L37
    L30:
        throw new IllegalArgumentException("unknown message " + r113);     // Catch: ChannelWriteException -> L33 Throwable -> L37
    L35:
        r106.getClass();
        u0.a("WebSocket closed.", null);
        throw null;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r104 = (ChannelIterator) r101.L$2;
        r105 = (ByteBuffer) r101.L$1;
        r106 = (n) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: ChannelWriteException -> L33 Throwable -> L37
    L41:
        r9.getClass();
        u0.a("WebSocket closed.", null);
        throw null;
    L37:
        r9.getClass();     // Catch: Throwable -> L41
        throw null;     // Catch: Throwable -> L41
    L33:
        e = move-exception;
        r9.getClass();     // Catch: Throwable -> L41
        u0.a("Failed to write to WebSocket.", e);     // Catch: Throwable -> L41
        throw null;     // Catch: Throwable -> L41
    L5:
        r101 = new WebSocketWriter$writeLoop$1(r111, this);
        goto L6
    }
}
