package t85;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, e> f545040a;

    public c() {
        this.f545040a = new ConcurrentHashMap();
    }

    public final e a(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (e) ((ConcurrentHashMap) this.f545040a).get(r100);
    }

    public final void b(String r100, e r101) {
        ((ConcurrentHashMap) this.f545040a).put(r100, r101);
    }
}
