package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class a<T> extends JobSupport implements Continuation<T>, CoroutineScope {
    public final CoroutineContext c;

    public void l0(Throwable r1, boolean r2) {
    }

    public void m0(T r1) {
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
        return this.c;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.c;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void O(CompletionHandlerException r2) {
        y.a(this.c, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    public final void a0(Object r3) {
        if ((r3 instanceof t) == false) goto L9;
        t r4 = (t) r3;
        Throwable r0 = r4.a;
        if (t.b.get(r4) == 0) goto L7;
        boolean r5 = true;
    L8:
        l0(r0, r5);
        return;
    L7:
        r5 = false;
        goto L8
    L9:
        m0(r3);
    }

    public void k0(Object r1) {
        o(r1);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r3) {
        Throwable r0 = Result.m52exceptionOrNullimpl(r3);
        if (r0 == null) goto L6;
        r3 = new t(r0, false);
    L6:
        Object r4 = V(r3);
        if (r4 != g1.b) goto L9;
        return;
    L9:
        k0(r4);
    }

    public a(CoroutineContext r1, boolean r2, boolean r3) {
        super(r3);
        if (r2 == false) goto L5;
        P((Job) r1.get(Job.Key));
    L5:
        this.c = r1.plus(this);
    }
}
