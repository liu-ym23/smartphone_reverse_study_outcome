package ti2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WindowManager a;
    public final /* synthetic */ View b;
    public final /* synthetic */ WindowManager.LayoutParams c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Context e;

    public b(WindowManager r1, View r2, WindowManager.LayoutParams r3, int r4, Context r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r7) {
        Object r8 = r7.getAnimatedValue();
        if ((r8 instanceof PointF) == true) goto L5;
        r8 = null;
    L5:
        PointF r9 = (PointF) r8;
        if (r9 != null) goto L15;
        r9 = new PointF();
    L15:
        WindowManager r0 = this.a;     // Catch: IllegalArgumentException -> L12
        if (r0 == null) goto L17;
        View r1 = this.b;     // Catch: IllegalArgumentException -> L12
        WindowManager.LayoutParams r2 = this.c;     // Catch: IllegalArgumentException -> L12
        r2.x = (int) (r9.x - (this.d / 2.0f));     // Catch: IllegalArgumentException -> L12
        r2.y = (int) ((r9.y - eh.b.b(this.e)) - (this.d / 2.0f));     // Catch: IllegalArgumentException -> L12
        Unit r10 = Unit.INSTANCE;     // Catch: IllegalArgumentException -> L12
        r0.updateViewLayout(r1, r2);     // Catch: IllegalArgumentException -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
