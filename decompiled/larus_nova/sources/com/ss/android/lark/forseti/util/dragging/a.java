package com.ss.android.lark.forseti.util.dragging;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingView;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f424613a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.forseti.util.dragging.a$a, reason: collision with other inner class name */
    public interface InterfaceC5019a extends Animator.AnimatorListener {
        void c(float r100, float r101);
    }

    static {
    }

    public static void a(ForsetiNormalChainDraggingView r100, float r101, float r102, float r103, InterfaceC5019a r104) {
        if (r100 != null) goto L5;
        Log.e("ForsetiColumnsDraggingAnimator", "current view is null, stops animation.");
        return;
    L5:
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{r101, r102});
        r105.addUpdateListener(new b(r100, r103, r101, r104));
        r105.setDuration(150);
        r105.setInterpolator(new DecelerateInterpolator(1.0f));
        r105.addListener(new c(r104));
        r105.start();
    }
}
