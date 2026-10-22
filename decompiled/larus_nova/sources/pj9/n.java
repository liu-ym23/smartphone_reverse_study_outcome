package pj9;

import android.animation.Animator;
import com.larus.livetutor.impl.databinding.FragmentLiveTutorSubtitleLayoutBinding;
import com.larus.livetutor.impl.tutor.fragment.LiveTutorSubtitleFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class n implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTutorSubtitleFragment f529527a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    public n(LiveTutorSubtitleFragment r100) {
        this.f529527a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        FragmentLiveTutorSubtitleLayoutBinding r101 = this.f529527a.f356573g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L5:
        r101.f355918b.setText("");
    }
}
