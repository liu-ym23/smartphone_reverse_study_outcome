package usa;

import android.animation.ValueAnimator;
import com.ss.android.bytedcert.view.ScrollTextView;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollTextView f551564a;

    public e(ScrollTextView r100) {
        this.f551564a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        ScrollTextView r101 = this.f551564a;
        ((Float) r100.getAnimatedValue()).floatValue();
        r101.getClass();
        this.f551564a.invalidate();
    }
}
