package usa;

import android.animation.ValueAnimator;
import com.ss.android.bytedcert.view.CircleMotionView;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircleMotionView f551559a;

    public a(CircleMotionView r100) {
        this.f551559a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        this.f551559a.invalidate();
        float r101 = ((Float) r100.getAnimatedValue()).floatValue();
        this.f551559a.f407731l = r101;
        float r102 = r101 * 0.75f;
        this.f551559a.f407730k = r102;
    }
}
