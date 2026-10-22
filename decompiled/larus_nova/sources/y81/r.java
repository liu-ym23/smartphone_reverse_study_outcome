package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class r extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f566826a;

    public r(l r100) {
        this.f566826a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroup r101 = this.f566826a.f566777l;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        this.f566826a.q();
        this.f566826a.i(0);
        RelativeLayout r102 = this.f566826a.f566785t;
        if (r102 == null) goto L11;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L12;
        r103.width = -2;
        return;
    L12:
        return;
    }
}
