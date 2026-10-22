package ti2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Unit;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowManager f546041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f546042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WindowManager.LayoutParams f546043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f546044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f546045e;

    public b(WindowManager r100, View r101, WindowManager.LayoutParams r102, int r103, Context r104) {
        this.f546041a = r100;
        this.f546042b = r101;
        this.f546043c = r102;
        this.f546044d = r103;
        this.f546045e = r104;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof PointF) == true) goto L5;
        r101 = null;
    L5:
        PointF r102 = (PointF) r101;
        if (r102 != null) goto L15;
        r102 = new PointF();
    L15:
        WindowManager r103 = this.f546041a;     // Catch: IllegalArgumentException -> L12
        if (r103 == null) goto L17;
        View r104 = this.f546042b;     // Catch: IllegalArgumentException -> L12
        WindowManager.LayoutParams r105 = this.f546043c;     // Catch: IllegalArgumentException -> L12
        r105.x = (int) (r102.x - (this.f546044d / 2.0f));     // Catch: IllegalArgumentException -> L12
        r105.y = (int) ((r102.y - eh.b.b(this.f546045e)) - (this.f546044d / 2.0f));     // Catch: IllegalArgumentException -> L12
        Unit r106 = Unit.INSTANCE;     // Catch: IllegalArgumentException -> L12
        r103.updateViewLayout(r104, r105);     // Catch: IllegalArgumentException -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
