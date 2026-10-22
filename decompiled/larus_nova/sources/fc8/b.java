package fc8;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.utils.CubicBezierInterpolator;

/* JADX INFO: loaded from: classes25.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f476364a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f476364a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        Object r100 = this.f476364a.getParent();
        if ((r100 instanceof View) == false) goto L5;
        View r101 = (View) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        this.f476364a.setTranslationY(r101.getHeight() - this.f476364a.getY());
        this.f476364a.animate().setDuration(240).setInterpolator(new CubicBezierInterpolator(0.23f, 0.0f, 0.58f)).translationY(0.0f).start();
        return;
    L5:
        r101 = null;
        goto L6
    }

    public b(View r100) {
        this.f476364a = r100;
    }
}
