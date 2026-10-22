package com.larksuite.framework.thread;

import com.ss.android.lark.log.Log;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes24.dex */
public final class e extends q<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Callable f285747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f285748b;

    @Override // com.larksuite.framework.thread.q, java.util.concurrent.Callable
    public Object call() throws Exception {
        return this.f285747a.call();
    L4:
        e = move-exception;
        Log.e("CoreScheduledThreadPoolExecutor", "schedule task exception, task name: " + this.f285748b.getClass());
        a.c().a(e);
        a.c().getClass();
        System.currentTimeMillis();
        throw e;
    }

    public e(c r100, Callable r101) {
        this.f285747a = r100;
        this.f285748b = r101;
    }
}
