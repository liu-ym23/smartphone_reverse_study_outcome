package jr;

import android.animation.ValueAnimator;
import com.bytedance.android.ecom.live.adapter.impl.views.CircularProgressView;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f500108a;

    public a(CircularProgressView r100) {
        this.f500108a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f500108a;
        r101.f51194h = ((Float) r100.getAnimatedValue()).floatValue();
        this.f500108a.invalidate();
    }
}
