package io.ktor.utils.io;

import androidx.collection.SieveCacheKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.ConsumeEachKt", f = "ConsumeEach.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2}, l = {46, 50, 53}, m = "consumeEachBufferRange", n = {"$this$consumeEachBufferRange", "visitor", "continueFlag", "lastChunkReported", "$this$read_u24default$iv", "$this$consumeEachBufferRange", "visitor", "continueFlag", "lastChunkReported", "$this$read_u24default$iv", "buffer$iv", "bytesRead$iv", "cause$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0"})
final class ConsumeEachKt$consumeEachBufferRange$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    public ConsumeEachKt$consumeEachBufferRange$1(Continuation<? super ConsumeEachKt$consumeEachBufferRange$1> r100) {
        super(r100);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0136 -> B:51:0x013a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        this.result = r210;
        int r100 = this.label | Integer.MIN_VALUE;
        this.label = r100;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r100 - Integer.MIN_VALUE;
        ConsumeEachKt$consumeEachBufferRange$1 r101 = this;
    L6:
        Object r102 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = false;
        int r106 = 1;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L14;
        if (r104 != 3) goto L12;
        Throwable r107 = (Throwable) r101.L$0;
        ResultKt.throwOnFailure(r102);
        throw r107;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        io.ktor.utils.io.core.a r108 = (io.ktor.utils.io.core.a) r101.L$5;
        ByteReadChannel r110 = (ByteReadChannel) r101.L$4;
        Ref.BooleanRef r111 = (Ref.BooleanRef) r101.L$3;
        Ref.BooleanRef r112 = (Ref.BooleanRef) r101.L$2;
        Function2 r113 = (Function2) r101.L$1;
        ByteReadChannel r114 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L17
        Ref.BooleanRef r109 = r111;
        Ref.BooleanRef r115 = r112;
        Function2 r116 = r113;
        ByteReadChannel r117 = r114;
    L52:
        if (r109.element == false) goto L57;
        if (r117.E() == false) goto L57;
    L62:
        return Unit.INSTANCE;
    L57:
        if (r115.element == false) goto L62;
        r105 = false;
        r106 = 1;
    L21:
        r115.element = r105;
        r101.L$0 = r117;
        r101.L$1 = r116;
        r101.L$2 = r115;
        r101.L$3 = r109;
        r101.L$4 = r117;
        r101.L$5 = null;
        r101.label = r106;
        Object r118 = ReadSessionKt.b(r117, r106, r101);
        if (r118 == r103) goto L66;
        ByteReadChannel r119 = r117;
        Function2 r120 = r116;
        Ref.BooleanRef r121 = r109;
        Ref.BooleanRef r122 = r115;
        r102 = r118;
    L25:
        io.ktor.utils.io.core.a r123 = (io.ktor.utils.io.core.a) r102;
        if (r123 != null) goto L28;
        int r124 = io.ktor.utils.io.core.a.f492019g;
        r123 = io.ktor.utils.io.core.internal.a.f492030m;
    L28:
        io.ktor.utils.io.core.a r125 = r123;
        ByteBuffer r126 = r125.f492020a;     // Catch: Throwable -> L17
        long r127 = r125.f492021b;     // Catch: Throwable -> L17
        long r128 = r125.f492022c;     // Catch: Throwable -> L17
        if (r128 <= r127) goto L40;
        long r129 = r128 - r127;     // Catch: Throwable -> L17
        ByteBuffer r130 = jsc.c.f500279b;     // Catch: Throwable -> L17
        if (r127 >= SieveCacheKt.NodeLinkMask) goto L38;
        int r131 = (int) r127;     // Catch: Throwable -> L17
        if (r129 >= SieveCacheKt.NodeLinkMask) goto L36;
        ByteBuffer r132 = jsc.d.c(r126, r131, (int) r129);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r132, "buffer");     // Catch: Throwable -> L17
    L42:
        if (r132.remaining() == r119.w()) goto L44;
    L46:
        boolean r133 = false;
    L47:
        r121.element = r133;     // Catch: Throwable -> L17
        r122.element = ((Boolean) r120.invoke(r132, Boxing.boxBoolean(r133))).booleanValue();     // Catch: Throwable -> L17
        int r134 = r132.position();     // Catch: Throwable -> L17
        r101.L$0 = r119;     // Catch: Throwable -> L17
        r101.L$1 = r120;     // Catch: Throwable -> L17
        r101.L$2 = r122;     // Catch: Throwable -> L17
        r101.L$3 = r121;     // Catch: Throwable -> L17
        r101.L$4 = r117;     // Catch: Throwable -> L17
        r101.L$5 = r125;     // Catch: Throwable -> L17
        r101.I$0 = r134;     // Catch: Throwable -> L17
        r101.label = 2;     // Catch: Throwable -> L17
        if (ReadSessionKt.a(r117, r125, r134, r101) == r103) goto L67;
        r109 = r121;
        r115 = r122;
        r116 = r120;
        r117 = r119;
        goto L52
    L67:
        return r103;
    L44:
        if (r119.c() == false) goto L46;
        r133 = true;
        goto L47
    L36:
        io.ktor.utils.io.core.internal.b.a(r129, "length");     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L38:
        io.ktor.utils.io.core.internal.b.a(r127, "offset");     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L40:
        r132 = jsc.c.f500279b;     // Catch: Throwable -> L17
        goto L42
    L66:
        return r103;
    L17:
        th = move-exception;
        ConsumeEachKt$consumeEachBufferRange$1 r135 = r101;
        r135.L$0 = th;
        r135.L$1 = null;
        r135.L$2 = null;
        r135.L$3 = null;
        r135.L$4 = null;
        r135.L$5 = null;
        r135.label = 3;
        if (ReadSessionKt.a(r110, r108, 0, r135) != r103) goto L68;
        return r103;
    L68:
        throw th;
    L19:
        ByteReadChannel r136 = (ByteReadChannel) r101.L$4;
        Ref.BooleanRef r137 = (Ref.BooleanRef) r101.L$3;
        Ref.BooleanRef r138 = (Ref.BooleanRef) r101.L$2;
        Function2 r139 = (Function2) r101.L$1;
        ByteReadChannel r140 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r102);
        r119 = r140;
        r120 = r139;
        r122 = r138;
        r121 = r137;
        r117 = r136;
        goto L25
    L20:
        ResultKt.throwOnFailure(r102);
        r115 = new Ref.BooleanRef();
        r109 = new Ref.BooleanRef();
        r117 = null;
        r116 = null;
        goto L21
    L5:
        r101 = new ConsumeEachKt$consumeEachBufferRange$1(this);
        goto L6
    }
}
