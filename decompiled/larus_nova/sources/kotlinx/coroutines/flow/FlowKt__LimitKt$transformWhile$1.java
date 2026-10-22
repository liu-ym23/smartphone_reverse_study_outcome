package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", i = {0}, l = {149}, m = "invokeSuspend", n = {"collector$iv"}, s = {"L$0"})
final class FlowKt__LimitKt$transformWhile$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_transformWhile;
    final /* synthetic */ Function3<FlowCollector<Object>, Object, Continuation<? super Boolean>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$transformWhile$1(Flow<Object> r100, Function3<? super FlowCollector<Object>, Object, ? super Continuation<? super Boolean>, ? extends Object> r101, Continuation<? super FlowKt__LimitKt$transformWhile$1> r102) {
        this.$this_transformWhile = r100;
        this.$transform = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FlowKt__LimitKt$transformWhile$1 r102 = new FlowKt__LimitKt$transformWhile$1(this.$this_transformWhile, this.$transform, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<Object> r100, Continuation<? super Unit> r101) {
        return ((FlowKt__LimitKt$transformWhile$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 != 1) goto L11;
        FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 r103 = (FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: AbortFlowException -> L8
    L21:
        return Unit.INSTANCE;
    L8:
        e = e;
    L19:
        if (e.owner == r103) goto L21;
        throw e;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r100);
        FlowCollector r104 = (FlowCollector) this.L$0;
        Flow<Object> r105 = this.$this_transformWhile;
        FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 r106 = new FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1(this.$transform, r104);
        this.L$0 = r106;     // Catch: AbortFlowException -> L16
        this.label = 1;     // Catch: AbortFlowException -> L16
        if (r105.collect(r106, this) != r101) goto L21;
        return r101;
    L16:
        e = e;
        r103 = r106;
        goto L19
    }
}
