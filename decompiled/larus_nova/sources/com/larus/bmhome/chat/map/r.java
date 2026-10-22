package com.larus.bmhome.chat.map;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes25.dex */
public final class r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile r f306915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f306916d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f306917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.larus.bmhome.chat.map.a> f306918b;

    public static final class a {
        public a() {
        }
    }

    static {
        a r100 = new a();
        r r101 = f306915c;
        if (r101 != null) goto L13;
        monitor-enter(r100);
        r101 = f306915c;     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        r101 = new r();     // Catch: Throwable -> L10
        f306915c = r101;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);
    L10:
        th = move-exception;
        throw th;
    L13:
        f306916d = r101;
    }

    public r() {
        this.f306917a = new AtomicBoolean(false);
        this.f306918b = new ArrayList();
    }
}
