package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {43}, m = "readDoubleLittleEndian", n = {}, s = {})
final class ChannelLittleEndianKt$readDoubleLittleEndian$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public ChannelLittleEndianKt$readDoubleLittleEndian$1(Continuation<? super ChannelLittleEndianKt$readDoubleLittleEndian$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        ChannelLittleEndianKt$readDoubleLittleEndian$1 r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L13;
        if (r104 != 1) goto L12;
        ResultKt.throwOnFailure(r103);
        return Boxing.boxDouble(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) r103).doubleValue()))));
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r103);
        r102.label = 1;
        throw null;
    L5:
        r102 = new ChannelLittleEndianKt$readDoubleLittleEndian$1(this);
        goto L6
    }
}
