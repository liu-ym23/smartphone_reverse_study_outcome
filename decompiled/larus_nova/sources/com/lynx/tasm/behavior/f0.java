package com.lynx.tasm.behavior;

import android.view.Choreographer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class f0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f382038a;

    public class a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f382039a;

        public a(f0 r100) {
            this.f382039a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            LLog.i(this.f382039a.f382038a.f382026u, "onRootViewDraw ObserverHandler");
            this.f382039a.f382038a.h();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        e0 r100 = this.f382038a;     // Catch: Throwable -> L6
        if (r100.f382011f == true) goto L9;
        r100.f382011f = true;     // Catch: Throwable -> L6
        Choreographer.getInstance().postFrameCallback(new a(this));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public f0(e0 r100) {
        this.f382038a = r100;
    }
}
