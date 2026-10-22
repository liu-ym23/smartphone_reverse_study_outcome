package kotlinx.coroutines.flow;

import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Flow f504754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3 f504755b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 1, 2}, l = {113, 120, 127}, m = ShareChannel.COLLECT, n = {"this", "$this$onCompletion_u24lambda_u242", "e", SRStrategy.KEY_SR_STRATEGY_CONFIG}, s = {"L$0", "L$1", "L$0", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 this$0;

        public AnonymousClass1(FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r100, Continuation r101) {
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

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow r100, Function3 r101) {
        this.f504754a = r100;
        this.f504755b = r101;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super Object> r100, Continuation<? super Unit> r110) {
        if ((r110 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r101 = (AnonymousClass1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L26;
        if (r104 == 1) goto L21;
        if (r104 == 2) goto L20;
        if (r104 != 3) goto L19;
        SafeCollector r105 = (SafeCollector) r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L16
    L36:
        r105.releaseIntercepted();
        return Unit.INSTANCE;
    L16:
        Throwable th10 = th;
    L40:
        r105.releaseIntercepted();
        throw th10;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        Throwable r106 = (Throwable) r101.L$0;
        ResultKt.throwOnFailure(r111);
        throw r106;
    L21:
        r100 = (FlowCollector) r101.L$1;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r107 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L24
    L31:
        SafeCollector r112 = new SafeCollector(r100, r101.getContext());
        Function3 r108 = r107.f504755b;     // Catch: Throwable -> L38
        r101.L$0 = r112;     // Catch: Throwable -> L38
        r101.L$1 = null;     // Catch: Throwable -> L38
        r101.label = 3;     // Catch: Throwable -> L38
        InlineMarker.mark(6);     // Catch: Throwable -> L38
        Object r109 = r108.invoke(r112, null, r101);     // Catch: Throwable -> L38
        InlineMarker.mark(7);     // Catch: Throwable -> L38
        if (r109 != r103) goto L35;
        return r103;
    L35:
        r105 = r112;
    L38:
        th = move-exception;
        th10 = th;
        r105 = r112;
    L24:
        th = th;
    L44:
        l1 r113 = new l1(th);
        Function3 r114 = r107.f504755b;
        r101.L$0 = th;
        r101.L$1 = null;
        r101.label = 2;
        if (u.a(r113, r114, th, r101) != r103) goto L56;
        return r103;
    L56:
        throw th;
    L26:
        ResultKt.throwOnFailure(r111);
        Flow r115 = this.f504754a;     // Catch: Throwable -> L42
        r101.L$0 = this;     // Catch: Throwable -> L42
        r101.L$1 = r100;     // Catch: Throwable -> L42
        r101.label = 1;     // Catch: Throwable -> L42
        if (r115.collect(r100, r101) != r103) goto L30;
        return r103;
    L30:
        r107 = this;
    L42:
        th = th;
        r107 = this;
    L7:
        r101 = new AnonymousClass1(this, r110);
        goto L8
    }
}
