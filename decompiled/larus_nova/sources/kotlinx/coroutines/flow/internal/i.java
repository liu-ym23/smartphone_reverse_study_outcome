package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
public final class i implements CoroutineContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f504886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f504887b;

    @Override // kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r100, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r101) {
        return (R) this.f504887b.fold(r100, r101);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r100) {
        return (E) this.f504887b.get(r100);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> r100) {
        return this.f504887b.minusKey(r100);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r100) {
        return this.f504887b.plus(r100);
    }

    public i(Throwable r100, CoroutineContext r101) {
        this.f504886a = r100;
        this.f504887b = r101;
    }
}
