package kotlinx.coroutines.flow;

import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__LimitKt$take$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Flow f504777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f504778b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1", f = "Limit.kt", i = {0}, l = {115}, m = ShareChannel.COLLECT, n = {"ownershipMarker"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__LimitKt$take$$inlined$unsafeFlow$1 this$0;

        public AnonymousClass1(FlowKt__LimitKt$take$$inlined$unsafeFlow$1 r100, Continuation r101) {
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

    public FlowKt__LimitKt$take$$inlined$unsafeFlow$1(Flow r100) {
        this.f504777a = r100;
        this.f504778b = 1;
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
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        Object r105 = r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: AbortFlowException -> L14
    L27:
        return Unit.INSTANCE;
    L14:
        AbortFlowException e100 = e;
    L25:
        if (e100.owner == r105) goto L27;
        throw e100;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        Object r112 = new Object();
        Ref.IntRef r106 = new Ref.IntRef();
        Flow r107 = this.f504777a;     // Catch: AbortFlowException -> L22
        FlowKt__LimitKt$take$2$1 r108 = new FlowKt__LimitKt$take$2$1(r106, this.f504778b, r100, r112);     // Catch: AbortFlowException -> L22
        r101.L$0 = r112;     // Catch: AbortFlowException -> L22
        r101.label = 1;     // Catch: AbortFlowException -> L22
        if (r107.collect(r108, r101) != r103) goto L27;
        return r103;
    L22:
        e = move-exception;
        e100 = e;
        r105 = r112;
    L7:
        r101 = new AnonymousClass1(this, r110);
        goto L8
    }
}
