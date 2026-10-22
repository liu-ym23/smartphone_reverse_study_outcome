package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes42.dex */
public final class i1 extends r1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Continuation<Unit> f504923d;

    @Override // kotlinx.coroutines.JobSupport
    public final void c0() {
        cuc.a.a(this.f504923d, this);
    }

    public i1(CoroutineContext r100, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r101) {
        super(r100, false);
        this.f504923d = IntrinsicsKt.createCoroutineUnintercepted(r101, this, this);
    }
}
