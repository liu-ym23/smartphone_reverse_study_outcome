package rz1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements GiftIconMaskView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f539961a;

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView.b
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public d(b r100) {
        this.f539961a = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView.b
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        b r101 = this.f539961a;
        if (r101.f539955b != null) goto L5;
        r101.f539955b = new AnimatorSet();
    L5:
        AnimatorSet r102 = r101.f539955b;
        if (r102 == null) goto L9;
        r102.cancel();
        r102.removeAllListeners();
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r101.f539956c, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.12f, 1.0f});
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r101.f539956c, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.12f, 1.0f});
        r102.play(r103).with(r104);
        r102.setDuration(200);
        r102.addListener(new c(r101));
        r102.start();
        return;
    }
}
