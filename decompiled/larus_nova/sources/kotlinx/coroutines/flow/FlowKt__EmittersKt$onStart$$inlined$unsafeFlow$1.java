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
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f504760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Flow f504761b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0}, l = {115, 119}, m = ShareChannel.COLLECT, n = {"this", "$this$onStart_u24lambda_u241", "safeCollector"}, s = {"L$0", "L$1", "L$2"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 this$0;

        public AnonymousClass1(FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r100, Continuation r101) {
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

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(Function2 r100, Flow r101) {
        this.f504760a = r100;
        this.f504761b = r101;
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
        if (r106 == 0) goto L20;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SafeCollector r107 = (SafeCollector) r102.L$2;
        FlowCollector<? super Object> r108 = (FlowCollector) r102.L$1;
        FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r109 = (FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L18
    L25:
        r107.releaseIntercepted();
        Flow r110 = r109.f504761b;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.label = 2;
        if (r110.collect(r108, r102) != r105) goto L29;
        return r105;
    L18:
        Throwable th10 = th;
    L32:
        r107.releaseIntercepted();
        throw th10;
    L20:
        ResultKt.throwOnFailure(r104);
        SafeCollector r111 = new SafeCollector(r100, r102.getContext());
        Function2 r112 = this.f504760a;     // Catch: Throwable -> L30
        r102.L$0 = this;     // Catch: Throwable -> L30
        r102.L$1 = r100;     // Catch: Throwable -> L30
        r102.L$2 = r111;     // Catch: Throwable -> L30
        r102.label = 1;     // Catch: Throwable -> L30
        InlineMarker.mark(6);     // Catch: Throwable -> L30
        Object r113 = r112.invoke(r111, r102);     // Catch: Throwable -> L30
        InlineMarker.mark(7);     // Catch: Throwable -> L30
        if (r113 != r105) goto L24;
        return r105;
    L24:
        r109 = this;
        r108 = r100;
        r107 = r111;
    L30:
        th = move-exception;
        th10 = th;
        r107 = r111;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
