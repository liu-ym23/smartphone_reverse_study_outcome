package ra2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class w extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatchHotMsgView f536836a;

    public w(MatchHotMsgView r100) {
        this.f536836a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        MatchHotMsgView r101 = this.f536836a;
        if (r101.F == true) goto L5;
        return;
    L5:
        if (r101.getStatus() == this.f536836a.getNeedExit()) goto L17;
        MatchHotMsgView r102 = this.f536836a;
        r102.f140139u = 0;
        r102.f140140v = 0;
        AnimatedDrawable2 r103 = r102.f140136r;
        if (r103 == null) goto L9;
        r103.stop();
    L9:
        AnimatedDrawable2 r104 = r102.f140136r;
        if (r104 == null) goto L12;
        r104.start();
    L12:
        AnimatorSet r105 = this.f536836a.getScaleAnimatorSets();
        if (r105 == null) goto L18;
        r105.start();
        return;
    L18:
        return;
    }
}
