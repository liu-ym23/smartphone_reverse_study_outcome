package r04;

import android.animation.ValueAnimator;
import com.bytedance.awemeopen.apps.framework.profile.view.ProfileTabView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ProfileTabView a;

    public b(ProfileTabView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        ProfileTabView.a(this.a, r2);
    }
}
