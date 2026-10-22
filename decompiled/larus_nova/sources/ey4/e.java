package ey4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;

/* JADX INFO: loaded from: classes16.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseBlockEditPanel f474801a;

    public e(BaseBlockEditPanel r100) {
        this.f474801a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f474801a.setVisibility(0);
    }
}
