package com.bytedance.platform.thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f266632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f266633b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f266634c;

    public static class a implements RejectedExecutionHandler {
        public a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
            a r102 = d.f266632a;
            throw null;
        }
    }

    public static class b implements e {
        public b() {
        }
    }

    static {
        Runtime.getRuntime().availableProcessors();
        f266632a = new a();
        f266633b = new b();
    }

    public d() {
    }
}
