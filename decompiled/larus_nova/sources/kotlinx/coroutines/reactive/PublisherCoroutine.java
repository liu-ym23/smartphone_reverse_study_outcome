package kotlinx.coroutines.reactive;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.selects.i;
import kotlinx.coroutines.selects.j;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes42.dex */
public final class PublisherCoroutine<T> extends kotlinx.coroutines.a<Unit> implements k<T>, wwc.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f505029d = null;
    private volatile /* synthetic */ long _nRequested$volatile;
    private volatile boolean cancelled;

    /* JADX INFO: renamed from: kotlinx.coroutines.reactive.PublisherCoroutine$send$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherCoroutine", f = "Publish.kt", i = {0, 0}, l = {128}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PublisherCoroutine<T> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(PublisherCoroutine<? super T> r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.send(null, this);
        }
    }

    static {
        f505029d = AtomicLongFieldUpdater.newUpdater(PublisherCoroutine.class, "_nRequested$volatile");
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel() {
        this.cancelled = true;
        cancel(null);
    }

    @Override // kotlinx.coroutines.channels.k
    public final SendChannel<T> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final i<T, SendChannel<T>> getOnSend() {
        PublisherCoroutine$onSend$1 r100 = PublisherCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r101 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r100, 3);
        PublisherCoroutine$onSend$2 r102 = PublisherCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new j(this, r101, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r102, 3));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return !isActive();
    }

    public final void s0() {
        throw null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable r100) {
        return s(r100);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1 r100) {
        throw new UnsupportedOperationException("PublisherCoroutine doesn't support invokeOnClose");
    }

    @Override // kotlinx.coroutines.a
    public final void m0(Unit r100) {
        r0(null, false);
    }

    public final Throwable n0(T r100) {
        if (r100 != null) goto L4;
        s0();
        throw new NullPointerException("Attempted to emit `null` inside a reactive publisher");
    L4:
        if (isActive() == true) goto L17;
        s0();
        return getCancellationException();
    L17:
        throw null;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.cancelled = true;
        boolean r101 = s(th);
        s0();
        if (r101 == false) goto L13;
        return th;
    L13:
        getContext();
        throw null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public final boolean offer(T r100) {
        return SendChannel.a.b(this, r100);
    }

    @Override // wwc.c
    public final void request(long r110) {
        if (r110 > 0) goto L6;
        s(new IllegalArgumentException("non-positive subscription request " + r110));
        return;
    L6:
        AtomicLongFieldUpdater r100 = f505029d;
        long r101 = r100.get(this);
        if (r101 < 0) goto L8;
        long r102 = r101 + r110;
        if (r102 >= 0) goto L12;
    L13:
        r102 = Long.MAX_VALUE;
    L15:
        if (r101 == r102) goto L16;
        if (r100.compareAndSet(this, r101, r102) == false) goto L6;
        if (r101 != 0) goto L26;
        s0();
        return;
    L26:
        return;
    L16:
        return;
    L12:
        if (r110 != Long.MAX_VALUE) goto L15;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo10962trySendJP2dKIU(T r100) {
        throw null;
    }

    @Override // kotlinx.coroutines.a
    public final void l0(Throwable r100, boolean r101) {
        r0(r100, r101);
    }

    public final void q0(Throwable r100, boolean r101) {
        AtomicLongFieldUpdater r102 = f505029d;     // Catch: Throwable -> L21
        if (r102.get(this) == (-2)) goto L20;
        r102.set(this, -2);     // Catch: Throwable -> L21
        if (this.cancelled == false) goto L13;
        if (r100 == null) goto L12;
        if (r101 == true) goto L25;
        getContext();     // Catch: Throwable -> L21
        throw null;     // Catch: Throwable -> L21
    L25:
        throw null;
    L12:
        throw null;
    L13:
        r100.getClass();
        throw null;     // Catch: Throwable -> L15
    L27:
        throw null;
    L15:
        th = move-exception;
        if (th == r100) goto L18;
        ExceptionsKt.addSuppressed(r100, th);     // Catch: Throwable -> L21
    L18:
        y.a(getContext(), r100);     // Catch: Throwable -> L21
        throw null;
    L26:
        throw null;
    L20:
        throw null;
    L21:
        throw null;
    }

    public final void r0(Throwable r100, boolean r101) {
    L2:
        AtomicLongFieldUpdater r102 = f505029d;
        long r103 = r102.get(this);
        if (r103 == (-2)) goto L4;
        if (r103 < 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L18;
        if (r102.compareAndSet(this, r103, -1) == false) goto L2;
        if (r103 != 0) goto L16;
        q0(r100, r101);
        throw null;
    L16:
        throw null;
    L18:
        throw new IllegalStateException("Check failed.".toString());
    L8:
        r104 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(T r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        Object r106 = r102.L$1;
        PublisherCoroutine r107 = (PublisherCoroutine) r102.L$0;
        ResultKt.throwOnFailure(r104);
        throw r107.n0(r106);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 1;
        throw null;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
