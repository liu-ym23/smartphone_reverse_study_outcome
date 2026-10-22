package ct3;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class c$a implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ WeakReference a;
    public final /* synthetic */ Integer b;
    public final /* synthetic */ c c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.a.get() != null) goto L5;
        return;
    L5:
        View r0 = ((View) this.a.get()).findViewById(this.b.intValue());
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.getVisibility() == 0) goto L10;
        return;
    L10:
        if (r0.getWidth() <= 0) goto L29;
        ViewTreeObserver r1 = ((View) this.a.get()).getViewTreeObserver();
        if (r1.isAlive() == false) goto L16;
        ViewTreeObserver.OnGlobalLayoutListener r2 = this.c.c;
        if (r2 == null) goto L16;
        r1.removeOnGlobalLayoutListener(r2);
    L16:
        c r3 = this.c;
        Runnable r4 = r3.d;
        if (r4 == null) goto L19;
        r3.e.removeCallbacks(r4);
        this.c.d = null;
    L19:
        c r5 = this.c;
        r5.c = null;
        if (r5.a <= 0) goto L30;
        long r6 = System.currentTimeMillis();
        c r7 = this.c;
        long r8 = r6 - r7.a;
        r7.a = 0;
        if (r8 < r7.f) goto L24;
        return;
    L24:
        if (r8 <= 0) goto L32;
        AutoPageTraceHelper.reportViewIdStats(r6, r7.b);
        MonitorTool.reportTraceTime(this.c.b, "activityOnCreateToViewShow", r8);
        return;
    L32:
        return;
    L30:
        return;
    }

    public c$a(c r1, WeakReference r2, Integer r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
