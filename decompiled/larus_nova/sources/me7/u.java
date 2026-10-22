package me7;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes22.dex */
public final class u<T> implements j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<T> f513567a;

    @Override // me7.j
    public final T provideInstance() {
        WeakReference<T> r100 = this.f513567a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // me7.j
    public final void release() {
        WeakReference<T> r100 = this.f513567a;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f513567a = null;
    }

    public u(T r100) {
        if (r100 != null) goto L5;
        WeakReference<T> r101 = null;
    L6:
        this.f513567a = r101;
        return;
    L5:
        r101 = new WeakReference(r100);
        goto L6
    }
}
