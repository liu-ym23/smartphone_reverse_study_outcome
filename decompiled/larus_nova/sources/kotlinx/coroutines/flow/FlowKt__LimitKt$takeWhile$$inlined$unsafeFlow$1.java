package kotlinx.coroutines.flow;

import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Flow f504783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f504784b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1", f = "Limit.kt", i = {0}, l = {123}, m = ShareChannel.COLLECT, n = {"collector$iv"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 this$0;

        public AnonymousClass1(FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 r100, Continuation r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    public FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(Flow r100, Function2 r101) {
        this.f504783a = r100;
        this.f504784b = r101;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super Object> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 r107 = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: AbortFlowException -> L14
    L27:
        return Unit.INSTANCE;
    L14:
        e = e;
    L25:
        if (e.owner == r107) goto L27;
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        Flow r108 = this.f504783a;
        FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 r109 = new FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1(this.f504784b, r100);
        r102.L$0 = r109;     // Catch: AbortFlowException -> L22
        r102.label = 1;     // Catch: AbortFlowException -> L22
        if (r108.collect(r109, r102) != r105) goto L27;
        return r105;
    L22:
        e = e;
        r107 = r109;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
