package g16;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f479613a = null;

    static {
        f479613a = new ConcurrentHashMap();
    }

    public static b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        b r101 = f479613a.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return new b();
    }
}
