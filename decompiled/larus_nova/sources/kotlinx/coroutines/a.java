package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> extends JobSupport implements Continuation<T>, CoroutineScope {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext f504616c;

    public void l0(Throwable r100, boolean r101) {
    }

    public void m0(T r100) {
    }

    @Override // kotlinx.coroutines.JobSupport
    public final String x() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // kotlinx.coroutines.JobSupport
    public String W() {
        return super.W();
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f504616c;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f504616c;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void O(CompletionHandlerException r100) {
        y.a(this.f504616c, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    public final void a0(Object r100) {
        if ((r100 instanceof t) == false) goto L9;
        t r101 = (t) r100;
        Throwable r102 = r101.f505148a;
        if (t.f505147b.get(r101) == 0) goto L7;
        boolean r103 = true;
    L8:
        l0(r102, r103);
        return;
    L7:
        r103 = false;
        goto L8
    L9:
        m0(r100);
    }

    public void k0(Object r100) {
        o(r100);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r100) {
        Throwable r101 = Result.m9452exceptionOrNullimpl(r100);
        if (r101 == null) goto L6;
        r100 = new t(r101, false);
    L6:
        Object r102 = V(r100);
        if (r102 != g1.f504913b) goto L9;
        return;
    L9:
        k0(r102);
    }

    public a(CoroutineContext r100, boolean r101, boolean r102) {
        super(r102);
        if (r101 == false) goto L5;
        P((Job) r100.get(Job.Key));
    L5:
        this.f504616c = r100.plus(this);
    }
}
