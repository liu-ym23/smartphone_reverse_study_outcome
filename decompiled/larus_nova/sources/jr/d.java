package jr;

import android.animation.ValueAnimator;
import com.bytedance.android.ecom.live.adapter.impl.views.CircularProgressView;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f500113a;

    public d(CircularProgressView r100) {
        this.f500113a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f500113a;
        r101.f51195i = ((Float) r100.getAnimatedValue()).floatValue();
    }
}
