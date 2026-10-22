package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.u1;

/* JADX INFO: loaded from: classes42.dex */
public final class e0<T> implements u1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f504943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadLocal<T> f504944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f504945c;

    public final String toString() {
        return "ThreadLocal(value=" + this.f504943a + ", threadLocal = " + this.f504944b + ')';
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return this.f504945c;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r100) {
        if (Intrinsics.areEqual(this.f504945c, r100) == false) goto L5;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    L5:
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> r100) {
        if (Intrinsics.areEqual(this.f504945c, r100) == false) goto L6;
        return EmptyCoroutineContext.INSTANCE;
    L6:
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r100) {
        return CoroutineContext.Element.DefaultImpls.plus(this, r100);
    }

    @Override // kotlinx.coroutines.u1
    public final T updateThreadContext(CoroutineContext r100) {
        T r101 = this.f504944b.get();
        this.f504944b.set(this.f504943a);
        return r101;
    }

    public e0(T r100, ThreadLocal<T> r101) {
        this.f504943a = r100;
        this.f504944b = r101;
        this.f504945c = new f0(r101);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r100, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r101) {
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r100, r101);
    }

    @Override // kotlinx.coroutines.u1
    public final void restoreThreadContext(CoroutineContext r100, T r101) {
        this.f504944b.set(r101);
    }
}
