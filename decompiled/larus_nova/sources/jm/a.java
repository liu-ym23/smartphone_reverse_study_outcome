package jm;

import androidx.lifecycle.LifecycleOwner;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f499610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c<T> f499611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<T, Unit> f499612c;

    @Override // jm.c
    public final T getValue() {
        return this.f499611b.getValue();
    }

    public a(int r100) {
        this.f499612c = null;
        this.f499611b = new d();
    }

    @Override // jm.c
    public final void b(Observer<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f499611b.b(r100);
    }

    @Override // jm.c
    public final void c(T r100) {
        this.f499610a = r100;
        Function1<T, Unit> r101 = this.f499612c;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke(r100);
    L5:
        this.f499611b.c(r100);
    }

    @Override // jm.c
    public final void setValue(T r100) {
        this.f499610a = r100;
        Function1<T, Unit> r101 = this.f499612c;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke(r100);
    L5:
        this.f499611b.setValue(r100);
    }

    @Override // jm.c
    public final void d(LifecycleOwner r100, Observer<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f499611b.d(r100, r101);
    }

    @Override // jm.c
    public final void a(LifecycleOwner r100, Observer<T> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f499611b.a(r100, r101, r102);
    }
}
