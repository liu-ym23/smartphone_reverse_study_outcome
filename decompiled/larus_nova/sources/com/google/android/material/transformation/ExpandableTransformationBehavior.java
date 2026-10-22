package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    private AnimatorSet currentAnimation;

    public abstract AnimatorSet onCreateExpandedStateChangeAnimation(View r100, View r101, boolean r102, boolean r103);

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public static /* synthetic */ AnimatorSet access$002(ExpandableTransformationBehavior r100, AnimatorSet r101) {
        r100.currentAnimation = r101;
        return r101;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public boolean onExpandedStateChange(View r100, View r101, boolean r102, boolean r103) {
        AnimatorSet r104 = this.currentAnimation;
        if (r104 == null) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        r104.cancel();
    L8:
        AnimatorSet r106 = onCreateExpandedStateChangeAnimation(r100, r101, r102, r105);
        this.currentAnimation = r106;
        r106.addListener(new AnonymousClass1(this));
        this.currentAnimation.start();
        if (r103 == true) goto L11;
        this.currentAnimation.end();
    L11:
        return true;
    L5:
        r105 = false;
        goto L6
    }
}
