package kotlinx.coroutines.flow;

import com.larus.bmhome.share.panel.ShareChannel;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes42.dex */
public final class SubscribedSharedFlow<T> implements d1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d1<T> f504832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> f504833b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedSharedFlow", f = "Share.kt", i = {}, l = {405}, m = ShareChannel.COLLECT, n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SubscribedSharedFlow<T> this$0;

        public AnonymousClass1(SubscribedSharedFlow<T> r100, Continuation<? super AnonymousClass1> r101) {
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

    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.MutableSharedFlow
    public final List<T> getReplayCache() {
        return this.f504832a.getReplayCache();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedSharedFlow(d1<? extends T> r100, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> r101) {
        this.f504832a = r100;
        this.f504833b = r101;
    }

    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> r100, Continuation<?> r101) {
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
        if (r106 != 1) goto L12;
        ResultKt.throwOnFailure(r104);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        d1<T> r107 = this.f504832a;
        SubscribedFlowCollector r108 = new SubscribedFlowCollector(r100, this.f504833b);
        r102.label = 1;
        if (r107.collect(r108, r102) != r105) goto L18;
        return r105;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
