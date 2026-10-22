package io.ktor.utils.io;

import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0}, l = {128}, m = "readFullySuspend", n = {"this", "dst", "count"}, s = {"L$0", "L$1", "I$0"})
final class ByteChannelSequentialJVM$readFullySuspend$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialJVM this$0;

    public ByteChannelSequentialJVM$readFullySuspend$1(ByteChannelSequentialJVM r100, Continuation<? super ByteChannelSequentialJVM$readFullySuspend$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ByteChannelSequentialJVM r101 = this.this$0;
        int r102 = ByteChannelSequentialJVM.f492009g;
        r101.getClass();
        int r103 = this.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r103 - Integer.MIN_VALUE;
        ByteChannelSequentialJVM$readFullySuspend$1 r104 = this;
    L6:
        Object r105 = r104.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 != 0) goto L9;
        ResultKt.throwOnFailure(r105);
        throw null;
    L9:
        if (r106 != 1) goto L25;
        ByteBuffer r107 = (ByteBuffer) r104.L$1;
        ByteChannelSequentialJVM r108 = (ByteChannelSequentialJVM) r104.L$0;
        ResultKt.throwOnFailure(r105);
        if (((Boolean) r105).booleanValue() == false) goto L23;
        Throwable r109 = r108.d();
        if (r109 == null) goto L15;
        throw r109;
    L15:
        if (r108.U() == true) goto L17;
        throw null;
    L17:
        if (r108.w() == 0) goto L19;
        throw null;
    L19:
        throw new EOFException("Channel closed");
    L23:
        throw new EOFException("Channel closed");
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r104 = new ByteChannelSequentialJVM$readFullySuspend$1(r101, this);
        goto L6
    }
}
