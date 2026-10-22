package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public final class StateListAnimator {
    private final Animator.AnimatorListener animationListener;
    private Tuple lastMatch;
    ValueAnimator runningAnimator;
    private final ArrayList<Tuple> tuples;

    public static class Tuple {
        final ValueAnimator animator;
        final int[] specs;

        public Tuple(int[] r100, ValueAnimator r101) {
            this.specs = r100;
            this.animator = r101;
        }
    }

    private void cancel() {
        ValueAnimator r100 = this.runningAnimator;
        if (r100 == null) goto L6;
        r100.cancel();
        this.runningAnimator = null;
        return;
    }

    public void jumpToCurrentState() {
        ValueAnimator r100 = this.runningAnimator;
        if (r100 == null) goto L6;
        r100.end();
        this.runningAnimator = null;
        return;
    }

    public StateListAnimator() {
        this.tuples = new ArrayList();
        this.lastMatch = null;
        this.runningAnimator = null;
        this.animationListener = new AnonymousClass1(this);
    }

    private void start(Tuple r100) {
        ValueAnimator r101 = r100.animator;
        this.runningAnimator = r101;
        r101.start();
    }

    public void setState(int[] r100) {
        int r101 = this.tuples.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        Tuple r103 = (Tuple) ListProtector.get(this.tuples, r102);
        if (StateSet.stateSetMatches(r103.specs, r100) == true) goto L9;
        r102 = r102 + 1;
    L9:
        Tuple r104 = this.lastMatch;
        if (r103 != r104) goto L12;
        return;
    L12:
        if (r104 == null) goto L14;
        cancel();
    L14:
        this.lastMatch = r103;
        if (r103 == null) goto L20;
        start(r103);
        return;
    L20:
        return;
    L8:
        r103 = null;
        goto L9
    }

    public void addState(int[] r100, ValueAnimator r101) {
        Tuple r102 = new Tuple(r100, r101);
        r101.addListener(this.animationListener);
        this.tuples.add(r102);
    }
}
