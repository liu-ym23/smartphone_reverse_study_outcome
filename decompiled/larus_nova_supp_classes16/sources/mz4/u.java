package mz4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.doc.structure.FloatingStructureFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u extends AnimatorListenerAdapter {
    public final /* synthetic */ FloatingStructureFragment a;

    public u(FloatingStructureFragment r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        super.onAnimationEnd(r2);
        FloatingStructureFragment r3 = this.a;
        r3.da0(r3.g.getActive());
    }
}
