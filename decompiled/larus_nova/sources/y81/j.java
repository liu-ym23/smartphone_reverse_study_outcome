package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f566768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f566769b;

    public j(LottieAnimationView r100, c r101) {
        this.f566768a = r100;
        this.f566769b = r101;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroup.LayoutParams r102 = this.f566768a.getLayoutParams();
        ViewGroup r103 = this.f566769b.f566680p;
        if (r103 == null) goto L5;
        int r104 = r103.getWidth();
    L6:
        r102.width = r104;
        ViewGroup r105 = this.f566769b.f566680p;
        if (r105 == null) goto L9;
        int r106 = r105.getHeight();
    L10:
        r102.height = r106;
        this.f566768a.setLayoutParams(r102);
        this.f566768a.setVisibility(0);
        return;
    L9:
        r106 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }
}
