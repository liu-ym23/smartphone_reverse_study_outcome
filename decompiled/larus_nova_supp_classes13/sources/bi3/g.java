package bi3;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends k43.c {
    public final Window b;

    public final void f(int r5) {
        Window r0 = this.b;     // Catch: Exception -> L9
        if (r0 == null) goto L5;
        r0.addFlags(2);     // Catch: Exception -> L9
    L5:
        Window r1 = this.b;     // Catch: Exception -> L9
        if (r1 == null) goto L14;
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{0.0f, Color.alpha(r5) / 255.0f});     // Catch: Exception -> L9
        r6.setDuration(390);     // Catch: Exception -> L9
        r6.setInterpolator(new DecelerateInterpolator());     // Catch: Exception -> L9
        r6.addUpdateListener(new f(r1));     // Catch: Exception -> L9
        r6.start();     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public g(Window r2, View r3) {
        Intrinsics.checkNotNullParameter(r3, "platformView");
        super(r3);
        this.b = r2;
    }
}
