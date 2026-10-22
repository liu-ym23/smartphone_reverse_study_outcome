package com.relax;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.relax.embedding.LLog;
import com.relax.embedding.module.NativeModuleRegistry;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class BackendWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BackendWorkerJNI f404534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Looper f404535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<byte[]> f404536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f404537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PthreadThreadV2 f404538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<Runnable> f404539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RuntimeType f404540g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BackendWorker f404541a;

        public final void a() {
            BackendWorker r100 = this.f404541a;
            BackendWorkerJNI r101 = r100.f404534a;
            if (r101 != null) goto L5;
        L8:
            BackendWorker r102 = this.f404541a;
            if (r102.f404538e == null) goto L14;
            Handler r103 = r102.f404537d;
            if (r103 == null) goto L15;
            ThreadMethodProxy.quitSafely(r103.getLooper());
            return;
        L15:
            return;
        L14:
            return;
        L5:
            if (r100.f404540g != RuntimeType.RuntimeTypeVM) goto L7;
            NativeModuleRegistry.unregisterFunction(r101.getBackendWorkerPtr(), "");
        L7:
            this.f404541a.f404534a.onDestroy();
            BackendWorker r104 = this.f404541a;
            r104.f404534a = null;
            r104.f404536c = null;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(BackendWorker r100) {
            this.f404541a = r100;
        }
    }

    public final void a() {
        c(new a(this));
        PthreadThreadV2 r100 = this.f404538e;
        if (r100 != null) goto L15;
        return;
    L15:
        ThreadMethodProxy.join(r100);     // Catch: Throwable -> L7 InterruptedException -> L9
    L11:
        this.f404538e = null;
        return;
    L9:
        e = move-exception;
        LLog.e("" + e.getStackTrace().toString());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        this.f404538e = null;
        throw th;
    }

    public final boolean b() {
        if (Looper.myLooper() == this.f404535b) goto L6;
        LLog.e("BackendWorker must work on a consistent thread. If you create BackendWorker on a background thread, you must use it in the same worker thread unless the BackendWorker instance has been bind to ui thread. If runtime instance has been bind to ui thread, you must use it in ui thread.");
        return false;
    L6:
        return true;
    }

    public BackendWorker(RuntimeType r100) {
        this.f404534a = null;
        this.f404535b = null;
        this.f404536c = new ArrayList();
        this.f404537d = null;
        this.f404538e = null;
        this.f404539f = null;
        this.f404540g = RuntimeType.RuntimeTypeVM;
        this.f404540g = r100;
        d(new BackendWorkerJNI(r100));
    }

    public final void c(Runnable r100) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f404535b != null) goto L6;
    L8:
        Handler r101 = this.f404537d;     // Catch: Throwable -> L17
        if (r101 == null) goto L12;
        r101.post(r100);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L12:
        if (this.f404539f != null) goto L14;
        this.f404539f = new ArrayList();     // Catch: Throwable -> L17
    L14:
        this.f404539f.add(r100);     // Catch: Throwable -> L17
        goto L15
    L6:
        if (Looper.myLooper() != this.f404535b) goto L8;
        r100.run();     // Catch: Throwable -> L17
        goto L15
    }

    public final void d(BackendWorkerJNI r100) {
        monitor-enter(this);
        this.f404535b = Looper.myLooper();     // Catch: Throwable -> L10
        this.f404537d = new Handler(this.f404535b);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        if (this.f404535b != null) goto L8;
        LLog.e("BackendWorker has no loop");
    L8:
        this.f404534a = r100;
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public BackendWorker(boolean r100, final RuntimeType r101) {
        this.f404534a = null;
        this.f404535b = null;
        this.f404536c = new ArrayList();
        this.f404537d = null;
        this.f404538e = null;
        this.f404539f = null;
        this.f404540g = RuntimeType.RuntimeTypeVM;
        this.f404540g = r101;
        if (r100 == false) goto L5;
        PthreadThreadV2 r102 = new PthreadThreadV2(new com.relax.a(this, r101), "BackendWorker");
        this.f404538e = r102;
        ThreadMethodProxy.start(r102);
        return;
    L5:
        d(new BackendWorkerJNI(r101));
    }

    public BackendWorker(BackendWorkerJNI r100, RuntimeType r101) {
        this.f404534a = null;
        this.f404535b = null;
        this.f404536c = new ArrayList();
        this.f404537d = null;
        this.f404538e = null;
        this.f404539f = null;
        this.f404540g = RuntimeType.RuntimeTypeVM;
        this.f404540g = r101;
        d(r100);
    }
}
