package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteOrder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {0}, l = {15}, m = "readLong", n = {"byteOrder"}, s = {"L$0"})
final class ChannelLittleEndianKt$readLong$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ChannelLittleEndianKt$readLong$1(Continuation<? super ChannelLittleEndianKt$readLong$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        ChannelLittleEndianKt$readLong$1 r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        ByteOrder r105 = (ByteOrder) r102.L$0;
        ResultKt.throwOnFailure(r103);
        if (g.f492056a[r105.ordinal()] != 1) goto L13;
        return r103;
    L13:
        return Boxing.boxLong(Long.reverseBytes(((Number) r103).longValue()));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        r102.L$0 = null;
        r102.label = 1;
        throw null;
    L5:
        r102 = new ChannelLittleEndianKt$readLong$1(this);
        goto L6
    }
}
