package t85;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final Map<String, e> a;

    public c() {
        this.a = new ConcurrentHashMap();
    }

    public final e a(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (e) ((ConcurrentHashMap) this.a).get(r2);
    }

    public final void b(String r2, e r3) {
        ((ConcurrentHashMap) this.a).put(r2, r3);
    }
}
