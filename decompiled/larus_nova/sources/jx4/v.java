package jx4;

import android.animation.ValueAnimator;
import com.bytedance.ee.bear.debug.LoadingView;

/* JADX INFO: loaded from: classes16.dex */
public final class v implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoadingView f500862a;

    public v(LoadingView r100) {
        this.f500862a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        float r101 = ((Float) r100.getAnimatedValue()).floatValue();
        LoadingView r102 = this.f500862a;
        r102.f217355c = r101 * 360.0f;
        r102.invalidate();
    }
}
