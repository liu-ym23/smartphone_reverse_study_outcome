package hk5;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final ConcurrentHashMap<String, a> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        a.remove(r1);
    }

    public static void b(String r1, a r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "callback");
        a.put(r1, r2);
    }
}
