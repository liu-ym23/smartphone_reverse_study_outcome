package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$1", f = "Delay.kt", i = {0, 1, 2}, l = {307, 309, 310}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
final class FlowKt__DelayKt$fixedPeriodTicker$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.k<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    private /* synthetic */ Object L$0;
    int label;

    public FlowKt__DelayKt$fixedPeriodTicker$1(long r100, Continuation<? super FlowKt__DelayKt$fixedPeriodTicker$1> r101) {
        this.$delayMillis = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FlowKt__DelayKt$fixedPeriodTicker$1 r102 = new FlowKt__DelayKt$fixedPeriodTicker$1(this.$delayMillis, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.k<? super Unit> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.channels.k<? super Unit> r100, Continuation<? super Unit> r101) {
        return ((FlowKt__DelayKt$fixedPeriodTicker$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005b -> B:15:0x0040). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L11;
        if (r102 == 1) goto L7;
        if (r102 == 2) goto L10;
        if (r102 == 3) goto L7;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        kotlinx.coroutines.channels.k r103 = (kotlinx.coroutines.channels.k) this.L$0;
        ResultKt.throwOnFailure(r100);
        FlowKt__DelayKt$fixedPeriodTicker$1 r104 = this;
    L18:
        long r105 = r104.$delayMillis;
        r104.L$0 = r103;
        r104.label = 3;
        if (DelayKt.delay(r105, r104) == r101) goto L20;
    L15:
        SendChannel r106 = r103.getChannel();
        Unit r107 = Unit.INSTANCE;
        r104.L$0 = r103;
        r104.label = 2;
        if (r106.send(r107, r104) != r101) goto L18;
        return r101;
    L20:
        return r101;
    L7:
        r103 = (kotlinx.coroutines.channels.k) this.L$0;
        ResultKt.throwOnFailure(r100);
    L14:
        r104 = this;
        goto L15
    L11:
        ResultKt.throwOnFailure(r100);
        r103 = (kotlinx.coroutines.channels.k) this.L$0;
        long r108 = this.$delayMillis;
        this.L$0 = r103;
        this.label = 1;
        if (DelayKt.delay(r108, this) != r101) goto L14;
        return r101;
    }
}
