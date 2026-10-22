package ey4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseBlockEditPanel a;

    public e(BaseBlockEditPanel r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        this.a.setVisibility(0);
    }
}
