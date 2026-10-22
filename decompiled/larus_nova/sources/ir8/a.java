package ir8;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f495491a = null;

    static {
        f495491a = new ConcurrentHashMap();
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return r100 + ':' + UUID.randomUUID();
    }
}
