package r04;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.awemeopen.apps.framework.profile.view.ProfileTabView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ ProfileTabView a;

    public c(ProfileTabView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        super.onAnimationEnd(r2);
        this.a.b.setVisibility(8);
    }
}
