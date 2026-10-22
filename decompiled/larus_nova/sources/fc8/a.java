package fc8;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.utils.CubicBezierInterpolator;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f476363a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f476363a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f476363a.setTranslationY(c7.b(40));
        this.f476363a.animate().setDuration(240).setInterpolator(new CubicBezierInterpolator(0.23f, 0.0f, 0.58f)).translationY(0.0f).start();
    }

    public a(View r100) {
        this.f476363a = r100;
    }
}
