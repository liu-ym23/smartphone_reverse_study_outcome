package mz4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.doc.structure.FloatingStructureFragment;

/* JADX INFO: loaded from: classes16.dex */
public final class v extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FloatingStructureFragment f516529a;

    public v(FloatingStructureFragment r100) {
        this.f516529a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100, boolean r101) {
        this.f516529a.f218172n.setVisibility(4);
    }
}
