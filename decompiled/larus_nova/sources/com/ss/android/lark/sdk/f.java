package com.ss.android.lark.sdk;

import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    public interface a {
        void a();
    }

    public static <T> void a(List<T> r100, T r101, a r102) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == false) goto L15;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r100.isEmpty() == false) goto L10;
        r102.a();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
    L15:
        r100.add(r101);
    }

    public static <T> void b(List<T> r100, T r101, a r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        monitor-enter(r100);
        r100.remove(r101);     // Catch: Throwable -> L19
        monitor-exit(r100);     // Catch: Throwable -> L19
        if (r100.isEmpty() == false) goto L18;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (r100.isEmpty() == false) goto L13;
        r102.a();     // Catch: Throwable -> L15
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
