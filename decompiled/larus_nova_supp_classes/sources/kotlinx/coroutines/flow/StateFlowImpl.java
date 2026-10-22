package kotlinx.coroutines.flow;

import android.util.EventsUtils;
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
import kotlinx.coroutines.flow.internal.a;
import kotlinx.coroutines.flow.internal.c;
import kotlinx.coroutines.flow.internal.l;
import kotlinx.coroutines.flow.internal.o;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class StateFlowImpl<T> extends a<k1> implements z0<T>, Flow, l<T> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = null;
    private volatile /* synthetic */ Object _state$volatile;
    public int e;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {384, 396, 401}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newState", "this", "collector", "slot", "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StateFlowImpl<T> this$0;

        public AnonymousClass1(StateFlowImpl<T> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    static {
        f = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final c[] d() {
        return new k1[2];
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final c c() {
        return new k1();
    }

    @Override // kotlinx.coroutines.flow.z0, kotlinx.coroutines.flow.i1
    public final T getValue() {
        b0 r0 = o.a;
        T r1 = (T) f.get(this);
        if (r1 != r0) goto L6;
        return null;
    L6:
        return r1;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.d1
    public final List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    public StateFlowImpl(Object r1) {
        this._state$volatile = r1;
    }

    @Override // kotlinx.coroutines.flow.z0
    public final void setValue(T r2) {
        if (r2 != null) goto L4;
        r2 = (T) o.a;
    L4:
        f(null, r2);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final boolean tryEmit(T r1) {
        setValue(r1);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00f8 -> B:34:0x00a6). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> r12, Continuation<?> r13) {
        if ((r13 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L18;
        if (r3 != 3) goto L17;
        Object r15 = r0.L$4;
        Job r4 = (Job) r0.L$3;
        k1 r7 = (k1) r0.L$2;
        FlowCollector r8 = (FlowCollector) r0.L$1;
        StateFlowImpl<T> r9 = (StateFlowImpl) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L24
    L34:
        Object r16 = f.get(r9);     // Catch: Throwable -> L24
        if (r4 == null) goto L37;
        JobKt.ensureActive(r4);     // Catch: Throwable -> L24
    L37:
        if (r15 == null) goto L41;
        r8 = r8;
        if (Intrinsics.areEqual(r15, r16) == false) goto L41;
    L48:
        Object r17 = r7.a.getAndSet(j1.a);     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L24
        if (r17 != j1.b) goto L64;
        if (1 != 0) goto L34;
        r0.L$0 = r9;     // Catch: Throwable -> L24
        r0.L$1 = r8;     // Catch: Throwable -> L24
        r0.L$2 = r7;     // Catch: Throwable -> L24
        r0.L$3 = r4;     // Catch: Throwable -> L24
        r0.L$4 = r15;     // Catch: Throwable -> L24
        r0.label = 3;     // Catch: Throwable -> L24
        if (r7.c(r0) != r2) goto L34;
        return r2;
    L64:
        if (0 != 0) goto L34;
    L41:
        if (r16 != o.a) goto L43;
        Object r18 = null;
    L44:
        r0.L$0 = r9;     // Catch: Throwable -> L24
        r0.L$1 = r8;     // Catch: Throwable -> L24
        r0.L$2 = r7;     // Catch: Throwable -> L24
        r0.L$3 = r4;     // Catch: Throwable -> L24
        r0.L$4 = r16;     // Catch: Throwable -> L24
        r0.label = 2;     // Catch: Throwable -> L24
        if (r8.emit(r18, r0) != r2) goto L47;
        return r2;
    L47:
        r15 = r16;
        r8 = r8;
        goto L48
    L43:
        r18 = r16;
        goto L44
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r15 = r0.L$4;
        r4 = (Job) r0.L$3;
        r7 = (k1) r0.L$2;
        FlowCollector r10 = (FlowCollector) r0.L$1;
        r9 = (StateFlowImpl) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L24
        r8 = r10;
        goto L48
    L21:
        r7 = (k1) r0.L$2;
        r12 = (FlowCollector) r0.L$1;
        r9 = (StateFlowImpl) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L24
    L33:
        r8 = r12;
        r4 = (Job) r0.getContext().get(Job.Key);     // Catch: Throwable -> L24
        r15 = null;
        goto L34
    L26:
        ResultKt.throwOnFailure(r14);
        r7 = b();
    L56:
        th = th;
        r9 = this;
    L58:
        r9.e(r7);
        throw th;
    L28:
        if ((r12 instanceof SubscribedFlowCollector) == false) goto L32;
        r0.L$0 = this;     // Catch: Throwable -> L56
        r0.L$1 = r12;     // Catch: Throwable -> L56
        r0.L$2 = r7;     // Catch: Throwable -> L56
        r0.label = 1;     // Catch: Throwable -> L56
        if (((SubscribedFlowCollector) r12).a(r0) != r2) goto L32;
        return r2;
    L32:
        r9 = this;
    L24:
        th = th;
    L7:
        r0 = new AnonymousClass1(this, r13);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.z0
    public final boolean compareAndSet(T r1, T r2) {
        if (r1 != null) goto L4;
        r1 = (T) o.a;
    L4:
        if (r2 != null) goto L7;
        r2 = (T) o.a;
    L7:
        return f(r1, r2);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r1, Continuation<? super Unit> r2) {
        setValue(r1);
        return Unit.INSTANCE;
    }

    public final boolean f(Object r12, Object r13) {
        monitor-enter(this);
        AtomicReferenceFieldUpdater r0 = f;     // Catch: Throwable -> L68
        Object r1 = r0.get(this);     // Catch: Throwable -> L68
        if (r12 == null) goto L11;
        if (Intrinsics.areEqual(r1, r12) == true) goto L11;
        monitor-exit(this);
        return false;
    L11:
        if (Intrinsics.areEqual(r1, r13) == false) goto L14;
        monitor-exit(this);
        return true;
    L14:
        r0.set(this, r13);     // Catch: Throwable -> L68
        int r14 = this.e;     // Catch: Throwable -> L68
        if ((r14 & 1) != 0) goto L65;
        int r15 = r14 + 1;     // Catch: Throwable -> L68
        this.e = r15;     // Catch: Throwable -> L68
        Object r16 = this.a;     // Catch: Throwable -> L68
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L68
        monitor-exit(this);
    L18:
        k1[] r17 = (k1[]) r16;
        if (r17 == null) goto L52;
        int r3 = r17.length;
        int r4 = 0;
    L21:
        if (r4 >= r3) goto L52;
        k1 r5 = r17[r4];
        if (r5 == null) goto L51;
        AtomicReference<Object> r6 = r5.a;
    L25:
        Object r7 = r6.get();
        if (r7 == null) goto L51;
        b0 r8 = j1.b;
        if (r7 == r8) goto L51;
        b0 r9 = j1.a;
        if (r7 == r9) goto L33;
        AtomicReference<Object> r10 = r5.a;
    L44:
        if (r10.compareAndSet(r7, r9) == true) goto L45;
        if (r10.get() == r7) goto L44;
        boolean r11 = false;
    L49:
        if (r11 == false) goto L25;
        Result.Companion r18 = Result.Companion;
        ((j) r7).resumeWith(Result.m49constructorimpl(Unit.INSTANCE));
        goto L51
    L45:
        r11 = true;
        goto L49
    L33:
        AtomicReference<Object> r19 = r5.a;
    L35:
        if (r19.compareAndSet(r7, r8) == true) goto L36;
        if (r19.get() == r7) goto L35;
        boolean r20 = false;
    L40:
        if (r20 == false) goto L25;
    L36:
        r20 = true;
    L51:
        r4 = r4 + 1;
    L52:
        monitor-enter(this);
        int r110 = this.e;     // Catch: Throwable -> L61
        if (r110 == r15) goto L55;
        Object r111 = this.a;     // Catch: Throwable -> L61
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L61
        monitor-exit(this);
        r16 = r111;
        r15 = r110;
        goto L18
    L55:
        this.e = r15 + 1;     // Catch: Throwable -> L61
        monitor-exit(this);
        return true;
    L61:
        th = move-exception;
        throw th;
    L65:
        this.e = r14 + 2;     // Catch: Throwable -> L68
        monitor-exit(this);
        return true;
    L68:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.internal.l
    public final Flow<T> a(CoroutineContext r2, int r3, BufferOverflow r4) {
        b0 r0 = j1.a;
        if (r3 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L12;
        if (r3 == (-2)) goto L12;
    L15:
        return SharedFlowKt.fuseSharedFlow(this, r2, r3, r4);
    L12:
        if (r4 != BufferOverflow.DROP_OLDEST) goto L15;
        return this;
    L5:
        if (r3 >= 2) goto L7;
        r1 = true;
        goto L8
    }
}
