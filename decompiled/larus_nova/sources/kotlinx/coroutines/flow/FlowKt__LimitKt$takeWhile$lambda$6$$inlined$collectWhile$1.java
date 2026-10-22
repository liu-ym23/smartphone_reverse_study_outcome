package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 implements FlowCollector<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f504785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f504786b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1", f = "Limit.kt", i = {0, 0, 1}, l = {139, 140}, m = "emit", n = {"this", "value", "this"}, s = {"L$0", "L$1", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 this$0;

        public AnonymousClass1(FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 r100, Continuation r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.emit(null, this);
        }
    }

    public FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1(Function2 r100, FlowCollector r101) {
        this.f504785a = r100;
        this.f504786b = r101;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 r108 = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L26:
        if (r107 == false) goto L30;
        return Unit.INSTANCE;
    L30:
        throw new AbortFlowException(r108);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Object r109 = r102.L$1;
        FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 r110 = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1) r102.L$0;
        ResultKt.throwOnFailure(r104);
        Object r111 = r109;
        r108 = r110;
        Object r112 = r104;
    L21:
        if (((Boolean) r112).booleanValue() == false) goto L25;
        FlowCollector r113 = r108.f504786b;
        r102.L$0 = r108;
        r102.L$1 = null;
        r102.label = 2;
        if (r113.emit(r111, r102) != r105) goto L26;
        return r105;
    L25:
        r107 = false;
        goto L26
    L16:
        ResultKt.throwOnFailure(r104);
        Function2 r114 = this.f504785a;
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 1;
        InlineMarker.mark(6);
        Object r115 = r114.invoke(r100, r102);
        InlineMarker.mark(7);
        if (r115 != r105) goto L19;
        return r105;
    L19:
        r112 = r115;
        r111 = r100;
        r108 = this;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
