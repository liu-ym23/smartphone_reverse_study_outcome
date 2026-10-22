package fd0;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f476451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f476452b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        this.f476451a.update(this.f476452b, ((Float) r100.getAnimatedValue()).floatValue());
    }

    public e(d r100, View r101) {
        this.f476451a = r100;
        this.f476452b = r101;
    }
}
