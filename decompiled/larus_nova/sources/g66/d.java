package g66;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<T> f480167a;

    @Override // g66.a
    public final T provideInstance() {
        WeakReference<T> r100 = this.f480167a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // p56.e
    public final void release() {
        WeakReference<T> r100 = this.f480167a;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f480167a = null;
    }

    public d(T r100) {
        if (r100 != null) goto L5;
        WeakReference<T> r101 = null;
    L6:
        this.f480167a = r101;
        return;
    L5:
        r101 = new WeakReference(r100);
        goto L6
    }
}
