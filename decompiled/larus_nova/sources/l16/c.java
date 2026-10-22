package l16;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f506989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f506990b;

    @Override // l16.a
    public final boolean a() {
        return this.f506989a;
    }

    @Override // l16.a
    public final T getProperty() {
        return this.f506990b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Object r100) {
        if (r100 == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f506989a = r101;
        this.f506990b = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // l16.a
    public final void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (this.f506989a == false) goto L6;
        r100.a();
        return;
    L6:
        if (r100.a() == false) goto L10;
        T r101 = (T) r100.getProperty();
        this.f506989a = true;
        this.f506990b = r101;
        return;
    }
}
