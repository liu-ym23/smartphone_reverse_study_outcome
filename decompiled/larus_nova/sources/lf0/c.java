package lf0;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.liveinteract.interact.audience.ui.InteractAudienceAlertWindow;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractAudienceAlertWindow f509036a;

    public c(InteractAudienceAlertWindow r100) {
        this.f509036a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L14;
        float r102 = ((Float) r101).floatValue();
        this.f509036a.setAlpha(r102);
        this.f509036a.setScaleX(r102);
        this.f509036a.setScaleY(r102);
        if (r102 != 0.0f) goto L15;
        ViewParent r103 = this.f509036a.getParent();
        if ((r103 instanceof ViewGroup) == true) goto L9;
        r103 = null;
    L9:
        ViewGroup r104 = (ViewGroup) r103;
        if (r104 == null) goto L16;
        r104.removeView(this.f509036a);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
