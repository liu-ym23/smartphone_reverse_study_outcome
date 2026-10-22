package ga7;

import java.util.HashMap;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, v97.d<?>> f480571a = null;

    static {
        f480571a = new HashMap();
    }

    @JvmStatic
    public static final <T> void a(v97.d<T> r100) {
        HashMap<String, v97.d<?>> r101 = f480571a;
        monitor-enter(r101);
        v97.d<?> r102 = r101.put(r100.name(), r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
