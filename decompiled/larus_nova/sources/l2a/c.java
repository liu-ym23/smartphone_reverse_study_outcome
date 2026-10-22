package l2a;

import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes32.dex */
public final class c extends TransitionSet {
    public c() {
        setOrdering(0);
        ChangeBounds r100 = new ChangeBounds();
        r100.setDuration(150);
        r100.setInterpolator(new PathInterpolator(0.42f, 0.0f, 1.0f, 1.0f));
        addTransition(r100);
        Transition r101 = new a(false);
        r101.setDuration(150);
        r101.setInterpolator(new PathInterpolator(0.42f, 0.0f, 1.0f, 1.0f));
        addTransition(r101);
    }
}
