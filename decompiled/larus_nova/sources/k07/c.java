package k07;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f501263a = null;

    static {
        ConcurrentHashMap<String, a> r100 = new ConcurrentHashMap();
        b r101 = b.f501262a;
        r100.put("default", r101);
        r100.put("light", r101);
        f501263a = r100;
    }
}
