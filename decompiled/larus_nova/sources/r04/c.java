package r04;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.awemeopen.apps.framework.profile.view.ProfileTabView;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProfileTabView f535452a;

    public c(ProfileTabView r100) {
        this.f535452a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
        this.f535452a.f197516b.setVisibility(8);
    }
}
