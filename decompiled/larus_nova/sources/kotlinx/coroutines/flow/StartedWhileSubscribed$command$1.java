package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {174, 176, 178, 179, 181}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
public final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StartedWhileSubscribed this$0;

    public StartedWhileSubscribed$command$1(StartedWhileSubscribed r100, Continuation<? super StartedWhileSubscribed$command$1> r101) {
        this.this$0 = r100;
        super(3, r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super SharingCommand> r100, Integer r101, Continuation<? super Unit> r102) {
        return invoke(r100, r101.intValue(), r102);
    }

    public final Object invoke(FlowCollector<? super SharingCommand> r100, int r101, Continuation<? super Unit> r102) {
        StartedWhileSubscribed$command$1 r103 = new StartedWhileSubscribed$command$1(this.this$0, r102);
        r103.L$0 = r100;
        r103.I$0 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L16;
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L14;
        if (r101 == 3) goto L13;
        if (r101 == 4) goto L12;
        if (r101 == 5) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        FlowCollector r102 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r110);
    L32:
        SharingCommand r111 = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
        this.L$0 = null;
        this.label = 5;
        if (r102.emit(r111, this) != r100) goto L36;
        return r100;
    L36:
        return Unit.INSTANCE;
    L13:
        r102 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r110);
    L29:
        long r103 = this.this$0.f504827c;
        this.L$0 = r102;
        this.label = 4;
        if (DelayKt.delay(r103, this) != r100) goto L32;
        return r100;
    L14:
        r102 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r110);
    L25:
        if (this.this$0.f504827c <= 0) goto L32;
        SharingCommand r112 = SharingCommand.STOP;
        this.L$0 = r102;
        this.label = 3;
        if (r102.emit(r112, this) != r100) goto L29;
        return r100;
    L15:
        ResultKt.throwOnFailure(r110);
        goto L36
    L16:
        ResultKt.throwOnFailure(r110);
        r102 = (FlowCollector) this.L$0;
        if (this.I$0 <= 0) goto L21;
        SharingCommand r113 = SharingCommand.START;
        this.label = 1;
        if (r102.emit(r113, this) != r100) goto L36;
        return r100;
    L21:
        long r104 = this.this$0.f504826b;
        this.L$0 = r102;
        this.label = 2;
        if (DelayKt.delay(r104, this) != r100) goto L25;
        return r100;
    }
}
