package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes42.dex */
public final class d<T> extends WeakReference<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f504733a;

    public d(T r100, ReferenceQueue<T> r101) {
        super(r100, r101);
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        this.f504733a = r102;
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
