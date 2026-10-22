package hk5;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f485570a = null;

    static {
        f485570a = new ConcurrentHashMap();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        f485570a.remove(r100);
    }

    public static void b(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "callback");
        f485570a.put(r100, r101);
    }
}
