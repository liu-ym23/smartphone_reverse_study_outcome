package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes6.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f505110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<Object, l<?>, Object, Unit> f505111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<l<?>, Object, Object, Function1<Throwable, Unit>> f505112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function3<Object, Object, Object, Object> f505113d;

    @Override // kotlinx.coroutines.selects.k
    public final Function3<l<?>, Object, Object, Function1<Throwable, Unit>> a() {
        return this.f505112c;
    }

    @Override // kotlinx.coroutines.selects.k
    public final Function3<Object, l<?>, Object, Unit> b() {
        return this.f505111b;
    }

    @Override // kotlinx.coroutines.selects.k
    public final Object c() {
        return this.f505110a;
    }

    @Override // kotlinx.coroutines.selects.k
    public final Function3<Object, Object, Object, Object> d() {
        return this.f505113d;
    }

    public f(Object r100, Function3 r101) {
        this.f505110a = r100;
        this.f505111b = r101;
        this.f505112c = null;
        this.f505113d = SelectKt.f505099a;
    }
}
