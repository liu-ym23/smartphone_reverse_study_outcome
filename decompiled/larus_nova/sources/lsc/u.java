package lsc;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class u implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<q, Object> f510623a;

    public u() {
        this.f510623a = new HashMap(3);
    }

    public final <T> T a(q<T> r100) {
        return (T) ((HashMap) this.f510623a).get(r100);
    }

    public final <T> T b(q<T> r100, T r101) {
        T r102 = (T) ((HashMap) this.f510623a).get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return r101;
    }

    public final <T> void c(q<T> r100, T r101) {
        if (r101 != null) goto L4;
        ((HashMap) this.f510623a).remove(r100);
        return;
    L4:
        ((HashMap) this.f510623a).put(r100, r101);
    }
}
