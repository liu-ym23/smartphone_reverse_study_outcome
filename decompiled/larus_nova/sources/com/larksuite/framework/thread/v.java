package com.larksuite.framework.thread;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes24.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f285804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f285805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledFuture f285806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f285807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f285808e;

    public interface a {
        void a(AtomicInteger r100);
    }

    public v() {
        this.f285808e = new AtomicInteger(0);
        this.f285804a = CoreThreadPool.getDefault().getScheduleThreadPool();
        this.f285805b = new u(this);
    }
}
