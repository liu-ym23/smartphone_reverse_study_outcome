package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes6.dex */
public final class j<P, Q> implements i<P, Q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f505118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<Object, l<?>, Object, Unit> f505119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<Object, Object, Object, Object> f505120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function3<l<?>, Object, Object, Function1<Throwable, Unit>> f505121d;

    @Override // kotlinx.coroutines.selects.k
    public final Function3<Object, l<?>, Object, Unit> b() {
        return this.f505119b;
    }

    @Override // kotlinx.coroutines.selects.k
    public final Function3<Object, Object, Object, Object> d() {
        return this.f505120c;
    }

    public j(Object r100, Function3 r101, Function3 r102) {
        this.f505118a = r100;
        this.f505119b = r101;
        this.f505120c = r102;
        this.f505121d = null;
    }
}
