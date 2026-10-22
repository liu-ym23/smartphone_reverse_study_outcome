package com.bytedance.ee.bear.document.at;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m {
    public static Context a;
    public static l b;
    public static k c;

    public m() {
    }

    public static void a() {
        if (b == null) goto L5;
    L14:
        kn4.f.a = b;
        kn4.f.b = c;
        return;
    L5:
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new l();     // Catch: Throwable -> L11
        c = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
        goto L14
    }
}
