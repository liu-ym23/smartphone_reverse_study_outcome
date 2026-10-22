package m27;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static volatile c d;
    public volatile boolean a;
    public volatile boolean b;
    public final Map<String, Exception> c;

    public static c a() {
        if (d != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public c() {
        this.a = false;
        this.b = false;
        this.c = new HashMap();
    }
}
