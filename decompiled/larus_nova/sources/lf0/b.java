package lf0;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.liveinteract.interact.audience.ui.InteractAudienceAlertWindow;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractAudienceAlertWindow f509035a;

    public b(InteractAudienceAlertWindow r100) {
        this.f509035a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroup.LayoutParams r101 = this.f509035a.getLayoutParams();
        if (r101 == null) goto L11;
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
        Object r103 = r100.getAnimatedValue();
        if (r103 == null) goto L9;
        r102.rightMargin = ((Integer) r103).intValue();
        this.f509035a.setLayoutParams(r102);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
}
