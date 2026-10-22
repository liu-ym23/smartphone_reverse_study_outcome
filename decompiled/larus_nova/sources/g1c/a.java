package g1c;

import kotlin.jvm.internal.Intrinsics;
import o1c.c;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a<T> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f479631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f479632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f479633c;

    @Override // g1c.b
    public boolean a() {
        return false;
    }

    @Override // g1c.b
    public void e(c<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
    }

    @Override // g1c.b
    public final boolean c() {
        return this.f479632b;
    }

    public a(T r100) {
        this.f479631a = r100;
    }

    @Override // g1c.b
    public final void setValue(T r100) {
        this.f479632b = !Intrinsics.areEqual(this.f479633c, r100);
        this.f479633c = r100;
    }
}
