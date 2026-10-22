package com.bytedance.ee.bear.document.at;

import android.content.Context;

/* JADX INFO: loaded from: classes16.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f219111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static l f219112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static k f219113c;

    public m() {
    }

    public static void a() {
        if (f219112b == null) goto L5;
    L14:
        kn4.f.f504221a = f219112b;
        kn4.f.f504222b = f219113c;
        return;
    L5:
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f219112b != null) goto L9;
        f219112b = new l();     // Catch: Throwable -> L11
        f219113c = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
        goto L14
    }
}
