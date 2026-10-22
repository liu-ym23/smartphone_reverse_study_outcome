package t6a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes32.dex */
public final class h extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f544733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f544734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f544735c;

    @Override // android.view.animation.Animation
    public final boolean willChangeBounds() {
        return false;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        this.f544733a.setAlpha(this.f544734b + (this.f544735c * r100));
    }

    public h(View r100, float r101, float r102) {
        this.f544733a = r100;
        this.f544734b = r101;
        this.f544735c = r102 - r101;
    }
}
