package el0;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f472991a;

    public b(a r100) {
        this.f472991a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        float r102 = ((Float) r101).floatValue();
        this.f472991a.setAlpha(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
