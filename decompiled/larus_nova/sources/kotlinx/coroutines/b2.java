package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes5.dex */
public final class b2<T> extends kotlinx.coroutines.internal.x<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ThreadLocal<Pair<CoroutineContext, Object>> f504633e;
    private volatile boolean threadLocalIsSet;

    public final boolean n0() {
        if (this.threadLocalIsSet == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        this.f504633e.remove();
        return !r100;
    L5:
        if (this.f504633e.get() != null) goto L7;
        r100 = true;
        goto L8
    }

    @Override // kotlinx.coroutines.internal.x, kotlinx.coroutines.a
    public final void k0(Object r100) {
        if (this.threadLocalIsSet == false) goto L8;
        Pair<CoroutineContext, Object> r101 = this.f504633e.get();
        if (r101 == null) goto L7;
        ThreadContextKt.a(r101.component1(), r101.component2());
    L7:
        this.f504633e.remove();
    L8:
        Object r102 = v.a(r100);
        Continuation<T> r103 = this.f504982d;
        CoroutineContext r104 = r103.getContext();
        b2<?> r105 = null;
        Object r106 = ThreadContextKt.c(r104, null);
        if (r106 == ThreadContextKt.f504930a) goto L23;
        r105 = CoroutineContextKt.d(r103, r104, r106);
    L23:
        this.f504982d.resumeWith(r102);     // Catch: Throwable -> L17
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L17
        if (r105 != null) goto L14;
    L15:
        ThreadContextKt.a(r104, r106);
        return;
    L14:
        if (r105.n0() == true) goto L15;
        return;
    L17:
        th = move-exception;
        if (r105 != null) goto L20;
    L21:
        ThreadContextKt.a(r104, r106);
    L22:
        throw th;
    L20:
        if (r105.n0() == false) goto L22;
        goto L21
    }

    public b2(CoroutineContext r100, Continuation<? super T> r101) {
        c2 r102 = c2.f504644a;
        if (r100.get(r102) != null) goto L5;
        CoroutineContext r103 = r100.plus(r102);
    L6:
        super(r103, r101);
        this.f504633e = new ThreadLocal();
        if ((r101.getContext().get(ContinuationInterceptor.Key) instanceof CoroutineDispatcher) == true) goto L10;
        Object r104 = ThreadContextKt.c(r100, null);
        ThreadContextKt.a(r100, r104);
        q0(r100, r104);
        return;
    L10:
        return;
    L5:
        r103 = r100;
        goto L6
    }

    public final void q0(CoroutineContext r100, Object r101) {
        this.threadLocalIsSet = true;
        this.f504633e.set(TuplesKt.to(r100, r101));
    }
}
