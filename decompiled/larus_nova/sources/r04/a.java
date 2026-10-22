package r04;

import android.animation.ValueAnimator;
import com.bytedance.awemeopen.apps.framework.profile.view.ProfileTabView;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProfileTabView f535450a;

    public a(ProfileTabView r100) {
        this.f535450a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        ProfileTabView.a(this.f535450a, r100);
    }
}
