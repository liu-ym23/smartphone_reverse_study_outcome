package com.bytedance.lighten.core.utils;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes20.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f254685a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f254686a = null;

        static {
            f254686a = new b();
        }
    }

    public b() {
        this.f254685a = new Handler(Looper.getMainLooper());
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(this.f254685a.getLooper())) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100.run();
        return;
    L8:
        this.f254685a.post(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }
}
