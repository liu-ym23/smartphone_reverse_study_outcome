package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public final class e1 extends kotlinx.coroutines.flow.internal.c<SharedFlowImpl<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f504847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kotlinx.coroutines.j f504848b;

    public e1() {
        this.f504847a = -1;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public final boolean a(kotlinx.coroutines.flow.internal.a r100) {
        SharedFlowImpl r101 = (SharedFlowImpl) r100;
        if (this.f504847a < 0) goto L5;
        return false;
    L5:
        long r102 = r101.f504813i;
        if (r102 >= r101.f504814j) goto L8;
        r101.f504814j = r102;
    L8:
        this.f504847a = r102;
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public final Continuation[] b(kotlinx.coroutines.flow.internal.a r100) {
        long r101 = this.f504847a;
        this.f504847a = -1;
        this.f504848b = null;
        return ((SharedFlowImpl) r100).r(r101);
    }
}
