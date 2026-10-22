package su7;

import android.animation.ValueAnimator;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f543593a;

    public a(CircularProgressView r100) {
        this.f543593a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f543593a;
        r101.f274319h = ((Float) r100.getAnimatedValue()).floatValue();
        this.f543593a.invalidate();
    }
}
