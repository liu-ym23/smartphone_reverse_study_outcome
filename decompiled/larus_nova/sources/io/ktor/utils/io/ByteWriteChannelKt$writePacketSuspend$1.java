package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelKt", f = "ByteWriteChannel.kt", i = {0}, l = {202, 202}, m = "writePacketSuspend", n = {"builder$iv"}, s = {"L$0"})
final class ByteWriteChannelKt$writePacketSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ByteWriteChannelKt$writePacketSuspend$1(Continuation<? super ByteWriteChannelKt$writePacketSuspend$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        ByteWriteChannelKt$writePacketSuspend$1 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r103);
        io.ktor.utils.io.core.j r106 = new io.ktor.utils.io.core.j(null);
        r102.L$0 = r106;     // Catch: Throwable -> L26
        r102.L$1 = null;     // Catch: Throwable -> L26
        r102.label = 1;     // Catch: Throwable -> L26
        throw null;     // Catch: Throwable -> L26
    L26:
        th = th;
        io.ktor.utils.io.core.j r107 = r106;
    L28:
        r107.close();
        throw th;
    L9:
        if (r105 == 1) goto L14;
        if (r105 != 2) goto L13;
        ResultKt.throwOnFailure(r103);
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d r108 = (d) r102.L$1;
        r107 = (io.ktor.utils.io.core.j) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L21
        io.ktor.utils.io.core.k r109 = r107.m();     // Catch: Throwable -> L21
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        if (r108.l(r109, r102) != r104) goto L20;
        return r104;
    L21:
        th = th;
        goto L28
    L5:
        r102 = new ByteWriteChannelKt$writePacketSuspend$1(this);
        goto L6
    }
}
