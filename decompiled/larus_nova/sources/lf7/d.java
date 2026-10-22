package lf7;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f509087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f509088b = null;

    static {
        f509088b = new ConcurrentHashMap();
    }

    public static a a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return f509088b.get(r100);
    }
}
