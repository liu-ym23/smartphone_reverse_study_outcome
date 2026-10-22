package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lio/ktor/utils/io/q;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$copied$1", f = "Delimited.kt", i = {0, 0, 1, 1}, l = {85, 95}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", "copied", "$this$lookAheadSuspend", "copied"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class DelimitedKt$readUntilDelimiterSuspend$copied$1 extends SuspendLambda implements Function2<q, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $copied0;
    final /* synthetic */ ByteBuffer $delimiter;
    final /* synthetic */ ByteBuffer $dst;
    final /* synthetic */ Ref.BooleanRef $endFound;
    final /* synthetic */ ByteReadChannel $this_readUntilDelimiterSuspend;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    public DelimitedKt$readUntilDelimiterSuspend$copied$1(int r100, ByteBuffer r101, ByteBuffer r102, Ref.BooleanRef r103, ByteReadChannel r104, Continuation<? super DelimitedKt$readUntilDelimiterSuspend$copied$1> r105) {
        this.$copied0 = r100;
        this.$delimiter = r101;
        this.$dst = r102;
        this.$endFound = r103;
        this.$this_readUntilDelimiterSuspend = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        DelimitedKt$readUntilDelimiterSuspend$copied$1 r101 = new DelimitedKt$readUntilDelimiterSuspend$copied$1(this.$copied0, this.$delimiter, this.$dst, this.$endFound, this.$this_readUntilDelimiterSuspend, r110);
        r101.L$0 = r100;
        return r101;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(q r100, Continuation<? super Integer> r101) {
        return ((DelimitedKt$readUntilDelimiterSuspend$copied$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(q r100, Continuation<? super Integer> r101) {
        return invoke2(r100, r101);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007c -> B:26:0x007f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        int r103 = this.I$0;
        q r104 = (q) this.L$0;
        ResultKt.throwOnFailure(r100);
        DelimitedKt$readUntilDelimiterSuspend$copied$1 r105 = this;
    L26:
        q r106 = r104;
        DelimitedKt$readUntilDelimiterSuspend$copied$1 r107 = r105;
        q r108 = r106;
        if (r107.$dst.hasRemaining() == false) goto L35;
        if (r107.$endFound.element == true) goto L35;
    L11:
        r107.L$0 = r108;
        r107.I$0 = r103;
        r107.label = 1;
        if (r108.f(1, r107) != r101) goto L14;
        return r101;
    L14:
        DelimitedKt$readUntilDelimiterSuspend$copied$1 r109 = r107;
        r104 = r108;
        r105 = r109;
    L15:
        int r110 = l.a(r104, r105.$delimiter, r105.$dst);
        if (r110 == 0) goto L18;
        if (r110 > 0) goto L29;
        r105.$endFound.element = true;
    L29:
        r103 = r103 + (-r110);
        goto L26
    L36:
        r103 = r103 + r110;
        goto L26
    L18:
        if (l.c(r104, r105.$delimiter) != r105.$delimiter.remaining()) goto L21;
        r105.$endFound.element = true;
        goto L35
    L21:
        if (r105.$this_readUntilDelimiterSuspend.c() == true) goto L35;
        int r111 = r105.$delimiter.remaining();
        r105.L$0 = r104;
        r105.I$0 = r103;
        r105.label = 2;
        if (r104.f(r111, r105) != r101) goto L26;
        return r101;
    L35:
        return Boxing.boxInt(r103);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r103 = this.I$0;
        r104 = (q) this.L$0;
        ResultKt.throwOnFailure(r100);
        r105 = this;
        goto L15
    L10:
        ResultKt.throwOnFailure(r100);
        r108 = (q) this.L$0;
        r103 = this.$copied0;
        r107 = this;
        goto L11
    }
}
