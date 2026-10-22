package bi3;

import android.animation.ValueAnimator;
import android.view.Window;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Window a;

    public f(Window r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L11;
        float r4 = ((Float) r3).floatValue();
        this.a.setDimAmount(r4);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
