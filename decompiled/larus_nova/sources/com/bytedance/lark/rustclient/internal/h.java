package com.bytedance.lark.rustclient.internal;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes20.dex */
public final class h implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.lark.rustclient.api.o f253988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f253989b;

    public h(com.bytedance.lark.rustclient.api.o r100, AtomicBoolean r101) {
        this.f253988a = r100;
        this.f253989b = r101;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        this.f253988a.f253918a.execute(r100);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        if (this.f253989b.compareAndSet(false, true) == false) goto L8;
        Log.e("DefaultRustClientDefinition", "custom async callback executor rejected task, fallback to default", e);
    L8:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(r100);
    }
}
