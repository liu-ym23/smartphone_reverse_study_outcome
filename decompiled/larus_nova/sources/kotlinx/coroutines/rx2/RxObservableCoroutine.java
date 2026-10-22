package kotlinx.coroutines.rx2;

import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
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

/* JADX INFO: loaded from: classes42.dex */
public final class RxObservableCoroutine<T> extends kotlinx.coroutines.a<Unit> implements k<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f505052d = null;
    private volatile /* synthetic */ int _signal$volatile;

    /* JADX INFO: renamed from: kotlinx.coroutines.rx2.RxObservableCoroutine$send$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.rx2.RxObservableCoroutine", f = "RxObservable.kt", i = {0, 0}, l = {113}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RxObservableCoroutine<T> this$0;

        public AnonymousClass1(RxObservableCoroutine<T> r100, Continuation<? super AnonymousClass1> r101) {
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
        f505052d = AtomicIntegerFieldUpdater.newUpdater(RxObservableCoroutine.class, "_signal$volatile");
    }

    @Override // kotlinx.coroutines.channels.k
    public final SendChannel<T> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final i<T, SendChannel<T>> getOnSend() {
        RxObservableCoroutine$onSend$1 r100 = RxObservableCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r101 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r100, 3);
        RxObservableCoroutine$onSend$2 r102 = RxObservableCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new j(this, r101, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r102, 3));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return !isActive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable r100) {
        return s(r100);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1 r100) {
        throw new UnsupportedOperationException("RxObservableCoroutine doesn't support invokeOnClose");
    }

    @Override // kotlinx.coroutines.a
    public final void m0(Unit r100) {
        if (f505052d.compareAndSet(this, 0, -1) == true) goto L6;
        return;
    L6:
        throw null;
    }

    public final Throwable n0(T r100) {
        if (isActive() == true) goto L10;
        q0(D(), E());
        throw null;
    L10:
        throw null;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        s(new UndeliverableException(th));
        throw null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public final boolean offer(T r100) {
        return SendChannel.a.b(this, r100);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo10962trySendJP2dKIU(T r100) {
        throw null;
    }

    @Override // kotlinx.coroutines.a
    public final void l0(Throwable r100, boolean r101) {
        if (f505052d.compareAndSet(this, 0, -1) == true) goto L6;
        return;
    L6:
        throw null;
    }

    public final void q0(Throwable r100, boolean r101) {
        AtomicIntegerFieldUpdater r102 = f505052d;     // Catch: Throwable -> L23
        if (r102.get(this) == (-2)) goto L22;
        r102.set(this, -2);     // Catch: Throwable -> L23
        if (r100 == null) goto L8;
        Throwable r103 = r100;
    L9:
        r103.getClass();
        if ((r103 instanceof UndeliverableException) == false) goto L16;
        if (r101 == true) goto L16;
        b.a(r100, getContext());     // Catch: Throwable -> L23
        throw null;
    L16:
        if (r103 != getCancellationException()) goto L24;
        throw null;     // Catch: Throwable -> L23
    L24:
        throw null;     // Catch: Exception -> L19 Throwable -> L23
    L28:
        throw null;
    L19:
        e = move-exception;
        ExceptionsKt.addSuppressed(r100, e);     // Catch: Throwable -> L23
        b.a(r100, getContext());     // Catch: Throwable -> L23
        throw null;
    L23:
        throw null;
    L8:
        r103 = null;
        goto L9
    L22:
        throw null;
    L29:
        throw null;
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
        RxObservableCoroutine r107 = (RxObservableCoroutine) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r107.n0(r106);
        throw null;
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
