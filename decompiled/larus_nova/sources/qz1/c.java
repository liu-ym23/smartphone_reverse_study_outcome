package qz1;

import android.animation.ValueAnimator;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftSwitchImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftSwitchImageView f535223a;

    public c(GiftSwitchImageView r100) {
        this.f535223a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        GiftSwitchImageView r101 = this.f535223a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        r101.setAlpha(((Float) r102).floatValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
