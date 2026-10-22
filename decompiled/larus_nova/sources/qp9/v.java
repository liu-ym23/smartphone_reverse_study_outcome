package qp9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class v extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScaleGestureLayout f534436a;

    public v(ScaleGestureLayout r100) {
        this.f534436a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        ScaleGestureLayout r101 = this.f534436a;
        int r102 = ScaleGestureLayout.M;
        r101.l();
        this.f534436a.f364570n.reset();
        ViewCompat.postInvalidateOnAnimation(this.f534436a);
        this.f534436a.f364578v = null;
    }
}
