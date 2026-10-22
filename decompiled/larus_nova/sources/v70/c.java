package v70;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f553414a;

    @Override // v70.a
    public final ViewPropertyAnimator a() {
        return this.f553414a.animate();
    }

    @Override // v70.a
    public final int getVisibility() {
        return this.f553414a.getVisibility();
    }

    @Override // v70.a
    public final int getWidth() {
        return this.f553414a.getWidth();
    }

    @Override // v70.a
    public final View getView() {
        return this.f553414a;
    }

    public c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f553414a = r100;
    }

    @Override // v70.a
    public final void setAlpha(float r100) {
        this.f553414a.setAlpha(r100);
    }

    @Override // v70.a
    public final void setTranslationY(float r100) {
        this.f553414a.setTranslationY(r100);
    }

    @Override // v70.a
    public final void setVisibility(int r100) {
        this.f553414a.setVisibility(r100);
    }

    @Override // v70.a
    public final void setX(float r100) {
        this.f553414a.setX(r100);
    }

    @Override // v70.a
    public final void b(int r100, int r101, int r102, int r103) {
        UIUtils.updateLayoutMargin(this.f553414a, r100, r101, r102, r103);
    }
}
