package m16;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<T> f511606a;

    @Override // m16.c
    public final T provideInstance() {
        WeakReference<T> r100 = this.f511606a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // com.bytedance.ies.bullet.service.base.i0
    public final void release() {
        WeakReference<T> r100 = this.f511606a;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f511606a = null;
    }

    public d(T r100) {
        if (r100 != null) goto L5;
        WeakReference<T> r101 = null;
    L6:
        this.f511606a = r101;
        return;
    L5:
        r101 = new WeakReference(r100);
        goto L6
    }
}
