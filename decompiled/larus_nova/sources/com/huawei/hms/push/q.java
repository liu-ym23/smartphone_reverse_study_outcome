package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f277658a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ThreadPoolExecutor f277659b;

    static {
        f277658a = new Object();
        f277659b = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static ThreadPoolExecutor a() {
        Object r100 = f277658a;
        monitor-enter(r100);
        ThreadPoolExecutor r101 = f277659b;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }
}
