package jv2;

import android.animation.ValueAnimator;
import com.bytedance.android.livesdk.widget.crop.PreviewBoxViewV2;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreviewBoxViewV2 f500550a;

    public g(PreviewBoxViewV2 r100) {
        this.f500550a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        PreviewBoxViewV2 r101 = this.f500550a;
        r101.f161675n = ((Float) r100.getAnimatedValue()).floatValue();
        this.f500550a.invalidate();
    }
}
