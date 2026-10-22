package sa5;

import java.lang.ref.WeakReference;
import sa5.r;

/* JADX INFO: loaded from: classes16.dex */
public class g<T extends r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<T> f541168a;

    public final T b() {
        return this.f541168a.get();
    }

    public g(T r100) {
        this.f541168a = new WeakReference(r100);
    }
}
