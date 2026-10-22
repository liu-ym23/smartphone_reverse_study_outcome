package sa5;

import java.lang.ref.WeakReference;
import sa5.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class g<T extends r> {
    public final WeakReference<T> a;

    public final T b() {
        return this.a.get();
    }

    public g(T r2) {
        this.a = new WeakReference(r2);
    }
}
