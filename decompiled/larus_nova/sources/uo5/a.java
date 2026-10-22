package uo5;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.tts.view.FloatViewContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout.LayoutParams f550915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FloatViewContainer f550916b;

    public a(FrameLayout.LayoutParams r100, FloatViewContainer r101) {
        this.f550915a = r100;
        this.f550916b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FrameLayout.LayoutParams r101 = this.f550915a;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        r101.rightMargin = ((Integer) r102).intValue();
        this.f550916b.requestLayout();
    }
}
