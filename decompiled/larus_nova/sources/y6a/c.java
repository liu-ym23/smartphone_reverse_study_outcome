package y6a;

import android.view.Choreographer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.u0;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f566405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f566406b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f566407a;

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (TraceEvent.isTracingStarted() == false) goto L5;
            TraceEvent.beginSection("ChoreographerLayoutTick.triggerLayout");     // Catch: Throwable -> L9
        L5:
            this.f566407a.f566405a.run();     // Catch: Throwable -> L9
            if (TraceEvent.isTracingStarted() == false) goto L12;
            TraceEvent.endSection("ChoreographerLayoutTick.triggerLayout");     // Catch: Throwable -> L9
            return;
        }

        public a(c r100) {
            this.f566407a = r100;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        if (this.f566406b.f566408a.hasLayoutThreadChanged() == false) goto L6;
        this.f566406b.f566408a.runOnLayoutThread(new a(this));
        return;
    L6:
        if (TraceEvent.isTracingStarted() == false) goto L8;
        TraceEvent.beginSection("ChoreographerLayoutTick.triggerLayout");
    L8:
        this.f566405a.run();
        if (TraceEvent.isTracingStarted() == false) goto L13;
        TraceEvent.endSection("ChoreographerLayoutTick.triggerLayout");
        return;
    }

    public c(d r100, u0 r101) {
        this.f566406b = r100;
        this.f566405a = r101;
    }
}
