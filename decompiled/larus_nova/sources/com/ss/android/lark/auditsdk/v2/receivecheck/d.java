package com.ss.android.lark.auditsdk.v2.receivecheck;

import com.larksuite.framework.thread.n;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f409653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, ValidateIMFileResult> f409654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantReadWriteLock f409655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<com.ss.android.lark.auditsdk.v2.receivecheck.a.InterfaceC4761a, Object> f409656d;

    public static final class a {
    }

    static {
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f409653a = PThreadExecutorsUtils.newSingleThreadExecutor(new n("thread-pool-authority-cache" + r100 + System.currentTimeMillis()));
        this.f409654b = new ConcurrentHashMap();
        this.f409655c = new ReentrantReadWriteLock();
        this.f409656d = new ConcurrentHashMap();
    }

    public final void update(Map<String, ValidateIMFileResult> r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        ConcurrentHashMap r101 = new ConcurrentHashMap();
        this.f409655c.writeLock().lock();     // Catch: Throwable -> L10
        r101.putAll(r100);     // Catch: Throwable -> L10
        this.f409654b.putAll(r100);     // Catch: Throwable -> L10
        this.f409655c.writeLock().unlock();
        if (this.f409653a.isShutdown() == false) goto L7;
        return;
    L7:
        if (this.f409653a.isTerminated() == true) goto L16;
        this.f409653a.execute(new e(this, r101));
        return;
    L16:
        return;
    L10:
        th = move-exception;
        this.f409655c.writeLock().unlock();
        throw th;
    }
}
