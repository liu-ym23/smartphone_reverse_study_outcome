package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.DelimitedKt", f = "Delimited.kt", i = {0, 0, 0}, l = {81, 113}, m = "readUntilDelimiterSuspend", n = {"$this$readUntilDelimiterSuspend", "dst", "endFound"}, s = {"L$0", "L$1", "L$2"})
final class DelimitedKt$readUntilDelimiterSuspend$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public DelimitedKt$readUntilDelimiterSuspend$1(Continuation<? super DelimitedKt$readUntilDelimiterSuspend$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        DelimitedKt$readUntilDelimiterSuspend$1 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r103);
        throw new IllegalArgumentException("Failed requirement.".toString());
    L9:
        if (r105 == 1) goto L14;
        if (r105 != 2) goto L13;
        int r106 = r102.I$0;
        ResultKt.throwOnFailure(r103);
    L24:
        int r107 = RangesKt.coerceAtLeast(((Number) r103).intValue(), 0) + r106;
    L30:
        return Boxing.boxInt(r107);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        Ref.BooleanRef r108 = (Ref.BooleanRef) r102.L$2;
        ByteBuffer r109 = (ByteBuffer) r102.L$1;
        ByteReadChannel r110 = (ByteReadChannel) r102.L$0;
        ResultKt.throwOnFailure(r103);
        r107 = ((Number) r103).intValue();
        if (r107 > 0) goto L17;
    L25:
        if (r107 != 0) goto L30;
        if (r110.E() == false) goto L30;
        r107 = -1;
        goto L30
    L17:
        if (r110.c() == false) goto L25;
        if (r108.element == true) goto L25;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.I$0 = r107;
        r102.label = 2;
        Object r111 = r110.B(r109, r102);
        if (r111 == r104) goto L33;
        r103 = r111;
        r106 = r107;
        goto L24
    L33:
        return r104;
    L5:
        r102 = new DelimitedKt$readUntilDelimiterSuspend$1(this);
        goto L6
    }
}
