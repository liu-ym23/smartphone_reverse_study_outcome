package zf1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;

/* JADX INFO: loaded from: classes7.dex */
public final class d0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0.b f571647a;

    public d0(b0.b r100) {
        this.f571647a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
        this.f571647a.f571644a.d("backtrack error", "timeout");
        this.f571647a.f571644a.e(IAnchorBacktrackService.State.BACKTRACK_DOING, IAnchorBacktrackService.State.IDLE);
    }
}
