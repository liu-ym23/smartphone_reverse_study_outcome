package kotlinx.coroutines.flow;

import com.larus.bmhome.share.panel.ShareChannel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3 implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f504748a;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3", f = "Builders.kt", i = {0}, l = {114}, m = ShareChannel.COLLECT, n = {"$this$asFlow_u24lambda_u243"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3 this$0;

        public AnonymousClass1(FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3 r100, Continuation r101) {
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

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3() {
        this.f504748a = null;
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
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        Iterator r107 = (Iterator) r102.L$1;
        FlowCollector r108 = (FlowCollector) r102.L$0;
        ResultKt.throwOnFailure(r104);
        FlowCollector r109 = r108;
    L16:
        if (r107.hasNext() == false) goto L21;
        Object r110 = r107.next();
        r102.L$0 = r109;
        r102.L$1 = r107;
        r102.label = 1;
        if (r109.emit(r110, r102) != r105) goto L16;
        return r105;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Iterator r111 = this.f504748a.iterator();
        r109 = r100;
        r107 = r111;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
