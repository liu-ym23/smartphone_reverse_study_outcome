package u02;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.pkProp.PKBattlePropEffectWidget;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PKBattlePropEffectWidget f548148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f548149b;

    public c(PKBattlePropEffectWidget r100, View r101) {
        this.f548148a = r100;
        this.f548149b = r101;
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void b(k r100, Exception r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void d(ImageInfo r100) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void e(k r100) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void c(k r110, int r111, int r210, boolean r211) {
        PKBattlePropEffectWidget r100 = this.f548148a;
        View r101 = this.f548149b;
        if (r101 != null) goto L5;
        r100.getClass();
        return;
    L5:
        HSImageView r102 = r100.f130009h;
        if (r102 == null) goto L39;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L36;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        int[] r105 = {0, 0};
        r101.getLocationOnScreen(r105);
        r104.leftMargin = r105[0];
        r104.topMargin = r105[1] - s1.A();
        HSImageView r106 = r100.f130009h;
        if (r106 == null) goto L13;
        r106.setLayoutParams(r104);
    L13:
        HSImageView r107 = r100.f130009h;
        if (r107 == null) goto L16;
        r107.setVisibility(0);
    L16:
        HSImageView r108 = r100.f130009h;
        if (r108 == null) goto L19;
        r108.setTranslationX(0.0f);
    L19:
        HSImageView r109 = r100.f130009h;
        if (r109 == null) goto L22;
        r109.setTranslationY(0.0f);
    L22:
        HSImageView r112 = r100.f130009h;
        if (r112 == null) goto L25;
        r112.setAlpha(1.0f);
    L25:
        HSImageView r113 = r100.f130009h;
        if (r113 == null) goto L28;
        r113.setScaleX(1.0f);
    L28:
        HSImageView r114 = r100.f130009h;
        if (r114 == null) goto L31;
        r114.setScaleY(1.0f);
    L31:
        HSImageView r115 = r100.f130009h;
        Intrinsics.checkNotNull(r115);
        Intrinsics.checkNotNullParameter(r115, "flyIcon");
        Intrinsics.checkNotNullParameter(r101, "leftCount");
        AnimatorSet r116 = new AnimatorSet();
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{80.0f, 0.0f});
        ObjectAnimator r118 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{62.0f, 0.0f});
        r117.setDuration(500);
        r118.setDuration(500);
        ObjectAnimator r119 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.2f, 0.3f});
        ObjectAnimator r120 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.2f, 0.3f});
        r119.setDuration(500);
        r120.setDuration(500);
        ObjectAnimator.ofFloat(r115, "alpha", new float[]{0.0f, 1.0f}).setDuration(150);
        ObjectAnimator r121 = ObjectAnimator.ofFloat(r115, "alpha", new float[]{1.0f, 0.0f});
        r121.setDuration(150);
        r121.setStartDelay(350);
        ObjectAnimator r122 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.5f});
        ObjectAnimator r123 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.5f});
        r122.setDuration(500);
        r123.setDuration(500);
        r122.setStartDelay(350);
        r123.setStartDelay(350);
        ObjectAnimator r124 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.5f, 1.05f});
        ObjectAnimator r125 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.5f, 1.05f});
        r124.setDuration(250);
        r125.setDuration(250);
        r124.setStartDelay(500);
        r125.setStartDelay(500);
        ObjectAnimator r126 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.05f, 0.98f});
        ObjectAnimator r127 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.05f, 0.98f});
        r126.setDuration(250);
        r127.setDuration(250);
        r126.setStartDelay(750);
        r127.setStartDelay(750);
        ObjectAnimator r128 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.98f, 1.0f});
        ObjectAnimator r129 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.98f, 1.0f});
        r128.setDuration(250);
        r129.setDuration(250);
        r128.setStartDelay(1000);
        r129.setStartDelay(1000);
        ObjectAnimator r130 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{0.0f, 1.0f});
        r130.setDuration(150);
        r130.setStartDelay(350);
        r116.playTogether(new Animator[]{r117, r118, r119, r120, r122, r123, r124, r125, r126, r127, r129, r128, r130});
        r100.f130010i = r116;
        r116.addListener(r100.f130013l);
        AnimatorSet r131 = r100.f130010i;
        if (r131 == null) goto L38;
        r131.start();
        return;
    L38:
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
