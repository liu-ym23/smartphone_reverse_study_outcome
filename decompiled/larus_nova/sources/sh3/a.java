package sh3;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.WindowManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowManager f541953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f541954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WindowManager.LayoutParams f541955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f541956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Boolean f541957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ View f541958f;

    public a(WindowManager r100, View r101, WindowManager.LayoutParams r102, int r103, Boolean r104, View r105) {
        this.f541953a = r100;
        this.f541954b = r101;
        this.f541955c = r102;
        this.f541956d = r103;
        this.f541957e = r104;
        this.f541958f = r105;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof PointF) == true) goto L5;
        r101 = null;
    L5:
        PointF r102 = (PointF) r101;
        if (r102 != null) goto L18;
        r102 = new PointF();
    L18:
        WindowManager r103 = this.f541953a;     // Catch: IllegalArgumentException -> L17
        if (r103 == null) goto L20;
        View r104 = this.f541954b;     // Catch: IllegalArgumentException -> L17
        WindowManager.LayoutParams r105 = this.f541955c;     // Catch: IllegalArgumentException -> L17
        r105.x = ((int) r102.x) - this.f541956d;     // Catch: IllegalArgumentException -> L17
        if (Intrinsics.areEqual(this.f541957e, Boolean.TRUE) == false) goto L14;
        int r106 = ((int) r102.y) - eh.b.b(this.f541958f.getContext());     // Catch: IllegalArgumentException -> L17
        int r107 = this.f541956d;     // Catch: IllegalArgumentException -> L17
    L15:
        r105.y = r106 - r107;     // Catch: IllegalArgumentException -> L17
        Unit r108 = Unit.INSTANCE;     // Catch: IllegalArgumentException -> L17
        r103.updateViewLayout(r104, r105);     // Catch: IllegalArgumentException -> L17
        return;
    L14:
        r106 = (int) r102.y;     // Catch: IllegalArgumentException -> L17
        r107 = this.f541956d;     // Catch: IllegalArgumentException -> L17
        goto L15
    L20:
        return;
    }
}
