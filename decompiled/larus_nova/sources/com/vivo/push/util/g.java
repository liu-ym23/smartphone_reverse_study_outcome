package com.vivo.push.util;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f462574a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f462575b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f462576c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ExecutorService f462577d;

    static {
        int r100 = Runtime.getRuntime().availableProcessors();
        f462574a = r100;
        int r101 = Math.max(2, Math.min(r100 - 1, 4));
        f462575b = r101;
        int r102 = (r100 * 2) + 1;
        f462576c = r102;
        f462577d = new PThreadPoolExecutor(r101, r102, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new h("COMMON_THREAD"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static ExecutorService a() {
        return f462577d;
    }
}
