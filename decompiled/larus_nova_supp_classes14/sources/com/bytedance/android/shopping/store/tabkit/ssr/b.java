package com.bytedance.android.shopping.store.tabkit.ssr;

import com.bytedance.android.shopping.store.tabkit.ssr.interfaces.SSRFetchCallbackDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int b = 0;
    public SSRFetchCallbackDelegate a;

    public static final class a {
    }

    static {
    }

    public final void b(int r1, String r2, Integer r3) {
        throw null;
    }

    public final void c(String r1, Long r2) {
        throw null;
    }

    public static final void a(b r1, byte[] r2, boolean r3) {
        monitor-enter(r1);
        if (r3 == true) goto L5;
        if (r2 != null) goto L12;
    L10:
        monitor-exit(r1);
        return;
    L12:
        r1.getClass();     // Catch: Throwable -> L14
        throw null;     // Catch: Throwable -> L14
    L5:
        if (r2 != null) goto L7;
        r1.b(304, "empty template byte data", null);     // Catch: Throwable -> L14
        goto L10
    L7:
        r1.getClass();     // Catch: Throwable -> L14
        throw null;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
