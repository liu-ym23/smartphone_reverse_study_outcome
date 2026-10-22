package com.bytedance.frameworks.baselib.network.http.retrofit;

import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.dispatcher.a;
import com.bytedance.retrofit2.SsRunnable;
import java.util.concurrent.Executor;
import kx5.b;
import kx5.c;
import kx5.d;

/* JADX INFO: loaded from: classes3.dex */
public class SsHttpExecutor implements Executor {
    private static volatile b sRequestQueue;

    public SsHttpExecutor() {
    }

    public static void setRequestQueue(c r100) {
        sRequestQueue = r100;
    }

    public static void setThreadPoolConfig(d r100) {
        monitor-enter(c.class);
        c.f506560b = r100;     // Catch: Throwable -> L7
        d r101 = c.f506560b;     // Catch: Throwable -> L7
        r101.f506569h = c.f506559a;     // Catch: Throwable -> L7
        monitor-exit(c.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        if (r100 == null) goto L39;
        IRequest.Priority r101 = IRequest.Priority.NORMAL;
        if ((r100 instanceof SsRunnable) == false) goto L21;
        SsRunnable r102 = (SsRunnable) r100;
        int r103 = r102.priority();
        if (r103 != 0) goto L9;
        r101 = IRequest.Priority.LOW;
    L20:
        boolean r104 = r102.isStreaming();
        int r105 = r102.getRequestDelayTime();
    L23:
        if (sRequestQueue != null) goto L25;
        sRequestQueue = c.b();
    L25:
        a r106 = new a("NetExecutor", r101, r105, r100);
        if (r104 == false) goto L35;
        c r107 = (c) sRequestQueue;
        monitor-enter(r107);
        com.bytedance.frameworks.baselib.network.dispatcher.c.f244658g.b(r106);     // Catch: Throwable -> L32
        monitor-exit(r107);
        return;
    L32:
        th = move-exception;
        throw th;
    L35:
        ((c) sRequestQueue).a(r106);
        return;
    L9:
        if (1 == r103) goto L20;
        if (2 != r103) goto L15;
        r101 = IRequest.Priority.HIGH;
        goto L20
    L15:
        if (3 != r103) goto L18;
        r101 = IRequest.Priority.IMMEDIATE;
        goto L20
    L18:
        if ((-1) != r103) goto L20;
        r101 = IRequest.Priority.LOWEST;
        goto L20
    L21:
        r104 = false;
        r105 = 0;
        goto L23
    }
}
