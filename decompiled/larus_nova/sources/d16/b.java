package d16;

import android.animation.ValueAnimator;
import com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f466388a;

    public b(BottomSheetBehavior r100) {
        this.f466388a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        ((Float) r100.getAnimatedValue()).floatValue();
        this.f466388a.getClass();
    }
}
