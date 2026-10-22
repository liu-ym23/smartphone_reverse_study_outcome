package y6a;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.u0;

/* JADX INFO: loaded from: classes32.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f566418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f566419b;

    @Override // java.lang.Runnable
    public final void run() {
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    L19:
        return;
    L3:
        if (TraceEvent.isTracingStarted() == false) goto L5;
        TraceEvent.beginSection("ViewLayoutTick.requestLayout");     // Catch: Throwable -> L12
    L5:
        View r100 = this.f566419b.f566420a;     // Catch: Throwable -> L12
        if (r100 == null) goto L8;
        r100.requestLayout();     // Catch: Throwable -> L12
    L8:
        r r101 = this.f566419b;     // Catch: Throwable -> L12
        r101.f566421b = this.f566418a;     // Catch: Throwable -> L12
        if (TraceEvent.isTracingStarted() == false) goto L15;
        TraceEvent.endSection("ViewLayoutTick.requestLayout");     // Catch: Throwable -> L12
        return;
    }

    public q(r r100, u0 r101) {
        this.f566419b = r100;
        this.f566418a = r101;
    }
}
