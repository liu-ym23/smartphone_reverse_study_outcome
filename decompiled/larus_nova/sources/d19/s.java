package d19;

import android.animation.Animator;
import com.larus.common_ui.edgeeffect.ScreenEdgeEffectView;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.continue_talk.f2;
import com.larus.voicecall.impl.continue_talk.g2;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public final class s implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenEdgeEffectView f466484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f466485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f466486c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        FLogger.f375446a.i("ScreenEdgeEffectView", "hideScreenEdgeEffect onCancel");
        this.f466484a.destroy();
        this.f466484a.post(new r(this.f466486c, r100));
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        FLogger.f375446a.i("ScreenEdgeEffectView", "hideScreenEdgeEffect onEnd");
        this.f466484a.destroy();
        this.f466484a.post(new q(this.f466485b, r100));
    }

    public s(ScreenEdgeEffectView r100, f2 r101, g2 r102) {
        this.f466484a = r100;
        this.f466485b = r101;
        this.f466486c = r102;
    }
}
