package va1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f553923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f553924b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f553925a = null;

        static {
            f553925a = new c();
        }
    }

    public c() {
        this.f553923a = new ConcurrentHashMap();
        this.f553924b = Collections.synchronizedSet(new HashSet());
    }
}
