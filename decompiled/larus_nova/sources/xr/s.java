package xr;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, Object> f564823a = null;

    static {
        f564823a = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final <T extends o> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Object r101 = f564823a.get(r100);
        if (r101 != null) goto L7;
        LocalTestManager.a(new Class[]{uv.a.class});
        return null;
    L7:
        return (T) r101;
    }

    @JvmStatic
    public static final <T extends o> void b(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "instance");
        f564823a.put(r100, r101);
    }
}
