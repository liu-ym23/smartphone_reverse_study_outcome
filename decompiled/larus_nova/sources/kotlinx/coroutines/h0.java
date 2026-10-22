package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class h0<T> extends kotlinx.coroutines.internal.x<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f504920e = null;
    private volatile /* synthetic */ int _decision$volatile;

    static {
        f504920e = AtomicIntegerFieldUpdater.newUpdater(h0.class, "_decision$volatile");
    }

    @Override // kotlinx.coroutines.internal.x, kotlinx.coroutines.a
    public final void k0(Object r100) {
        AtomicIntegerFieldUpdater r101 = f504920e;
    L3:
        int r102 = r101.get(this);
        boolean r103 = true;
        if (r102 != 0) goto L5;
        if (f504920e.compareAndSet(this, 0, 2) == false) goto L3;
    L11:
        if (r103 == false) goto L13;
        return;
    L13:
        kotlinx.coroutines.internal.j.a(IntrinsicsKt.intercepted(this.f504982d), v.a(r100), null);
        return;
    L5:
        if (r102 != 1) goto L8;
        r103 = false;
        goto L11
    L8:
        throw new IllegalStateException("Already resumed".toString());
    }

    @Override // kotlinx.coroutines.internal.x, kotlinx.coroutines.JobSupport
    public final void o(Object r100) {
        k0(r100);
    }

    public h0(CoroutineContext r100, Continuation<? super T> r101) {
        super(r100, r101);
    }
}
