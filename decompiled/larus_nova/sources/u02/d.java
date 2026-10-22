package u02;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.pkProp.PKBattlePropEffectWidget;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PKBattlePropEffectWidget f548150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Pair f548151b;

    public d(PKBattlePropEffectWidget r100, Pair r101) {
        this.f548150a = r100;
        this.f548151b = r101;
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
    public final void c(k r110, int r111, int r112, boolean r210) {
        PKBattlePropEffectWidget r100 = this.f548150a;
        Pair r101 = this.f548151b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "targetLocation");
        HSImageView r102 = r100.f130009h;
        if (r102 == null) goto L35;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L33;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        r104.leftMargin = ((Number) r101.getFirst()).intValue();
        r104.topMargin = ((Number) r101.getSecond()).intValue() - s1.A();
        HSImageView r105 = r100.f130009h;
        if (r105 == null) goto L10;
        r105.setLayoutParams(r104);
    L10:
        HSImageView r106 = r100.f130009h;
        if (r106 == null) goto L13;
        r106.setVisibility(0);
    L13:
        HSImageView r107 = r100.f130009h;
        if (r107 == null) goto L16;
        r107.setTranslationX(0.0f);
    L16:
        HSImageView r108 = r100.f130009h;
        if (r108 == null) goto L19;
        r108.setTranslationY(0.0f);
    L19:
        HSImageView r109 = r100.f130009h;
        if (r109 == null) goto L22;
        r109.setAlpha(1.0f);
    L22:
        HSImageView r113 = r100.f130009h;
        if (r113 == null) goto L25;
        r113.setScaleX(1.0f);
    L25:
        HSImageView r114 = r100.f130009h;
        if (r114 == null) goto L28;
        r114.setScaleY(1.0f);
    L28:
        HSImageView r115 = r100.f130009h;
        Intrinsics.checkNotNull(r115);
        Intrinsics.checkNotNullParameter(r115, "animationView");
        AnimatorSet r116 = new AnimatorSet();
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{-30.0f, 0.0f});
        ObjectAnimator r118 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{35.0f, 0.0f});
        r117.setDuration(500);
        r118.setDuration(500);
        ObjectAnimator r119 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.2f, 0.9f});
        ObjectAnimator r120 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.2f, 0.9f});
        r119.setDuration(500);
        r120.setDuration(500);
        ObjectAnimator r121 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.9f, 1.04f});
        ObjectAnimator r122 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.9f, 1.04f});
        r121.setDuration(250);
        r122.setDuration(250);
        r121.setStartDelay(500);
        r122.setStartDelay(500);
        ObjectAnimator r123 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.04f, 1.0f});
        ObjectAnimator r124 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.04f, 1.0f});
        r123.setDuration(250);
        r124.setDuration(250);
        r123.setStartDelay(750);
        r124.setStartDelay(750);
        ObjectAnimator.ofFloat(r115, "alpha", new float[]{0.0f, 1.0f}).setDuration(150);
        r116.playTogether(new Animator[]{r117, r118, r119, r120, r121, r122, r123, r124});
        r100.f130010i = r116;
        r116.addListener(r100.f130013l);
        AnimatorSet r125 = r100.f130010i;
        if (r125 == null) goto L34;
        r125.start();
        return;
    L34:
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
