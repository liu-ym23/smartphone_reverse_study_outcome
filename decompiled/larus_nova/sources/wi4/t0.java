package wi4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.ugc.aweme.transition.ITransition;
import com.ss.android.ugc.aweme.transition.TransitionListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class t0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f559842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ITransition f559843b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        TransitionListener r101 = this.f559842a.f559836g;
        if (r101 == null) goto L5;
        r101.onShowEnd();
    L5:
        ITransition r102 = this.f559843b;
        if (r102 == null) goto L9;
        r102.onShowEnd();
        return;
    }

    public t0(r0 r100, ITransition r101) {
        this.f559842a = r100;
        this.f559843b = r101;
    }
}
