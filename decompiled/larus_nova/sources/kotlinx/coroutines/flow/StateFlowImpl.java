package kotlinx.coroutines.flow;

import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes.dex */
public final class StateFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<k1> implements z0<T>, Flow, kotlinx.coroutines.flow.internal.l<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504828f = null;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f504829e;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {384, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE, 401}, m = ShareChannel.COLLECT, n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newState", "this", "collector", "slot", "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StateFlowImpl<T> this$0;

        public AnonymousClass1(StateFlowImpl<T> r100, Continuation<? super AnonymousClass1> r101) {
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
        f504828f = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final kotlinx.coroutines.flow.internal.c[] d() {
        return new k1[2];
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final kotlinx.coroutines.flow.internal.c c() {
        return new k1();
    }

    @Override // kotlinx.coroutines.flow.z0, kotlinx.coroutines.flow.i1
    public final T getValue() {
        kotlinx.coroutines.internal.b0 r100 = kotlinx.coroutines.flow.internal.o.f504892a;
        T r101 = (T) f504828f.get(this);
        if (r101 != r100) goto L6;
        return null;
    L6:
        return r101;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.MutableSharedFlow
    public final List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    public StateFlowImpl(Object r100) {
        this._state$volatile = r100;
    }

    @Override // kotlinx.coroutines.flow.z0
    public final void setValue(T r100) {
        if (r100 != null) goto L4;
        r100 = (T) kotlinx.coroutines.flow.internal.o.f504892a;
    L4:
        f(null, r100);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final boolean tryEmit(T r100) {
        setValue(r100);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00f8 -> B:34:0x00a6). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> r110, Continuation<?> r111) {
        if ((r111 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r100 = (AnonymousClass1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L26;
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L18;
        if (r103 != 3) goto L17;
        Object r113 = r100.L$4;
        Job r104 = (Job) r100.L$3;
        k1 r105 = (k1) r100.L$2;
        FlowCollector r106 = (FlowCollector) r100.L$1;
        StateFlowImpl<T> r107 = (StateFlowImpl) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L24
    L34:
        Object r114 = f504828f.get(r107);     // Catch: Throwable -> L24
        if (r104 == null) goto L37;
        JobKt.ensureActive(r104);     // Catch: Throwable -> L24
    L37:
        if (r113 == null) goto L41;
        r106 = r106;
        if (Intrinsics.areEqual(r113, r114) == false) goto L41;
    L48:
        Object r115 = r105.f504900a.getAndSet(j1.f504898a);     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r115);     // Catch: Throwable -> L24
        if (r115 != j1.f504899b) goto L64;
        if (1 != 0) goto L34;
        r100.L$0 = r107;     // Catch: Throwable -> L24
        r100.L$1 = r106;     // Catch: Throwable -> L24
        r100.L$2 = r105;     // Catch: Throwable -> L24
        r100.L$3 = r104;     // Catch: Throwable -> L24
        r100.L$4 = r113;     // Catch: Throwable -> L24
        r100.label = 3;     // Catch: Throwable -> L24
        if (r105.c(r100) != r102) goto L34;
        return r102;
    L64:
        if (0 != 0) goto L34;
    L41:
        if (r114 != kotlinx.coroutines.flow.internal.o.f504892a) goto L43;
        Object r116 = null;
    L44:
        r100.L$0 = r107;     // Catch: Throwable -> L24
        r100.L$1 = r106;     // Catch: Throwable -> L24
        r100.L$2 = r105;     // Catch: Throwable -> L24
        r100.L$3 = r104;     // Catch: Throwable -> L24
        r100.L$4 = r114;     // Catch: Throwable -> L24
        r100.label = 2;     // Catch: Throwable -> L24
        if (r106.emit(r116, r100) != r102) goto L47;
        return r102;
    L47:
        r113 = r114;
        r106 = r106;
        goto L48
    L43:
        r116 = r114;
        goto L44
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r113 = r100.L$4;
        r104 = (Job) r100.L$3;
        r105 = (k1) r100.L$2;
        FlowCollector r108 = (FlowCollector) r100.L$1;
        r107 = (StateFlowImpl) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L24
        r106 = r108;
        goto L48
    L21:
        r105 = (k1) r100.L$2;
        r110 = (FlowCollector) r100.L$1;
        r107 = (StateFlowImpl) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L24
    L33:
        r106 = r110;
        r104 = (Job) r100.getContext().get(Job.Key);     // Catch: Throwable -> L24
        r113 = null;
        goto L34
    L26:
        ResultKt.throwOnFailure(r112);
        r105 = b();
    L56:
        th = th;
        r107 = this;
    L58:
        r107.e(r105);
        throw th;
    L28:
        if ((r110 instanceof SubscribedFlowCollector) == false) goto L32;
        r100.L$0 = this;     // Catch: Throwable -> L56
        r100.L$1 = r110;     // Catch: Throwable -> L56
        r100.L$2 = r105;     // Catch: Throwable -> L56
        r100.label = 1;     // Catch: Throwable -> L56
        if (((SubscribedFlowCollector) r110).a(r100) != r102) goto L32;
        return r102;
    L32:
        r107 = this;
    L24:
        th = th;
    L7:
        r100 = new AnonymousClass1(this, r111);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.z0
    public final boolean compareAndSet(T r100, T r101) {
        if (r100 != null) goto L4;
        r100 = (T) kotlinx.coroutines.flow.internal.o.f504892a;
    L4:
        if (r101 != null) goto L7;
        r101 = (T) kotlinx.coroutines.flow.internal.o.f504892a;
    L7:
        return f(r100, r101);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r100, Continuation<? super Unit> r101) {
        setValue(r100);
        return Unit.INSTANCE;
    }

    public final boolean f(Object r110, Object r111) {
        monitor-enter(this);
        AtomicReferenceFieldUpdater r100 = f504828f;     // Catch: Throwable -> L68
        Object r101 = r100.get(this);     // Catch: Throwable -> L68
        if (r110 == null) goto L11;
        if (Intrinsics.areEqual(r101, r110) == true) goto L11;
        monitor-exit(this);
        return false;
    L11:
        if (Intrinsics.areEqual(r101, r111) == false) goto L14;
        monitor-exit(this);
        return true;
    L14:
        r100.set(this, r111);     // Catch: Throwable -> L68
        int r112 = this.f504829e;     // Catch: Throwable -> L68
        if ((r112 & 1) != 0) goto L65;
        int r113 = r112 + 1;     // Catch: Throwable -> L68
        this.f504829e = r113;     // Catch: Throwable -> L68
        Object r114 = this.f504877a;     // Catch: Throwable -> L68
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L68
        monitor-exit(this);
    L18:
        k1[] r115 = (k1[]) r114;
        if (r115 == null) goto L52;
        int r103 = r115.length;
        int r104 = 0;
    L21:
        if (r104 >= r103) goto L52;
        k1 r105 = r115[r104];
        if (r105 == null) goto L51;
        AtomicReference<Object> r106 = r105.f504900a;
    L25:
        Object r107 = r106.get();
        if (r107 == null) goto L51;
        kotlinx.coroutines.internal.b0 r108 = j1.f504899b;
        if (r107 == r108) goto L51;
        kotlinx.coroutines.internal.b0 r109 = j1.f504898a;
        if (r107 == r109) goto L33;
        AtomicReference<Object> r116 = r105.f504900a;
    L44:
        if (r116.compareAndSet(r107, r109) == true) goto L45;
        if (r116.get() == r107) goto L44;
        boolean r117 = false;
    L49:
        if (r117 == false) goto L25;
        Result.Companion r118 = Result.Companion;
        ((kotlinx.coroutines.j) r107).resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        goto L51
    L45:
        r117 = true;
        goto L49
    L33:
        AtomicReference<Object> r119 = r105.f504900a;
    L35:
        if (r119.compareAndSet(r107, r108) == true) goto L36;
        if (r119.get() == r107) goto L35;
        boolean r120 = false;
    L40:
        if (r120 == false) goto L25;
    L36:
        r120 = true;
    L51:
        r104 = r104 + 1;
    L52:
        monitor-enter(this);
        int r121 = this.f504829e;     // Catch: Throwable -> L61
        if (r121 == r113) goto L55;
        Object r122 = this.f504877a;     // Catch: Throwable -> L61
        Unit r123 = Unit.INSTANCE;     // Catch: Throwable -> L61
        monitor-exit(this);
        r114 = r122;
        r113 = r121;
        goto L18
    L55:
        this.f504829e = r113 + 1;     // Catch: Throwable -> L61
        monitor-exit(this);
        return true;
    L61:
        th = move-exception;
        throw th;
    L65:
        this.f504829e = r112 + 2;     // Catch: Throwable -> L68
        monitor-exit(this);
        return true;
    L68:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.internal.l
    public final Flow<T> a(CoroutineContext r100, int r101, BufferOverflow r102) {
        kotlinx.coroutines.internal.b0 r103 = j1.f504898a;
        if (r101 >= 0) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L12;
        if (r101 == (-2)) goto L12;
    L15:
        return SharedFlowKt.fuseSharedFlow(this, r100, r101, r102);
    L12:
        if (r102 != BufferOverflow.DROP_OLDEST) goto L15;
        return this;
    L5:
        if (r101 >= 2) goto L7;
        r104 = true;
        goto L8
    }
}
