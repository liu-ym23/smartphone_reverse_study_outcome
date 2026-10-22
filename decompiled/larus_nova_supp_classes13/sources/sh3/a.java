package sh3;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.WindowManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WindowManager a;
    public final /* synthetic */ View b;
    public final /* synthetic */ WindowManager.LayoutParams c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Boolean e;
    public final /* synthetic */ View f;

    public a(WindowManager r1, View r2, WindowManager.LayoutParams r3, int r4, Boolean r5, View r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        Object r7 = r6.getAnimatedValue();
        if ((r7 instanceof PointF) == true) goto L5;
        r7 = null;
    L5:
        PointF r8 = (PointF) r7;
        if (r8 != null) goto L18;
        r8 = new PointF();
    L18:
        WindowManager r0 = this.a;     // Catch: IllegalArgumentException -> L17
        if (r0 == null) goto L20;
        View r1 = this.b;     // Catch: IllegalArgumentException -> L17
        WindowManager.LayoutParams r2 = this.c;     // Catch: IllegalArgumentException -> L17
        r2.x = ((int) r8.x) - this.d;     // Catch: IllegalArgumentException -> L17
        if (Intrinsics.areEqual(this.e, Boolean.TRUE) == false) goto L14;
        int r9 = ((int) r8.y) - eh.b.b(this.f.getContext());     // Catch: IllegalArgumentException -> L17
        int r3 = this.d;     // Catch: IllegalArgumentException -> L17
    L15:
        r2.y = r9 - r3;     // Catch: IllegalArgumentException -> L17
        Unit r10 = Unit.INSTANCE;     // Catch: IllegalArgumentException -> L17
        r0.updateViewLayout(r1, r2);     // Catch: IllegalArgumentException -> L17
        return;
    L14:
        r9 = (int) r8.y;     // Catch: IllegalArgumentException -> L17
        r3 = this.d;     // Catch: IllegalArgumentException -> L17
        goto L15
    L20:
        return;
    }
}
