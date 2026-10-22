package cy6;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f465795a = null;

    static {
        f465795a = new ConcurrentHashMap();
    }

    public static a a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return f465795a.remove(r100);
    }
}
