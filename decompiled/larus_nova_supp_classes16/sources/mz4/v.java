package mz4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.doc.structure.FloatingStructureFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v extends AnimatorListenerAdapter {
    public final /* synthetic */ FloatingStructureFragment a;

    public v(FloatingStructureFragment r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1, boolean r2) {
        this.a.n.setVisibility(4);
    }
}
