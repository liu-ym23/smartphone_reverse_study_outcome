package n37;

import h37.f;
import h37.g;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f516974a = null;

    public a() {
    }

    static {
        f516974a = new ConcurrentHashMap();
    }

    @Override // h37.g
    public final f b(String r100, boolean r101) {
        return a(r100, r101, false);
    }

    @Override // h37.g
    public final f a(String r100, boolean r101, boolean r102) {
        ConcurrentHashMap<String, b> r103 = f516974a;
        b r104 = r103.get(r100);
        if (r104 == null) goto L5;
        return r104;
    L5:
        b r105 = new b(m37.a.getContext(), r100, r101, r102);
        r103.put(r100, r105);
        return r105;
    }
}
