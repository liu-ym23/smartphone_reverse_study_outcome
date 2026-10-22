package km3;

import android.animation.ValueAnimator;
import com.bytedance.android.uicomponent.loading.CircularProgressView;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f504047a;

    public a(CircularProgressView r100) {
        this.f504047a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f504047a;
        r101.f187702j = ((Float) r100.getAnimatedValue()).floatValue();
        this.f504047a.invalidate();
    }
}
