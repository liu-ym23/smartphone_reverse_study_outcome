package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class LazyActorCoroutine<E> extends a<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Continuation<? super Unit> f504671e;

    @Override // kotlinx.coroutines.JobSupport
    public final void c0() {
        cuc.a.a(this.f504671e, this);
    }

    @Override // kotlinx.coroutines.channels.f, kotlinx.coroutines.channels.SendChannel
    public final kotlinx.coroutines.selects.i<E, SendChannel<E>> getOnSend() {
        LazyActorCoroutine$onSend$1 r100 = LazyActorCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.j(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r100, 3), super.getOnSend().d());
    }

    @Override // kotlinx.coroutines.channels.f, kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable r100) {
        boolean r101 = super.close(r100);
        start();
        return r101;
    }

    @Override // kotlinx.coroutines.channels.f, kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public final boolean offer(E r100) {
        start();
        return super.offer(r100);
    }

    @Override // kotlinx.coroutines.channels.f, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo10962trySendJP2dKIU(E r100) {
        start();
        return super.mo10962trySendJP2dKIU(r100);
    }

    @Override // kotlinx.coroutines.channels.f, kotlinx.coroutines.channels.SendChannel
    public final Object send(E r100, Continuation<? super Unit> r101) {
        start();
        Object r102 = super.send(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public LazyActorCoroutine(CoroutineContext r100, Channel<E> r101, Function2<? super c<E>, ? super Continuation<? super Unit>, ? extends Object> r102) {
        super(r100, r101, false);
        this.f504671e = IntrinsicsKt.createCoroutineUnintercepted(r102, this, this);
    }

    public static final void n0(LazyActorCoroutine r100, kotlinx.coroutines.selects.l r101, Object r102) {
        r100.c0();
        super.getOnSend().b().invoke(r100, r101, r102);
    }
}
