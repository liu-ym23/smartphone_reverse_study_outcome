package kotlinx.coroutines.flow;

import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AbstractFlow<T> implements Flow<T> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.AbstractFlow$collect$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", i = {0}, l = {226}, m = ShareChannel.COLLECT, n = {"safeCollector"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AbstractFlow<T> this$0;

        public AnonymousClass1(AbstractFlow<T> r100, Continuation<? super AnonymousClass1> r101) {
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

    public AbstractFlow() {
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> r100, Continuation<? super Unit> r101) {
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
        SafeCollector r107 = (SafeCollector) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
    L26:
        r107.releaseIntercepted();
        return Unit.INSTANCE;
    L14:
        Throwable th10 = th;
    L30:
        r107.releaseIntercepted();
        throw th10;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        SafeCollector r108 = new SafeCollector(r100, r102.getContext());
        r102.L$0 = r108;     // Catch: Throwable -> L28
        r102.label = 1;     // Catch: Throwable -> L28
        Object r109 = ((c1) this).f504844a.invoke(r108, r102);     // Catch: Throwable -> L28
        if (r109 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        r109 = Unit.INSTANCE;     // Catch: Throwable -> L28
    L23:
        if (r109 != r105) goto L25;
        return r105;
    L25:
        r107 = r108;
    L28:
        th = move-exception;
        th10 = th;
        r107 = r108;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
