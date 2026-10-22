package jha;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes33.dex */
public final class b implements CoroutineContext.Element {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f499120a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f499121b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ThreadLocal<Boolean> f499122c = null;

    public static final class a implements CoroutineContext.Key<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f499123a = null;

        static {
            f499123a = new a();
        }

        public a() {
        }
    }

    public b() {
    }

    static {
        f499120a = new b();
        f499121b = a.f499123a;
        f499122c = new ThreadLocal();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return f499121b;
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
