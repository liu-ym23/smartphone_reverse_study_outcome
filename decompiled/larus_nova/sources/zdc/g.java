package zdc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<a, Object> f571501a = null;

    public interface a {
        void a();

        void b();
    }

    static {
        f571501a = new ConcurrentHashMap();
    }
}
