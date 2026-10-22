package vp7;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f556650a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f556651a = null;

        static {
            f556651a = new c();
        }
    }

    public c() {
        this.f556650a = new ConcurrentHashMap();
    }

    public final <T extends vp7.a> T a(Class<T> r100) {
        String r101 = r100.getName();
        Object r102 = ((ConcurrentHashMap) this.f556650a).get(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return (T) r102;
    }
}
