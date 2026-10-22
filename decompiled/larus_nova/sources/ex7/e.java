package ex7;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes23.dex */
public final class e<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<T> f474723a;

    @Override // ex7.a
    public final T provideInstance() {
        WeakReference<T> r100 = this.f474723a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // ex7.b
    public final void release() {
        WeakReference<T> r100 = this.f474723a;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f474723a = null;
    }

    public e(T r100) {
        this.f474723a = new WeakReference(r100);
    }
}
