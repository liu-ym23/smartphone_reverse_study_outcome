package xbc;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.widget.ZoomInScrollView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ZoomInScrollView f563193a;

    public f(ZoomInScrollView r100) {
        this.f563193a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ZoomInScrollView r101 = this.f563193a;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
        ZoomInScrollView.a(r101, ((Float) r102).floatValue());
    }
}
