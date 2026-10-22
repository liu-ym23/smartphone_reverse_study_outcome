package io.ktor.client.engine;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class g implements CoroutineContext.Element {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f491646b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f491647a;

    public static final class a implements CoroutineContext.Key<g> {
        public a() {
        }
    }

    static {
        f491646b = new a();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return f491646b;
    }

    public g(CoroutineContext r100) {
        Intrinsics.checkNotNullParameter(r100, "callContext");
        this.f491647a = r100;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r100) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, r100);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> r100) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, r100);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r100) {
        return CoroutineContext.Element.DefaultImpls.plus(this, r100);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r100, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r101) {
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r100, r101);
    }
}
