package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
public final class h1<T> extends e0<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Continuation<Unit> f504921d;

    @Override // kotlinx.coroutines.JobSupport
    public final void c0() {
        cuc.a.a(this.f504921d, this);
    }

    public h1(CoroutineContext r100, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r101) {
        super(r100, false);
        this.f504921d = IntrinsicsKt.createCoroutineUnintercepted(r101, this, this);
    }
}
