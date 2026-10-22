package io.ktor.utils.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lio/ktor/utils/io/q;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.utils.io.DelimitedKt$skipDelimiterSuspend$2", f = "Delimited.kt", i = {0}, l = {66}, m = "invokeSuspend", n = {"$this$lookAheadSuspend"}, s = {"L$0"})
final class DelimitedKt$skipDelimiterSuspend$2 extends SuspendLambda implements Function2<q, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteBuffer $delimiter;
    private /* synthetic */ Object L$0;
    int label;

    public DelimitedKt$skipDelimiterSuspend$2(ByteBuffer r100, Continuation<? super DelimitedKt$skipDelimiterSuspend$2> r101) {
        this.$delimiter = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DelimitedKt$skipDelimiterSuspend$2 r102 = new DelimitedKt$skipDelimiterSuspend$2(this.$delimiter, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(q r100, Continuation<? super Unit> r101) {
        return ((DelimitedKt$skipDelimiterSuspend$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(q r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        q r103 = (q) this.L$0;
        ResultKt.throwOnFailure(r100);
    L13:
        if (l.b(r103, this.$delimiter) != this.$delimiter.remaining()) goto L17;
        return Unit.INSTANCE;
    L17:
        throw new IOException("Broken delimiter occurred");
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        q r104 = (q) this.L$0;
        int r105 = this.$delimiter.remaining();
        this.L$0 = r104;
        this.label = 1;
        if (r104.f(r105, this) != r101) goto L11;
        return r101;
    L11:
        r103 = r104;
        goto L13
    }
}
