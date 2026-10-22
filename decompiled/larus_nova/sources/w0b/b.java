package w0b;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.chameleonv2.debug.ui.LoadingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoadingView f557832a;

    public b(LoadingView r100) {
        this.f557832a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        LoadingView r103 = this.f557832a;
        r103.f411419e = r103.f411416b * r102;
        r103.invalidate();
    }
}
