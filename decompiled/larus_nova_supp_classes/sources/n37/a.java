package n37;

import h37.f;
import h37.g;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a implements g {
    public static final ConcurrentHashMap<String, b> a = null;

    public a() {
    }

    static {
        a = new ConcurrentHashMap();
    }

    @Override // h37.g
    public final f b(String r2, boolean r3) {
        return a(r2, r3, false);
    }

    @Override // h37.g
    public final f a(String r4, boolean r5, boolean r6) {
        ConcurrentHashMap<String, b> r0 = a;
        b r1 = r0.get(r4);
        if (r1 == null) goto L5;
        return r1;
    L5:
        b r2 = new b(m37.a.getContext(), r4, r5, r6);
        r0.put(r4, r2);
        return r2;
    }
}
