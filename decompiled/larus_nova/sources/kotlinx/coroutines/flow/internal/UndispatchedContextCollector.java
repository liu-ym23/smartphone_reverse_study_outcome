package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes42.dex */
public final class UndispatchedContextCollector<T> implements FlowCollector<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f504874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f504875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<T, Continuation<? super Unit>, Object> f504876c;

    public UndispatchedContextCollector(FlowCollector<? super T> r100, CoroutineContext r101) {
        this.f504874a = r101;
        this.f504875b = ThreadContextKt.b(r101);
        this.f504876c = new UndispatchedContextCollector$emitRef$1(r100, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r100, Continuation<? super Unit> r101) {
        Object r102 = e.a(this.f504874a, r100, this.f504875b, this.f504876c, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}
