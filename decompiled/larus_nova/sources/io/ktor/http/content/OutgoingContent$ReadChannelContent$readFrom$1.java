package io.ktor.http.content;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelJVMKt;
import io.ktor.utils.io.u;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.LongRange;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lio/ktor/utils/io/u;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.http.content.OutgoingContent$ReadChannelContent$readFrom$1", f = "OutgoingContent.kt", i = {0, 0}, l = {93, 95}, m = "invokeSuspend", n = {"$this$writer", "source"}, s = {"L$0", "L$1"})
final class OutgoingContent$ReadChannelContent$readFrom$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ LongRange $range;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ c.AbstractC6311c this$0;

    public OutgoingContent$ReadChannelContent$readFrom$1(c.AbstractC6311c r100, LongRange r101, Continuation<? super OutgoingContent$ReadChannelContent$readFrom$1> r102) {
        this.this$0 = r100;
        this.$range = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        OutgoingContent$ReadChannelContent$readFrom$1 r102 = new OutgoingContent$ReadChannelContent$readFrom$1(this.this$0, this.$range, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r100, Continuation<? super Unit> r101) {
        return ((OutgoingContent$ReadChannelContent$readFrom$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(u r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ByteReadChannel r103 = (ByteReadChannel) this.L$1;
        u r104 = (u) this.L$0;
        ResultKt.throwOnFailure(r100);
    L14:
        long r105 = (this.$range.getEndInclusive().longValue() - this.$range.getStart().longValue()) + 1;
        io.ktor.utils.io.b r106 = r104.zl();
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (ByteReadChannelJVMKt.a(r103, r106, r105, this) != r101) goto L18;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        u r107 = (u) this.L$0;
        r103 = this.this$0.d();
        long r108 = this.$range.getStart().longValue();
        this.L$0 = r107;
        this.L$1 = r103;
        this.label = 1;
        if (r103.p(r108, this) != r101) goto L13;
        return r101;
    L13:
        r104 = r107;
        goto L14
    }
}
