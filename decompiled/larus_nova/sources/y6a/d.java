package y6a;

import android.view.Choreographer;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.u0;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxContext f566408a;

    public d(LynxContext r100) {
        this.f566408a = r100;
    }

    @Override // y6a.f
    public final void a(u0 r100) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        TraceEvent.beginSection("ChoreographerLayoutTick.requestLayout");
    L5:
        Choreographer.getInstance().postFrameCallback(new c(this, r100));
        if (TraceEvent.isTracingStarted() == false) goto L9;
        TraceEvent.endSection("ChoreographerLayoutTick.requestLayout");
        return;
    }
}
