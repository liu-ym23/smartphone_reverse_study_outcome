package kotlinx.coroutines.stream;

import com.larus.bmhome.share.panel.ShareChannel;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes42.dex */
public final class StreamFlow<T> implements Flow<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f505123a = null;
    private volatile /* synthetic */ int consumed$volatile;

    /* JADX INFO: renamed from: kotlinx.coroutines.stream.StreamFlow$collect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.stream.StreamFlow", f = "Stream.kt", i = {0, 0}, l = {22}, m = ShareChannel.COLLECT, n = {"this", "collector"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StreamFlow<T> this$0;

        public AnonymousClass1(StreamFlow<T> r100, Continuation<? super AnonymousClass1> r101) {
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

    static {
        f505123a = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed$volatile");
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        if (r106 == 0) goto L22;
        if (r106 != 1) goto L21;
        Iterator r107 = (Iterator) r102.L$2;
        FlowCollector r108 = (FlowCollector) r102.L$1;
        StreamFlow<T> r109 = (StreamFlow) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L30
    L14:
        if (r107.hasNext() == false) goto L18;
        Object r110 = r107.next();     // Catch: Throwable -> L30
        r102.L$0 = r109;     // Catch: Throwable -> L30
        r102.L$1 = r108;     // Catch: Throwable -> L30
        r102.L$2 = r107;     // Catch: Throwable -> L30
        r102.label = 1;     // Catch: Throwable -> L30
        if (r108.emit(r110, r102) != r105) goto L14;
        return r105;
    L18:
        r109.getClass();
        throw null;
    L28:
        r109.getClass();
        throw null;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        ResultKt.throwOnFailure(r104);
        if (f505123a.compareAndSet(this, 0, 1) == false) goto L25;
        throw null;     // Catch: Throwable -> L27
    L27:
        r109 = this;
        goto L28
    L25:
        throw new IllegalStateException("Stream.consumeAsFlow can be collected only once".toString());
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
