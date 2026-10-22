package km3;

import android.animation.ValueAnimator;
import com.bytedance.android.uicomponent.loading.CircularProgressView;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f504049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f504050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f504051c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f504051c;
        r101.f187708p = ((Float) r100.getAnimatedValue()).floatValue();
        CircularProgressView r102 = this.f504051c;
        r102.f187702j = (this.f504049a - r102.f187708p) + this.f504050b;
        r102.invalidate();
    }

    public c(CircularProgressView r100, float r101, float r102) {
        this.f504051c = r100;
        this.f504049a = r101;
        this.f504050b = r102;
    }
}
