package mz4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.doc.structure.FloatingStructureFragment;

/* JADX INFO: loaded from: classes16.dex */
public final class u extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FloatingStructureFragment f516528a;

    public u(FloatingStructureFragment r100) {
        this.f516528a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
        FloatingStructureFragment r101 = this.f516528a;
        r101.da0(r101.f218165g.getActive());
    }
}
