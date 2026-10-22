package zw1;

import android.animation.ValueAnimator;
import com.bytedance.android.livesdk.feed.ui.XiguaLivingTagView;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XiguaLivingTagView f573794a;

    public b(XiguaLivingTagView r100) {
        this.f573794a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        int r101 = ((Integer) r100.getAnimatedValue()).intValue();
        XiguaLivingTagView r102 = this.f573794a;
        r102.f124542h.set(0.0f, 0.0f, r102.f124537c, r101);
        r102.invalidate();
    }
}
