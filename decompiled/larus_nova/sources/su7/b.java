package su7;

import android.animation.ValueAnimator;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

/* JADX INFO: loaded from: classes23.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f543594a;

    public b(CircularProgressView r100) {
        this.f543594a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f543594a;
        r101.f274320i = ((Float) r100.getAnimatedValue()).floatValue();
    }
}
