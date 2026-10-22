package l2a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends Transition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f507170a;

    @Override // android.transition.Transition
    public final void captureEndValues(TransitionValues r100) {
    }

    @Override // android.transition.Transition
    public final void captureStartValues(TransitionValues r100) {
    }

    public a(boolean r100) {
        this.f507170a = r100;
    }

    @Override // android.transition.Transition
    public final Animator createAnimator(ViewGroup r100, TransitionValues r101, TransitionValues r102) {
        Intrinsics.checkNotNullParameter(r100, "sceneRoot");
        View r103 = null;
        if (r101 == null) goto L7;
        View r104 = r101.view;
        if (r104 == null) goto L7;
        String r105 = r104.getTransitionName();
    L8:
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        if (r105.length() <= 0) goto L13;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L27;
        if (r101 == null) goto L18;
        r103 = r101.view;
    L18:
        float[] r107 = new float[2];
        boolean r108 = this.f507170a;
        float r109 = 1.0f;
        if (r108 == false) goto L21;
        float r110 = 1.0f;
    L22:
        r107[0] = r110;
        if (r108 == false) goto L25;
        r109 = 0.0f;
    L25:
        r107[1] = r109;
        ObjectAnimator r111 = ObjectAnimator.ofFloat(r103, "alpha", r107);
        Intrinsics.checkNotNull(r111);
        return r111;
    L21:
        r110 = 0.0f;
        goto L22
    L27:
        return ObjectAnimator.ofFloat(null, "alpha", new float[]{1.0f, 1.0f});
    L13:
        r106 = false;
    L7:
        r105 = null;
        goto L8
    }
}
