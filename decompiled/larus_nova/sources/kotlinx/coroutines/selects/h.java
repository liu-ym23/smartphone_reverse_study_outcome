package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes6.dex */
public final class h<Q> implements g<Q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f505114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<Object, l<?>, Object, Unit> f505115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<Object, Object, Object, Object> f505116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function3<l<?>, Object, Object, Function1<Throwable, Unit>> f505117d;

    @Override // kotlinx.coroutines.selects.k
    public final Function3<l<?>, Object, Object, Function1<Throwable, Unit>> a() {
        return this.f505117d;
    }

    @Override // kotlinx.coroutines.selects.k
    public final Function3<Object, l<?>, Object, Unit> b() {
        return this.f505115b;
    }

    @Override // kotlinx.coroutines.selects.k
    public final Object c() {
        return this.f505114a;
    }

    @Override // kotlinx.coroutines.selects.k
    public final Function3<Object, Object, Object, Object> d() {
        return this.f505116c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Object r100, Function3<Object, ? super l<?>, Object, Unit> r101, Function3<Object, Object, Object, ? extends Object> r102, Function3<? super l<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> r103) {
        this.f505114a = r100;
        this.f505115b = r101;
        this.f505116c = r102;
        this.f505117d = r103;
    }
}
