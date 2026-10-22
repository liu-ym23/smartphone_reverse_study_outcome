package kotlinx.coroutines.flow;

import android.util.EventsUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class FlowKt__ReduceKt$first$$inlined$collectWhile$2 implements FlowCollector<Object> {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ Ref$ObjectRef b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2", f = "Reduce.kt", i = {0, 0}, l = {139}, m = "emit", n = {"this", "it"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__ReduceKt$first$$inlined$collectWhile$2 this$0;

        public AnonymousClass1(FlowKt__ReduceKt$first$$inlined$collectWhile$2 r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.emit(null, this);
        }
    }

    public FlowKt__ReduceKt$first$$inlined$collectWhile$2(Function2 r1, Ref$ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Object r8 = r0.L$1;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2 r9 = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) r0.L$0;
        ResultKt.throwOnFailure(r7);
        T r10 = r8;
    L19:
        if (((Boolean) r7).booleanValue() == false) goto L21;
        r9.b.element = r10;
        r4 = false;
    L21:
        if (r4 == false) goto L25;
        return Unit.INSTANCE;
    L25:
        throw new AbortFlowException(r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        Function2 r11 = this.a;
        r0.L$0 = this;
        r0.L$1 = r5;
        r0.label = 1;
        InlineMarker.mark(6);
        r7 = r11.invoke(r5, r0);
        InlineMarker.mark(7);
        if (r7 != r2) goto L17;
        return r2;
    L17:
        r9 = this;
        r10 = r5;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }
}
