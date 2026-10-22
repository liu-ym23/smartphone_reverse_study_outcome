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
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Flow f504756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f504757b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0, 1}, l = {113, 121}, m = ShareChannel.COLLECT, n = {"this", "$this$onEmpty_u24lambda_u243", "isEmpty", "collector"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 this$0;

        public AnonymousClass1(FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 r100, Continuation r101) {
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

    public FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r100, Function2 r101) {
        this.f504756a = r100;
        this.f504757b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v7, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
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
        if (r106 == 0) goto L20;
        if (r106 == 1) goto L19;
        if (r106 != 2) goto L18;
        SafeCollector r107 = (SafeCollector) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L15
        r100 = r107;
    L30:
        r100.releaseIntercepted();
    L34:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Ref.BooleanRef r108 = (Ref.BooleanRef) r102.L$2;
        FlowCollector r109 = (FlowCollector) r102.L$1;
        FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 r110 = (FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1) r102.L$0;
        ResultKt.throwOnFailure(r104);
        ?? r111 = r109;
    L25:
        if (r108.element == false) goto L34;
        SafeCollector r112 = new SafeCollector(r111, r102.getContext());
        Function2 r113 = r110.f504757b;     // Catch: Throwable -> L15
        r102.L$0 = r112;     // Catch: Throwable -> L15
        r102.L$1 = null;     // Catch: Throwable -> L15
        r102.L$2 = null;     // Catch: Throwable -> L15
        r102.label = 2;     // Catch: Throwable -> L15
        InlineMarker.mark(6);     // Catch: Throwable -> L15
        Object r114 = r113.invoke(r112, r102);     // Catch: Throwable -> L15
        InlineMarker.mark(7);     // Catch: Throwable -> L15
        r100 = r112;
        if (r114 != r105) goto L30;
        return r105;
    L20:
        ResultKt.throwOnFailure(r104);
        Ref.BooleanRef r115 = new Ref.BooleanRef();
        r115.element = true;
        Flow r116 = this.f504756a;
        FlowKt__EmittersKt$onEmpty$1$1 r117 = new FlowKt__EmittersKt$onEmpty$1$1(r115, r100);
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.L$2 = r115;
        r102.label = 1;
        if (r116.collect(r117, r102) != r105) goto L23;
        return r105;
    L23:
        r110 = this;
        r111 = r100;
        r108 = r115;
    L15:
        th = move-exception;
        r100.releaseIntercepted();
        throw th;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
