package w5;

import android.animation.ValueAnimator;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f558291a;

    public b(BottomSheetBehavior r100) {
        this.f558291a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        ((Float) r100.getAnimatedValue()).floatValue();
        this.f558291a.getClass();
    }
}
