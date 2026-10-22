package kotlinx.coroutines.flow;

import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Flow f504764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3 f504765b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", f = "Errors.kt", i = {0, 0}, l = {112, 113}, m = ShareChannel.COLLECT, n = {"this", "$this$catch_u24lambda_u240"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 this$0;

        public AnonymousClass1(FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r100, Continuation r101) {
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

    public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(Flow r100, Function3 r101) {
        this.f504764a = r100;
        this.f504765b = r101;
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
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L26:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (FlowCollector) r102.L$1;
        FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r107 = (FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L20:
        Throwable r108 = (Throwable) r104;
        if (r108 == null) goto L26;
        Function3 r109 = r107.f504765b;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        InlineMarker.mark(6);
        Object r110 = r109.invoke(r100, r108, r102);
        InlineMarker.mark(7);
        if (r110 != r105) goto L26;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        Flow r111 = this.f504764a;
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 1;
        r104 = e.f(r111, r100, r102);
        if (r104 != r105) goto L19;
        return r105;
    L19:
        r107 = this;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
