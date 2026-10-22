package com.bytedance.forest.utils.io;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f244574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.forest.utils.c f244575b;

    public final int a() {
        monitor-enter(this);
        int r100 = this.f244574a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public f(com.bytedance.forest.utils.c r100) {
        this.f244575b = r100;
    }

    public final int delete(String r110) {
        monitor-enter(this);
        int r100 = this.f244574a - 1;     // Catch: Throwable -> L7
        this.f244574a = r100;     // Catch: Throwable -> L7
        com.bytedance.forest.utils.c.a(this.f244575b, 3, "Concurrent", "#" + r110 + ", decrement reference to:" + r100 + ", stack=" + Arrays.toString(ThreadMethodProxy.currentThread().getStackTrace()), false, null, null, 56);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }
}
