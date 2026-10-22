package com.bytedance.android.livesdk.log;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o {
    public static o b;
    public final Map<String, String> a;

    public static synchronized o a() {
        monitor-enter(o.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (b != null) goto L7;
        b = new o();     // Catch: Throwable -> L10
    L7:
        o r1 = b;     // Catch: Throwable -> L10
        monitor-exit(o.class);
        return r1;
    }

    public o() {
        this.a = new HashMap();
    }

    public final void b(long r2, String r4) {
        ((HashMap) this.a).put(r2 + "sort_type", r4);
    }
}
