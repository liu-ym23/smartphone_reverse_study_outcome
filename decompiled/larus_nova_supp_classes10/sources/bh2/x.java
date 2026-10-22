package bh2;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x {
    public static final List<w> a = null;
    public static volatile boolean b;
    public static final Map<String, Class<?>> c = null;
    public static final Map<Class<?>, am3.c<?>> d = null;
    public static final x e = null;

    public x() {
    }

    static {
        e = new x();
        a = new ArrayList();
        c = new LinkedHashMap();
        d = new LinkedHashMap();
    }

    public final synchronized am3.c<?> a(Class<?> r6) {
        monitor-enter(this);
        Map<Class<?>, am3.c<?>> r0 = d;     // Catch: Throwable -> L21
        am3.c<?> r1 = (am3.c) ((LinkedHashMap) r0).get(r6);     // Catch: Throwable -> L21
        if (r1 == null) goto L9;
        monitor-exit(this);
        return r1;
    L9:
        if (vh7.h.class.isAssignableFrom(r6) == true) goto L24;
    L15:
        y r3 = null;
    L16:
        if (r3 == null) goto L19;
        monitor-exit(this);
        return r3;
    L19:
        monitor-exit(this);
        return null;
    L24:
        r3 = new y(r6.getConstructor(new Class[]{am3.g.class}));     // Catch: NoSuchMethodException -> L13 Throwable -> L21
        r0.put(r6, r3);     // Catch: NoSuchMethodException -> L13 Throwable -> L21
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }
}
