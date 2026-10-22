package h26;

import android.graphics.Typeface;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Typeface> f483613a = null;

    static {
        f483613a = new ConcurrentHashMap();
    }

    public static Typeface a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return f483613a.get(r100);
    }

    public static void b(String r100, Typeface r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "cache");
        f483613a.put(r100, r101);
    }
}
