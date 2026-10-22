package x4b;

import android.os.Handler;
import android.os.Looper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f562460a;

    public final synchronized boolean a() {
        monitor-enter(this);
        boolean r100 = true;
        if (this.f562460a != null) goto L9;
        Log.i("HandlerExecutor", "Handler is null");     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    L9:
        if (Looper.myLooper() == this.f562460a.getLooper()) goto L12;
        r100 = false;
    L12:
        monitor-exit(this);
        return r100;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // x4b.d
    public final synchronized void shutdown() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f562460a.getLooper() == null) goto L6;
        ThreadMethodProxy.quitSafely(this.f562460a.getLooper());     // Catch: Throwable -> L9
    L6:
        this.f562460a = null;     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    @Override // x4b.d
    public final void f() {
        if (a() == true) goto L6;
        Log.e("HandlerExecutor", new Exception("serial task check failed"), true);
        return;
    }

    public b(String r100) {
        this.f562460a = CoreThreadPool.newThreadHandler(r100);
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable r100) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f562460a != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (a() == false) goto L10;
        r100.run();     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L10:
        this.f562460a.post(r100);     // Catch: Throwable -> L13
        goto L11
    }
}
