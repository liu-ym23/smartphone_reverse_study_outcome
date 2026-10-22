package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public static final long COLLAPSE_DELAY = 0;
    public static final long COLLAPSE_DURATION = 150;
    public static final long EXPAND_DELAY = 75;
    public static final long EXPAND_DURATION = 150;
    private final MotionTiming collapseTiming;
    private final MotionTiming expandTiming;

    public FabTransformationScrimBehavior() {
        this.expandTiming = new MotionTiming(75, 150);
        this.collapseTiming = new MotionTiming(0, 150);
    }

    public FabTransformationScrimBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.expandTiming = new MotionTiming(75, 150);
        this.collapseTiming = new MotionTiming(0, 150);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r100, View r101, View r102) {
        return r102 instanceof FloatingActionButton;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
        return super.onTouchEvent(r100, r101, r102);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet onCreateExpandedStateChangeAnimation(View r100, final View r101, final boolean r102, boolean r110) {
        ArrayList r103 = new ArrayList();
        createScrimAnimation(r101, r102, r110, r103, new ArrayList());
        AnimatorSet r111 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r111, r103);
        r111.addListener(new AnonymousClass1(this, r102, r101));
        return r111;
    }

    private void createScrimAnimation(View r100, boolean r101, boolean r102, List<Animator> r103, List<Animator.AnimatorListener> r104) {
        if (r101 == false) goto L4;
        MotionTiming r105 = this.expandTiming;
    L6:
        if (r101 == false) goto L10;
        if (r102 == true) goto L9;
        r100.setAlpha(0.0f);
    L9:
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r100, View.ALPHA, new float[]{1.0f});
    L11:
        r105.apply(r106);
        r103.add(r106);
        return;
    L10:
        r106 = ObjectAnimator.ofFloat(r100, View.ALPHA, new float[]{0.0f});
        goto L11
    L4:
        r105 = this.collapseTiming;
        goto L6
    }
}
